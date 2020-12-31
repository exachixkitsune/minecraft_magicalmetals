package net.exachixkitsune.magicalmetals.tileentities;

import net.minecraft.tileentity.TileEntityType;

// Similar method to botania at https://github.com/Vazkii/Botania/
import static net.exachixkitsune.magicalmetals.blocks.BlocksList.*;

public class TileEntityTypes {
	private TileEntityTypes() {}
	
	public static final TileEntityType<TransmutationMatrixTile> TRANSMUTATIONMATRIXTILE
		= TileEntityType.Builder.create(TransmutationMatrixTile::new, transmutation_matrix).build(null);
	public static final TileEntityType<BreakingBlockTile> BREAKINGBLOCKTILE
		= TileEntityType.Builder.create(BreakingBlockTile::new, breaking_block).build(null);
	
	public static final TileEntityType<ButterflyBoxTree_Tile> BUTTERFLYBOXTREETILE
		= TileEntityType.Builder.create(ButterflyBoxTree_Tile::new, butterflybox_tree).build(null);
	public static final TileEntityType<ButterflyBoxCrop_Tile> BUTTERFLYBOXCROPTILE
		= TileEntityType.Builder.create(ButterflyBoxCrop_Tile::new, butterflybox_crop).build(null);
	public static final TileEntityType<ButterflyBoxFlower_Tile> BUTTERFLYBOXGRASSTILE
	= TileEntityType.Builder.create(ButterflyBoxFlower_Tile::new, butterflybox_grass).build(null);
	
}
