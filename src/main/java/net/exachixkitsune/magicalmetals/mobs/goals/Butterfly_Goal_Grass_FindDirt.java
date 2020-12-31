package net.exachixkitsune.magicalmetals.mobs.goals;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Grass_Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class Butterfly_Goal_Grass_FindDirt extends MoveToBlockGoal {

	public Butterfly_Goal_Grass_FindDirt(CreatureEntity creatureIn, double speed, int length) {
		this(creatureIn, speed, length, 1);
	}
	
	public Butterfly_Goal_Grass_FindDirt(CreatureEntity creatureIn, double speed, int length, int p_i48796_5_) {
		super(creatureIn, speed, length, p_i48796_5_);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos checkLoc) {
		// Is this dirt?
		
		Block checkBlock = worldIn.getBlockState(checkLoc).getBlock();

		if (checkBlock == Blocks.DIRT) {
			
			
			if (worldIn.getBlockState(checkLoc.up()).isAir()) {

				Butterfly_Grass_Entity this_butterfly = (Butterfly_Grass_Entity)this.creature;
				this_butterfly.setTargetPos(checkLoc);
				return true;
			}
		}
		// No return? Return false
		return false;
	}

}
