package com.evo.candycraft.datagen;

import com.evo.candycraft.datagen.tag.CCBlockTagProvider;
import com.evo.candycraft.datagen.tag.CCItemTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

// TODO - NOTE!!!!

/**
 * In its current state, Quark breaks data gen. Until the
 * bug is fixed, Quark must be temporarily removed from
 * the dependency section in build.gradle every time we
 * wish to run the data gen. Shiver me timbers!
 */
public class DataGatherer {

    public static void onGatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeServer()) {
            BlockTagsProvider blockTagsProvider = new CCBlockTagProvider(dataGenerator, fileHelper);
            dataGenerator.addProvider(blockTagsProvider);
            dataGenerator.addProvider(new CCItemTagProvider(dataGenerator, blockTagsProvider, fileHelper));
        }
    }
}
