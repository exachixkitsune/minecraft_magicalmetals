package net.exachixkitsune.magicalmetals.blocks;

import net.exachixkitsune.magicalmetals.blocks.transmutation.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BlocksList {
	private BlocksList() {}
	
	public static final AbstractBlock.Properties common_properties(MaterialColor Colour) {
		return Block.Properties.of(Material.METAL, Colour)
				.strength(1.0F)
				.requiresCorrectToolForDrops()
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(1); // Stone+
	}
	
	public static final Block orichalcum_block 		= new MagicalFocusBlock(common_properties(MaterialColor.GOLD));
	public static final Block adamant_block 		= new MagicalFocusBlock(common_properties(MaterialColor.COLOR_PURPLE));
	public static final Block blueiron_block 		= new MagicalFocusBlock(common_properties(MaterialColor.COLOR_BLUE));
	public static final Block greeniron_block 		= new MagicalFocusBlock(common_properties(MaterialColor.COLOR_GREEN));
	public static final Block luminousgold_block 	= new MagicalFocusBlock(common_properties(MaterialColor.GOLD).lightLevel((p_235838_1_) -> { return 10; }));
	
	public static final Block starmetal_block 		= new MagicalFocusBlock(common_properties( MaterialColor.METAL));
	public static final Block purestarmetal_block 	= new MagicalFocusBlock(common_properties( MaterialColor.METAL));
	
	public static final Block transmutation_matrix 	= new TransmutationMatrix(Properties.of(Material.METAL));
	
	public static final Block transmutation_anchor_pure 		= new PurestarmetalAnchor(Properties.of(Material.METAL));
	public static final Block transmutation_anchor_adamant 		= new AdamantAnchor(Properties.of(Material.METAL));
	public static final Block transmutation_anchor_blueiron 	= new BlueironAnchor(Properties.of(Material.METAL));
	public static final Block transmutation_anchor_greeniron 	= new GreenironAnchor(Properties.of(Material.METAL));
	public static final Block transmutation_anchor_luminousgold = new LuminousgoldAnchor(Properties.of(Material.METAL));
	
	public static final Block breaking_block = new BreakingBlock(Properties.of(Material.METAL));
	
	public static final Block butterflybox_tree = new ButterflyBoxTree(common_properties(MaterialColor.COLOR_GREEN).harvestTool(ToolType.AXE));
	public static final Block butterflybox_crop = new ButterflyBoxCrop(common_properties(MaterialColor.COLOR_GREEN).harvestTool(ToolType.AXE));
	public static final Block butterflybox_grass = new ButterflyBoxGrass(common_properties(MaterialColor.COLOR_GREEN).harvestTool(ToolType.AXE));
}
