package net.exachixkitsune.magicalmetals.setup;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.mobs.MobList;
import net.exachixkitsune.magicalmetals.mobs.client.Butterfly_Crop_Renderer;
import net.exachixkitsune.magicalmetals.mobs.client.Butterfly_Grass_Renderer;
import net.exachixkitsune.magicalmetals.mobs.client.Butterfly_Tree_Renderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

// This class holds all the object registration that is client-size
@Mod.EventBusSubscriber(modid = MagicalMetals.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
	
	public static void init(final FMLClientSetupEvent event) {
		// Block Rendering.
		RenderTypeLookup.setRenderLayer(BlockRegister.STARMETAL_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.PURESTARMETAL_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.ADAMANT_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.BLUEIRON_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.GREENIRON_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.LUMINOUSGOLD_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.ORICHALCUM_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.STARMETAL_ORE_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.TRANSMUTATION_MATRIX_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.TRANSMUATIONANCHOR_PURE_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.TRANSMUATIONANCHOR_ADAMANT_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.TRANSMUATIONANCHOR_BLUEIRON_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.TRANSMUATIONANCHOR_GREENIRON_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.TRANSMUATIONANCHOR_LUMINOUSGOLD_BLOCK.get(), RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(BlockRegister.BREAKING_BLOCK.get(), RenderType.getSolid());
		
		// Entity Rendering Register
		RenderingRegistry.registerEntityRenderingHandler(MobList.BUTTERFLY_TREE, Butterfly_Tree_Renderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MobList.BUTTERFLY_CROP, Butterfly_Crop_Renderer::new);
		RenderingRegistry.registerEntityRenderingHandler(MobList.BUTTERFLY_GRASS, Butterfly_Grass_Renderer::new);
	}
}