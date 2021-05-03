package com.evo.candycraft.common.entities;

import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class GingerBreadAmmoEntity extends ThrowableEntity {
	public GingerBreadAmmoEntity(EntityType<? extends GingerBreadAmmoEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public GingerBreadAmmoEntity(double x, double y, double z, World worldIn) {
		super(CandyCraftEntities.GINGER_BREAD_AMMO_TYPE, x, y, z, worldIn);
	}

	public GingerBreadAmmoEntity(LivingEntity livingEntityIn, World worldIn) {
		super(CandyCraftEntities.GINGER_BREAD_AMMO_TYPE, livingEntityIn, worldIn);
	}

	@Override
	protected void registerData() {

	}

	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		p_213868_1_.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), 0.0F);

		this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 3.0F, Explosion.Mode.BREAK);

		this.remove();
	}

	@Override
	protected void func_230299_a_(BlockRayTraceResult p_230299_1_) {
		super.func_230299_a_(p_230299_1_);

		this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 3.0F, Explosion.Mode.BREAK);

		this.remove();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
}
