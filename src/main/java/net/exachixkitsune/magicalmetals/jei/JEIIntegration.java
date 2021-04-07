package net.exachixkitsune.magicalmetals.jei;

import net.exachixkitsune.magicalmetals.MagicalMetals;
import net.exachixkitsune.magicalmetals.setup.BlockRegister;

import java.util.HashSet;
import java.util.Set;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class JEIIntegration implements IModPlugin {
	private static final ResourceLocation ID = new ResourceLocation(MagicalMetals.MODID, "jei");
	
	@Override
	public ResourceLocation getPluginUid() {
		return ID;
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		// Had to look at Ice & Fire as to how to do this.
		Set<Item> describedItems = new HashSet<Item>();
		describedItems.add(BlockRegister.PURESTARMETAL_BLOCK_ITEM.get());
		describedItems.add(BlockRegister.ADAMANT_BLOCK_ITEM.get());
		describedItems.add(BlockRegister.BLUEIRON_BLOCK_ITEM.get());
		describedItems.add(BlockRegister.GREENIRON_BLOCK_ITEM.get());
		describedItems.add(BlockRegister.LUMINOUSGOLD_BLOCK_ITEM.get());
		
		describedItems.forEach((Item in) -> registration.addIngredientInfo(new ItemStack(in),
				VanillaTypes.ITEM,
				in.getDescriptionId()+".jei"));
	}

}
