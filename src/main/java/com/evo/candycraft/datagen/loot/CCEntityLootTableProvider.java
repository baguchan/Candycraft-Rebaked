package com.evo.candycraft.datagen.loot;

import net.minecraft.data.loot.EntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

public class CCEntityLootTableProvider extends EntityLoot {

    private final Set<EntityType<?>> knownEntities = new HashSet<>();

    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        return this.knownEntities;
    }

    @Override
    protected void add(EntityType<?> type, LootTable.Builder table) {
        super.add(type, table);
        this.knownEntities.add(type);
    }

    @Override
    protected void addTables() {

    }
}
