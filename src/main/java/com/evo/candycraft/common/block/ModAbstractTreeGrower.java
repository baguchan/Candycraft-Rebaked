package com.evo.candycraft.common.block;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Note that this is subject to change.
 * <p>
 * Feel free to change this up however you'd like,
 * as this only provides a single Holder
 * for a never changing result and not
 * taking the random instance or hive
 * boolean into consideration in
 * {@link net.minecraft.world.level.block.grower.AbstractTreeGrower#getConfiguredFeature(Random, boolean)}
 */
public class ModAbstractTreeGrower extends AbstractTreeGrower {

    private final Holder<ConfiguredFeature<TreeConfiguration, ?>> treeFeatureHolder;


    public ModAbstractTreeGrower(Holder<ConfiguredFeature<TreeConfiguration, ?>> treeFeatureHolder) {
        super();
        this.treeFeatureHolder = treeFeatureHolder;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean largeHive) {
        return this.treeFeatureHolder;
    }
}
