package com.evo.candycraft.common.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.EnumSet;

public class CroncherEntity extends Monster {

    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(CroncherEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IGNITED = SynchedEntityData.defineId(CroncherEntity.class, EntityDataSerializers.BOOLEAN);

    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 30;
    private int explosionRadius = 1;

    public CroncherEntity(EntityType<? extends CroncherEntity> type, Level level) {
        super(type, level);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new CrouperSwellGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public int getMaxFallDistance() {
        return this.getTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource damageSource) {
        boolean flag = super.causeFallDamage(distance, damageMultiplier, damageSource);
        this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + distance * 1.5F);

        if (this.timeSinceIgnited > this.fuseTime - 5) {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
        return flag;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, -1);
        this.entityData.define(IGNITED, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putShort("Fuse", (short)this.fuseTime);
        compound.putByte("ExplosionRadius", (byte)this.explosionRadius);
        compound.putBoolean("Ignited", this.hasIgnited());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        if (compound.contains("Fuse", 99)) {
            this.fuseTime = compound.getShort("Fuse");
        }

        if (compound.contains("ExplosionRadius", 99)) {
            this.explosionRadius = compound.getByte("ExplosionRadius");
        }

        if (compound.getBoolean("Ignited")) {
            this.ignite();
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick() {
        if (this.isAlive()) {
            this.lastActiveTime = this.timeSinceIgnited;
            if (this.hasIgnited()) {
                this.setState(1);
            }

            int i = this.getState();
            if (i > 0 && this.timeSinceIgnited == 0) {
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
            }

            this.timeSinceIgnited += i;
            if (this.timeSinceIgnited < 0) {
                this.timeSinceIgnited = 0;
            }

            if (this.timeSinceIgnited >= this.fuseTime) {
                this.timeSinceIgnited = this.fuseTime;
                this.explode();
            }
        }
        super.tick();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.CREEPER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CREEPER_DEATH;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public float getCrouperFlashIntensity(float partialTicks) {
        return Mth.lerp(partialTicks, (float)this.lastActiveTime, (float)this.timeSinceIgnited) / (float)(this.fuseTime - 2);
    }

    public int getState() {
        return this.entityData.get(STATE);
    }

    public void setState(int state) {
        this.entityData.set(STATE, state);
    }

    private void explode() {
        if (!this.level.isClientSide) {
            this.dead = true;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), this.explosionRadius, Explosion.BlockInteraction.NONE);
            this.discard();
        }
    }

    public boolean hasIgnited() {
        return this.entityData.get(IGNITED);
    }

    public void ignite() {
        this.entityData.set(IGNITED, true);
    }

    private static class CrouperSwellGoal extends Goal {

        private final CroncherEntity crouperEntity;
        private LivingEntity attackTarget;

        public CrouperSwellGoal(CroncherEntity cookieCrouperEntity) {
            this.crouperEntity = cookieCrouperEntity;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            LivingEntity livingentity = this.crouperEntity.getTarget();
            return this.crouperEntity.getState() > 0 || livingentity != null && this.crouperEntity.distanceTo(livingentity) < 9.0D;
        }

        @Override
        public void start() {
            this.crouperEntity.getNavigation().stop();
            this.attackTarget = this.crouperEntity.getTarget();
        }

        @Override
        public void stop() {
            this.attackTarget = null;
        }

        private boolean canSwell(CroncherEntity crouper, LivingEntity attackTarget) {
            return attackTarget != null && (crouper.distanceTo(attackTarget) < 48.0D && crouper.getSensing().hasLineOfSight(attackTarget));
        }

        @Override
        public void tick() {
            if (this.canSwell(this.crouperEntity, this.attackTarget)) {
                this.crouperEntity.setState(1);
            }
            else {
                this.crouperEntity.setState(-1);
            }
        }
    }
}
