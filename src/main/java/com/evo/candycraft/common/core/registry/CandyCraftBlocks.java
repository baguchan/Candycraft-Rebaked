package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CandyCraftBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CandyCraft.MODID);

    public static final RegistryObject<Block> WAFFLE_CONE_BLOCK = registerBlock("waffle_cone_block", () -> new Block(AbstractBlock.Properties.create(Material.WOOL).hardnessAndResistance(1.0f)));

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }
}
