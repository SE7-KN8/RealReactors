package se7kn8.realreactors.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import se7kn8.realreactors.common.block.properties.BlockOreProperties;

public class BlockOre extends BlockMeta<BlockOreProperties> {

	private static final PropertyEnum<BlockOreProperties> type = PropertyEnum.create("type", BlockOreProperties.class);

	public BlockOre() {
		super("ore", Material.ROCK, type, BlockOreProperties.PITCHBLENDE);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, type);
	}
}
