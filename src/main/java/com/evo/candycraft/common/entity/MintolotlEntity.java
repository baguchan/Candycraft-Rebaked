package com.evo.candycraft.common.entity;

import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.core.registry.CandyCraftEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MintolotlEntity extends Axolotl {
	public MintolotlEntity(EntityType<? extends Axolotl> type, Level level) {
		super(type, level);
	}

	public static boolean checkMintlotlSpawnRules(EntityType<? extends LivingEntity> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos blockPos, Random random) {
		return level.getBlockState(blockPos.below()).is(CandyCraftBlocks.WAFFLE_CONE_BLOCK.get());
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 12.0D).add(Attributes.MOVEMENT_SPEED, 2.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@Override
	protected void handleAirSupply(int p_149194_) {
		this.setAirSupply(this.getMaxAirSupply());
	}

	@Override
	public void rehydrate() {
		int i = this.getAirSupply() + 1800;
		this.setAirSupply(Math.min(i, this.getMaxAirSupply()));
	}

	@Override
	public int getMaxAirSupply() {
		return 6000;
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return CandyCraftEntities.MINTOLOTL.get().create(level);
	}
}
