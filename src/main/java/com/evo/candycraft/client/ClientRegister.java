package com.evo.candycraft.client;

import com.evo.candycraft.client.renderers.entity.CookieCrouperRenderer;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
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
        RenderTypeLookup.setRenderLayer(CandyCraftBlocks.CANDY_CANE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CandyCraftBlocks.POTTED_CANDY_CANE_SAPLING.get(), RenderType.getCutout());
    }

    private static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.COOKIE_CROUPER.get(), (rendererManager) -> new CookieCrouperRenderer<>(rendererManager, "cookie_crouper"));
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.STRAWBERRY_COOKIE_CROUPER.get(), (rendererManager) -> new CookieCrouperRenderer<>(rendererManager, "strawberry_cookie_crouper"));
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.SWEETBERRY_COOKIE_CROUPER.get(), (rendererManager) -> new CookieCrouperRenderer<>(rendererManager, "sweetberry_cookie_crouper"));
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.OREO_COOKIE_CROUPER.get(), (rendererManager) -> new CookieCrouperRenderer<>(rendererManager, "oreo_cookie_crouper"));
    }

    @SubscribeEvent
    public static void onParticleFactoryRegister(ParticleFactoryRegisterEvent event) {
        ParticleManager particleManager = Minecraft.getInstance().particles;
        
    }
}
