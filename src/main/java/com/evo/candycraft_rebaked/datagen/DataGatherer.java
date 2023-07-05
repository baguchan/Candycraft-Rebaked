package com.evo.candycraft_rebaked.datagen;

import com.evo.candycraft_rebaked.datagen.loot.CCLootTableProvider;
import com.evo.candycraft_rebaked.datagen.recipe.CCRecipeProvider;
import com.evo.candycraft_rebaked.datagen.tag.CCBlockTagProvider;
import com.evo.candycraft_rebaked.datagen.tag.CCItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

// TODO - NOTE!!!!

/**
 * In its current state, Quark breaks data gen. Until the
 * bug is fixed, Quark must be temporarily removed from
 * the dependency section in build.gradle every time we
 * wish to run the data gen. Shiver me timbers!
 */
public class DataGatherer {

    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        event.getGenerator().addProvider(event.includeClient(), new BlockstateGenerator(packOutput, event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeClient(), new ItemModelGenerator(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new CustomTagGenerator.BannerPatternTagGenerator(packOutput, lookupProvider, existingFileHelper));
        BlockTagsProvider blocktags = new BlockTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper());
        event.getGenerator().addProvider(event.includeServer(), blocktags);
        event.getGenerator().addProvider(event.includeServer(), new ItemTagGenerator(packOutput, lookupProvider, blocktags.contentsGetter(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeServer(), new EntityTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeServer(), new FluidTagGenerator(packOutput, lookupProvider, event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeServer(), TofuLootTableProvider.create(packOutput));
        event.getGenerator().addProvider(event.includeServer(), new CraftingGenerator(packOutput));
        event.getGenerator().addProvider(event.includeServer(), new RegistryDataGenerator(packOutput, lookupProvider));
        event.getGenerator().addProvider(event.includeServer(), RegistryDataGenerator.createLevelStem(packOutput, existingFileHelper));

    }
}
