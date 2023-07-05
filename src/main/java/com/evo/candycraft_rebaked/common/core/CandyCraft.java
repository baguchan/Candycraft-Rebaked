package com.evo.candycraft_rebaked.common.core;

import com.evo.candycraft_rebaked.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft_rebaked.common.core.registry.CandyCraftCreativeTabs;
import com.evo.candycraft_rebaked.common.core.registry.CandyCraftEntities;
import com.evo.candycraft_rebaked.common.event.EntitySpawnEvents;
import com.evo.candycraft_rebaked.common.tag.CCBlockTags;
import com.evo.candycraft_rebaked.datagen.DataGatherer;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CandyCraft.MODID)
public class CandyCraft {

    public static final String MODID = "candycraft_rebaked";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    private static CandyCraft INSTANCE;


    public CandyCraft() {
        INSTANCE = this;

        CCBlockTags.init();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(DataGatherer::onGatherData);

        MinecraftForge.EVENT_BUS.register(new EntitySpawnEvents());
        REGISTRY_HELPER.register(eventBus);
        CandyCraftCreativeTabs.CREATIVE_MODE_TABS.register(eventBus);

        CandyCraftEntities.ENTITIES.register(eventBus);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        CandyCraftEntities.initSpawnRules();
        CandyCraftBlocks.registerBlockData();
    }

    public static ResourceLocation resourceLoc(String path) {
        return new ResourceLocation(MODID, path);
    }


    public static CandyCraft getInstance() {
        return INSTANCE;
    }
}
