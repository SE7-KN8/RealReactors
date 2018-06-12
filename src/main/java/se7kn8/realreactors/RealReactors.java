package se7kn8.realreactors;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import se7kn8.realreactors.common.block.tile.TileEntityCrusher;
import se7kn8.realreactors.common.util.GuiHandler;
import se7kn8.realreactors.common.world.gen.OreGenerator;
import se7kn8.realreactors.server.proxy.ServerProxy;

import org.apache.logging.log4j.Logger;
import se7kn8.realreactors.common.util.RealReactorsBlocks;
import se7kn8.realreactors.common.util.RealReactorsItems;

@Mod(modid = RealReactors.MOD_ID, useMetadata = true)
@SuppressWarnings("unused") // Loaded by fml
public class RealReactors {

	public static final int ENTITY_ID_ALKALI_METAL = 10;

	public static final int GUI_ID_CRUSHER = 1;

	public static final CreativeTabs creativeTab = new CreativeTabs(RealReactors.MOD_ID) {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.COMMAND_BLOCK); //TODO new icon
		}
	};

	public static final String MOD_ID = "realreactors";
	public static Logger log;

	@SidedProxy(serverSide = "se7kn8.realreactors.server.proxy.ServerProxy", clientSide = "se7kn8.realreactors.client.proxy.ClientProxy")
	public static ServerProxy proxy;

	@Mod.Instance(RealReactors.MOD_ID)
	public static RealReactors instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log = event.getModLog();
		log.info("PreInit");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		log.info("Init");
		RealReactorsItems.registerOreDict();
		RealReactorsBlocks.registerOreDict();
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(RealReactors.instance, new GuiHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		log.info("PostInit");
	}

	public static boolean isEffectiveClient() {
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	public static boolean isEffectiveServer() {
		return FMLCommonHandler.instance().getEffectiveSide().isServer();
	}

}
