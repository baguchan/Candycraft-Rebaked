package com.evo.candycraft.datagen;

import com.evo.candycraft.datagen.tag.CCBlockTagProvider;
import com.evo.candycraft.datagen.tag.CCItemTagProvider;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

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
