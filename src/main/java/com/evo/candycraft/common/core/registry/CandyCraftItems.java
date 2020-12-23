package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CandyCraftItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CandyCraft.MODID);

    public static final RegistryObject<Item> WAFFLE_CONE_BLOCK = registerBlockItem(CandyCraftBlocks.WAFFLE_CONE_BLOCK);


    private static RegistryObject<Item> registerItem(String name, Supplier<Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    private static RegistryObject<Item> registerBlockItem(RegistryObject<Block> blockSupplier) {
        return ITEMS.register(blockSupplier.getId().getPath(), () -> new BlockItem(blockSupplier.get(), new Item.Properties().group(CandyCraft.ITEM_GROUP)));
    }
}
