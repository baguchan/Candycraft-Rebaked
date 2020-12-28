package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.CookieCrouperEntity;
import com.evo.candycraft.common.entities.OreoCookieCrouperEntity;
import com.evo.candycraft.common.entities.StrawberryCookieCrouperEntity;
import com.evo.candycraft.common.entities.SweetberryCookieCrouperEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CandyCraftEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CandyCraft.MODID);

    public static final RegistryObject<EntityType<CookieCrouperEntity>> COOKIE_CROUPER = register("cookie_crouper", EntityType.Builder.create(CookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8));
    public static final RegistryObject<EntityType<StrawberryCookieCrouperEntity>> STRAWBERRY_COOKIE_CROUPER = register("strawberry_cookie_crouper", EntityType.Builder.create(StrawberryCookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8));
    public static final RegistryObject<EntityType<SweetberryCookieCrouperEntity>> SWEETBERRY_COOKIE_CROUPER = register("sweetberry_cookie_crouper", EntityType.Builder.create(SweetberryCookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8));
    public static final RegistryObject<EntityType<OreoCookieCrouperEntity>> OREO_COOKIE_CROUPER = register("oreo_cookie_crouper", EntityType.Builder.create(OreoCookieCrouperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8));


    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(STRAWBERRY_COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(SWEETBERRY_COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(OREO_COOKIE_CROUPER.get(), CookieCrouperEntity.registerAttributes().create());
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }
}

