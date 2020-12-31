package net.exachixkitsune.magicalmetals.mobs.goals;

import net.exachixkitsune.magicalmetals.mobs.Butterfly_Tree_Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class Butterfly_Goal_SitOnHome extends MoveToBlockGoal {

	public Butterfly_Goal_SitOnHome(CreatureEntity creatureIn, double speed, int length) {
		// Auto-generated Constructor
		this(creatureIn, speed, length, 1);
	}
	
	public Butterfly_Goal_SitOnHome(CreatureEntity creatureIn, double speed, int length, int p_i48796_5_) {
		// Auto-generated Constructor
		super(creatureIn, speed, length, p_i48796_5_);
	}

	@Override
	protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
		// Should only move home if pos is homePos.
		if (this.creature instanceof Butterfly_Tree_Entity) {
			Butterfly_Tree_Entity temp_creature = (Butterfly_Tree_Entity)this.creature;
			BlockPos homePos = temp_creature.getHomePosition();
			return (homePos.getX() == pos.getX() &&
					homePos.getY() == pos.getY() &&
					homePos.getZ() == pos.getZ());
		}
		else {
			return false;
		}
	}
	
}