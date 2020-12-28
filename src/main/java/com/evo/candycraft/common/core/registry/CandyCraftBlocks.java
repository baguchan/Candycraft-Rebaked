package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.blocks.CandyCaneSaplingBlock;
import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class CandyCraftBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CandyCraft.MODID);

    public static final RegistryObject<Block> WAFFLE_CONE_BLOCK = registerBlock("waffle_cone_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.0f).sound(SoundType.NETHER_GOLD)));
    public static final RegistryObject<Block> CANDY_CANE_BLOCK = registerBlock("candy_cane_block", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.WHITE_TERRACOTTA, MaterialColor.WHITE_TERRACOTTA)).hardnessAndResistance(1.0f, 1.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CANDY_CANE_WOOD = registerBlock("candy_cane_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(CANDY_CANE_BLOCK.get())));
    public static final RegistryObject<Block> CANDY_CANE_SAPLING = registerBlock("candy_cane_sapling", () -> new CandyCaneSaplingBlock(AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.WHITE_TERRACOTTA).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> POTTED_CANDY_CANE_SAPLING = registerBlock("potted_candy_cane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CANDY_CANE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f).notSolid()));

    public static void registerBlockData() {
        registerPottablePlant(CANDY_CANE_SAPLING, POTTED_CANDY_CANE_SAPLING);
    }

    private static void registerPottablePlant(Supplier<Block> plant, Supplier<Block> pottedPlant) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Objects.requireNonNull(plant.get().getRegistryName()), pottedPlant);
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    private static Function<BlockState, MaterialColor> pillarProp(MaterialColor topColor, MaterialColor sideColor) {
        return (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor;
    }
}
