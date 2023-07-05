package com.evo.candycraft_rebaked.common.event;

import com.evo.candycraft_rebaked.common.entity.goals.FoxStealCrouperBerriesGoal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntitySpawnEvents {

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onLivingSpawn(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Fox) {
            ((Fox) entity).goalSelector.addGoal(6, new FoxStealCrouperBerriesGoal<>((Fox) entity));
        }
    }
}
