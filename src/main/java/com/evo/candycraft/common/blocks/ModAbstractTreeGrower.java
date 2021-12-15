package com.evo.candycraft.common.blocks;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

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
 * {@link net.minecraft.world.level.block.grower.AbstractTreeGrower#getConfiguredFeature(Random, boolean)}
 */
public class ModAbstractTreeGrower extends AbstractTreeGrower {

    private final Supplier<ConfiguredFeature<TreeConfiguration, ?>> treeFeatureSupplier;


    public ModAbstractTreeGrower(Supplier<ConfiguredFeature<TreeConfiguration, ?>> treeFeatureSupplier) {
        super();
        this.treeFeatureSupplier = treeFeatureSupplier;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean largeHive) {
        return this.treeFeatureSupplier.get();
    }
}
