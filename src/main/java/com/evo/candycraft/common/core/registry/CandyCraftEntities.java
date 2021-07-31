package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CandyCraftEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CandyCraft.MODID);

    public static EntityType<CookieCroncherEntity> COOKIE_CRONCHER_TYPE;
    public static EntityType<StrawberryCookieCroncherEntity> STRAWBERRY_COOKIE_CRONCHER_TYPE;
    public static EntityType<SweetberryCookieCroncherEntity> SWEETBERRY_COOKIE_CRONCHER_TYPE;
    public static EntityType<OreoCookieCroncherEntity> OREO_COOKIE_CRONCHER_TYPE;
    public static EntityType<GingerBreadAmmoEntity> GINGER_BREAD_AMMO_TYPE;

    public static final RegistryObject<EntityType<CookieCroncherEntity>> COOKIE_CRONCHER = register("cookie_croncher", () -> COOKIE_CRONCHER_TYPE);
    public static final RegistryObject<EntityType<StrawberryCookieCroncherEntity>> STRAWBERRY_COOKIE_CRONCHER = register("strawberry_cookie_croncher", () -> STRAWBERRY_COOKIE_CRONCHER_TYPE);
    public static final RegistryObject<EntityType<SweetberryCookieCroncherEntity>> SWEETBERRY_COOKIE_CRONCHER = register("sweetberry_cookie_croncher", () -> SWEETBERRY_COOKIE_CRONCHER_TYPE);
    public static final RegistryObject<EntityType<OreoCookieCroncherEntity>> OREO_COOKIE_CRONCHER = register("oreo_cookie_croncher", () -> OREO_COOKIE_CRONCHER_TYPE);
    public static final RegistryObject<EntityType<GingerBreadAmmoEntity>> GINGER_BREAD_AMMO = register("ginger_bread_ammo", () -> GINGER_BREAD_AMMO_TYPE);

    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(COOKIE_CRONCHER.get(), CookieCroncherEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(STRAWBERRY_COOKIE_CRONCHER.get(), CookieCroncherEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(SWEETBERRY_COOKIE_CRONCHER.get(), CookieCroncherEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(OREO_COOKIE_CRONCHER.get(), CookieCroncherEntity.registerAttributes().create());
    }

    public static void initEntityTypes() {
        COOKIE_CRONCHER_TYPE = EntityType.Builder.create(CookieCroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("cookie_CRONCHER");
        STRAWBERRY_COOKIE_CRONCHER_TYPE = EntityType.Builder.create(StrawberryCookieCroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("strawberry_cookie_CRONCHER");
        SWEETBERRY_COOKIE_CRONCHER_TYPE = EntityType.Builder.create(SweetberryCookieCroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("sweetberry_cookie_CRONCHER");
        OREO_COOKIE_CRONCHER_TYPE = EntityType.Builder.create(OreoCookieCroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("oreo_cookie_CRONCHER");
        GINGER_BREAD_AMMO_TYPE = EntityType.Builder.<GingerBreadAmmoEntity>create(GingerBreadAmmoEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).setTrackingRange(12).build("ginger_bread_ammo");
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> entityTypeSupplier) {
        return ENTITIES.register(name, entityTypeSupplier);
    }
}

