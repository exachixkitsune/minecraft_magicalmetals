package net.exachixkitsune.magicalmetals.tileentities;

import net.exachixkitsune.magicalmetals.mobs.Butterfly_Entity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class ButterflyBox_Tile extends TileEntity implements ITickableTileEntity {

	public ButterflyBox_Tile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	// NBT Keys
	private static String KEY_timerProcessing = "TimerProcessing";
	private static String KEY_butterflyID = "ButterflyID";

	// Tick every 15 seconds
	private final int TicksBetweenMakingButterfly = 15 * 20;
	
	private int TicksRemainingMakeButterfly = -1;
	private int thisButterflyID;
	
	// NBT Communication functionality
	@Override
	public CompoundNBT save(CompoundNBT compoundNBTData) {
		compoundNBTData = super.save(compoundNBTData);
		compoundNBTData.putInt(KEY_timerProcessing, TicksRemainingMakeButterfly);
		compoundNBTData.putInt(KEY_butterflyID, thisButterflyID);
		return compoundNBTData;
	}
	@Override
	public void load(BlockState state, CompoundNBT compoundNBTData) {
		super.load(state, compoundNBTData);
		TicksRemainingMakeButterfly = compoundNBTData.getInt(KEY_timerProcessing);
		thisButterflyID = compoundNBTData.getInt(KEY_butterflyID);
	}
	
	// set by the block upon creation
	public void setup()
	{
		TicksRemainingMakeButterfly = 0;
		thisButterflyID = 0;
	}
	
	@Override
	public void tick() {
		if (!this.hasLevel()) return;  // prevent crash
		World world = this.getLevel();
		if (world.isClientSide()) return;   // don't bother doing anything on the client side.

		// I was placed.
		--TicksRemainingMakeButterfly;

		if ((TicksRemainingMakeButterfly < 0)) {
			// Check butterfly ID
			Entity this_entity = world.getEntity(thisButterflyID);
			if (this_entity == null || !(isMyButterfly(this_entity))) {
				BlockPos myPos = this.getBlockPos();
				// If we've got here, no butterflyID has been set.

				// Make the butterfly
				Butterfly_Entity this_butterfly = makeButterfly(world);

				// Configure Butterfly
				this_butterfly.setPos(myPos.getX(), myPos.getY()+1, myPos.getZ());
				this_butterfly.setHomePos(myPos);
				world.addFreshEntity(this_butterfly);
				thisButterflyID = this_butterfly.getId();
				// Set Tick
				TicksRemainingMakeButterfly = TicksBetweenMakingButterfly;
				// Set my dirtyness
				this.setChanged();
			}
		}
	}
	
	protected abstract boolean isMyButterfly(Entity entity);
	protected abstract Butterfly_Entity makeButterfly(World world);

}
