package se7kn8.realreactors.common.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se7kn8.realreactors.RealReactors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event){
		RealReactors.log.info("CommonPreInit");
	}

	public void init(FMLInitializationEvent event){
		RealReactors.log.info("CommonInit");
	}

	public void postInit(FMLPostInitializationEvent event){
		RealReactors.log.info("CommonPostInit");
	}

}
