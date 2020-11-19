package net.exachixkitsune.magicalmetals.blocks.transmutation;

import net.exachixkitsune.magicalmetals.setup.BlockRegister;
import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlueironAnchor extends TransmutationAnchor {

	public BlueironAnchor(Properties properties) {
		super(properties);
	}

	@Override
	public Block ConvertOrichalcumToBlock() {
		return BlockRegister.BLUEIRON_BLOCK.get();
	}

	@Override
	public Item ConvertOrichalcumToIngot() {
		return ItemRegister.BLUEIRON_INGOT_ITEM.get();
	}

}
