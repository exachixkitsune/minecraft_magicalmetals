package net.exachixkitsune.magicalmetals.tileentities;

import net.exachixkitsune.magicalmetals.mobs.Butterfly_Entity;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Tree_Entity;
import net.exachixkitsune.magicalmetals.setup.EntityRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ButterflyBoxTree_Tile extends ButterflyBox_Tile {

	public ButterflyBoxTree_Tile() {
		super(TileEntityTypes.BUTTERFLYBOXTREETILE);
	}

	@Override
	protected Butterfly_Entity makeButterfly(World world) {
		// Make the butterfly
		Butterfly_Tree_Entity this_butterfly = new Butterfly_Tree_Entity(EntityRegister.BUTTERFLY_TREE.get(), world);
		return this_butterfly;
	}

	@Override
	protected boolean isMyButterfly(Entity entity) {
		return (entity instanceof Butterfly_Tree_Entity);
	}

}
