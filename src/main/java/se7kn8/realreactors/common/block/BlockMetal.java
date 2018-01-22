package se7kn8.realreactors.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import se7kn8.realreactors.common.block.properties.BlockMetalProperties;

import javax.annotation.Nullable;

public class BlockMetal extends BlockMeta<BlockMetalProperties> {

	private static final PropertyEnum<BlockMetalProperties> type = PropertyEnum.create("type", BlockMetalProperties.class);

	public BlockMetal() {
		super("block_metal", Material.ROCK, type, BlockMetalProperties.BORON);
		setHardness(5.0f);
		setResistance(3.0f);
	}

	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		switch (state.getValue(type).ordinal()){
			case 1:
			case 3:
				return 3;
			case 0:
			case 2:
			case 5:
			case 6:
			case 7:
				return 2;
			default:
				return 1;
		}
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, type);
	}

}
