package com.evo.candycraft_rebaked.datagen.recipe;

import com.google.common.collect.ImmutableMap;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Houses various helper methods for easily
 * writing recipe types that are used frequently,
 * like a bunch of wood stuff (stairs, fence, slabs etc.)
 */
public abstract class AbstractRecipeProvider extends RecipeProvider {

    private static final Map<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>> SHAPE_BUILDERS = ImmutableMap.<BlockFamily.Variant, BiFunction<ItemLike, ItemLike, RecipeBuilder>>builder()
      .put(BlockFamily.Variant.BUTTON, (result, ingredient) -> buttonBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.CHISELED, (result, ingredient) -> chiseledBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.CUT, (result, ingredient) -> cutBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.DOOR, (result, ingredient) -> doorBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.FENCE, (result, ingredient) -> woodenFenceBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.FENCE_GATE, (result, ingredient) -> fenceGateBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.SIGN, (result, ingredient) -> signBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.SLAB, (result, ingredient) -> slabBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.STAIRS, (result, ingredient) -> stairBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.PRESSURE_PLATE, (result, ingredient) -> pressurePlateBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.POLISHED, (result, ingredient) -> polishedBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.TRAPDOOR, (result, ingredient) -> trapdoorBuilder(result, Ingredient.of(ingredient)))
            .put(BlockFamily.Variant.WALL, (result, ingredient) -> wallBuilder(result, Ingredient.of(ingredient))).build();


