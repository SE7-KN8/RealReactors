package se7kn8.realreactors.server.proxy;

import com.google.common.collect.ImmutableMap;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

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

	public IAnimationStateMachine loadASM(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters) {
		//Method is called on client
		return null;
	}

}
