package net.exachixkitsune.magicalmetals.blocks.transmutation;

import javax.annotation.Nullable;

import net.exachixkitsune.magicalmetals.blocks.MagicalFocusBlock;
import net.exachixkitsune.magicalmetals.tileentities.TransmutationMatrixTile;
import net.exachixkitsune.magicalmetals.util.ConvertMode;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;

public class TransmutationMatrix extends MagicalFocusBlock {
	
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	
	public TransmutationMatrix(AbstractBlock.Properties properties) {
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
	
	public BlockState setPoweredState(BlockState currentState, World worldIn, BlockPos pos) {
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
		return new TransmutationMatrixTile();
	}

	// Copied from https://github.com/TheGreyGhost/MinecraftByExample/ - lightly modified
	// Called just after the player places a block.  Start the tileEntity's timer
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(worldIn, pos, state, placer, stack);
		TileEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof TransmutationMatrixTile) { // prevent a crash if not the right type, or is null
			TransmutationMatrixTile tileEntityData = (TransmutationMatrixTile)tileentity;
			tileEntityData.setup();
		}
	}

	@Override
	public ActionResultType use(BlockState blockState, World world, BlockPos myPos,
			PlayerEntity player, Hand userhand, BlockRayTraceResult raytrace) {
		if (world.isClientSide()) {
			// Output text to player saying what will be produced
			// Probably should work out an in-world way of doing this
			
			// Given world stuff, what is my current output mode
			TranslationTextComponent ExpectedOutput = ConvertMode.determineConvertTo(world, myPos).getTranslatedName();
			
			ITextComponent message = new StringTextComponent("")
					.append(new TranslationTextComponent("magicalmetals.transmutationmsg.base"))
					.append(ExpectedOutput);
			
			player.displayClientMessage(message, true);
		}
		return ActionResultType.SUCCESS;
	}
	
	
}
