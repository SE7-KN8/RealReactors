package se7kn8.realreactors.client.proxy;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.proxy.CommonProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RealReactors.log.info("ClientPreInit");

	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		RealReactors.log.info("ClientInit");
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		RealReactors.log.info("ClientPostInit");
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(RealReactors.MOD_ID, id), "inventory"));
	}

	@Override
	public void registerModelVariants(Item item, String baseName, String... names) {
		ResourceLocation[] resourceLocations = new ResourceLocation[names.length];

		for (int i = 0; i < names.length; i++) {
			resourceLocations[i] = new ResourceLocation(RealReactors.MOD_ID, baseName + "/" + names[i]);
		}

		ModelBakery.registerItemVariants(item, resourceLocations);
	}
}
