package net.exachixkitsune.magicalmetals.mobs;

import net.exachixkitsune.magicalmetals.mobs.goals.Butterfly_Goal_Tree_FindPollinate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Butterfly_Tree_Entity extends Butterfly_Entity {

	public Butterfly_Tree_Entity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected boolean PollinateBlockCheck(Block thisBlock) {
		return (thisBlock instanceof SaplingBlock);
	}

	@Override
	protected void doPollinate(Block thisBlock, BlockState thisBlockState) {
		SaplingBlock thisSapling = (SaplingBlock)thisBlock;
		if (thisSapling.canUseBonemeal(world, rand, targetPos, thisBlockState)) {
			// Grow the Sapling
			thisSapling.grow((ServerWorld)world, rand, targetPos, thisBlockState);
			// Reset pollination
			currentPollinateRecharge = pollinateRechargeMax;
			currentPollinateCharge = pollinateChargeTime;
		}
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		// Add additional goal
		this.goalSelector.addGoal(2, new Butterfly_Goal_Tree_FindPollinate(this, goalSpeed, maxRangeFromHome, 5));
	}
	
	
}
