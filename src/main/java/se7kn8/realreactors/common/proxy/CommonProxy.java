package se7kn8.realreactors.common.proxy;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.util.RealReactorsItems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event){
		RealReactors.log.info("CommonPreInit");
		RealReactorsItems.preInit();
	}

	public void init(FMLInitializationEvent event){
		RealReactors.log.info("CommonInit");
		RealReactorsItems.init();
	}

	public void postInit(FMLPostInitializationEvent event){
		RealReactors.log.info("CommonPostInit");
		RealReactorsItems.postInit();
	}

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public void registerModelVariants(Item item, String baseName, String... names){
	}

}
