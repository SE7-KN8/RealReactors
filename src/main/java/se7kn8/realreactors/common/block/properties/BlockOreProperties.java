package se7kn8.realreactors.common.block.properties;

import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public enum BlockOreProperties implements IStringSerializable {

	/* 0 */ PITCHBLENDE,
	/* 1 */ CHROMITE;

	@Override
	@Nonnull
	public String getName() {
		return this.toString();
	}

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
