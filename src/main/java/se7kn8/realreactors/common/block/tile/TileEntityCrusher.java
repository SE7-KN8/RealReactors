package se7kn8.realreactors.common.block.tile;

import com.google.common.collect.ImmutableMap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.animation.TimeValues;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import se7kn8.realreactors.RealReactors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityCrusher extends TileEntity {

	private IAnimationStateMachine asm;
	private final TimeValues.VariableValue cycleLength = new TimeValues.VariableValue(4);

	public TileEntityCrusher() {
		asm = RealReactors.proxy.loadASM(new ResourceLocation(RealReactors.MOD_ID, "asms/block/crusher.json"), ImmutableMap.of(
				"cycle_length", cycleLength
		));
	}

	@Override
	public boolean hasFastRenderer() {
		return true;
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return CapabilityAnimation.ANIMATION_CAPABILITY.cast(asm);
		}
		return super.getCapability(capability, facing);
	}

	public void toggleState() {
		System.out.println(asm.currentState());
		if (asm.currentState().equals("default")) {
			asm.transition("moving");
		} else if (asm.currentState().equals("moving")) {
			asm.transition("default");
		}
	}

}
