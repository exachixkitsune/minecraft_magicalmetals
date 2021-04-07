package net.exachixkitsune.magicalmetals.blocks;

import net.exachixkitsune.magicalmetals.tileentities.ButterflyBoxCrop_Tile;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ButterflyBoxCrop extends Block {
	
	public ButterflyBoxCrop(AbstractBlock.Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ButterflyBoxCrop_Tile();
	}
	
	@Override
	public void setPlacedBy(World world_in, BlockPos pos_in, BlockState state_in, LivingEntity livingEntity_in, ItemStack itemStack_in) {
		super.setPlacedBy(world_in, pos_in, state_in, livingEntity_in, itemStack_in);
		TileEntity tileentity = world_in.getBlockEntity(pos_in);
		if (tileentity instanceof ButterflyBoxCrop_Tile) { // prevent a crash if not the right type, or is null
			ButterflyBoxCrop_Tile tileEntityData = (ButterflyBoxCrop_Tile)tileentity;
			tileEntityData.setup();
		}
	}
}
