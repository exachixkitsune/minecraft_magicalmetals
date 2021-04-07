package net.exachixkitsune.magicalmetals.mobs.goals;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Tree_Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class Butterfly_Goal_Tree_FindPollinate extends MoveToBlockGoal {

	public Butterfly_Goal_Tree_FindPollinate(CreatureEntity creatureIn, double speed, int length) {
		this(creatureIn, speed, length, 1);
	}
	
	public Butterfly_Goal_Tree_FindPollinate(CreatureEntity creatureIn, double speed, int length, int p_i48796_5_) {
		super(creatureIn, speed, length, p_i48796_5_);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected boolean isValidTarget(IWorldReader worldIn, BlockPos pos) {
		// Is this position next to a sapling
		//Block thisBlock = worldIn.getBlockState(pos).getBlock();
		//return (thisBlock instanceof SaplingBlock);
		BlockState thisBlockState = worldIn.getBlockState(pos);
		if (thisBlockState.isAir(worldIn, pos)) {
			BlockPos[] checkLocations = {pos.north(), pos.south(), pos.east(), pos.west()};
			for (BlockPos checkLoc : checkLocations) {
				Block checkBlock = worldIn.getBlockState(checkLoc).getBlock();
				if (checkBlock instanceof SaplingBlock) {
					Butterfly_Tree_Entity this_butterfly = (Butterfly_Tree_Entity)this.mob;
					this_butterfly.setTargetPos(checkLoc);
					return true;
				}
			}
			// No return? Return false
			return false;
		} else {
			return false;
		}
	}

}
