package net.exachixkitsune.magicalmetals.blocks.transmutation;

import net.exachixkitsune.magicalmetals.setup.BlockRegister;
import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class LuminousgoldAnchor extends TransmutationAnchor {

	public LuminousgoldAnchor(Properties properties) {
		super(properties);
	}

	@Override
	public Block ConvertOrichalcumToBlock() {
		return BlockRegister.LUMINOUSGOLD_BLOCK.get();
	}

	@Override
	public Item ConvertOrichalcumToIngot() {
		return ItemRegister.LUMINOUSGOLD_INGOT_ITEM.get();
	}

}
