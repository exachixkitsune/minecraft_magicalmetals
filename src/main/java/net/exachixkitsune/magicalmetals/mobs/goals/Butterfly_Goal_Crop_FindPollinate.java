package net.exachixkitsune.magicalmetals.mobs.goals;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.StemBlock;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Crop_Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class Butterfly_Goal_Crop_FindPollinate extends MoveToBlockGoal {

	public Butterfly_Goal_Crop_FindPollinate(CreatureEntity creatureIn, double speed, int length) {
		this(creatureIn, speed, length, 1);
	}
	
	public Butterfly_Goal_Crop_FindPollinate(CreatureEntity creatureIn, double speed, int length, int p_i48796_5_) {
		super(creatureIn, speed, length, p_i48796_5_);
	}
	
	@Override
	protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos checkLoc) {
		// Is this a crop?
		
		Block checkBlock = worldIn.getBlockState(checkLoc).getBlock();

		if (checkBlock instanceof CropsBlock) {
			CropsBlock checkBlockCrop = (CropsBlock)checkBlock;
			if (checkBlockCrop.canGrow(worldIn, checkLoc, worldIn.getBlockState(checkLoc), worldIn.isRemote())) {

				Butterfly_Crop_Entity this_butterfly = (Butterfly_Crop_Entity)this.creature;
				this_butterfly.setTargetPos(checkLoc);
				return true;
			}
		} else if (checkBlock instanceof StemBlock) {
			StemBlock checkBlockStem = (StemBlock)checkBlock;
			if (checkBlockStem.canGrow(worldIn, checkLoc, worldIn.getBlockState(checkLoc), worldIn.isRemote())) {

				Butterfly_Crop_Entity this_butterfly = (Butterfly_Crop_Entity)this.creature;
				this_butterfly.setTargetPos(checkLoc);
				return true;
			}
		}
		// No return? Return false
		return false;
	}

}
