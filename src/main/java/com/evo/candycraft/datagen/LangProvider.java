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
        this.addItem(CandyCraftItems.CRONCHER_SPAWN_EGG, "Croncher Spawn Egg");
        this.addItem(CandyCraftItems.STRAWBERRY_CRONCHER_SPAWN_EGG, "Strawberry Croncher Spawn Egg");
        this.addItem(CandyCraftItems.SWEETBERRY_CRONCHER_SPAWN_EGG, "Sweetberry Croncher Spawn Egg");
        this.addItem(CandyCraftItems.OREO_CRONCHER_SPAWN_EGG, "Oreo Croncher Spawn Egg");

        this.addBlock(CandyCraftBlocks.WAFFLE_CONE_BLOCK, "Waffle Cone Block");
        this.addBlock(CandyCraftBlocks.WAFFLE_CONE_DOOR, "Waffle Door");
        this.addBlock(CandyCraftBlocks.WAFFLE_CONE_TRAPDOOR, "Waffle Trapdoor");
        this.addBlock(CandyCraftBlocks.CANDY_CANE_BLOCK, "Candy Cane Block");
        this.addBlock(CandyCraftBlocks.CANDY_CANE_WOOD, "Candy Cane Bark");
        this.addBlock(CandyCraftBlocks.CANDY_CANE_SAPLING, "Candy Cane");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_LOG, "Red Licorice Log");
        this.addBlock(CandyCraftBlocks.STRIPPED_RED_LICORICE_LOG, "Stripped Red Licorice Log");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_WOOD, "Red Licorice Wood");
        this.addBlock(CandyCraftBlocks.STRIPPED_RED_LICORICE_WOOD, "Red Licorice Wood");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_PLANKS, "Red Licorice Planks");
        this.addBlock(CandyCraftBlocks.RED_LICORICE_TREE_SAPLING, "Red Licorice Tree Sapling");;

        this.addEntityType(CandyCraftEntities.CRONCHER, "Croncher");
        this.addEntityType(CandyCraftEntities.STRAWBERRY_CRONCHER, "Strawberry Croncher");
        this.addEntityType(CandyCraftEntities.SWEETBERRY_CRONCHER, "Sweetberry Croncher");
        this.addEntityType(CandyCraftEntities.OREO_CRONCHER, "Oreo Croncher");
    }
}
