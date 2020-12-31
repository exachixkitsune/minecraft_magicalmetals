package net.exachixkitsune.magicalmetals;

import net.exachixkitsune.magicalmetals.mobs.MobList;
import net.exachixkitsune.magicalmetals.setup.*;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//Primary Mod Class
@Mod(MagicalMetals.MODID)
public class MagicalMetals {
	public static final String MODID = "magicalmetals";
    public static final String MODNAME = "Magical Metals";
    public static final String VERSION = "1.16.3-1.2";
	
    // Constructor
	public MagicalMetals() {
		// Registry
		BlockRegister.registerBlocks();
		ItemRegister.registerItems();
		TileEntityRegister.registerTileEntities();
		EntityRegister.registerEntities();
		
		// Client Setup
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
        
        // Other Events
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
	}
	
	// Common Setup Events
	private void commonSetup(FMLCommonSetupEvent event) {
		// Using the same way as Botania (https://github.com/Vazkii/Botania/blob/master/src/main/java/vazkii/botania/common/Botania.java)
		// Mob Attributes
		event.enqueueWork(() -> {
			MobList.setup();
		});
	}
}
