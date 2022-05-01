package com.evo.candycraft_rebaked.common.core.registry;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import com.evo.candycraft_rebaked.common.features.CandyCaneTreeFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CandyCraftFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CandyCraft.MODID);

    public static final RegistryObject<Feature<TreeConfiguration>> CANDY_CANE_TREE = FEATURES.register("candy_cane_tree", () -> new CandyCaneTreeFeature(TreeConfiguration.CODEC));
}
