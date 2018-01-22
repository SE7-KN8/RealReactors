package se7kn8.realreactors.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import se7kn8.realreactors.RealReactors;

public class BlockBase extends Block {

	private String name;

	public BlockBase(String name, Material material){
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(RealReactors.MOD_ID, name);
		setCreativeTab(RealReactors.creativeTab);
	}

	public String getName() {
		return name;
	}
}
