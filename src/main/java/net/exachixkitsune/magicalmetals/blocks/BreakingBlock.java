package net.exachixkitsune.magicalmetals.blocks;

import javax.annotation.Nullable;

import net.exachixkitsune.magicalmetals.tileentities.BreakingBlockTile;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BreakingBlock extends Block {
	
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	
	public BreakingBlock(AbstractBlock.Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState()
				.setValue(POWERED, false));
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(POWERED);
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos pos = context.getClickedPos();
		World world = context.getLevel();
		BlockState blockState = setPoweredState(this.defaultBlockState(), world, pos);
		return blockState;
	}
	
	// Update powered information when a block nearby is updated
	@Override
	public void neighborChanged(BlockState currentState, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		worldIn.setBlockAndUpdate(pos, setPoweredState(currentState, worldIn, pos));
	}
	
	// What to do when setting powered state
	public BlockState setPoweredState(BlockState currentState, World worldIn, BlockPos pos) {
		// If already powered, don't make unpowered
		if (currentState.getValue(POWERED)) return currentState;
		// Obtain power level from each direction
		int powerlevel = worldIn.getDirectSignalTo(pos);
		return currentState.setValue(POWERED, powerlevel>0);
	}

	@Override
	public boolean hasTileEntity(BlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new BreakingBlockTile();
	}

	// Copied from https://github.com/TheGreyGhost/MinecraftByExample/ - lightly modified
	// Called just after the player places a block.  Start the tileEntity's timer
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(worldIn, pos, state, placer, stack);
		TileEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof BreakingBlockTile) { // prevent a crash if not the right type, or is null
			BreakingBlockTile tileEntityData = (BreakingBlockTile)tileentity;
			tileEntityData.setup();
		}
	}

}
