package net.exachixkitsune.magicalmetals.mobs.client;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.mobs.Butterfly_Tree_Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Butterfly_Tree_Renderer extends MobRenderer<Butterfly_Tree_Entity, Butterfly_Tree_Model> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(MagicalMetals.MODID, "textures/entity/butterfly_tree.png");
	
	// Default constructor
	public Butterfly_Tree_Renderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new Butterfly_Tree_Model(), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Butterfly_Tree_Entity entity) {
		return TEXTURE;
	}

}
