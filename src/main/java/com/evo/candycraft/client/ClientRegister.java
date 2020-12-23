package com.evo.candycraft.client;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        setupRenderLayers();
    }

    private static void setupRenderLayers() {

    }
}
