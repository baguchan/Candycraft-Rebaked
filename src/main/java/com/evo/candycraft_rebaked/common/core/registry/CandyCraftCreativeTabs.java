package com.evo.candycraft_rebaked.common.core.registry;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class CandyCraftCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CandyCraft.MODID);


    public static final RegistryObject<CreativeModeTab> CANDY_CRAFT = CREATIVE_MODE_TABS.register("candycraft_rebaked", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup." + "candycraft_rebaked"))
            .icon(() -> CandyCraftItems.CANDY_CANE_SWORD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(CandyCraft.REGISTRY_HELPER.getItemSubHelper().getDeferredRegister().getEntries().stream().map(sup -> {
                    return sup.get().getDefaultInstance();
                }).toList());
            }).build());

}
