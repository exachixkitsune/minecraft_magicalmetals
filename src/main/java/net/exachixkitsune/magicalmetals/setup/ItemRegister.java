package net.exachixkitsune.magicalmetals.setup;

//import net.exachixkitsune.magicalmetals.blocks.*;
import net.exachixkitsune.magicalmetals.item.*;
import net.exachixkitsune.magicalmetals.item.tools.*;
import net.exachixkitsune.magicalmetals.util.MagicalItemTiers;
import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.extras.MagicalItemGroup;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister {

	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MagicalMetals.MODID);
	
	private static final int maxStackSize = 64;
	private static final int toolStackSize = 1;
	private static final int effectDurationMinor = 30*20; // 30 seconds in Ticks
	
	// Standard metal's blocks
	public static final RegistryObject<Item> STARMETAL_INGOT_ITEM = ITEMS.register("metal_starmetal_ingot",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	public static final RegistryObject<Item> PURESTARMETAL_INGOT_ITEM = ITEMS.register("metal_purestarmetal_ingot",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	public static final RegistryObject<Item> ADAMANT_INGOT_ITEM = ITEMS.register("metal_adamant_ingot",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	public static final RegistryObject<Item> BLUEIRON_INGOT_ITEM = ITEMS.register("metal_blueiron_ingot",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	public static final RegistryObject<Item> GREENIRON_INGOT_ITEM = ITEMS.register("metal_greeniron_ingot",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	public static final RegistryObject<Item> LUMINOUSGOLD_INGOT_ITEM = ITEMS.register("metal_luminousgold_ingot",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	
	public static final RegistryObject<Item> ORICHALCUM_INGOT_ITEM = ITEMS.register("metal_orichalcum_ingot",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	
	// Purification Salts
	public static final RegistryObject<Item> PURIFYING_DUST = ITEMS.register("purifying_dust",
			() -> new Item(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	
	
	// Tools
	public static final RegistryObject<Item> TOOL_BATTLE_HOE = ITEMS.register("battle_hoe",
			() -> new Battle_Hoe(MagicalItemTiers.GREENIRON, new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize)));
	
	
	// Misc items
	public static final RegistryObject<Item> TINY_FLAG = ITEMS.register("tiny_flag",
			() -> new TinyFlag(new Item.Properties().tab(MagicalItemGroup.GROUP).stacksTo(maxStackSize)));
	
	
	// Rods
	public static final RegistryObject<Item> ROD_COMPONENT = ITEMS.register("rod_component",
			() -> new Item(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize)));
	public static final RegistryObject<Item> ROD_DISPEL = ITEMS.register("rod_dispel",
			() -> new Magical_Rod_Dispel(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize)));
	public static final RegistryObject<Item> ROD_HEAL = ITEMS.register("rod_heal",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.HEAL, 1, 0));
	public static final RegistryObject<Item> ROD_REGEN = ITEMS.register("rod_regen",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.REGENERATION, effectDurationMinor, 2));
	public static final RegistryObject<Item> ROD_RESIST = ITEMS.register("rod_resistance",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.DAMAGE_RESISTANCE, effectDurationMinor, 2));
	public static final RegistryObject<Item> ROD_STRENGTH = ITEMS.register("rod_strength",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.DAMAGE_BOOST, effectDurationMinor, 2));
	public static final RegistryObject<Item> ROD_HASTE = ITEMS.register("rod_haste",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.DIG_SPEED, effectDurationMinor, 1));
	public static final RegistryObject<Item> ROD_SATURATION = ITEMS.register("rod_saturation",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.SATURATION, 4, 0));
	public static final RegistryObject<Item> ROD_WATER = ITEMS.register("rod_water",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.WATER_BREATHING, effectDurationMinor, 0));
	public static final RegistryObject<Item> ROD_SIGHT = ITEMS.register("rod_sight",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.NIGHT_VISION, effectDurationMinor, 0));
	public static final RegistryObject<Item> ROD_FIRERESIST = ITEMS.register("rod_fireresist",
			() -> new Magical_Rod(new Item.Properties().fireResistant().tab(MagicalItemGroup.GROUP).stacksTo(toolStackSize),
					Effects.FIRE_RESISTANCE, effectDurationMinor, 0));
	
	public static void registerItems() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}