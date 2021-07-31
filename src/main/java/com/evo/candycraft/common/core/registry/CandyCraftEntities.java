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

    public static EntityType<CroncherEntity> CRONCHER_TYPE;
    public static EntityType<StrawberryCroncherEntity> STRAWBERRY_CRONCHER_TYPE;
    public static EntityType<SweetberryCroncherEntity> SWEETBERRY_CRONCHER_TYPE;
    public static EntityType<OreoCroncherEntity> OREO_CRONCHER_TYPE;
    public static EntityType<GingerBreadAmmoEntity> GINGER_BREAD_AMMO_TYPE;

    public static final RegistryObject<EntityType<CroncherEntity>> CRONCHER = register("croncher", () -> CRONCHER_TYPE);
    public static final RegistryObject<EntityType<StrawberryCroncherEntity>> STRAWBERRY_CRONCHER = register("strawberry_croncher", () -> STRAWBERRY_CRONCHER_TYPE);
    public static final RegistryObject<EntityType<SweetberryCroncherEntity>> SWEETBERRY_CRONCHER = register("sweetberry_croncher", () -> SWEETBERRY_CRONCHER_TYPE);
    public static final RegistryObject<EntityType<OreoCroncherEntity>> OREO_CRONCHER = register("oreo_croncher", () -> OREO_CRONCHER_TYPE);
    public static final RegistryObject<EntityType<GingerBreadAmmoEntity>> GINGER_BREAD_AMMO = register("ginger_bread_ammo", () -> GINGER_BREAD_AMMO_TYPE);

    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(CRONCHER.get(), CroncherEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(STRAWBERRY_CRONCHER.get(), CroncherEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(SWEETBERRY_CRONCHER.get(), CroncherEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(OREO_CRONCHER.get(), CroncherEntity.registerAttributes().create());
    }

    public static void initEntityTypes() {
        CRONCHER_TYPE = EntityType.Builder.create(CroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("croncher");
        STRAWBERRY_CRONCHER_TYPE = EntityType.Builder.create(StrawberryCroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("strawberry_croncher");
        SWEETBERRY_CRONCHER_TYPE = EntityType.Builder.create(SweetberryCroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("sweetberry_croncher");
        OREO_CRONCHER_TYPE = EntityType.Builder.create(OreoCroncherEntity::new, EntityClassification.MONSTER).size(0.6F, 1.55F).setTrackingRange(8).build("oreo_croncher");
        GINGER_BREAD_AMMO_TYPE = EntityType.Builder.<GingerBreadAmmoEntity>create(GingerBreadAmmoEntity::new, EntityClassification.MISC).size(0.5F, 0.5F).setTrackingRange(12).build("ginger_bread_ammo");
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> entityTypeSupplier) {
        return ENTITIES.register(name, entityTypeSupplier);
    }
}

