package se7kn8.realreactors.client.proxy;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.block.item.ItemBlockMeta;
import se7kn8.realreactors.server.proxy.ServerProxy;

import javax.annotation.Nonnull;

public class ClientProxy extends ServerProxy {
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ResourceLocation location = new ResourceLocation(RealReactors.MOD_ID, id);
		if (item instanceof ItemBlockMeta) {
			ItemBlockMeta metaItem = (ItemBlockMeta) item;
			ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
				@Override
				@Nonnull
				public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
					return new ModelResourceLocation(location, "inventory");
				}
			});
			String variant = "inventory," + metaItem.getMetaBlock().type.getName() + "=" + metaItem.getMetaBlock().getEnumValues()[meta].toString().toLowerCase();
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(location, variant));
		} else {
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(location, "inventory"));
		}
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

	public IAnimationStateMachine loadASM(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters) {
		return ModelLoaderRegistry.loadASM(location, parameters);
	}

}
