package com.evo.candycraft.common.event;

import com.evo.candycraft.common.entity.goals.FoxStealCrouperBerriesGoal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntitySpawnEvents {

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onLivingSpawn(LivingSpawnEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (entity instanceof Fox) {
            ((Fox) entity).goalSelector.addGoal(6, new FoxStealCrouperBerriesGoal<>((Fox) entity));
        }
    }
}
