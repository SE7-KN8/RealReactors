package se7kn8.realreactors.common.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.animation.AnimationTESR;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.block.BlockCrusher;
import se7kn8.realreactors.common.block.BlockMetal;
import se7kn8.realreactors.common.block.BlockOre;
import se7kn8.realreactors.common.block.item.ItemBlockBase;
import se7kn8.realreactors.common.block.item.ItemBlockMeta;
import se7kn8.realreactors.common.block.tile.TileEntityCrusher;
import se7kn8.realreactors.common.holder.CrusherItemAnimationHolder;

import javax.annotation.Nullable;

public class RealReactorsBlocks {

	public static BlockMetal blockMetal;
	public static BlockOre blockOre;
	public static BlockCrusher blockCrusher;

	static {
		blockMetal = new BlockMetal();
		blockOre = new BlockOre();
		blockCrusher = new BlockCrusher();
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
		registry.register(new ItemBlockBase(blockCrusher) {
			@Override
			public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
				return new CrusherItemAnimationHolder();
			}
		});
	}

	public static void registerBlock(IForgeRegistry<Block> registry) {
		registry.register(blockMetal);
		registry.register(blockOre);
		registry.register(blockCrusher);
		GameRegistry.registerTileEntity(TileEntityCrusher.class, new ResourceLocation(RealReactors.MOD_ID, "tile_crusher"));
	}

	public static void registerModels() {
		for (int i = 0; i < blockMetal.enumValues.length; i++) {
			RealReactors.proxy.registerItemRenderer(Item.getItemFromBlock(blockMetal), i, "block_metal");
		}

		for (int i = 0; i < blockOre.enumValues.length; i++) {
			RealReactors.proxy.registerItemRenderer(Item.getItemFromBlock(blockOre), i, "ore");
		}

		RealReactors.proxy.registerItemRenderer(Item.getItemFromBlock(blockCrusher), 0, "crusher");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrusher.class, new AnimationTESR<>());
	}

}
