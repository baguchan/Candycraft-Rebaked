package com.evo.candycraft.common.entities;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SweetberryCroncherEntity extends CroncherEntity {


    private static final EntityDataAccessor<Boolean> HAS_BERRIES = SynchedEntityData.defineId(SweetberryCroncherEntity.class, EntityDataSerializers.BOOLEAN);

    public SweetberryCroncherEntity(EntityType<? extends SweetberryCroncherEntity> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HAS_BERRIES, true);
    }

    public boolean hasBerries() {
        return this.entityData.get(HAS_BERRIES);
    }

    public void setBerries(boolean hasBerries) {
        this.entityData.set(HAS_BERRIES, hasBerries);
    }
}
