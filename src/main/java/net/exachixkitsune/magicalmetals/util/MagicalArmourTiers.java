package net.exachixkitsune.magicalmetals.util;

import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.item.ArmorMaterial;

public enum MagicalArmourTiers implements IArmorMaterial {
	STARMETAL ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantmentValue(), ArmorMaterial.DIAMOND.getEquipSound(),
			ItemRegister.STARMETAL_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.getKnockbackResistance()),
	PURESTARMETAL("purestarmetal", 0, ArmorMaterial.DIAMOND.getEnchantmentValue(), ArmorMaterial.DIAMOND.getEquipSound(),
			ItemRegister.PURESTARMETAL_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.getKnockbackResistance()),
	ADAMANT ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantmentValue(), ArmorMaterial.DIAMOND.getEquipSound(),
			ItemRegister.ADAMANT_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.getKnockbackResistance()),
	BLUEIRON ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantmentValue(), ArmorMaterial.DIAMOND.getEquipSound(),
			ItemRegister.BLUEIRON_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.getKnockbackResistance()),
	GREENIRON ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantmentValue(), ArmorMaterial.DIAMOND.getEquipSound(),
			ItemRegister.GREENIRON_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.getKnockbackResistance()),
	LUMINOUSGOLD ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantmentValue(), ArmorMaterial.DIAMOND.getEquipSound(),
			ItemRegister.LUMINOUSGOLD_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.getKnockbackResistance());

	private final String name;
	private final int durability;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final Ingredient repairMaterial;
	private final float toughness;
	private final float knockbackResistance;
	
	MagicalArmourTiers(String in_name, int in_durability, int in_enchantability, SoundEvent in_soundEvent,
			Item in_repairMaterial, float in_toughness, float in_knockbackResistance) {
		this.name = in_name;
		this.durability = in_durability;
		this.enchantability = in_enchantability;
		this.soundEvent = in_soundEvent;
		this.repairMaterial = Ingredient.of(in_repairMaterial);
		this.toughness = in_toughness;
		this.knockbackResistance = in_knockbackResistance;
	}
	
	@Override
	public int getDefenseForSlot(EquipmentSlotType slotIn) {
		return ArmorMaterial.DIAMOND.getDefenseForSlot(slotIn);
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType slotIn) {
		return this.durability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial;
	}

}
