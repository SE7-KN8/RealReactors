package se7kn8.realreactors.common.item;

import net.minecraft.item.Item;
import se7kn8.realreactors.RealReactors;

public class ItemBase extends Item {

	private String name;

	public ItemBase(String name, boolean hasSubtypes) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(RealReactors.MOD_ID, name);
		setHasSubtypes(hasSubtypes);
		setCreativeTab(RealReactors.creativeTab);
	}

	public String getName() {
		return name;
	}
}
