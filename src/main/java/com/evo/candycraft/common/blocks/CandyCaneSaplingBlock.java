package com.evo.candycraft.common.blocks;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.world.features.ConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class CandyCaneSaplingBlock extends SaplingBlock {

    public CandyCaneSaplingBlock(Properties properties) {
        super(new CandyCaneTree(), properties);
    }

    private static class CandyCaneTree extends Tree {

        @Override
        public boolean attemptGrowTree(ServerWorld world, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random rand) {
            ConfiguredFeature<BaseTreeFeatureConfig, ?> feature = this.getTreeFeature(rand, false);
            if (feature == null) {
                CandyCraft.LOGGER.info("Feature is null! What the frick dude :C");
                return false;
            } else {
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
                feature.config.forcePlacement();
                if (feature.generate(world, chunkGenerator, rand, pos)) {
                    return true;
                } else {
                    world.setBlockState(pos, state, 4);
                    return false;
                }
            }
        }

        @Nullable
        @Override
        protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
            return ConfiguredFeatures.CANDY_CANE_TREE_FEATURE;
        }
    }
}
