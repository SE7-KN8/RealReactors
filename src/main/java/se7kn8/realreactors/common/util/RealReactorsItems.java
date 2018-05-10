package se7kn8.realreactors.common.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.item.ItemIngot;

public class RealReactorsItems {

	public static Item itemIngot;

	static {
		itemIngot = new ItemIngot();
	}

	public static void registerOreDict() {
		for (int i = 0; i < ItemIngot.SUBTYPES.length; i++) {
			OreDictionary.registerOre("ingot" + StringHelper.makeOreDictString(ItemIngot.SUBTYPES[i]), new ItemStack(itemIngot, 1, i));
		}
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
		registry.register(itemIngot);
	}

	public static void registerModels() {
		for (int i = 0; i < ItemIngot.SUBTYPES.length; i++) {
			RealReactors.proxy.registerItemRenderer(itemIngot, i, "ingot/" + ItemIngot.SUBTYPES[i]);
		}
		RealReactors.proxy.registerModelVariants(itemIngot, "ingot", ItemIngot.SUBTYPES);
	}

}
