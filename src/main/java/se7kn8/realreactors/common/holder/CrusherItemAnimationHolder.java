package se7kn8.realreactors.common.holder;

import com.google.common.collect.ImmutableMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.animation.TimeValues;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import se7kn8.realreactors.RealReactors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CrusherItemAnimationHolder implements ICapabilityProvider {
	private final TimeValues.VariableValue cycleLength = new TimeValues.VariableValue(4);

	private final IAnimationStateMachine asm = RealReactors.proxy.loadASM(new ResourceLocation(RealReactors.MOD_ID, "asms/block/crusher.json"), ImmutableMap.of(
			"cycle_length", cycleLength
	));

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityAnimation.ANIMATION_CAPABILITY;
	}

	@Override
	@Nullable
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return CapabilityAnimation.ANIMATION_CAPABILITY.cast(asm);
		}
		return null;
	}

}
