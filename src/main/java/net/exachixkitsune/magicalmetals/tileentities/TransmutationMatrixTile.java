package net.exachixkitsune.magicalmetals.tileentities;

import net.exachixkitsune.magicalmetals.blocks.MagicalFocusBlock;
import net.exachixkitsune.magicalmetals.blocks.transmutation.TransmutationMatrix;
import net.exachixkitsune.magicalmetals.blocks.transmutation.TransmutationAnchor;
import net.exachixkitsune.magicalmetals.blocks.BlocksList;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;

import net.minecraft.block.*;
import net.minecraft.world.World;


public class TransmutationMatrixTile extends TileEntity implements ITickableTileEntity {
	
	public TransmutationMatrixTile() {
		super(TileEntityTypes.TRANSMUTATIONMATRIXTILE);
	}
	
	// NBT Keys
	private static String KEY_timerProcessing = "TimerProcessing";
	
	// Configuration
	// TODO: Send to Config file?
	// Process every 5s.
	private final int TicksBetweenProcessing = 20 * 5;
	// Distance for block check to go
	private final int blockCheckDistance = 3;
	// Valid items
	//private final Item[] validItems = {ItemRegister.ORICHALCUM_INGOT_ITEM.get(), BlockRegister.ORICHALCUM_BLOCK_ITEM.get()};
	
	// Variables
	private final int INVALID_VALUE = -1;
	private int TicksRemainingProcessing = INVALID_VALUE;
	
	// NBT Communication functionality
	@Override
	public CompoundNBT write(CompoundNBT compoundNBTData) {
		compoundNBTData = super.write(compoundNBTData);
		compoundNBTData.putInt(KEY_timerProcessing, TicksRemainingProcessing);
		return compoundNBTData;
	}
	@Override
	public void func_230337_a_(BlockState state, CompoundNBT compoundNBTData) {
		// I think this is "read"
		super.func_230337_a_(state, compoundNBTData);
		TicksRemainingProcessing = compoundNBTData.getInt(KEY_timerProcessing);
	}
	

	// set by the block upon creation
	public void setup()
	{
		TicksRemainingProcessing = TicksBetweenProcessing;
	}

	@Override
	public void tick() {
		if (!this.hasWorld()) return;  // prevent crash
		World world = this.getWorld();
		if (world.isRemote) return;   // don't bother doing anything on the client side.
		
		// So;
		//   If Powered: do the check if can process
		if (this.getBlockState().get(TransmutationMatrix.POWERED)) {
			--TicksRemainingProcessing;
			// Ticks incomplete? Return
			if (TicksRemainingProcessing > 0)  return;
			TicksRemainingProcessing = TicksBetweenProcessing;
			
			// Process.
			// This function contains checkConfigurationStatus()
			processBlocks(world);
		}
	}
	
	private boolean checkConfigurationStatus() {
		World world = this.getWorld();
		BlockPos myPos = this.getPos();
		
		boolean output = false;
		
		// Check
		BlockPos upPos = myPos.add(0, blockCheckDistance, 0);
		BlockPos downPos = myPos.add(0, -1*blockCheckDistance, 0);
		if ((world.getBlockState(upPos).getBlock() instanceof MagicalFocusBlock) && 
				(world.getBlockState(downPos).getBlock() instanceof MagicalFocusBlock)) {
			// Both blocks are the magical blocks.
			// Further check - are there source blocks/inventories in the right place
			// Each direction is independent, but if there's air in two directions, need valid blocks in the other.
			BlockPos EastPos = myPos.add(blockCheckDistance, 0, 0);
			BlockPos WestPos = myPos.add(-1*blockCheckDistance, 0, 0);
			BlockPos SouthPos = myPos.add(0, 0, blockCheckDistance);
			BlockPos NorthPos = myPos.add(0, 0, -1*blockCheckDistance);
			// If East/West are Air, check South/North
			// If South/North are Air, check East/West
			// Are the two aligned elements Orichalcum?
			if (world.isAirBlock(EastPos) && world.isAirBlock(WestPos)) {
				output = (validSourceBlock(world,NorthPos) && 
						validSourceBlock(world,SouthPos));
			}
			else if (world.isAirBlock(SouthPos) && world.isAirBlock(NorthPos)) {
				output = (validSourceBlock(world,EastPos) && 
						validSourceBlock(world,WestPos));
			}
		}
		return output;
	}
	
