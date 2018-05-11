package se7kn8.realreactors.common.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.block.BlockMetal;
import se7kn8.realreactors.common.block.BlockOre;
import se7kn8.realreactors.common.block.item.ItemBlockMeta;

public class RealReactorsBlocks {

	public static BlockMetal blockMetal;
	public static BlockOre blockOre;

	static {
		blockMetal = new BlockMetal();
		blockOre = new BlockOre();
	}

	public static void registerOreDict() {
		for (int i = 0; i < blockMetal.enumValues.length; i++) {
			OreDictionary.registerOre("block" + StringHelper.makeOreDictString(blockMetal.enumValues[i].toString()), new ItemStack(Item.getItemFromBlock(blockMetal), 1, i));
		}
		for (int i = 0; i < blockOre.enumValues.length; i++) {
			OreDictionary.registerOre("ore" + StringHelper.makeOreDictString(blockOre.enumValues[i].toString()), new ItemStack(Item.getItemFromBlock(blockOre), 1, i));
		}
	}

	public static void registerItemBlock(IForgeRegistry<Item> registry) {
		registry.register(new ItemBlockMeta(blockMetal));
		registry.register(new ItemBlockMeta(blockOre));
	}

	public static void registerBlock(IForgeRegistry<Block> registry) {
		registry.register(blockMetal);
		registry.register(blockOre);
	}

	public static void registerModels() {
		for (int i = 0; i < blockMetal.enumValues.length; i++) {
			RealReactors.proxy.registerItemRenderer(Item.getItemFromBlock(blockMetal), i, "block/metal/" + blockMetal.enumValues[i].toString());
		}

		for (int i = 0; i < blockOre.enumValues.length; i++) {
			RealReactors.proxy.registerItemRenderer(Item.getItemFromBlock(blockOre), i, "block/ore/" + blockOre.enumValues[i].toString());
		}
	}

}
