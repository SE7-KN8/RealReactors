package se7kn8.realreactors.common.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import se7kn8.realreactors.RealReactors;

@Mod.EventBusSubscriber(modid = RealReactors.MOD_ID)
public class RegistryUtil {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		RealReactorsItems.registerItems(event.getRegistry());
		RealReactorsBlocks.registerItemBlock(event.getRegistry());
	}

	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event){
		RealReactorsItems.registerModels();
		RealReactorsBlocks.registerModels();
	}

	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event){
		RealReactorsBlocks.registerBlock(event.getRegistry());
	}
}
