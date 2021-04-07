package net.exachixkitsune.magicalmetals.util;

import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum MagicalItemTiers implements IItemTier {
	STARMETAL    (0, ItemTier.DIAMOND.getSpeed(), ItemTier.DIAMOND.getAttackDamageBonus(), ItemTier.DIAMOND.getLevel(),
			ItemTier.DIAMOND.getEnchantmentValue(), ItemRegister.STARMETAL_INGOT_ITEM.get()),
	PURESTARMETAL(0, ItemTier.DIAMOND.getSpeed(), ItemTier.DIAMOND.getAttackDamageBonus(), ItemTier.DIAMOND.getLevel(),
			ItemTier.DIAMOND.getEnchantmentValue(), ItemRegister.PURESTARMETAL_INGOT_ITEM.get()),
	ADAMANT(0, ItemTier.DIAMOND.getSpeed(), ItemTier.DIAMOND.getAttackDamageBonus(), ItemTier.DIAMOND.getLevel(),
			ItemTier.DIAMOND.getEnchantmentValue(), ItemRegister.ADAMANT_INGOT_ITEM.get()),
	BLUEIRON(0, ItemTier.DIAMOND.getSpeed(), ItemTier.DIAMOND.getAttackDamageBonus(), ItemTier.DIAMOND.getLevel(),
			ItemTier.DIAMOND.getEnchantmentValue(), ItemRegister.BLUEIRON_INGOT_ITEM.get()),
	GREENIRON(0, ItemTier.DIAMOND.getSpeed(), ItemTier.DIAMOND.getAttackDamageBonus(), ItemTier.DIAMOND.getLevel(),
			ItemTier.DIAMOND.getEnchantmentValue(), ItemRegister.GREENIRON_INGOT_ITEM.get()),
	LUMINOUSGOLD(0, ItemTier.DIAMOND.getSpeed(), ItemTier.DIAMOND.getAttackDamageBonus(), ItemTier.DIAMOND.getLevel(),
			ItemTier.DIAMOND.getEnchantmentValue(), ItemRegister.LUMINOUSGOLD_INGOT_ITEM.get());
	
	private final int maxUses;
	private final float efficiency;
	private final float AttackDamage;
	private final int HarvestLevel;
	private final int Enchantability;
	private final Ingredient RepairMaterial;
	
	MagicalItemTiers(int in_maxUses, float in_efficiency, float in_attackDamage, int in_harvestLevel, int in_enchantability, Item repairItem) {
		this.maxUses = in_maxUses;
		this.efficiency = in_efficiency;
		this.AttackDamage = in_attackDamage;
		this.HarvestLevel = in_harvestLevel;
		this.Enchantability = in_enchantability;
		this.RepairMaterial = Ingredient.of(repairItem);
	}

	@Override
	public int getUses() {
		return this.maxUses;
	}

	@Override
	public float getSpeed() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.AttackDamage;
	}

	@Override
	public int getLevel() {
		return this.HarvestLevel;
	}

	@Override
	public int getEnchantmentValue() {
		return this.Enchantability;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.RepairMaterial;
	}

}
