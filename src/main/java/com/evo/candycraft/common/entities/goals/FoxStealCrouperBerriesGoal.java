package com.evo.candycraft.common.entities.goals;

import com.evo.candycraft.common.entities.SweetberryCroncherEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;

import java.util.EnumSet;
import java.util.List;

public class FoxStealCrouperBerriesGoal<T extends FoxEntity> extends Goal {

    private final FoxEntity foxEntity;
    private SweetberryCroncherEntity target;

    public FoxStealCrouperBerriesGoal(FoxEntity foxEntity) {
        this.foxEntity = foxEntity;
        this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
    }

    @Override
    public void startExecuting() {
        this.foxEntity.setSitting(false);
        this.foxEntity.setStuck(false);
    }

    @Override
    public boolean shouldExecute() {
        if (this.foxEntity.isSleeping())
            return false;

        List<SweetberryCroncherEntity> entities = this.foxEntity.getEntityWorld().getEntitiesWithinAABB(SweetberryCroncherEntity.class, this.foxEntity.getBoundingBox().grow(10, 4.0D, 10));
        SweetberryCroncherEntity crouper = null;

        if (!entities.isEmpty()) {
            for (SweetberryCroncherEntity entity : entities) {
                double distance = this.foxEntity.getDistanceSq(entity);

                if (distance <= 80 && this.foxEntity.getEntitySenses().canSee(entity)) {
                    if (canStealBerries(this.foxEntity, entity)) {
                        crouper = entity;
                        break;
                    }
                }
            }
            if (crouper == null) {
                return false;
            }
            else {
                this.target = crouper;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean shouldContinueExecuting() {
        LivingEntity target = this.target;
        if (target != null && this.foxEntity.getDistanceSq(target) <= 80 && this.foxEntity.getEntitySenses().canSee(target)) {
            return canStealBerries(this.foxEntity, target);
        }
        return false;
    }


    @Override
    public void resetTask() {
        LivingEntity target = this.target;

        if (target != null && FoxEntity.func_213481_a(this.foxEntity, target)) {
            this.foxEntity.func_213502_u(true);
            this.foxEntity.setCrouching(true);
            this.foxEntity.getNavigator().clearPath();
            this.foxEntity.getLookController().setLookPositionWithEntity(target, this.foxEntity.getHorizontalFaceSpeed(), this.foxEntity.getVerticalFaceSpeed());
        }
        else {
            this.foxEntity.func_213502_u(false);
            this.foxEntity.setCrouching(false);
        }
    }

    @Override
    public void tick() {
        this.foxEntity.getLookController().setLookPositionWithEntity(target, this.foxEntity.getHorizontalFaceSpeed(), this.foxEntity.getVerticalFaceSpeed());

        if (this.foxEntity.getDistanceSq(this.target) <= 4.0D) {
            this.foxEntity.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.SWEET_BERRIES));
            this.foxEntity.getEntityWorld().playSound(null, this.foxEntity.getPosition(), SoundEvents.ENTITY_FOX_BITE, SoundCategory.NEUTRAL, 0.9f, 1.0f);

            this.target.setBerries(false);
            this.target.attackEntityFrom(DamageSource.causeMobDamage(this.foxEntity), 0.0f);

            // Do this or else the crouper will blow up
            this.target.setRevengeTarget(null);
        }
        else {
            this.foxEntity.getNavigator().tryMoveToEntityLiving(target, 1.5D);
        }
    }

    private static boolean canStealBerries(FoxEntity foxEntity, LivingEntity crouper) {
        if (!(crouper instanceof SweetberryCroncherEntity))
            throw new IllegalArgumentException("[FoxStealCrouperBerriesGoal] Tried casting the wrong entity! Should be SweetberryCookieCrouperEntity");

        return ((SweetberryCroncherEntity)crouper).hasBerries() && foxEntity.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
    }
}
