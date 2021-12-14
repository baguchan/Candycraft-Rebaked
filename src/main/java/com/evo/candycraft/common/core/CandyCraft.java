package com.evo.candycraft.common.core;

import com.evo.candycraft.client.ClientRegister;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import com.evo.candycraft.common.core.registry.CandyCraftFeatures;
import com.evo.candycraft.common.core.registry.CandyCraftItems;
import com.evo.candycraft.common.event.EntitySpawnEvents;
import com.evo.candycraft.common.tag.CCBlockTags;
import com.evo.candycraft.common.world.features.ConfiguredFeatures;
import com.evo.candycraft.datagen.DataGatherer;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
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

        // Spawn egg item has the big stupid
        CandyCraftEntities.initEntityTypes();
        CCBlockTags.init();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(DataGatherer::onGatherData);

        MinecraftForge.EVENT_BUS.register(new EntitySpawnEvents());

        REGISTRY_HELPER.register(eventBus);

        CandyCraftEntities.ENTITIES.register(eventBus);
        CandyCraftFeatures.FEATURES.register(eventBus);
    }

    public final static ItemGroup ITEM_GROUP = new ItemGroup("candycraft_rebaked") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CandyCraftItems.CANDY_CANE.get());
        }
    };

    public void commonSetup(final FMLCommonSetupEvent event) {
        ConfiguredFeatures.register();
        CandyCraftBlocks.registerBlockData();
        CandyCraftEntities.registerAttributes();
    }

    public static ResourceLocation resourceLoc(String path) {
        return new ResourceLocation(MODID, path);
    }


    public static CandyCraft getInstance() {
        return INSTANCE;
    }
}
