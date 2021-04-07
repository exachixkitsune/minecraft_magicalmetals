package net.exachixkitsune.magicalmetals.mobs.client;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Grass_Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Butterfly_Grass_Renderer extends MobRenderer<Butterfly_Grass_Entity, Butterfly_Grass_Model> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(MagicalMetals.MODID, "textures/entity/butterfly_grass.png");
	
	// Default constructor
	public Butterfly_Grass_Renderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new Butterfly_Grass_Model(), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Butterfly_Grass_Entity entity) {
		return TEXTURE;
	}

}
