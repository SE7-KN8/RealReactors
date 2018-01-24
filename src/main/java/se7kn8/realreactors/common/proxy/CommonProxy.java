package se7kn8.realreactors.common.proxy;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.util.RealReactorsBlocks;
import se7kn8.realreactors.common.util.RealReactorsItems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event){
		RealReactors.log.info("CommonPreInit");
	}

	public void init(FMLInitializationEvent event){
		RealReactors.log.info("CommonInit");
		RealReactorsItems.registerOreDict();
		RealReactorsBlocks.registerOreDict();
	}

	public void postInit(FMLPostInitializationEvent event){
		RealReactors.log.info("CommonPostInit");
	}

	public void registerItemRenderer(Item item, int meta, String id) {
		//Method is called on client
	}

	public void registerModelVariants(Item item, String baseName, String... names){
		//Method is called on client
	}

	public void spawnParticle(EnumParticleTypes particleType, double x, double y, double z, double motX, double motY, double motZ) {
		//Method is called on client
	}

}
