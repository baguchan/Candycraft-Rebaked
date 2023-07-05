package com.evo.candycraft_rebaked.common.entity;

import com.evo.candycraft_rebaked.common.core.registry.CandyCraftEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.NetworkHooks;

public class GingerBreadAmmoEntity extends ThrowableProjectile {

	public GingerBreadAmmoEntity(EntityType<? extends GingerBreadAmmoEntity> type, Level level) {
		super(type, level);
	}

	public GingerBreadAmmoEntity(Player player, double x, double y, double z, Level level) {
		super(CandyCraftEntities.GINGER_BREAD_AMMO.get(), x, y, z, level);
		this.setOwner(player);
	}

	public GingerBreadAmmoEntity(LivingEntity livingEntity, Level level) {
		super(CandyCraftEntities.GINGER_BREAD_AMMO.get(), livingEntity, level);
	}

	@Override
	protected void defineSynchedData() {

	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);

		if (!this.level().isClientSide) {
			Entity target = result.getEntity();
			Entity shooter = this.getOwner();

			target.hurt(target.damageSources().thrown(this, shooter), 1.0F);

			if (shooter instanceof LivingEntity) {
				this.doEnchantDamageEffects((LivingEntity) shooter, target);
			}
		}
		this.discard();
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);

		if (!this.level().isClientSide) {
			boolean flag = ForgeEventFactory.getMobGriefingEvent(this.level(), this.getOwner());
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 3.0F, flag ? Level.ExplosionInteraction.BLOCK : Level.ExplosionInteraction.NONE);
		}
		this.discard();
	}



	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
