package com.evo.candycraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

public class DataGatherer {

    public static void onGatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();

        if (event.includeClient()) {
            dataGenerator.addProvider(new LangProvider(dataGenerator));
        }
    }
}
