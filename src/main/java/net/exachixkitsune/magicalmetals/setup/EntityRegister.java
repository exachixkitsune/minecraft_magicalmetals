package net.exachixkitsune.magicalmetals.setup;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.mobs.*;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegister {
	private static final DeferredRegister<EntityType<?>> ENTITYTYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MagicalMetals.MODID);
	
	// Mobs
	public static final RegistryObject<EntityType<Butterfly_Tree_Entity>> BUTTERFLY_TREE = ENTITYTYPES.register("butterfly_tree",
			() -> MobList.BUTTERFLY_TREE);
	public static final RegistryObject<EntityType<Butterfly_Crop_Entity>> BUTTERFLY_CROP = ENTITYTYPES.register("butterfly_crop",
			() -> MobList.BUTTERFLY_CROP);
	public static final RegistryObject<EntityType<Butterfly_Grass_Entity>> BUTTERFLY_GRASS = ENTITYTYPES.register("butterfly_grass",
			() -> MobList.BUTTERFLY_GRASS);
	
	public static void registerEntities() {
		ENTITYTYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}
 