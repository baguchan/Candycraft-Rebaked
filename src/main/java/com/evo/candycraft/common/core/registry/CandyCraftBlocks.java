package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.block.ModSaplingBlock;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.features.ConfiguredFeatures;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CandyCraftBlocks {

    public static final BlockSubRegistryHelper HELPER = CandyCraft.REGISTRY_HELPER.getBlockSubHelper();


    public static final RegistryObject<Block> WAFFLE_CONE_BLOCK = HELPER.createBlock("waffle_cone_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f).sound(SoundType.NETHER_GOLD_ORE)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> WAFFLE_CONE_DOOR = HELPER.createBlock("waffle_cone_door", () -> new DoorBlock(Properties.WAFFLE_CONE_DOOR), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> WAFFLE_CONE_TRAPDOOR = HELPER.createBlock("waffle_cone_trapdoor", ()-> new TrapDoorBlock(Properties.WAFFLE_CONE_TRAPDOOR), CandyCraft.ITEM_GROUP);

    public static final RegistryObject<Block> CANDY_CANE_BLOCK = HELPER.createBlock("candy_cane_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.TERRACOTTA_WHITE, MaterialColor.TERRACOTTA_WHITE)).strength(1.0f, 1.0f).sound(SoundType.STONE)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> CANDY_CANE_WOOD = HELPER.createBlock("candy_cane_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(CANDY_CANE_BLOCK.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> CANDY_CANE_SAPLING = HELPER.createBlockNoItem("candy_cane_sapling", () -> new ModSaplingBlock(() -> ConfiguredFeatures.CANDY_CANE_TREE_FEATURE, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).instabreak().noCollission().randomTicks().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> POTTED_CANDY_CANE_SAPLING = HELPER.createBlockNoItem("potted_candy_cane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CANDY_CANE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noCollission()));

    public static final RegistryObject<Block> RED_LICORICE_LOG = HELPER.createBlock("red_licorice_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_RED, MaterialColor.COLOR_BROWN)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_LOG = HELPER.createBlock("stripped_red_licorice_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_WOOD = HELPER.createBlock("red_licorice_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_WOOD = HELPER.createBlock("stripped_red_licorice_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_PLANKS = HELPER.createBlock("red_licorice_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_STAIRS = HELPER.createBlock("red_licorice_stairs", () -> new StairBlock(RED_LICORICE_PLANKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_SLAB = HELPER.createBlock("red_licorice_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "red_licorice_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_LEAVES = HELPER.createBlock("red_licorice_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_TREE_SAPLING = HELPER.createBlock("red_licorice_tree_sapling", () -> new ModSaplingBlock(() -> ConfiguredFeatures.RED_LICORICE_TREE_FEATURE, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).instabreak().noCollission().randomTicks().sound(SoundType.GRASS)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> POTTED_RED_LICORICE_TREE_SAPLING = HELPER.createBlockNoItem("potted_red_licorice_tree_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, RED_LICORICE_TREE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> NOUGAT_SLATE = HELPER.createBlock("nougat_slate", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)), CandyCraft.ITEM_GROUP);



    public static void registerBlockData() {
        registerPottablePlant(CANDY_CANE_SAPLING, POTTED_CANDY_CANE_SAPLING);
        registerPottablePlant(RED_LICORICE_TREE_SAPLING, POTTED_RED_LICORICE_TREE_SAPLING);
    }

    private static void registerPottablePlant(Supplier<Block> plant, Supplier<Block> pottedPlant) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Objects.requireNonNull(plant.get().getRegistryName()), pottedPlant);
    }

    private static Function<BlockState, MaterialColor> pillarProp(MaterialColor topColor, MaterialColor sideColor) {
        return (blockState) -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor;
    }

    public static class Properties {
        public static final BlockBehaviour.Properties WAFFLE_CONE_DOOR = BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.NETHER_GOLD_ORE);
        public static final BlockBehaviour.Properties WAFFLE_CONE_TRAPDOOR = BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.NETHER_GOLD_ORE);
    }
}
