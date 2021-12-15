package com.evo.candycraft.common.blocks;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Random;
import java.util.function.Supplier;

public class ModSaplingBlock extends SaplingBlock {

    public ModSaplingBlock(Supplier<ConfiguredFeature<TreeConfiguration, ?>> treeFeatureSupplier, Properties properties) {
        super(new ModAbstractTreeGrower(treeFeatureSupplier) {

            @Override
            public boolean growTree(ServerLevel level, ChunkGenerator chunkGenerator, BlockPos pos, BlockState state, Random rand) {
                ConfiguredFeature<TreeConfiguration, ?> feature = this.getConfiguredFeature(rand, false);

                if (feature == null) {
                    CandyCraft.LOGGER.info("Feature is null! What the frick dude :C");
                    return false;
                }
                else {
                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
                    if (feature.place(level, chunkGenerator, rand, pos)) {
                        return true;
                    }
                    else {
                        level.setBlock(pos, state, 4);
                        return false;
                    }
                }
            }
        }, properties);
    }
}
