package net.exachixkitsune.magicalmetals.util;

import net.exachixkitsune.magicalmetals.setup.ItemRegister;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.item.ArmorMaterial;

public enum MagicalArmourTiers implements IArmorMaterial {
	STARMETAL ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantability(), ArmorMaterial.DIAMOND.getSoundEvent(),
			ItemRegister.STARMETAL_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.func_230304_f_()),
	PURESTARMETAL("purestarmetal", 0, ArmorMaterial.DIAMOND.getEnchantability(), ArmorMaterial.DIAMOND.getSoundEvent(),
			ItemRegister.PURESTARMETAL_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.func_230304_f_()),
	ADAMANT ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantability(), ArmorMaterial.DIAMOND.getSoundEvent(),
			ItemRegister.ADAMANT_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.func_230304_f_()),
	BLUEIRON ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantability(), ArmorMaterial.DIAMOND.getSoundEvent(),
			ItemRegister.BLUEIRON_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.func_230304_f_()),
	GREENIRON ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantability(), ArmorMaterial.DIAMOND.getSoundEvent(),
			ItemRegister.GREENIRON_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.func_230304_f_()),
	LUMINOUSGOLD ("starmetal", 0, ArmorMaterial.DIAMOND.getEnchantability(), ArmorMaterial.DIAMOND.getSoundEvent(),
			ItemRegister.LUMINOUSGOLD_INGOT_ITEM.get(), ArmorMaterial.DIAMOND.getToughness(), ArmorMaterial.DIAMOND.func_230304_f_());

	private final String name;
	private final int durability;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final Ingredient repairMaterial;
	private final float toughness;
	private final float otherProperty;
	
	MagicalArmourTiers(String in_name, int in_durability, int in_enchantability, SoundEvent in_soundEvent,
			Item in_repairMaterial, float in_toughness, float in_otherProperty) {
		this.name = in_name;
		this.durability = in_durability;
		this.enchantability = in_enchantability;
		this.soundEvent = in_soundEvent;
		this.repairMaterial = Ingredient.fromItems(in_repairMaterial);
		this.toughness = in_toughness;
		this.otherProperty = in_otherProperty;
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return this.durability;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return ArmorMaterial.DIAMOND.getDamageReductionAmount(slotIn);
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial;
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
	public float func_230304_f_() {
		return this.otherProperty;
	}

}
