package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.items.CandyCraftFoods;
import com.evo.candycraft.common.items.GingerBreadLauncherItem;
import com.evo.candycraft.common.items.ToolTiers;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CandyCraftItems {

    public static final ItemSubRegistryHelper HELPER = CandyCraft.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> RED_LICORICE_BOAT = HELPER.createBoatItem("red_licorice", CandyCraftBlocks.RED_LICORICE_PLANKS);

    public static final RegistryObject<Item> WAFFLE_CONE_CRUMBLE = registerSimpleItem("waffle_cone_crumble");
    public static final RegistryObject<Item> CANDY_CANE = HELPER.createItem("candy_cane", () -> new BlockNamedItem(CandyCraftBlocks.CANDY_CANE_SAPLING.get(), properties().food(CandyCraftFoods.CANDY_CANE)));

    public static final RegistryObject<Item> CANDY_CANE_SWORD = HELPER.createItem("candy_cane_sword", () -> new SwordItem(ToolTiers.CANDY_CANE, 3, -2.0f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_SHOVEL = HELPER.createItem("candy_cane_shovel", () -> new ShovelItem(ToolTiers.CANDY_CANE, 1.5f, -2.4f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_PICKAXE = HELPER.createItem("candy_cane_pickaxe", () -> new PickaxeItem(ToolTiers.CANDY_CANE, 1, -2.2f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_AXE = HELPER.createItem("candy_cane_axe", () -> new AxeItem(ToolTiers.CANDY_CANE, 6, -2.8f, properties()));
    public static final RegistryObject<Item> CANDY_CANE_HOE = HELPER.createItem("candy_cane_hoe", () -> new HoeItem(ToolTiers.CANDY_CANE, -2, -1.0f, properties()));

    public static final RegistryObject<Item> GINGER_BREAD_LAUNCHER = HELPER.createItem("ginger_bread_launcher", () -> new GingerBreadLauncherItem(properties().maxStackSize(1).maxDamage(364)));
    public static final RegistryObject<Item> GINGER_BREAD_AMMO = HELPER.createItem("ginger_bread_ammo", () -> new Item(properties()));


    public static final RegistryObject<Item> COOKIE_CROUPER_SPAWN_EGG = HELPER.createItem("cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.COOKIE_CROUPER_TYPE, 0xE9964B, 0x572F1A, properties()));
    public static final RegistryObject<Item> STRAWBERRY_COOKIE_CROUPER_SPAWN_EGG = HELPER.createItem("strawberry_cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.STRAWBERRY_COOKIE_CROUPER_TYPE, 0xFFD7A1, 0xC52936, properties()));
    public static final RegistryObject<Item> SWEETBERRY_COOKIE_CROUPER_SPAWN_EGG = HELPER.createItem("sweetberry_cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.SWEETBERRY_COOKIE_CROUPER_TYPE, 0xFBAD66, 0xC2263E, properties()));
    public static final RegistryObject<Item> OREO_COOKIE_CROUPER_SPAWN_EGG = HELPER.createItem("oreo_cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.OREO_COOKIE_CROUPER_TYPE, 0x362A26, 0xFFFFFF, properties()));

    private static RegistryObject<Item> registerSimpleItem(String name) {
        return HELPER.createItem(name, () -> new Item(new Item.Properties().group(CandyCraft.ITEM_GROUP)));
    }

    private static Item.Properties properties() {
        return new Item.Properties().group(CandyCraft.ITEM_GROUP);
    }
}
