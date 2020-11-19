package net.exachixkitsune.magicalmetals.tileentities;

import net.minecraft.tileentity.TileEntityType;

// Similar method to botania at https://github.com/Vazkii/Botania/
import static net.exachixkitsune.magicalmetals.blocks.BlocksList.*;

public class TileEntityTypes {
	private TileEntityTypes() {}
	
	public static final TileEntityType<TransmutationMatrixTile> TRANSMUTATIONMATRIXTILE = TileEntityType.Builder.create(TransmutationMatrixTile::new, transmutation_matrix).build(null);
	public static final TileEntityType<TransmutationMatrixTile> BREAKINGBLOCKTILE = TileEntityType.Builder.create(TransmutationMatrixTile::new, breaking_block).build(null);
	
}
