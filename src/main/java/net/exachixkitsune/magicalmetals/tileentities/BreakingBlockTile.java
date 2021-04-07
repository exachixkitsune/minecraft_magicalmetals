package net.exachixkitsune.magicalmetals.tileentities;

import net.exachixkitsune.magicalmetals.blocks.BreakingBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.block.BlockState;

import net.minecraft.world.World;


public class BreakingBlockTile extends TileEntity implements ITickableTileEntity {
	
	public BreakingBlockTile() {
		super(TileEntityTypes.BREAKINGBLOCKTILE);
	}
	
	// NBT Keys
	private static String KEY_timerProcessing = "TimerProcessing";
	
	// Configuration
	// TODO: Send to Config file?
	// Process every 5s.
	private final int TicksToProcess = 20;
	private final int TicksDelay = 10;
	
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
		TicksRemainingProcessing = TicksToProcess;
	}

	@Override
	public void tick() {
		if (!this.hasLevel()) return;  // prevent crash
		World world = this.getLevel();
		if (world.isClientSide()) return;   // don't bother doing anything on the client side.
		
		// So;
		//   If Powered: do the check if can process
		if (this.getBlockState().getValue(BreakingBlock.POWERED)) {
			// If no processing has happened yet - TickRemainingProcess will be at full
			if (TicksRemainingProcessing == (TicksToProcess-TicksDelay)) {
				// Render adjacent blocks to be powered
				BlockPos position = this.getBlockPos();
				BlockPos[] stepPositions = {position.above(), position.below(), position.north(), position.south(), position.east(), position.west()};
				for (BlockPos stepPosition : stepPositions) {
					// Update all blocks around, make them powered. IF they are a BreakingBlock.
					BlockState stepBlock = world.getBlockState(stepPosition);
					if ((stepBlock.getBlock() instanceof BreakingBlock) &&
							!stepBlock.getValue(BreakingBlock.POWERED)) {
						world.setBlockAndUpdate(stepPosition, stepBlock.setValue(BreakingBlock.POWERED, true));
					}
				}
			}
			
			--TicksRemainingProcessing;
			
			// Ticks incomplete? Return
			if (TicksRemainingProcessing > 0)  return;
			// Destroy self
			world.destroyBlock(this.getBlockPos(), true);
			world.removeBlockEntity(this.getBlockPos());
		}
	}


}
