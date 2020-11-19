package net.exachixkitsune.magicalmetals.blocks.transmutation;

import net.exachixkitsune.magicalmetals.setup.BlockRegister;
import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class GreenironAnchor extends TransmutationAnchor {

	public GreenironAnchor(Properties properties) {
		super(properties);
	}

	@Override
	public Block ConvertOrichalcumToBlock() {
		return BlockRegister.GREENIRON_BLOCK.get();
	}

	@Override
	public Item ConvertOrichalcumToIngot() {
		return ItemRegister.GREENIRON_INGOT_ITEM.get();
	}

}
