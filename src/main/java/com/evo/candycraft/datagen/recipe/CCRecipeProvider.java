package com.evo.candycraft.datagen.recipe;

import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.tag.CCItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class CCRecipeProvider extends AbstractRecipeProvider {

    public CCRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        this.planksFromLogRecipe(CCItemTags.RED_LICORICE_LOGS, CandyCraftBlocks.RED_LICORICE_PLANKS.get(), consumer);

        this.stairsRecipe(CandyCraftBlocks.RED_LICORICE_PLANKS.get(), CandyCraftBlocks.RED_LICORICE_STAIRS.get(), consumer);
    }
}
