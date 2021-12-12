package com.evo.candycraft.common.blocks;

import com.evo.candycraft.common.core.CandyCraft;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Supplier;

public class ModSaplingBlock extends SaplingBlock {


    public ModSaplingBlock(Supplier<ConfiguredFeature<BaseTreeFeatureConfig, ?>> treeFeatureSupplier, Properties properties) {
        super(new ModTree(treeFeatureSupplier) {

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
        }, properties);
    }
}
