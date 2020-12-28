package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.items.CandyCraftFoods;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
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
