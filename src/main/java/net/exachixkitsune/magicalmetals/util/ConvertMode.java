package net.exachixkitsune.magicalmetals.util;

import net.exachixkitsune.magicalmetals.blocks.BlocksList;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public enum ConvertMode {
	DEFAULT("Pure Starmetal", BlocksList.purestarmetal_block, "magicalmetals.purestarmetal"),
	ADAMANT("Adamant", BlocksList.adamant_block, "magicalmetals.adamant"),
	GREENIRON("Green Iron", BlocksList.greeniron_block, "magicalmetals.greeniron"),
	BLUEIRON("Blue Iron", BlocksList.blueiron_block, "magicalmetals.blueiron"),
	LUMINOUSGOLD("Luminous Gold", BlocksList.luminousgold_block, "magicalmetals.luminousgold");
	
	@SuppressWarnings("unused")
	private final String shortName;
	private final Block convertTo;
	private final String langToken;
	
	ConvertMode(String in_shortName, Block in_convertTo, String in_MessageText) {
		this.shortName = in_shortName;
		this.convertTo = in_convertTo;
		this.langToken = in_MessageText;
	}
	
	public Block getConvertTo_Block() {
		return this.convertTo;
	}
	public TranslationTextComponent getTranslatedName() {
		return new TranslationTextComponent(this.langToken);
	}
	
	// Function that works out what you convert to
	public static ConvertMode determineConvertTo(World world, BlockPos myPos) {
		if (myPos.getY() < 30) {
			return ConvertMode.ADAMANT;
		}
		else {
			Biome myBiome = world.getBiome(myPos);
			if ((myBiome.getBiomeCategory() == Biome.Category.BEACH) ||
					(myBiome.getBiomeCategory() == Biome.Category.RIVER)  ||
					(myBiome.getBiomeCategory() == Biome.Category.OCEAN)||
					(myBiome.getBiomeCategory() == Biome.Category.SWAMP)) {
				return ConvertMode.GREENIRON;
			}
			else {
				float myTemperature = myBiome.getTemperature(myPos);
				if (myTemperature <= 0.3) {
					return ConvertMode.BLUEIRON;
				}
				else if (myTemperature >= 1.0) {
					return ConvertMode.LUMINOUSGOLD;
				}
			}
		}
		// OTHERWISE
		return ConvertMode.DEFAULT;
	}
}