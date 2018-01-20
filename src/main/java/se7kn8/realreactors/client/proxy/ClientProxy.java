package se7kn8.realreactors.client.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.proxy.CommonProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientProxy extends CommonProxy{

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
}