	private boolean validSourceBlock(World world, BlockPos pos) {
		BlockState thisBlockState = world.getBlockState(pos);
		Block thisBlock = thisBlockState.getBlock();
		
		if (thisBlock == BlocksList.orichalcum_block) return true;
		
		// TODO: Currently turns blocks to blocks, otherwise it's mildly too complicated.
		
		// Default output if falls through
		return false;
	}
	
	private void processBlocks(World world) {
		// Destroy Orichalcum Blocks, Create nonorichalcum blocks
		// First: What are the new blocks to make?
		// Up block sets East/South block.
		// Down block sets West/North block.
		
		// First, check all is good - if not, exit;
		if (!checkConfigurationStatus()) { return; };
		
		// Defaults
		Block blocktomake_1 = null;
		Block blocktomake_2 = null;
		BlockPos myPos = this.getPos();
		
		
		BlockPos eastPos = myPos.add(blockCheckDistance, 0, 0);
		BlockPos westPos = myPos.add(-1*blockCheckDistance, 0, 0);
		BlockPos southPos = myPos.add(0, 0, blockCheckDistance);
		BlockPos northPos = myPos.add(0, 0, -1*blockCheckDistance);
		BlockPos upPos = myPos.add(0, blockCheckDistance, 0);
		BlockPos downPos = myPos.add(0, -1*blockCheckDistance, 0);
		
		// Set East/South
		Block upBlock = world.getBlockState(upPos).getBlock();
		if (upBlock instanceof TransmutationAnchor) {
			TransmutationAnchor thisBlock = (TransmutationAnchor)upBlock;
			blocktomake_1 = thisBlock.ConvertOrichalcumToBlock();
		}
		// Set West/North
		Block DownBlock = world.getBlockState(downPos).getBlock();
		if (DownBlock instanceof TransmutationAnchor) {
			TransmutationAnchor thisBlock = (TransmutationAnchor)DownBlock;
			blocktomake_2 = thisBlock.ConvertOrichalcumToBlock();
		}
		
		
		// By Default, output block is Pure Starmetal
		// By Biome
		if ((blocktomake_1 == null) || (blocktomake_2 == null)) {
			Block fromBiome = BlocksList.purestarmetal_block;
			if (myPos.getY() < 30) {
				fromBiome = BlocksList.adamant_block;
			}
			else {
				Biome myBiome = world.getBiome(myPos);
				if ((myBiome.getCategory() == Biome.Category.BEACH) ||
						(myBiome.getCategory() == Biome.Category.RIVER)  ||
						(myBiome.getCategory() == Biome.Category.OCEAN)||
						(myBiome.getCategory() == Biome.Category.SWAMP)) {
					fromBiome = BlocksList.greeniron_block;
				}
				else {
					float myTemperature = myBiome.getTemperature(myPos);
					if (myTemperature <= 0.3) {
						fromBiome = BlocksList.blueiron_block;
					}
					else if (myTemperature >= 1.0) {
						fromBiome = BlocksList.luminousgold_block;
					}
				}
			}
			if (blocktomake_1 == null) { blocktomake_1 = fromBiome; };
			if (blocktomake_2 == null) { blocktomake_2 = fromBiome; };
		}

		// Fully Check that everything is good, otherwise don't change.
		if (world.isAirBlock(eastPos) && world.isAirBlock(westPos) &&
				validSourceBlock(world,southPos) && 
				validSourceBlock(world,northPos)) {
			// TODO: Expand to deal with inventories too
			world.destroyBlock(southPos, false);
			world.destroyBlock(northPos, false);
			world.setBlockState(eastPos, blocktomake_1.getDefaultState());
			world.setBlockState(westPos, blocktomake_2.getDefaultState());
		}
		else if (world.isAirBlock(southPos) && world.isAirBlock(northPos) &&
				validSourceBlock(world,eastPos) && 
				validSourceBlock(world,westPos)) {
			// TODO: Expand to deal with inventories too
			world.destroyBlock(eastPos, false);
			world.destroyBlock(westPos, false);
			world.setBlockState(southPos, blocktomake_1.getDefaultState());
			world.setBlockState(northPos, blocktomake_2.getDefaultState());
		}
	}


}
