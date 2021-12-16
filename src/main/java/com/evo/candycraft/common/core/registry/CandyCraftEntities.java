package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entity.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
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

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CRONCHER.get(), CroncherEntity.registerAttributes().build());
        event.put(STRAWBERRY_CRONCHER.get(), CroncherEntity.registerAttributes().build());
        event.put(SWEETBERRY_CRONCHER.get(), CroncherEntity.registerAttributes().build());
        event.put(OREO_CRONCHER.get(), CroncherEntity.registerAttributes().build());
    }

    public static void initEntityTypes() {
        CRONCHER_TYPE = EntityType.Builder.of(CroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("croncher");
        STRAWBERRY_CRONCHER_TYPE = EntityType.Builder.of(StrawberryCroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("strawberry_croncher");
        SWEETBERRY_CRONCHER_TYPE = EntityType.Builder.of(SweetberryCroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("sweetberry_croncher");
        OREO_CRONCHER_TYPE = EntityType.Builder.of(OreoCroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("oreo_croncher");
        GINGER_BREAD_AMMO_TYPE = EntityType.Builder.<GingerBreadAmmoEntity>of(GingerBreadAmmoEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).setTrackingRange(12).build("ginger_bread_ammo");
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> entityTypeSupplier) {
        return ENTITIES.register(name, entityTypeSupplier);
    }
}

