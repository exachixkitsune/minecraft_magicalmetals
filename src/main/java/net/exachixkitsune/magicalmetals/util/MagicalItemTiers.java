package net.exachixkitsune.magicalmetals.util;

import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum MagicalItemTiers implements IItemTier {
	STARMETAL    (0, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.STARMETAL_INGOT_ITEM.get()),
	PURESTARMETAL(0, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.PURESTARMETAL_INGOT_ITEM.get()),
	ADAMANT(0, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.ADAMANT_INGOT_ITEM.get()),
	BLUEIRON(0, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.BLUEIRON_INGOT_ITEM.get()),
	GREENIRON(0, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.GREENIRON_INGOT_ITEM.get()),
	LUMINOUSGOLD(0, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.LUMINOUSGOLD_INGOT_ITEM.get());
	
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
		this.RepairMaterial = Ingredient.fromItems(repairItem);
	}
	
	@Override
	public int getMaxUses() {
		return this.maxUses;
	}
	@Override
	public float getEfficiency() {
		return this.efficiency;
	}
	@Override
	public float getAttackDamage() {
		return this.AttackDamage;
	}
	@Override
	public int getHarvestLevel() {
		return this.HarvestLevel;
	}
	@Override
	public int getEnchantability() {
		return this.Enchantability;
	}
	@Override
	public Ingredient getRepairMaterial() {
		return this.RepairMaterial;
	}

}
