package se7kn8.realreactors.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public abstract class BlockMeta<T extends Enum<T> & IStringSerializable> extends BlockBase {

	public final IProperty<T> type;
	public final T[] enumValues;

	public BlockMeta(String name, Material material, PropertyEnum<T> propertyEnum, T value) {
		super(name, material);
		type = propertyEnum;
		enumValues = type.getValueClass().getEnumConstants();
		this.setDefaultState(this.blockState.getBaseState().withProperty(type, value));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(type).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(type, enumValues[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(type).ordinal();
	}

	@Override
	protected abstract BlockStateContainer createBlockState();

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		if (itemIn == CreativeTabs.SEARCH || itemIn == this.getCreativeTabToDisplayOn()) {
			for (int i = 0; i < enumValues.length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
}
