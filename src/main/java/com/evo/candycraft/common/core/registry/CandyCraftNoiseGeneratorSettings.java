package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.world.CandyWorldSurfaceRuleData;
import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;

import java.util.Map;
import java.util.Optional;

public class CandyCraftNoiseGeneratorSettings {

	public static final ResourceKey<NoiseGeneratorSettings> CANDYWORLD = ResourceKey.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, new ResourceLocation(CandyCraft.MODID, "candy_world"));

	public static NoiseGeneratorSettings candyWorld() {
		Map<StructureFeature<?>, StructureFeatureConfiguration> map = Maps.newHashMap();
		return new NoiseGeneratorSettings(new StructureSettings(Optional.empty(), map), NoiseSettings.create(-64, 384, new NoiseSamplingSettings(1.0D, 1.0D, 80.0D, 160.0D), new NoiseSlider(-0.078125D, 2, 8), new NoiseSlider(0.1171875D, 3, 0), 1, 2, false, false, false, TerrainProvider.overworld(false)), CandyCraftBlocks.WAFFLE_CONE_BLOCK.get().defaultBlockState(), Blocks.WATER.defaultBlockState(), CandyWorldSurfaceRuleData.candyWorld(), 63, false, true, true, true, true, false);
	}

	public static void register(ResourceKey<NoiseGeneratorSettings> p_198263_, NoiseGeneratorSettings p_198264_) {
		BuiltinRegistries.register(BuiltinRegistries.NOISE_GENERATOR_SETTINGS, p_198263_.location(), p_198264_);
	}

	public static void init() {
		register(CANDYWORLD, candyWorld());
	}
}