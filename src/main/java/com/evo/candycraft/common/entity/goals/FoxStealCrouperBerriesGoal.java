package com.evo.candycraft.common.entity.goals;

import com.evo.candycraft.common.entity.SweetberryCroncherEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.EnumSet;
import java.util.List;

public class FoxStealCrouperBerriesGoal<T extends Fox> extends Goal {

    private final T fox;
    private SweetberryCroncherEntity target;

    public FoxStealCrouperBerriesGoal(T fox) {
        this.fox = fox;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
    }

    @Override
    public void start() {
        this.fox.setSitting(false);
    }

    @Override
    public boolean canUse() {
        if (this.fox.isSleeping() || this.fox.isFaceplanted())
            return false;

        List<SweetberryCroncherEntity> entities = this.fox.getLevel().getEntitiesOfClass(SweetberryCroncherEntity.class, this.fox.getBoundingBox().inflate(10, 4.0D, 10));
        SweetberryCroncherEntity crouper = null;

        if (!entities.isEmpty()) {
            for (SweetberryCroncherEntity entity : entities) {
                double distance = this.fox.distanceTo(entity);

                if (distance <= 80 && this.fox.getSensing().hasLineOfSight(entity)) {
                    if (canStealBerries(this.fox, entity)) {
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
    public boolean canContinueToUse() {
        LivingEntity target = this.target;
        if (target != null && this.fox.distanceTo(target) <= 80 && this.fox.getSensing().hasLineOfSight(target)) {
            return canStealBerries(this.fox, target);
        }
        return false;
    }


    @Override
    public void stop() {
        LivingEntity target = this.target;

        if (target != null) {
            this.fox.getNavigation().stop();
        }
    }

    @Override
    public void tick() {
        this.fox.getLookControl().setLookAt(target, this.fox.getMaxHeadYRot(), this.fox.getMaxHeadXRot());

        if (this.fox.distanceTo(this.target) <= 4.0D) {
            this.fox.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.SWEET_BERRIES));
            this.fox.getLevel().playSound(null, this.fox.blockPosition(), SoundEvents.FOX_BITE, SoundSource.NEUTRAL, 0.9f, 1.0f);

            this.target.setBerries(false);
            this.target.hurt(DamageSource.mobAttack(this.fox), 0.0f);

            // Do this or else the crouper will blow up
            if (this.target.getTarget() == this.fox) {
                this.target.setTarget(null);
            }
        }
        else {
            this.fox.getNavigation().moveTo(target, 1.5D);
        }
    }

    private boolean canStealBerries(T fox, LivingEntity crouper) {
        if (!(crouper instanceof SweetberryCroncherEntity))
            return false;

        return ((SweetberryCroncherEntity)crouper).hasBerries() && fox.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
    }
}
