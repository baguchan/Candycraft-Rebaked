package com.evo.candycraft.datagen.recipe;

import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.tag.CCItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

/**
 * Hello and welcome to the dumpster fire that is recipe generation!
 *
 * For readability purposes, helper methods for creating specific
 * types of recipes that reoccur a lot (slabs, stairs, doors, buttons etc.),
 * are located in {@link AbstractRecipeProvider}.
 *
 * Also note that we are copying vanilla's method of dealing
 * with reoccurring recipe types, utilizing {@link net.minecraft.data.BlockFamily}.
 *
 * This mod's block families are located in {@link CCBlockFamilies}
 */
public class CCRecipeProvider extends AbstractRecipeProvider {

    public CCRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        BlockFamilyHolder.getAllFamilyHolders().filter((blockFamilyHolder) -> blockFamilyHolder.get().shouldGenerateRecipe()).forEach((blockFamilyHolder) -> {
            generateFamilyRecipes(consumer, blockFamilyHolder.get());
        });

        this.planksFromLogRecipe(CCItemTags.RED_LICORICE_LOGS, CandyCraftBlocks.RED_LICORICE_PLANKS.get(), consumer);
    }
}
