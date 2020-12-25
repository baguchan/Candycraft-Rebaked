package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.CookieCrouperEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CandyCraftEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CandyCraft.MODID);

    public static final RegistryObject<EntityType<CookieCrouperEntity>> COOKIE_CROUPER = register("cookie_crouper" ,EntityType.Builder.create(CookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8));


    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(COOKIE_CROUPER.get(), CreeperEntity.registerAttributes().create());
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }
}

