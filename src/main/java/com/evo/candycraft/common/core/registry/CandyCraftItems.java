package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.items.CandyCraftFoods;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CandyCraftItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CandyCraft.MODID);

    public static final RegistryObject<Item> WAFFLE_CONE_BLOCK = registerBlockItem(CandyCraftBlocks.WAFFLE_CONE_BLOCK);
    public static final RegistryObject<Item> CANDY_CANE_BLOCK = registerBlockItem(CandyCraftBlocks.CANDY_CANE_BLOCK);
    public static final RegistryObject<Item> CANDY_CANE_WOOD = registerBlockItem(CandyCraftBlocks.CANDY_CANE_WOOD);

    public static final RegistryObject<Item> WAFFLE_CONE_CRUMBLE = registerSimpleItem("waffle_cone_crumble");
    public static final RegistryObject<Item> CANDY_CANE = registerItem("candy_cane", () -> new BlockNamedItem(CandyCraftBlocks.CANDY_CANE_SAPLING.get(), new Item.Properties().group(CandyCraft.ITEM_GROUP).food(CandyCraftFoods.CANDY_CANE)));

    public static final RegistryObject<Item> COOKIE_CROUPER_SPAWN_EGG = registerItem("cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.COOKIE_CROUPER_TYPE, 0xE9964B, 0x572F1A, new Item.Properties().group(CandyCraft.ITEM_GROUP)));
    public static final RegistryObject<Item> STRAWBERRY_COOKIE_CROUPER_SPAWN_EGG = registerItem("strawberry_cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.STRAWBERRY_COOKIE_CROUPER_TYPE, 0xFFD7A1, 0xC52936, new Item.Properties().group(CandyCraft.ITEM_GROUP)));
    public static final RegistryObject<Item> SWEETBERRY_COOKIE_CROUPER_SPAWN_EGG = registerItem("sweetberry_cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.SWEETBERRY_COOKIE_CROUPER_TYPE, 0xFBAD66, 0xC2263E, new Item.Properties().group(CandyCraft.ITEM_GROUP)));
    public static final RegistryObject<Item> OREO_COOKIE_CROUPER_SPAWN_EGG = registerItem("oreo_cookie_crouper_spawn_egg", () -> new SpawnEggItem(CandyCraftEntities.OREO_COOKIE_CROUPER_TYPE, 0x362A26, 0xFFFFFF, new Item.Properties().group(CandyCraft.ITEM_GROUP)));


    private static RegistryObject<Item> registerItem(String name, Supplier<Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    private static RegistryObject<Item> registerSimpleItem(String name) {
        return registerItem(name, () -> new Item(new Item.Properties().group(CandyCraft.ITEM_GROUP)));
    }

    private static RegistryObject<Item> registerBlockItem(RegistryObject<Block> blockSupplier) {
        return registerItem(blockSupplier.getId().getPath(), () -> new BlockItem(blockSupplier.get(), new Item.Properties().group(CandyCraft.ITEM_GROUP)));
    }
}
