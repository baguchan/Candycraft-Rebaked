package com.evo.candycraft.client;

import com.evo.candycraft.client.renderers.entity.CookieCroncherRenderer;
import com.evo.candycraft.client.renderers.entity.GingerBreadAmmoRenderer;
import com.evo.candycraft.client.renderers.entity.SweetberryCookieCroncherRenderer;
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
        RenderTypeLookup.setRenderLayer(CandyCraftBlocks.RED_LICORICE_TREE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(CandyCraftBlocks.POTTED_RED_LICORICE_TREE_SAPLING.get(), RenderType.getCutout());
    }

    private static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.COOKIE_CRONCHER.get(), (rendererManager) -> new CookieCroncherRenderer<>(rendererManager, "cookie_croncher"));
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.STRAWBERRY_COOKIE_CRONCHER.get(), (rendererManager) -> new CookieCroncherRenderer<>(rendererManager, "strawberry_cookie_croncher"));
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.SWEETBERRY_COOKIE_CRONCHER.get(), (rendererManager) -> new SweetberryCookieCroncherRenderer<>(rendererManager, "sweetberry_cookie_croncher"));
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.OREO_COOKIE_CRONCHER.get(), (rendererManager) -> new CookieCroncherRenderer<>(rendererManager, "oreo_cookie_croncher"));
        RenderingRegistry.registerEntityRenderingHandler(CandyCraftEntities.GINGER_BREAD_AMMO.get(), (rendererManager) -> new GingerBreadAmmoRenderer<>(rendererManager));
    }

    @SubscribeEvent
    public static void onParticleFactoryRegister(ParticleFactoryRegisterEvent event) {
        ParticleManager particleManager = Minecraft.getInstance().particles;
        
    }
}
