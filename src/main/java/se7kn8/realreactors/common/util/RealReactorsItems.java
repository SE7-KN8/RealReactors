package se7kn8.realreactors.common.util;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.item.ItemIngot;

public class RealReactorsItems {

	public static Item itemIngot;

	public static void preInit() {
		itemIngot = new ItemIngot();
	}

	public static void init() {

	}

	public static void postInit() {

	}

	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(itemIngot);
	}

	public static void registerModels() {
		for (int i = 0; i < ItemIngot.SUBTYPES.length; i++) {
			RealReactors.proxy.registerItemRenderer(itemIngot, i, "ingot/" + ItemIngot.SUBTYPES[i]);
		}
		RealReactors.proxy.registerModelVariants(itemIngot, "ingot", ItemIngot.SUBTYPES);
	}

}
