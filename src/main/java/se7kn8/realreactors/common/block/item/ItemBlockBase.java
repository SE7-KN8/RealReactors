package se7kn8.realreactors.common.block.item;

import net.minecraft.item.ItemBlock;
import se7kn8.realreactors.common.block.BlockBase;

public class ItemBlockBase extends ItemBlock{

	public ItemBlockBase(BlockBase block){
		super(block);
		setRegistryName(block.getName());
		setUnlocalizedName(block.getUnlocalizedName());
	}
}
