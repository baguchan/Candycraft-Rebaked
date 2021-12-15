package com.evo.candycraft.client;

import com.evo.candycraft.client.renderers.entity.CroncherRenderer;
import com.evo.candycraft.client.renderers.entity.GingerBreadAmmoRenderer;
import com.evo.candycraft.client.renderers.entity.SweetberryCroncherRenderer;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
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
        ItemBlockRenderTypes.setRenderLayer(CandyCraftBlocks.CANDY_CANE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CandyCraftBlocks.POTTED_CANDY_CANE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CandyCraftBlocks.RED_LICORICE_TREE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CandyCraftBlocks.POTTED_RED_LICORICE_TREE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CandyCraftBlocks.RED_LICORICE_LEAVES.get(), RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(CandyCraftBlocks.WAFFLE_CONE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CandyCraftBlocks.WAFFLE_CONE_TRAPDOOR.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CandyCraftEntities.CRONCHER.get(), (rendererManager) -> new CroncherRenderer<>(rendererManager, "croncher"));
        event.registerEntityRenderer(CandyCraftEntities.STRAWBERRY_CRONCHER.get(), (rendererManager) -> new CroncherRenderer<>(rendererManager, "strawberry_croncher"));
        event.registerEntityRenderer(CandyCraftEntities.SWEETBERRY_CRONCHER.get(), (rendererManager) -> new SweetberryCroncherRenderer<>(rendererManager, "sweetberry_croncher"));
        event.registerEntityRenderer(CandyCraftEntities.OREO_CRONCHER.get(), (rendererManager) -> new CroncherRenderer<>(rendererManager, "oreo_croncher"));
        event.registerEntityRenderer(CandyCraftEntities.GINGER_BREAD_AMMO.get(), GingerBreadAmmoRenderer::new);
    }

    // TODO - Find out how this shit works
    @SubscribeEvent
    public static void registerEntityLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }

    @SubscribeEvent
    public static void onParticleFactoryRegister(ParticleFactoryRegisterEvent event) {
        ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;
    }
}
