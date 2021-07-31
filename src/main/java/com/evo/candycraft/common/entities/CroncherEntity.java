package com.evo.candycraft.common.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.EnumSet;

public class CroncherEntity extends MonsterEntity {

    private static final DataParameter<Integer> STATE = EntityDataManager.createKey(CroncherEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(CroncherEntity.class, DataSerializers.BOOLEAN);

    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 30;
    private int explosionRadius = 1;

    public CroncherEntity(EntityType<? extends CroncherEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new CrouperSwellGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public int getMaxFallHeight() {
        return this.getAttackTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
    }

    public boolean onLivingFall(float distance, float damageMultiplier) {
        boolean flag = super.onLivingFall(distance, damageMultiplier);
        this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + distance * 1.5F);

        if (this.timeSinceIgnited > this.fuseTime - 5) {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
        return flag;
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(STATE, -1);
        this.dataManager.register(IGNITED, false);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putShort("Fuse", (short)this.fuseTime);
        compound.putByte("ExplosionRadius", (byte)this.explosionRadius);
        compound.putBoolean("Ignited", this.hasIgnited());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

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
    public void tick() {
        if (this.isAlive()) {
            this.lastActiveTime = this.timeSinceIgnited;
            if (this.hasIgnited()) {
                this.setState(1);
            }

            int i = this.getState();
            if (i > 0 && this.timeSinceIgnited == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
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
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public float getCrouperFlashIntensity(float partialTicks) {
        return MathHelper.lerp(partialTicks, (float)this.lastActiveTime, (float)this.timeSinceIgnited) / (float)(this.fuseTime - 2);
    }

    public int getState() {
        return this.dataManager.get(STATE);
    }

    public void setState(int state) {
        this.dataManager.set(STATE, state);
    }

    private void explode() {
        if (!this.world.isRemote) {
            this.dead = true;
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), this.explosionRadius, Explosion.Mode.NONE);
            this.remove();
        }
    }

    public boolean hasIgnited() {
        return this.dataManager.get(IGNITED);
    }

    public void ignite() {
        this.dataManager.set(IGNITED, true);
    }

    private static class CrouperSwellGoal extends Goal {

        private final CroncherEntity crouperEntity;
        private LivingEntity attackTarget;

        public CrouperSwellGoal(CroncherEntity cookieCrouperEntity) {
            this.crouperEntity = cookieCrouperEntity;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean shouldExecute() {
            LivingEntity livingentity = this.crouperEntity.getAttackTarget();
            return this.crouperEntity.getState() > 0 || livingentity != null && this.crouperEntity.getDistanceSq(livingentity) < 9.0D;
        }

        @Override
        public void startExecuting() {
            this.crouperEntity.getNavigator().clearPath();
            this.attackTarget = this.crouperEntity.getAttackTarget();
        }

        @Override
        public void resetTask() {
            this.attackTarget = null;
        }

        private boolean canSwell(CroncherEntity crouper, LivingEntity attackTarget) {
            return attackTarget != null && (crouper.getDistanceSq(attackTarget) < 48.0D && crouper.getEntitySenses().canSee(attackTarget));
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
