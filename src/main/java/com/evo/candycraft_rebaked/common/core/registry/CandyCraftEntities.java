package com.evo.candycraft_rebaked.common.core.registry;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import com.evo.candycraft_rebaked.common.entity.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
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

    public static final RegistryObject<EntityType<CroncherEntity>> CRONCHER = register("croncher", () -> EntityType.Builder.of(CroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("croncher"));
    public static final RegistryObject<EntityType<StrawberryCroncherEntity>> STRAWBERRY_CRONCHER = register("strawberry_croncher", () -> EntityType.Builder.of(StrawberryCroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("strawberry_croncher"));
    public static final RegistryObject<EntityType<SweetberryCroncherEntity>> SWEETBERRY_CRONCHER = register("sweetberry_croncher", () -> EntityType.Builder.of(SweetberryCroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("sweetberry_croncher"));
    public static final RegistryObject<EntityType<OreoCroncherEntity>> OREO_CRONCHER = register("oreo_croncher", () -> EntityType.Builder.of(OreoCroncherEntity::new, MobCategory.MONSTER).sized(0.6F, 1.55F).setTrackingRange(8).build("oreo_croncher"));
    public static final RegistryObject<EntityType<MintolotlEntity>> MINTOLOTL = register("mintolotl", () -> EntityType.Builder.of(MintolotlEntity::new, MobCategory.CREATURE).sized(0.45F, 0.35F).setTrackingRange(10).build("mintolotl"));
    public static final RegistryObject<EntityType<GingerBreadAmmoEntity>> GINGER_BREAD_AMMO = register("ginger_bread_ammo", () -> EntityType.Builder.<GingerBreadAmmoEntity>of(GingerBreadAmmoEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).setTrackingRange(12).build("ginger_bread_ammo"));

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CRONCHER.get(), CroncherEntity.registerAttributes().build());
        event.put(STRAWBERRY_CRONCHER.get(), CroncherEntity.registerAttributes().build());
        event.put(SWEETBERRY_CRONCHER.get(), CroncherEntity.registerAttributes().build());
        event.put(OREO_CRONCHER.get(), CroncherEntity.registerAttributes().build());
        event.put(MINTOLOTL.get(), MintolotlEntity.registerAttributes().build());
    }

    public static void initSpawnRules() {
        SpawnPlacements.register(CRONCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(STRAWBERRY_CRONCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SWEETBERRY_CRONCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(OREO_CRONCHER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(MINTOLOTL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MintolotlEntity::checkMintlotlSpawnRules);
    }

    public static void initEntityTypes() {
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> entityTypeSupplier) {
        return ENTITIES.register(name, entityTypeSupplier);
    }
}

