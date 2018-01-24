package se7kn8.realreactors.common.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.block.BlockMetal;
import se7kn8.realreactors.common.block.item.ItemBlockMeta;

public class RealReactorsBlocks {

	public static BlockMetal blockMetal;

	static {
		blockMetal = new BlockMetal();
	}

	public static void registerOreDict() {
		for (int i = 0; i < blockMetal.enumValues.length; i++) {
			OreDictionary.registerOre("block" + StringHelper.capitalizeFirstLetter(blockMetal.enumValues[i].toString()), new ItemStack(Item.getItemFromBlock(blockMetal), 1, i));
		}
	}

	public static void registerItemBlock(IForgeRegistry<Item> registry) {
		registry.register(new ItemBlockMeta(blockMetal));
	}

	public static void registerBlock(IForgeRegistry<Block> registry) {
		registry.register(blockMetal);
	}

	public static void registerModels() {
		for (int i = 0; i < blockMetal.enumValues.length; i++) {
			RealReactors.proxy.registerItemRenderer(Item.getItemFromBlock(blockMetal), i, "block/metal/" + blockMetal.enumValues[i].toString());
		}
	}

}
