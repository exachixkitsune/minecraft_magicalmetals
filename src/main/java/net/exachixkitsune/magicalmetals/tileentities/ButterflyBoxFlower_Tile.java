package net.exachixkitsune.magicalmetals.tileentities;

import net.exachixkitsune.magicalmetals.mobs.Butterfly_Entity;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Grass_Entity;
import net.exachixkitsune.magicalmetals.setup.EntityRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ButterflyBoxFlower_Tile extends ButterflyBox_Tile {

	public ButterflyBoxFlower_Tile() {
		super(TileEntityTypes.BUTTERFLYBOXGRASSTILE);
	}

	@Override
	protected Butterfly_Entity makeButterfly(World world) {
		// Make the butterfly
		Butterfly_Grass_Entity this_butterfly = new Butterfly_Grass_Entity(EntityRegister.BUTTERFLY_GRASS.get(), world);
		return this_butterfly;
	}

	@Override
	protected boolean isMyButterfly(Entity entity) {
		return (entity instanceof Butterfly_Grass_Entity);
	}
}
