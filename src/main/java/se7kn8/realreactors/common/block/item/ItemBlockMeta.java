package se7kn8.realreactors.common.block.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.block.BlockMeta;

import javax.annotation.Nonnull;

public class ItemBlockMeta extends ItemBlockBase {

	private BlockMeta metaBlock;

	public ItemBlockMeta(BlockMeta block) {
		super(block);
		if (block.enumValues.length > 1) {
			setHasSubtypes(true);
		}
		this.metaBlock = block;
	}

	@Override
	public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
		if (tab == CreativeTabs.SEARCH || tab == RealReactors.creativeTab) {
			metaBlock.getSubBlocks(tab, items);
		}
	}

	@Override
	@Nonnull
	public String getUnlocalizedName(ItemStack stack) {
		return "item.block_" + metaBlock.enumValues[stack.getMetadata()].toString();
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	public BlockMeta getMetaBlock() {
		return metaBlock;
	}
}
