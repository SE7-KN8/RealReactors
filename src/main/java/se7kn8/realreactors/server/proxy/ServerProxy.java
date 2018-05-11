package se7kn8.realreactors.server.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;

public class ServerProxy {
	public void registerItemRenderer(Item item, int meta, String id) {
		//Method is called on client
	}

	public void registerModelVariants(Item item, String baseName, String... names) {
		//Method is called on client
	}

	public void spawnParticle(EnumParticleTypes particleType, double x, double y, double z, double motX, double motY, double motZ) {
		//Method is called on client
	}

}
