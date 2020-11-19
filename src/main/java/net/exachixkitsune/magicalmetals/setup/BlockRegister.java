package net.exachixkitsune.magicalmetals.setup;

import net.exachixkitsune.magicalmetals.blocks.*;

import java.util.HashSet;
import java.util.Set;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.extras.MagicalItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegister {

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MagicalMetals.MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MagicalMetals.MODID);
	
	// Basic Stuff
	private static final int maxStackSize = 64;
	private static final Item.Properties baseProperties = new Item.Properties().maxStackSize(maxStackSize).group(MagicalItemGroup.GROUP);
	
	// Standard metal's blocks
	public static final RegistryObject<Block> STARMETAL_BLOCK = BLOCKS.register("metal_starmetal_block", 
			() -> BlocksList.starmetal_block);
	public static final RegistryObject<Item> STARMETAL_BLOCK_ITEM = ITEMS.register("metal_starmetal_block",
			() -> new BlockItem(STARMETAL_BLOCK.get(), baseProperties));
	
	public static final RegistryObject<Block> PURESTARMETAL_BLOCK = BLOCKS.register("metal_purestarmetal_block", 
			() -> BlocksList.purestarmetal_block);
	public static final RegistryObject<Item> PURESTARMETAL_BLOCK_ITEM = ITEMS.register("metal_purestarmetal_block",
			() -> new BlockItem(PURESTARMETAL_BLOCK.get(), new Item.Properties().maxStackSize(maxStackSize).group(MagicalItemGroup.GROUP)));
	
	public static final RegistryObject<Block> ADAMANT_BLOCK = BLOCKS.register("metal_adamant_block", 
			() -> BlocksList.adamant_block);
	public static final RegistryObject<Item> ADAMANT_BLOCK_ITEM = ITEMS.register("metal_adamant_block",
			() -> new BlockItem(ADAMANT_BLOCK.get(), new Item.Properties().maxStackSize(maxStackSize).group(MagicalItemGroup.GROUP)));
	public static final RegistryObject<Block> BLUEIRON_BLOCK = BLOCKS.register("metal_blueiron_block", 
			() -> BlocksList.blueiron_block);
	public static final RegistryObject<Item> BLUEIRON_BLOCK_ITEM = ITEMS.register("metal_blueiron_block",
			() -> new BlockItem(BLUEIRON_BLOCK.get(), new Item.Properties().maxStackSize(maxStackSize).group(MagicalItemGroup.GROUP)));
	public static final RegistryObject<Block> GREENIRON_BLOCK = BLOCKS.register("metal_greeniron_block", 
			() -> BlocksList.greeniron_block);
	public static final RegistryObject<Item> GREENIRON_BLOCK_ITEM = ITEMS.register("metal_greeniron_block",
			() -> new BlockItem(GREENIRON_BLOCK.get(), new Item.Properties().maxStackSize(maxStackSize).group(MagicalItemGroup.GROUP)));
	public static final RegistryObject<Block> LUMINOUSGOLD_BLOCK = BLOCKS.register("metal_luminousgold_block", 
			() -> BlocksList.luminousgold_block);
	public static final RegistryObject<Item> LUMINOUSGOLD_BLOCK_ITEM = ITEMS.register("metal_luminousgold_block",
			() -> new BlockItem(LUMINOUSGOLD_BLOCK.get(), new Item.Properties().maxStackSize(maxStackSize).group(MagicalItemGroup.GROUP)));
	
	// Nonmagical Metal Block
	public static final RegistryObject<Block> ORICHALCUM_BLOCK = BLOCKS.register("metal_orichalcum_block", 
			() -> BlocksList.orichalcum_block);
	public static final RegistryObject<Item> ORICHALCUM_BLOCK_ITEM = ITEMS.register("metal_orichalcum_block",
			() -> new BlockItem(ORICHALCUM_BLOCK.get(), new Item.Properties().maxStackSize(maxStackSize).group(MagicalItemGroup.GROUP)));
	
	// Ore
	public static final RegistryObject<Block> STARMETAL_ORE_BLOCK = BLOCKS.register("ore_starmetal_block", 
			() -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).func_235861_h_()));
	public static final RegistryObject<Item> STARMETAL_ORE_BLOCK_ITEM = ITEMS.register("ore_starmetal_block",
			() -> new BlockItem(STARMETAL_ORE_BLOCK.get(), baseProperties));
	
	// Active Blocks
	public static final RegistryObject<Block> TRANSMUTATION_MATRIX_BLOCK = BLOCKS.register("transmutation_matrix", 
			() -> BlocksList.transmutation_matrix);
	public static final RegistryObject<Item> TRANSMUATION_MATRIX_BLOCK_ITEM = ITEMS.register("transmutation_matrix",
			() -> new BlockItem(TRANSMUTATION_MATRIX_BLOCK.get(), baseProperties));
	
	// Biome boxes
	public static final RegistryObject<Block> TRANSMUATIONANCHOR_PURE_BLOCK = BLOCKS.register("transmutation_anchor_pure",
			() -> BlocksList.transmutation_anchor_pure);
	public static final RegistryObject<Block> TRANSMUATIONANCHOR_ADAMANT_BLOCK = BLOCKS.register("transmutation_anchor_adamant",
			() -> BlocksList.transmutation_anchor_adamant);
	public static final RegistryObject<Block> TRANSMUATIONANCHOR_BLUEIRON_BLOCK = BLOCKS.register("transmutation_anchor_blueiron",
			() -> BlocksList.transmutation_anchor_blueiron);
	public static final RegistryObject<Block> TRANSMUATIONANCHOR_GREENIRON_BLOCK = BLOCKS.register("transmutation_anchor_greeniron",
			() -> BlocksList.transmutation_anchor_greeniron);
	public static final RegistryObject<Block> TRANSMUATIONANCHOR_LUMINOUSGOLD_BLOCK = BLOCKS.register("transmutation_anchor_luminousgold",
			() -> BlocksList.transmutation_anchor_luminousgold);
	
	public static final RegistryObject<Item> TRANSMUATIONANCHOR_PURE_BLOCK_ITEM = ITEMS.register("transmutation_anchor_pure",
			() -> new BlockItem(TRANSMUATIONANCHOR_PURE_BLOCK.get(), baseProperties));
	public static final RegistryObject<Item> TRANSMUATIONANCHOR_ADAMANT_BLOCK_ITEM = ITEMS.register("transmutation_anchor_adamant",
			() -> new BlockItem(TRANSMUATIONANCHOR_ADAMANT_BLOCK.get(), baseProperties));
	public static final RegistryObject<Item> TRANSMUATIONANCHOR_BLUEIRON_BLOCK_ITEM = ITEMS.register("transmutation_anchor_blueiron",
			() -> new BlockItem(TRANSMUATIONANCHOR_BLUEIRON_BLOCK.get(), baseProperties));
	public static final RegistryObject<Item> TRANSMUATIONANCHOR_GREENIRON_BLOCK_ITEM = ITEMS.register("transmutation_anchor_greeniron",
			() -> new BlockItem(TRANSMUATIONANCHOR_GREENIRON_BLOCK.get(), baseProperties));
	public static final RegistryObject<Item> TRANSMUATIONANCHOR_LUMINOUSGOLD_BLOCK_ITEM = ITEMS.register("transmutation_anchor_luminousgold",
			() -> new BlockItem(TRANSMUATIONANCHOR_LUMINOUSGOLD_BLOCK.get(), baseProperties));
	
	// Machines
	public static final RegistryObject<Block> BREAKING_BLOCK = BLOCKS.register("breaking_block",
			() -> BlocksList.breaking_block);
	public static final RegistryObject<Item> BREAKING_BLOCK_ITEM = ITEMS.register("breaking_block",
			() -> new BlockItem(BREAKING_BLOCK.get(), baseProperties));
	
	//public static final Block[] MachineArray = { TRANSMUATION_MATRIX_BLOCK.get() };
	//public static final Set<Block> MachineSet = Collections.emptySortedSet().addAll(Arrays.asList(MachineArray));
	
	// Subsequent Lists;
	public static Set<Block> MachineSet() {
		Set<Block> machineSet = new HashSet<Block>();
		
		machineSet.add(TRANSMUTATION_MATRIX_BLOCK.get());
		machineSet.add(TRANSMUATIONANCHOR_PURE_BLOCK.get());
		machineSet.add(TRANSMUATIONANCHOR_ADAMANT_BLOCK.get());
		machineSet.add(TRANSMUATIONANCHOR_BLUEIRON_BLOCK.get());
		machineSet.add(TRANSMUATIONANCHOR_GREENIRON_BLOCK.get());
		machineSet.add(TRANSMUATIONANCHOR_LUMINOUSGOLD_BLOCK.get());
		machineSet.add(BREAKING_BLOCK.get());
		
		return machineSet;
	}
	
	
	public static void registerBlocks() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
}