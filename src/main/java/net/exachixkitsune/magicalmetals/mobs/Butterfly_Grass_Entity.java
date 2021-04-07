package net.exachixkitsune.magicalmetals.mobs;

import net.exachixkitsune.magicalmetals.mobs.goals.Butterfly_Goal_Grass_FindDirt;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class Butterfly_Grass_Entity extends Butterfly_Entity {

	public Butterfly_Grass_Entity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected boolean PollinateBlockCheck(Block thisBlock) {
		// Grass or Dirt
		return (thisBlock == Blocks.DIRT);
	}

	@Override
	protected void doPollinate(Block thisBlock, BlockState thisBlockState) {
		if (thisBlock == Blocks.DIRT) {
			level.destroyBlock(targetPos, false);
			level.setBlockAndUpdate(targetPos, Blocks.GRASS_BLOCK.defaultBlockState());
			currentPollinateRecharge = pollinateRechargeMax;
			currentPollinateCharge = pollinateChargeTime;
		}
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		// Add additional goal
		this.goalSelector.addGoal(2, new Butterfly_Goal_Grass_FindDirt(this, goalSpeed, maxRangeFromHome, 5));
	}
	
	
}
