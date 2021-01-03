package com.evo.candycraft.common.event;

import com.evo.candycraft.common.entities.goals.FoxStealCrouperBerriesGoal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntitySpawnEvents {

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onLivingSpawn(LivingSpawnEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (entity instanceof FoxEntity) {
            ((FoxEntity) entity).goalSelector.addGoal(6, new FoxStealCrouperBerriesGoal<>((FoxEntity) entity));
        }
    }
}
