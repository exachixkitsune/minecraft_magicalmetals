package net.exachixkitsune.magicalmetals.blocks.transmutation;

import net.exachixkitsune.magicalmetals.blocks.MagicalFocusBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public abstract class TransmutationAnchor extends MagicalFocusBlock {

	public TransmutationAnchor(Properties properties) {
		super(properties);
	}
	
	// Function that tells you what the block converts to.
	public abstract Block ConvertOrichalcumToBlock();
	public abstract Item ConvertOrichalcumToIngot();
}
