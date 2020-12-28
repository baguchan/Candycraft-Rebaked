package com.evo.candycraft.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class SweetberryCookieCrouperEntity extends CookieCrouperEntity {

    private static final DataParameter<Boolean> HAS_BERRIES = EntityDataManager.createKey(SweetberryCookieCrouperEntity.class, DataSerializers.BOOLEAN);

    public SweetberryCookieCrouperEntity(EntityType<? extends SweetberryCookieCrouperEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(HAS_BERRIES, true);
    }

    public boolean hasBerries() {
        return this.dataManager.get(HAS_BERRIES);
    }

    public void setBerries(boolean hasBerries) {
        this.dataManager.set(HAS_BERRIES, hasBerries);
    }
}
