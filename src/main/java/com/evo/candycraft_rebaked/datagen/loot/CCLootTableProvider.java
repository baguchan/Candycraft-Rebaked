package com.evo.candycraft_rebaked.datagen.loot;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CCLootTableProvider {
    public static LootTableProvider create(PackOutput p_250807_) {
        return new LootTableProvider(p_250807_, Set.of(), List.of(new LootTableProvider.SubProviderEntry(CCBlockLootTableProvider::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(CCEntityLootTableProvider::new, LootContextParamSets.ENTITY)));
    }
}
