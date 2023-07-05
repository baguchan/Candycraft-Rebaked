package com.evo.candycraft_rebaked.datagen;

import com.evo.candycraft_rebaked.datagen.loot.CCLootTableProvider;
import com.evo.candycraft_rebaked.datagen.tag.CCBlockTagProvider;
import com.evo.candycraft_rebaked.datagen.tag.CCItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
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
        BlockTagsProvider blocktags = new CCBlockTagProvider(packOutput, lookupProvider, event.getExistingFileHelper());
        event.getGenerator().addProvider(event.includeServer(), blocktags);
        event.getGenerator().addProvider(event.includeServer(), new CCItemTagProvider(packOutput, lookupProvider, blocktags.contentsGetter(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeServer(), CCLootTableProvider.create(packOutput));

    }
}
