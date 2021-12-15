package com.evo.candycraft.common.world.features;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.core.registry.CandyCraftFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ConfiguredFeatures {

    public static ConfiguredFeature<TreeConfiguration, ?> CANDY_CANE_TREE_FEATURE;
    public static ConfiguredFeature<TreeConfiguration, ?> RED_LICORICE_TREE_FEATURE;

    public static void register() {

        CANDY_CANE_TREE_FEATURE = register("candy_cane_tree", CandyCraftFeatures.CANDY_CANE_TREE.get()
                .configured(new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), new StraightTrunkPlacer(0, 0, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0), new TwoLayersFeatureSize(0, 0, 0))
                        .ignoreVines()
                        .build()));

        RED_LICORICE_TREE_FEATURE = register("red_licorice_tree", Feature.TREE
                .configured(new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(CandyCraftBlocks.RED_LICORICE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(CandyCraftBlocks.RED_LICORICE_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines()
                        .build()));
    }

    private static <C extends FeatureConfiguration> ConfiguredFeature<C, ?> register(String key, ConfiguredFeature<C, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, CandyCraft.MODID + ":" + key, configuredFeature);
    }
}
