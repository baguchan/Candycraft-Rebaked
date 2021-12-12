package com.evo.candycraft.common.blocks;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Note that this is subject to change.
 *
 * Feel free to change this up however you'd like,
 * as this only provides a single supplier
 * for a never changing result and not
 * taking the random instance or hive
 * boolean into consideration in
 * {@link Tree#getTreeFeature(Random, boolean)}
 */
public class ModTree extends Tree {

    private final Supplier<ConfiguredFeature<BaseTreeFeatureConfig, ?>> treeFeatureSupplier;


    public ModTree(Supplier<ConfiguredFeature<BaseTreeFeatureConfig, ?>> treeFeatureSupplier) {
        super();
        this.treeFeatureSupplier = treeFeatureSupplier;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
        return this.treeFeatureSupplier.get();
    }
}
