package se7kn8.realreactors.client.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.server.proxy.ServerProxy;

public class ClientProxy extends ServerProxy {
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

	@Override
	public void spawnParticle(EnumParticleTypes particleType, double x, double y, double z, double motX, double motY, double motZ) {
		Minecraft.getMinecraft().world.spawnParticle(particleType, x, y, z, motX, motY, motZ);
	}
}
