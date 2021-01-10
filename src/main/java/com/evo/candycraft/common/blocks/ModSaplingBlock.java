package com.evo.candycraft.common.blocks;

import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class ModSaplingBlock extends SaplingBlock {

    public ModSaplingBlock(Tree tree, Properties properties) {
        super(tree, properties);
    }

    public ModSaplingBlock(ConfiguredFeature<BaseTreeFeatureConfig, ?> treeFeature, Properties properties) {
        super(new Tree() {
            @Nullable
            @Override
            protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean largeHive) {
                return treeFeature;
            }
        }, properties);
    }
}
