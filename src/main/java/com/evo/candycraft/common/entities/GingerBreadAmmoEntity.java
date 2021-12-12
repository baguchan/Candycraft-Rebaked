package com.evo.candycraft.common.entities;

import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.network.NetworkHooks;

public class GingerBreadAmmoEntity extends ThrowableEntity {

	public GingerBreadAmmoEntity(EntityType<? extends GingerBreadAmmoEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public GingerBreadAmmoEntity(PlayerEntity player, double x, double y, double z, World worldIn) {
		super(CandyCraftEntities.GINGER_BREAD_AMMO_TYPE, x, y, z, worldIn);
		this.setShooter(player);
	}

	public GingerBreadAmmoEntity(LivingEntity livingEntityIn, World worldIn) {
		super(CandyCraftEntities.GINGER_BREAD_AMMO_TYPE, livingEntityIn, worldIn);
	}

	@Override
	protected void registerData() {

	}

	@Override
	protected void onEntityHit(EntityRayTraceResult result) {
		super.onEntityHit(result);

		if (!this.world.isRemote) {
			Entity target = result.getEntity();
			Entity shooter = this.func_234616_v_();

			target.attackEntityFrom(DamageSource.causeThrownDamage(this, shooter), 1.0F);

			if (shooter instanceof LivingEntity) {
				this.applyEnchantments((LivingEntity) shooter, target);
			}
		}
		this.remove();
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);

		if (!this.world.isRemote) {
			boolean flag = ForgeEventFactory.getMobGriefingEvent(this.world, this.func_234616_v_());
			this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 3.0F, flag ? Explosion.Mode.BREAK : Explosion.Mode.NONE);
		}
		this.remove();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
