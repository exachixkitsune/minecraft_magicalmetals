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
		return Block.Properties.create(Material.IRON, Colour)
				.hardnessAndResistance(1.0F)
				.func_235861_h_() // This makes it so you must use a tool.
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(1); // Stone+
	}
	
	public static final Block orichalcum_block 		= new MagicalFocusBlock(common_properties(MaterialColor.GOLD));
	public static final Block adamant_block 		= new MagicalFocusBlock(common_properties(MaterialColor.PURPLE));
	public static final Block blueiron_block 		= new MagicalFocusBlock(common_properties(MaterialColor.BLUE));
	public static final Block greeniron_block 		= new MagicalFocusBlock(common_properties(MaterialColor.GREEN));
	public static final Block luminousgold_block 	= new MagicalFocusBlock(common_properties(MaterialColor.GOLD).func_235838_a_((p_235838_1_) -> { return 10; }));
	
	public static final Block starmetal_block 		= new MagicalFocusBlock(common_properties( MaterialColor.IRON));
	public static final Block purestarmetal_block 	= new MagicalFocusBlock(common_properties( MaterialColor.IRON));
	
	public static final Block transmutation_matrix 	= new TransmutationMatrix(Properties.create(Material.IRON));
	
	public static final Block transmutation_anchor_pure 		= new PurestarmetalAnchor(Properties.create(Material.IRON));
	public static final Block transmutation_anchor_adamant 		= new AdamantAnchor(Properties.create(Material.IRON));
	public static final Block transmutation_anchor_blueiron 	= new BlueironAnchor(Properties.create(Material.IRON));
	public static final Block transmutation_anchor_greeniron 	= new GreenironAnchor(Properties.create(Material.IRON));
	public static final Block transmutation_anchor_luminousgold = new LuminousgoldAnchor(Properties.create(Material.IRON));
	
	public static final Block breaking_block = new BreakingBlock(Properties.create(Material.IRON));
}
