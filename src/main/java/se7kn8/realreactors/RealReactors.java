package se7kn8.realreactors;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import se7kn8.realreactors.common.proxy.CommonProxy;

import org.apache.logging.log4j.Logger;

@Mod(modid = RealReactors.MOD_ID, useMetadata = true)
@SuppressWarnings("unused") // Loaded by fml
public class RealReactors {

	public static final int ENTITY_ID_ALKALI_METAL = 10;

	public static final CreativeTabs creativeTab = new CreativeTabs(RealReactors.MOD_ID) {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.COMMAND_BLOCK); //TODO new icon
		}
	};

	public static final String MOD_ID = "realreactors";
	public static Logger log;

	@SidedProxy(serverSide = "se7kn8.realreactors.common.proxy.CommonProxy", clientSide = "se7kn8.realreactors.client.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.Instance(RealReactors.MOD_ID)
	public static RealReactors instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log = event.getModLog();
		log.info("PreInit");
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		log.info("Init");
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		log.info("PostInit");
		proxy.postInit(event);
	}

	public static boolean isEffectiveClient() {
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	public static boolean isEffectiveServer() {
		return FMLCommonHandler.instance().getEffectiveSide().isServer();
	}

}
