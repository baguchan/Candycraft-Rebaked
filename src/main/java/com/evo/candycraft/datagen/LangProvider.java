package com.evo.candycraft.datagen;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import com.evo.candycraft.common.core.registry.CandyCraftItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangProvider extends LanguageProvider {

    public LangProvider(DataGenerator gen) {
        super(gen, CandyCraft.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.candycraft_rebaked", "Candycraft-Rebaked");

        this.addItem(CandyCraftItems.CANDY_CANE, "Candy Cane");
        this.addItem(CandyCraftItems.WAFFLE_CONE_CRUMBLE, "Waffle Cone Crumble");
        this.addItem(CandyCraftItems.CANDY_CANE_SWORD, "Candy Cane Sword");
        this.addItem(CandyCraftItems.CANDY_CANE_SHOVEL, "Candy Cane Shovel");
        this.addItem(CandyCraftItems.CANDY_CANE_PICKAXE, "Candy Cane Pickaxe");
        this.addItem(CandyCraftItems.CANDY_CANE_AXE, "Candy Cane Axe");
        this.addItem(CandyCraftItems.CANDY_CANE_HOE, "Candy Cane Hoe");
        this.addItem(CandyCraftItems.RED_LICORICE_BOAT, "Red Licorice Boat");
        this.addItem(CandyCraftItems.COOKIE_CROUPER_SPAWN_EGG, "Cookie Crouper Spawn Egg");
        this.addItem(CandyCraftItems.STRAWBERRY_COOKIE_CROUPER_SPAWN_EGG, "Strawberry Cookie Crouper Spawn Egg");
        this.addItem(CandyCraftItems.SWEETBERRY_COOKIE_CROUPER_SPAWN_EGG, "Sweetberry Cookie Crouper Spawn Egg");
        this.addItem(CandyCraftItems.OREO_COOKIE_CROUPER_SPAWN_EGG, "Oreo Cookie Crouper Spawn Egg");

        this.addBlock(CandyCraftBlocks.WAFFLE_CONE_BLOCK, "Waffle Cone Block");
        this.addBlock(CandyCraftBlocks.CANDY_CANE_BLOCK, "Candy Cane Block");
        this.addBlock(CandyCraftBlocks.CANDY_CANE_WOOD, "Candy Cane Bark");
        this.addBlock(CandyCraftBlocks.CANDY_CANE_SAPLING, "Candy Cane");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_LOG, "Red Licorice Log");
        this.addBlock(CandyCraftBlocks.STRIPPED_RED_LICORICE_LOG, "Stripped Red Licorice Log");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_WOOD, "Red Licorice Wood");
        this.addBlock(CandyCraftBlocks.STRIPPED_RED_LICORICE_WOOD, "Red Licorice Wood");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_PLANKS, "Red Licorice Planks");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_TREE_SAPLING, "Red Licorice Tree Sapling");;

        this.addEntityType(CandyCraftEntities.COOKIE_CROUPER, "Cookie Crouper");
        this.addEntityType(CandyCraftEntities.STRAWBERRY_COOKIE_CROUPER, "Strawberry Cookie Crouper");
        this.addEntityType(CandyCraftEntities.SWEETBERRY_COOKIE_CROUPER, "Sweetberry Cookie Crouper");
        this.addEntityType(CandyCraftEntities.OREO_COOKIE_CROUPER, "Oreo Cookie Crouper");
    }
}
