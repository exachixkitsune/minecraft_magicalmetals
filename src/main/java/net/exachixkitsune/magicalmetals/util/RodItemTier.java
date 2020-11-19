package net.exachixkitsune.magicalmetals.util;

import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum RodItemTier implements IItemTier {
	STARMETAL(32, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.STARMETAL_INGOT_ITEM.get()),
	PURESTARMETAL(32, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getHarvestLevel(),
			ItemTier.DIAMOND.getEnchantability(), ItemRegister.PURESTARMETAL_INGOT_ITEM.get());
	
	private final int maxUses;
	private final float efficiency;
	private final float AttackDamage;
	private final int HarvestLevel;
	private final int Enchantability;
	private final Ingredient RepairMaterial;
	
	RodItemTier(int in_maxUses, float in_efficiency, float in_attackDamage, int in_harvestLevel, int in_enchantability, Item repairItem) {
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
