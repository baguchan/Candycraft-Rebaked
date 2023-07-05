package com.evo.candycraft_rebaked.common.core.registry;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import com.evo.candycraft_rebaked.common.item.CandyCraftFoods;
import com.evo.candycraft_rebaked.common.item.GingerBreadLauncherItem;
import com.evo.candycraft_rebaked.common.item.ToolTiers;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CandyCraftItems {

    public static final ItemSubRegistryHelper HELPER = CandyCraft.REGISTRY_HELPER.getItemSubHelper();

    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> RED_LICORICE_BOATS = HELPER.createBoatAndChestBoatItem("red_licorice", CandyCraftBlocks.RED_LICORICE_PLANKS, false);

    public static final RegistryObject<Item> RED_LICORICE_BOAT = RED_LICORICE_BOATS.getFirst();
    public static final RegistryObject<Item> RED_LICORICE_CHEST_BOAT = RED_LICORICE_BOATS.getSecond();


    public static final RegistryObject<Item> WAFFLE_CONE_CRUMBLE = registerSimpleItem("waffle_cone_crumble");
    public static final RegistryObject<Item> CANDY_CANE = HELPER.createItem("candy_cane", () -> new Item(properties().food(CandyCraftFoods.CANDY_CANE)));

    // public static final RegistryObject<Item> CANDY_CANE = HELPER.createItem("candy_cane", () -> new ItemNameBlockItem(CandyCraftBlocks.CANDY_CANE_SAPLING.get(), properties().food(CandyCraftFoods.CANDY_CANE)));

    public static final RegistryObject<Item> CANDY_CANE_SWORD = HELPER.createItem("candy_cane_sword", () -> new SwordItem(ToolTiers.CANDY_CANE, 3, -2.0f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_SHOVEL = HELPER.createItem("candy_cane_shovel", () -> new ShovelItem(ToolTiers.CANDY_CANE, 1.5f, -2.4f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_PICKAXE = HELPER.createItem("candy_cane_pickaxe", () -> new PickaxeItem(ToolTiers.CANDY_CANE, 1, -2.2f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_AXE = HELPER.createItem("candy_cane_axe", () -> new AxeItem(ToolTiers.CANDY_CANE, 6, -2.8f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_HOE = HELPER.createItem("candy_cane_hoe", () -> new HoeItem(ToolTiers.CANDY_CANE, -2, -1.0f, properties()));

    public static final RegistryObject<Item> GINGER_BREAD_LAUNCHER = HELPER.createItem("ginger_bread_launcher", () -> new GingerBreadLauncherItem(properties().stacksTo(1).durability(364)));
    public static final RegistryObject<Item> GINGER_BREAD_AMMO = HELPER.createItem("ginger_bread_ammo", () -> new Item(properties()));


    public static final RegistryObject<Item> CRONCHER_SPAWN_EGG = HELPER.createItem("croncher_spawn_egg", () -> new ForgeSpawnEggItem(CandyCraftEntities.CRONCHER, 0xE9964B, 0x572F1A, properties()));
    public static final RegistryObject<Item> STRAWBERRY_CRONCHER_SPAWN_EGG = HELPER.createItem("strawberry_croncher_spawn_egg", () -> new ForgeSpawnEggItem(CandyCraftEntities.STRAWBERRY_CRONCHER, 0xFFD7A1, 0xC52936, properties()));
    public static final RegistryObject<Item> SWEETBERRY_CRONCHER_SPAWN_EGG = HELPER.createItem("sweetberry_croncher_spawn_egg", () -> new ForgeSpawnEggItem(CandyCraftEntities.SWEETBERRY_CRONCHER, 0xFBAD66, 0xC2263E, properties()));
    public static final RegistryObject<Item> OREO_CRONCHER_SPAWN_EGG = HELPER.createItem("oreo_croncher_spawn_egg", () -> new ForgeSpawnEggItem(CandyCraftEntities.OREO_CRONCHER, 0x362A26, 0xFFFFFF, properties()));
    public static final RegistryObject<Item> MINTOLOTL_SPAWN_EGG = HELPER.createItem("mintolotl_spawn_egg", () -> new ForgeSpawnEggItem(CandyCraftEntities.MINTOLOTL, 0x8DF4AE, 0x65D3A7, properties()));


    private static RegistryObject<Item> registerSimpleItem(String name) {
        return HELPER.createItem(name, () -> new Item(new Item.Properties()));
    }

    private static Item.Properties properties() {
        return new Item.Properties();
    }
}
