package com.evo.candycraft.client;

import com.evo.candycraft.client.renderers.entity.CookieCrouperRenderer;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        setupRenderLayers();
        registerEntityRenderers();
    }

    private static void setupRenderLayers() {

    }

    private static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.COOKIE_CROUPER.get(), CookieCrouperRenderer::new);
    }
}
