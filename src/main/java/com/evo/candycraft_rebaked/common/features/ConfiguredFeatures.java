package com.evo.candycraft_rebaked.common.features;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import com.evo.candycraft_rebaked.common.core.registry.CandyCraftBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ConfiguredFeatures {

    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> CANDY_CANE_TREE_FEATURE;
    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> RED_LICORICE_TREE_FEATURE;

    public static void register() {

        CANDY_CANE_TREE_FEATURE = FeatureUtils.register(prefix("candy_cane_tree"), Feature.TREE, createCandyCaneTree());

        RED_LICORICE_TREE_FEATURE = FeatureUtils.register(prefix("red_licorice_tree"), Feature.TREE, createRedLicoriceTree());
    }

    public static String prefix(String name) {
        return CandyCraft.MODID + ":" + name;
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block p_195147_, Block p_195148_, int p_195149_, int p_195150_, int p_195151_, int p_195152_) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(p_195147_), new StraightTrunkPlacer(p_195149_, p_195150_, p_195151_), BlockStateProvider.simple(p_195148_), new BlobFoliagePlacer(ConstantInt.of(p_195152_), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration createRedLicoriceTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CandyCraftBlocks.RED_LICORICE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(CandyCraftBlocks.RED_LICORICE_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                .ignoreVines()
                .build();
    }

    private static TreeConfiguration createCandyCaneTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), new StraightTrunkPlacer(0, 0, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0), new TwoLayersFeatureSize(0, 0, 0))
                .ignoreVines()
                .build();
    }
}
