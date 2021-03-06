package net.exachixkitsune.magicalmetals.setup;

import net.exachixkitsune.magicalmetals.tileentities.*;
import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityRegister {

	private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MagicalMetals.MODID);
	
	public static final RegistryObject<TileEntityType<?>> TRANSMUTATIONMATRIX = TILE_ENTITIES.register("transmuation_matrix",
			() -> TileEntityTypes.TRANSMUTATIONMATRIXTILE);
	
	public static final RegistryObject<TileEntityType<?>> BREAKINGBLOCK = TILE_ENTITIES.register("breaking_block",
			() -> TileEntityTypes.BREAKINGBLOCKTILE);
	
	public static final RegistryObject<TileEntityType<?>> BUTTERFLYBOXTREE = TILE_ENTITIES.register("butterflybox_tree",
			() -> TileEntityTypes.BUTTERFLYBOXTREETILE);
	public static final RegistryObject<TileEntityType<?>> BUTTERFLYBOXCROP = TILE_ENTITIES.register("butterflybox_crop",
			() -> TileEntityTypes.BUTTERFLYBOXCROPTILE);
	public static final RegistryObject<TileEntityType<?>> BUTTERFLYBOXGRASS = TILE_ENTITIES.register("butterflybox_grass",
			() -> TileEntityTypes.BUTTERFLYBOXGRASSTILE);
		
	public static void registerTileEntities() {
		TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}