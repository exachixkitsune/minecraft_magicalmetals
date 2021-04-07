package net.exachixkitsune.magicalmetals.item.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;


public class Battle_Hoe extends HoeItem {
	
	int setFireAmount = 1*20; // 1s of fire

	public Battle_Hoe(IItemTier itemTier, Properties properties) {
		super(itemTier, 2, -1f, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		ItemStack temp_stack = stack;
		if (!target.level.isClientSide() && target.isInvertedHealAndHarm()) {
			// Set Undead on Fire
			target.setRemainingFireTicks(setFireAmount);
		}
		return super.hurtEnemy(temp_stack, target, attacker);
	}
	
}
