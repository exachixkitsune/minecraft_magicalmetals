package net.exachixkitsune.magicalmetals.blocks.transmutation;

import net.exachixkitsune.magicalmetals.setup.BlockRegister;
import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class PurestarmetalAnchor extends TransmutationAnchor {

	public PurestarmetalAnchor(Properties properties) {
		super(properties);
	}

	@Override
	public Block ConvertOrichalcumToBlock() {
		return BlockRegister.PURESTARMETAL_BLOCK.get();
	}

	@Override
	public Item ConvertOrichalcumToIngot() {
		return ItemRegister.PURESTARMETAL_INGOT_ITEM.get();
	}

}
