package se7kn8.realreactors.common.block.properties;

import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public enum BlockMetalProperties implements IStringSerializable {

	/* 0 */ BORON,
	/* 1 */ BORON_STEEL,
	/* 2 */ CHROMIUM,
	/* 3 */ CHROMIUM_STEEL,
	/* 4 */ GRAPHITE,
	/* 5 */ POTASSIUM,
	/* 6 */ SODIUM,
	/* 7 */ STEEL;

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
