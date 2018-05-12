package se7kn8.realreactors.common.world.gen;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import se7kn8.realreactors.common.block.properties.BlockOreProperties;
import se7kn8.realreactors.common.util.RealReactorsBlocks;

import java.util.Random;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
			case 0:
				genOverworld(random, chunkX, chunkZ, world);
				break;
			case 1:
				break;
			case -1:
				break;
		}
	}

	private void genOverworld(Random random, int chunkX, int chunkZ, World world) {
		genOre(random, world, chunkX * 16, chunkZ * 16, 2, 42, 4 + random.nextInt(2), 5, RealReactorsBlocks.blockOre.getStateFromMeta(BlockOreProperties.PITCHBLENDE.ordinal()), BlockMatcher.forBlock(Blocks.STONE));
		genOre(random, world, chunkX * 16, chunkZ * 16, 10, 50, 4 + random.nextInt(2), 6, RealReactorsBlocks.blockOre.getStateFromMeta(BlockOreProperties.CHROMITE.ordinal()), BlockMatcher.forBlock(Blocks.STONE));
	}

	private void genOre(Random random, World world, int x, int z, int minY, int maxY, int size, int chances, IBlockState ore, Predicate<IBlockState> predicate) {
		int dY = maxY - minY;

		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(dY), z + random.nextInt(16));

			WorldGenMinable generator = new WorldGenMinable(ore, size, predicate);
			generator.generate(world, random, pos);
		}
	}


}