    public AbstractRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }


    protected void planksFromLogRecipe(TagKey<Item> logTag, ItemLike planksResult, Consumer<FinishedRecipe> consumer) {
        Objects.requireNonNull(planksResult.asItem().getRegistryName());

        ShapelessRecipeBuilder.shapeless(planksResult, 4)
                .requires(logTag)
                .group("planks")
                .unlockedBy("has_log", has(logTag))
                .save(consumer, planksResult.asItem().getRegistryName().getPath() + "_from_log");
    }

    protected static void generateFamilyRecipes(Consumer<FinishedRecipe> consumer, BlockFamily blockFamily) {
        blockFamily.getVariants().forEach((variant, block) -> {
            BiFunction<ItemLike, ItemLike, RecipeBuilder> biFunction = SHAPE_BUILDERS.get(variant);
            ItemLike itemLike = getBaseBlock(blockFamily, variant);

            if (biFunction != null) {
                RecipeBuilder recipebuilder = biFunction.apply(block, itemLike);
                blockFamily.getRecipeGroupPrefix().ifPresent((groupPrefix) -> {
                    recipebuilder.group(groupPrefix + (variant == BlockFamily.Variant.CUT ? "" : "_" + variant.getName()));
                });
                recipebuilder.unlockedBy(blockFamily.getRecipeUnlockedBy().orElseGet(() -> getHasName(itemLike)), has(itemLike));
                recipebuilder.save(consumer);
            }

            if (variant == BlockFamily.Variant.CRACKED) {
                smeltingResultFromBase(consumer, block, itemLike);
            }
        });
    }

    protected static Block getBaseBlock(BlockFamily blockFamily, BlockFamily.Variant variant) {
        if (variant == BlockFamily.Variant.CHISELED) {
            if (!blockFamily.getVariants().containsKey(BlockFamily.Variant.SLAB)) {
                throw new IllegalStateException("Slab is not defined for the family.");
            }
            else {
                return blockFamily.get(BlockFamily.Variant.SLAB);
            }
        }
        else {
            return blockFamily.getBaseBlock();
        }
    }

    protected static RecipeBuilder buttonBuilder(ItemLike result, Ingredient ingredient) {
        return ShapelessRecipeBuilder.shapeless(result)
                .requires(ingredient);
    }

    protected static RecipeBuilder doorBuilder(ItemLike doorResult, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(doorResult, 3)
                .define('#', ingredient)
                .pattern("##")
                .pattern("##")
                .pattern("##");
    }

    protected static RecipeBuilder woodenFenceBuilder(ItemLike fenceResult, Ingredient planksIngredient) {
        return ShapedRecipeBuilder.shaped(fenceResult, 3)
                .define('W', planksIngredient)
                .define('#', Tags.Items.RODS_WOODEN)
                .pattern("W#W")
                .pattern("W#W");
    }

    protected static RecipeBuilder fenceGateBuilder(ItemLike fenceGateResult, Ingredient p_176686_) {
        return ShapedRecipeBuilder.shaped(fenceGateResult)
                .define('#', Tags.Items.RODS_WOODEN)
                .define('W', p_176686_)
                .pattern("#W#")
                .pattern("#W#");
    }

    protected static void pressurePlate(Consumer<FinishedRecipe> consumer, ItemLike pressurePlateResult, ItemLike ingredient) {
        pressurePlateBuilder(pressurePlateResult, Ingredient.of(ingredient))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(consumer);
    }

    protected static RecipeBuilder pressurePlateBuilder(ItemLike pressurePlateResult, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(pressurePlateResult)
                .define('#', ingredient)
                .pattern("##");
    }

    protected static void slab(Consumer<FinishedRecipe> consumer, ItemLike slabResult, ItemLike ingredient) {
        slabBuilder(slabResult, Ingredient.of(ingredient))
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(consumer);
    }

    protected static RecipeBuilder slabBuilder(ItemLike slabResult, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(slabResult, 6)
                .define('#', ingredient)
                .pattern("###");
    }

    protected static RecipeBuilder stairBuilder(ItemLike stairResult, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(stairResult, 4)
                .define('#', ingredient)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###");
    }

    protected static RecipeBuilder trapdoorBuilder(ItemLike trapdoorResult, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(trapdoorResult, 2)
                .define('#', ingredient)
                .pattern("###")
                .pattern("###");
    }

    protected static RecipeBuilder signBuilder(ItemLike signResult, Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(signResult, 3)
                .group("sign")
                .define('#', ingredient)
                .define('X', Tags.Items.RODS_WOODEN)
                .pattern("###")
                .pattern("###")
                .pattern(" X ");
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        stonecutterResultFromBase(consumer, result, ingredient, 1);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, count)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(consumer, getConversionRecipeName(result, ingredient) + "_stonecutting");
    }

    protected static void smeltingResultFromBase(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, 0.1F, 200).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, ItemLike nine, ItemLike single) {
        nineBlockStorageRecipes(consumer, nine, single, getSimpleRecipeName(single), null, getSimpleRecipeName(single), null);
    }

    protected static void nineBlockStorageRecipesWithCustomPacking(Consumer<FinishedRecipe> consumer, ItemLike nine, ItemLike single, String nineRecipePath, String nineGroup) {
        nineBlockStorageRecipes(consumer, nine, single, nineRecipePath, nineGroup, getSimpleRecipeName(nine), null);
    }

    protected static void nineBlockStorageRecipesRecipesWithCustomUnpacking(Consumer<FinishedRecipe> consumer, ItemLike nine, ItemLike single, String singleRecipePath, String singleGroup) {
        nineBlockStorageRecipes(consumer, nine, single, getSimpleRecipeName(single), null, singleRecipePath, singleGroup);
    }

    /**
     * Helper method for generating recipes for items/blocks
     * that can be converted from 9 to 1 of one type and
     * from 1 to 9 of another type, like iron ingots to iron
     * blocks and iron blocks to iron ingots.
     *
     * @param nine The item that is needed 9 of to convert to 1.
     * @param single The item that is needed 1 of to convert to 9.
     * @param nineRecipePath The custom recipe path of the 9-to-1 recipe.
     * @param nineGroup The crafting group of the 9-to-1 recipe
     * @param singleRecipePath The custom recipe path of the 1-to-9 recipe.
     * @param singleGroup The crafting group of the 1-to-9 recipe.
     */
    public static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, ItemLike nine, ItemLike single, String nineRecipePath, @Nullable String nineGroup, String singleRecipePath, @Nullable String singleGroup) {
        ShapelessRecipeBuilder.shapeless(nine, 9)
                .requires(single)
                .group(singleGroup)
                .unlockedBy(getHasName(single), has(single))
                .save(consumer, new ResourceLocation(singleRecipePath));
        ShapedRecipeBuilder.shaped(single)
                .define('#', nine)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(nineGroup)
                .unlockedBy(getHasName(nine), has(nine))
                .save(consumer, new ResourceLocation(nineRecipePath));
    }

    public static String getHasName(ItemLike itemLike) {
        return "has_" + getItemName(itemLike);
    }

    public static String getItemName(ItemLike itemLike) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemLike.asItem())).getPath();
    }

    public static String getSimpleRecipeName(ItemLike itemLike) {
        return getItemName(itemLike);
    }

    public static String getConversionRecipeName(ItemLike converted, ItemLike toConvert) {
        return getItemName(converted) + "_from_" + getItemName(toConvert);
    }

    public static String getSmeltingRecipeName(ItemLike itemLike) {
        return getItemName(itemLike) + "_from_smelting";
    }

    public static String getBlastingRecipeName(ItemLike itemLike) {
        return getItemName(itemLike) + "_from_blasting";
    }
}