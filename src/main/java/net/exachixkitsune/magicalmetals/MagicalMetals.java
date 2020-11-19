package net.exachixkitsune.magicalmetals;

import net.exachixkitsune.magicalmetals.setup.*;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//Primary Mod Class
@Mod(MagicalMetals.MODID)
public class MagicalMetals {
	public static final String MODID = "magicalmetals";
    public static final String MODNAME = "Magical Metals";
    public static final String VERSION = "1.16.3-1.0";
	
    // Constructor
	public MagicalMetals() {
		
		BlockRegister.registerBlocks();
		ItemRegister.registerItems();
		TileEntityRegister.registerTileEntities();
		
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
	}
	
}