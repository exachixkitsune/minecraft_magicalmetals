package net.exachixkitsune.magicalmetals.tileentities;

import net.exachixkitsune.magicalmetals.blocks.MagicalFocusBlock;
import net.exachixkitsune.magicalmetals.blocks.transmutation.TransmutationMatrix;
import net.exachixkitsune.magicalmetals.util.ConvertMode;
import net.exachixkitsune.magicalmetals.blocks.transmutation.TransmutationAnchor;
import net.exachixkitsune.magicalmetals.blocks.BlocksList;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

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
	public CompoundNBT save(CompoundNBT compoundNBTData) {
		compoundNBTData = super.save(compoundNBTData);
		compoundNBTData.putInt(KEY_timerProcessing, TicksRemainingProcessing);
		return compoundNBTData;
	}
	@Override
	public void load(BlockState state, CompoundNBT compoundNBTData) {
		// I think this is "read"
		super.load(state, compoundNBTData);
		TicksRemainingProcessing = compoundNBTData.getInt(KEY_timerProcessing);
	}
	

	// set by the block upon creation
	public void setup()
	{
		TicksRemainingProcessing = TicksBetweenProcessing;
	}

	@Override
	public void tick() {
		if (!this.hasLevel()) return;  // prevent crash
		World world = this.getLevel();
		if (world.isClientSide()) return;   // don't bother doing anything on the client side.
		
		// So;
		//   If Powered: do the check if can process
		if (this.getBlockState().getValue(TransmutationMatrix.POWERED)) {
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
		World world = this.getLevel();
		BlockPos myPos = this.getBlockPos();
		
		boolean output = false;
		
		// Check
		BlockPos upPos = myPos.offset(0, blockCheckDistance, 0);
		BlockPos downPos = myPos.offset(0, -1*blockCheckDistance, 0);
		if ((world.getBlockState(upPos).getBlock() instanceof MagicalFocusBlock) && 
				(world.getBlockState(downPos).getBlock() instanceof MagicalFocusBlock)) {
			// Both blocks are the magical blocks.
			// Further check - are there source blocks/inventories in the right place
			// Each direction is independent, but if there's air in two directions, need valid blocks in the other.
			BlockPos EastPos = myPos.offset(blockCheckDistance, 0, 0);
			BlockPos WestPos = myPos.offset(-1*blockCheckDistance, 0, 0);
			BlockPos SouthPos = myPos.offset(0, 0, blockCheckDistance);
			BlockPos NorthPos = myPos.offset(0, 0, -1*blockCheckDistance);
			// If East/West are Air, check South/North
			// If South/North are Air, check East/West
			// Are the two aligned elements Orichalcum?
			if (world.isEmptyBlock(EastPos) && world.isEmptyBlock(WestPos)) {
				output = (validSourceBlock(world,NorthPos) && 
						validSourceBlock(world,SouthPos));
			}
			else if (world.isEmptyBlock(SouthPos) && world.isEmptyBlock(NorthPos)) {
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
		BlockPos myPos = this.getBlockPos();
		
		
		BlockPos eastPos = myPos.offset(blockCheckDistance, 0, 0);
		BlockPos westPos = myPos.offset(-1*blockCheckDistance, 0, 0);
		BlockPos southPos = myPos.offset(0, 0, blockCheckDistance);
		BlockPos northPos = myPos.offset(0, 0, -1*blockCheckDistance);
		BlockPos upPos = myPos.offset(0, blockCheckDistance, 0);
		BlockPos downPos = myPos.offset(0, -1*blockCheckDistance, 0);
		
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
			Block fromBiome = ConvertMode.determineConvertTo(world, myPos).getConvertTo_Block();
			if (blocktomake_1 == null) { blocktomake_1 = fromBiome; };
			if (blocktomake_2 == null) { blocktomake_2 = fromBiome; };
		}

		// Fully Check that everything is good, otherwise don't change.
		if (world.isEmptyBlock(eastPos) && world.isEmptyBlock(westPos) &&
				validSourceBlock(world,southPos) && 
				validSourceBlock(world,northPos)) {
			// TODO: Expand to deal with inventories too
			world.destroyBlock(southPos, false);
			world.destroyBlock(northPos, false);
			world.setBlockAndUpdate(eastPos, blocktomake_1.defaultBlockState());
			world.setBlockAndUpdate(westPos, blocktomake_2.defaultBlockState());
		}
		else if (world.isEmptyBlock(southPos) && world.isEmptyBlock(northPos) &&
				validSourceBlock(world,eastPos) && 
				validSourceBlock(world,westPos)) {
			// TODO: Expand to deal with inventories too
			world.destroyBlock(eastPos, false);
			world.destroyBlock(westPos, false);
			world.setBlockAndUpdate(southPos, blocktomake_1.defaultBlockState());
			world.setBlockAndUpdate(northPos, blocktomake_2.defaultBlockState());
		}
	}
	
}
