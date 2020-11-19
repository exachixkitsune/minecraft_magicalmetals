package net.exachixkitsune.magicalmetals.extras;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

// Code here very inspired by https://github.com/Vazkii/Botania/

public class MagicalItemGroup extends ItemGroup {
	
	public static final MagicalItemGroup GROUP = new MagicalItemGroup();
	
	public MagicalItemGroup() {
		super(MagicalMetals.MODID);
		setNoTitle();
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemRegister.PURESTARMETAL_INGOT_ITEM.get());
	}
	
}