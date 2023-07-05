package com.evo.candycraft_rebaked.datagen.loot;

import net.minecraft.data.loot.EntityLoot;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CCEntityLootTableProvider extends EntityLootSubProvider {

    private final Set<EntityType<?>> knownEntities = new HashSet<>();

    protected CCEntityLootTableProvider() {
        super(FeatureFlags.DEFAULT_FLAGS);
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return this.knownEntities.stream();
    }

    @Override
    protected void add(EntityType<?> type, LootTable.Builder table) {
        super.add(type, table);
        this.knownEntities.add(type);
    }

    @Override
    public void generate() {

    }
}
