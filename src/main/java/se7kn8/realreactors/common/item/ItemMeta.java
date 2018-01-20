package se7kn8.realreactors.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import se7kn8.realreactors.RealReactors;

import javax.annotation.Nonnull;

public class ItemMeta extends ItemBase {

	private String[] subtypes;

	public ItemMeta(String name, String... subtypes) {
		super(name, true);
		this.subtypes = subtypes;
	}

	@Override
	public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
		if (tab == CreativeTabs.SEARCH || tab == RealReactors.creativeTab) {
			for (int i = 0; i < subtypes.length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	@Nonnull
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + getName() + "_" + subtypes[stack.getItemDamage()];
	}
}
