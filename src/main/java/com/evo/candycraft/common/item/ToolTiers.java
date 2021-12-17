package com.evo.candycraft.common.item;

import com.evo.candycraft.common.core.registry.CandyCraftItems;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ToolTiers {

    public static final Tier CANDY_CANE = new ItemTier(230, 5.0f, 1.5f, 2, 18, () -> Ingredient.of(CandyCraftItems.CANDY_CANE.get()));

    private record ItemTier(int maxUses, float efficiency, float attackDamage, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial) implements Tier {

        @Override
        public int getUses() {
            return this.maxUses;
        }

        @Override
        public float getSpeed() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamageBonus() {
            return this.attackDamage;
        }

        @Override
        public int getLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairMaterial.get();
        }

        @Nullable
        @Override
        public Tag<Block> getTag() {
            return null;
        }
    }
}
