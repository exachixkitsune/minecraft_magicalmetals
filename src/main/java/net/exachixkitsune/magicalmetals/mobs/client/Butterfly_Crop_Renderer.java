package net.exachixkitsune.magicalmetals.mobs.client;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Crop_Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Butterfly_Crop_Renderer extends MobRenderer<Butterfly_Crop_Entity, Butterfly_Crop_Model> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(MagicalMetals.MODID, "textures/entity/butterfly_crop.png");
	
	// Default constructor
	public Butterfly_Crop_Renderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new Butterfly_Crop_Model(), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Butterfly_Crop_Entity entity) {
		return TEXTURE;
	}

}
