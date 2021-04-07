package net.exachixkitsune.magicalmetals.mobs;

import net.exachixkitsune.magicalmetals.mobs.goals.Butterfly_Goal_Crop_FindPollinate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Butterfly_Crop_Entity extends Butterfly_Entity {

	public Butterfly_Crop_Entity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected boolean PollinateBlockCheck(Block thisBlock) {
		return (thisBlock instanceof CropsBlock) || (thisBlock instanceof StemBlock);
	}

	@Override
	protected void doPollinate(Block thisBlock, BlockState thisBlockState) {
		if (thisBlock instanceof CropsBlock) {
			CropsBlock thisCrop = (CropsBlock)thisBlock;
			if (thisCrop.isValidBonemealTarget(level, targetPos, thisBlockState, level.isClientSide())) {
				// Grow the Sapling
				thisCrop.performBonemeal((ServerWorld)level, random, targetPos, thisBlockState);
				// Reset pollination
				currentPollinateRecharge = pollinateRechargeMax;
				currentPollinateCharge = pollinateChargeTime;
			}
		} else if (thisBlock instanceof StemBlock) {
			StemBlock thisStem = (StemBlock)thisBlock;
			if (thisStem.isValidBonemealTarget(level, targetPos, thisBlockState, level.isClientSide())) {
				// Grow the Sapling
				thisStem.performBonemeal((ServerWorld)level, random, targetPos, thisBlockState);
				// Reset pollination
				currentPollinateRecharge = pollinateRechargeMax;
				currentPollinateCharge = pollinateChargeTime;
			}
		}
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		// Add additional goal
		this.goalSelector.addGoal(2, new Butterfly_Goal_Crop_FindPollinate(this, goalSpeed, maxRangeFromHome, 5));
	}
	
	
}
