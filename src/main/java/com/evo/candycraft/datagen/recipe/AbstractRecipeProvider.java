package com.evo.candycraft.datagen.recipe;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

/**
 * Houses various helper methods for easily
 * writing recipe types that are used frequently,
 * like a bunch of wood stuff (stairs, fence, slabs etc.)
 */
public abstract class AbstractRecipeProvider extends RecipeProvider {

    public AbstractRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    protected void stairsRecipe(ItemLike planksBlock, ItemLike stairsResult, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairsResult, 4)
                .group("stairs")
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .define('P', planksBlock)
                .unlockedBy("has_planks", has(planksBlock))
                .save(consumer);
    }

    protected void planksFromLogRecipe(Tag.Named<Item> logTag, ItemLike planksResult, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(planksResult, 4)
                .requires(logTag)
                .group("planks")
                .unlockedBy("has_log", has(logTag))
                .save(consumer, planksResult.asItem().getRegistryName().getPath() + "_from_log");
    }
}