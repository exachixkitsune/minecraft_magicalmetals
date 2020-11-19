package net.exachixkitsune.magicalmetals.blocks.transmutation;

import net.exachixkitsune.magicalmetals.setup.BlockRegister;
import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class AdamantAnchor extends TransmutationAnchor {

	public AdamantAnchor(Properties properties) {
		super(properties);
	}

	@Override
	public Block ConvertOrichalcumToBlock() {
		return BlockRegister.ADAMANT_BLOCK.get();
	}

	@Override
	public Item ConvertOrichalcumToIngot() {
		return ItemRegister.ADAMANT_INGOT_ITEM.get();
	}

}
