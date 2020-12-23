package com.evo.candycraft.common.core;

import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.core.registry.CandyCraftItems;
import com.evo.candycraft.datagen.DataGatherer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(CandyCraft.MODID)
public class CandyCraft {

    public static final String MODID = "candycraft";
    private static final Logger LOGGER = LogManager.getLogger(MODID);

    private static CandyCraft INSTANCE;

    public CandyCraft() {
        INSTANCE = this;

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(DataGatherer::onGatherData);

        CandyCraftBlocks.BLOCKS.register(eventBus);
        CandyCraftItems.ITEMS.register(eventBus);
    }

    public static CandyCraft getInstance() {
        return INSTANCE;
    }

    public static final ItemGroup ITEM_GROUP = new ModGroup(MODID, () -> new ItemStack(Items.SUGAR));

    public static class ModGroup extends ItemGroup {

        private final Supplier<ItemStack> icon;

        public ModGroup(final String name, final Supplier<ItemStack> icon) {
            super(name);
            this.icon = icon;
        }

        @Override
        public ItemStack createIcon() {
            return this.icon.get();
        }
    }
}
