package com.evo.candycraft_rebaked.common.core.registry;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import com.evo.candycraft_rebaked.common.world.biome.CandyBiomeBuilder;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CandyCraftBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CandyCraft.MODID);

	public static final MultiNoiseBiomeSource.Preset CANDY_BIOMESOURCE = new MultiNoiseBiomeSource.Preset(new ResourceLocation(CandyCraft.MODID, "candy_world_biomes"), (p_187108_) -> {
		ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
		(new CandyBiomeBuilder()).addBiomes((p_204279_) -> {
			builder.add(p_204279_.mapSecond(p_187108_::getOrCreateHolder));
		});
		return new Climate.ParameterList<>(builder.build());
	});

	public static final ResourceKey<Biome> CHOCOLATE_BOG = register("chocolate_bog");
	public static final ResourceKey<Biome> COTTON_CANDY_WOODS = register("cotton_candy_woods");
	public static final ResourceKey<Biome> CREAMY_VALLEY = register("creamy_valley");
	public static final ResourceKey<Biome> RUNNY_RIVERS = register("runny_rivers");
	public static final ResourceKey<Biome> ROCK_CANDY_PEAKS = register("rock_candy_peaks");
	public static final ResourceKey<Biome> WOBBLY_HILLS = register("wobbly_hills");


	private static ResourceKey<Biome> register(String p_48229_) {
		BIOMES.register(p_48229_, OverworldBiomes::theVoid);
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(CandyCraft.MODID, p_48229_));
	}

	//set load new NoiseBiome
	public static void init() {
	}
}
