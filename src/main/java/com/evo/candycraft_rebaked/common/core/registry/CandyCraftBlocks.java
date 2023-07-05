package com.evo.candycraft_rebaked.common.core.registry;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import com.teamabnormals.blueprint.common.block.wood.BlueprintWoodButtonBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CandyCraftBlocks {

    public static final BlockSubRegistryHelper HELPER = CandyCraft.REGISTRY_HELPER.getBlockSubHelper();


    public static final RegistryObject<Block> WAFFLE_CONE_BLOCK = HELPER.createBlock("waffle_cone_block", () -> new Block(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.NETHER_GOLD_ORE)), new Item.Properties());
    public static final RegistryObject<Block> WAFFLE_CONE_DOOR = HELPER.createBlock("waffle_cone_door", () -> new DoorBlock(Properties.WAFFLE_CONE_DOOR, BlockSetType.OAK), new Item.Properties());
    public static final RegistryObject<Block> WAFFLE_CONE_TRAPDOOR = HELPER.createBlock("waffle_cone_trapdoor", ()-> new TrapDoorBlock(Properties.WAFFLE_CONE_TRAPDOOR, BlockSetType.OAK), new Item.Properties());

    public static final RegistryObject<Block> CANDY_CANE_BLOCK = HELPER.createBlock("candy_cane_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(1.0f, 1.0f).sound(SoundType.STONE)), new Item.Properties());
    public static final RegistryObject<Block> CANDY_CANE_WOOD = HELPER.createBlock("candy_cane_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(CANDY_CANE_BLOCK.get())), new Item.Properties());
    //public static final RegistryObject<Block> CANDY_CANE_SAPLING = HELPER.createBlockNoItem("candy_cane_sapling", () -> new ModSaplingBlock(ConfiguredFeatures.CANDY_CANE_TREE_FEATURE, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).instabreak().noCollission().randomTicks().sound(SoundType.GRASS)), new Item.Properties());
   // public static final RegistryObject<Block> POTTED_CANDY_CANE_SAPLING = HELPER.createBlockNoItem("potted_candy_cane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CANDY_CANE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noCollission()));

    public static final RegistryObject<Block> RED_LICORICE_LOG = HELPER.createBlock("red_licorice_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD)), new Item.Properties());
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_LOG = HELPER.createBlock("stripped_red_licorice_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD)), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_WOOD = HELPER.createBlock("red_licorice_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD)), new Item.Properties());
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_WOOD = HELPER.createBlock("stripped_red_licorice_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD)), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_PLANKS = HELPER.createBlock("red_licorice_planks", () -> new Block(BlockBehaviour.Properties.of().strength(1.0f).sound(SoundType.WOOD)), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_VERTICAL_PLANKS = HELPER.createBlock("red_licorice_vertical_planks", () -> new Block(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_STAIRS = HELPER.createBlock("red_licorice_stairs", () -> new StairBlock(RED_LICORICE_PLANKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_SLAB = HELPER.createBlock("red_licorice_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_FENCE = HELPER.createBlock("red_licorice_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_FENCE_GATE = HELPER.createBlock("red_licorice_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get()), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_PRESSURE_PLATE = HELPER.createBlock("red_licorice_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.of().mapColor(RED_LICORICE_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.OAK), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_BUTTON = HELPER.createBlock("red_licorice_button", () -> new BlueprintWoodButtonBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get()).strength(0.5f), BlockSetType.OAK), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_DOOR = HELPER.createBlock("red_licorice_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get()).noOcclusion().isValidSpawn(SpawnPredicates::never).strength(0.5F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), BlockSetType.BAMBOO), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_TRAPDOOR = HELPER.createBlock("red_licorice_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get()).noOcclusion().isValidSpawn(SpawnPredicates::never), BlockSetType.OAK), new Item.Properties());
    public static final RegistryObject<Block> RED_LICORICE_LEAVES = HELPER.createBlock("red_licorice_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), new Item.Properties());
    //public static final RegistryObject<Block> RED_LICORICE_TREE_SAPLING = HELPER.createBlock("red_licorice_tree_sapling", () -> new ModSaplingBlock(ConfiguredFeatures.RED_LICORICE_TREE_FEATURE, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).instabreak().noCollission().randomTicks().sound(SoundType.GRASS)), new Item.Properties());
    //public static final RegistryObject<Block> POTTED_RED_LICORICE_TREE_SAPLING = HELPER.createBlockNoItem("potted_red_licorice_tree_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, RED_LICORICE_TREE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> NOUGAT_SLATE = HELPER.createBlock("nougat_slate", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)), new Item.Properties());



    public static void registerBlockData() {
        //registerPottablePlant(CANDY_CANE_SAPLING, POTTED_CANDY_CANE_SAPLING);
        //registerPottablePlant(RED_LICORICE_TREE_SAPLING, POTTED_RED_LICORICE_TREE_SAPLING);
    }

    private static void registerPottablePlant(Supplier<Block> plant, Supplier<Block> pottedPlant) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(plant.get())), pottedPlant);
    }

    public static class Properties {
        public static final BlockBehaviour.Properties WAFFLE_CONE_DOOR = BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.NETHER_GOLD_ORE);
        public static final BlockBehaviour.Properties WAFFLE_CONE_TRAPDOOR = BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.NETHER_GOLD_ORE);
    }

    private static class SpawnPredicates {

        /**
         * For blocks that should never be considered
         * a valid spawn location for entities.
         */
        protected static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos, EntityType<?> entityType) {
            return false;
        }
    }
}
