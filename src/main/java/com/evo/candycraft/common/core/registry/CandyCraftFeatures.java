package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.world.features.CandyCaneTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CandyCraftFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CandyCraft.MODID);

    public static final RegistryObject<Feature<BaseTreeFeatureConfig>> CANDY_CANE_TREE = FEATURES.register("candy_cane_tree", () -> new CandyCaneTreeFeature(BaseTreeFeatureConfig.CODEC));
}
