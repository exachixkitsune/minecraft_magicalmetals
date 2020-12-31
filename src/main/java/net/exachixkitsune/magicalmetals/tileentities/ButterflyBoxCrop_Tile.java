package net.exachixkitsune.magicalmetals.tileentities;

import net.exachixkitsune.magicalmetals.mobs.Butterfly_Entity;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Crop_Entity;
import net.exachixkitsune.magicalmetals.setup.EntityRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ButterflyBoxCrop_Tile extends ButterflyBox_Tile {

	public ButterflyBoxCrop_Tile() {
		super(TileEntityTypes.BUTTERFLYBOXCROPTILE);
	}

	@Override
	protected Butterfly_Entity makeButterfly(World world) {
		// Make the butterfly
		Butterfly_Crop_Entity this_butterfly = new Butterfly_Crop_Entity(EntityRegister.BUTTERFLY_CROP.get(), world);
		return this_butterfly;
	}

	@Override
	protected boolean isMyButterfly(Entity entity) {
		return (entity instanceof Butterfly_Crop_Entity);
	}
}
