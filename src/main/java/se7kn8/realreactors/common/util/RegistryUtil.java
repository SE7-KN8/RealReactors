package se7kn8.realreactors.common.util;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryUtil {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		RealReactorsItems.registerItems(event);
	}

	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event){
		RealReactorsItems.registerModels();
	}

}
