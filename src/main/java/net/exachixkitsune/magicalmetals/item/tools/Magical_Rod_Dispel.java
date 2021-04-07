package net.exachixkitsune.magicalmetals.item.tools;

import java.util.Set;

import net.exachixkitsune.magicalmetals.setup.BlockRegister;
import net.exachixkitsune.magicalmetals.util.RodItemTier;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Magical_Rod_Dispel extends ToolItem {

	private static final Set<Block> effectiveBlocks = BlockRegister.MachineSet();
	
	public Magical_Rod_Dispel(Item.Properties properties) {
		// Attack damage here is so that only a half-heart of damage is done.
		super(-3, 1, RodItemTier.STARMETAL, effectiveBlocks, properties);
	}
	
	// Right-click uses tool on self
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		// Basically, hit self with it.
		// This item
		ItemStack thisItemStack = player.getItemInHand(hand);
		// Do a hit
		hurtEnemy(thisItemStack, player, player);
		// Return
		return super.use(world, player, hand);
	}
	
	// Yes you can use this tool on an entity
	@Override
	public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
		
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		// Compensate for damage
		//target.heal(1);
		// Apply effect
		target.curePotionEffects(Items.MILK_BUCKET.getDefaultInstance());
		return super.hurtEnemy(stack, target, attacker);
	}
}
