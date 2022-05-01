package com.evo.candycraft_rebaked.common.item;

import com.evo.candycraft_rebaked.common.core.registry.CandyCraftItems;
import com.evo.candycraft_rebaked.common.entity.GingerBreadAmmoEntity;
import com.google.common.collect.Lists;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class GingerBreadLauncherItem extends ProjectileWeaponItem implements Vanishable {

	/*
	*
	* This class is a rewrite based on crossbow
	* If you have any dissatisfaction, feel free to rewrite it.
	*
	*/
	public static final Predicate<ItemStack> GINGER_BREAD_AMMO_ONLY = (stack) -> stack.is(CandyCraftItems.GINGER_BREAD_AMMO.get());

	private static final String TAG_CHARGED = "Charged";
	private static final String TAG_CHARGED_PROJECTILES = "ChargedProjectiles";

	private boolean startSoundPlayed = false;
	private boolean midLoadSoundPlayed = false;

	public GingerBreadLauncherItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public Predicate<ItemStack> getSupportedHeldProjectiles() {
		return GINGER_BREAD_AMMO_ONLY;
	}

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return GINGER_BREAD_AMMO_ONLY;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemStack = player.getItemInHand(hand);

		if (isCharged(itemStack)) {
			performShooting(level, player, hand, itemStack, getShootingPower(itemStack), 1.0F);
			setCharged(itemStack, false);
			return InteractionResultHolder.consume(itemStack);
		}
		else if (!player.getProjectile(itemStack).isEmpty()) {
			if (!isCharged(itemStack)) {
				this.startSoundPlayed = false;
				this.midLoadSoundPlayed = false;
				player.startUsingItem(hand);
			}
			return InteractionResultHolder.consume(itemStack);
		}
		else {
			return InteractionResultHolder.fail(itemStack);
		}
	}

	private static float getShootingPower(ItemStack itemStack) {
		return 3.15F;
	}

	@Override
	public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int remainingTicks) {
		int useDuration = this.getUseDuration(itemStack) - remainingTicks;
		float power = getPowerForTime(useDuration, itemStack);

		if (power >= 1.0F && !isCharged(itemStack) && tryLoadProjectiles(livingEntity, itemStack)) {
			setCharged(itemStack, true);
			SoundSource soundsource = livingEntity instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
			level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.CROSSBOW_LOADING_END, soundsource, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
		}
	}

	private static boolean tryLoadProjectiles(LivingEntity livingEntity, ItemStack itemStack) {
		int multishotLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, itemStack);
		int projectileCount = multishotLevel == 0 ? 1 : 3;
		boolean creativeMode = livingEntity instanceof Player && ((Player) livingEntity).getAbilities().instabuild;

		ItemStack ammoStack = livingEntity.getProjectile(itemStack);
		ItemStack ammoStackCopy = ammoStack.copy();

		for(int i = 0; i < projectileCount; ++i) {
			if (i > 0) {
				ammoStack = ammoStackCopy.copy();
			}

			if (ammoStack.isEmpty() && creativeMode) {
				ammoStack = new ItemStack(CandyCraftItems.GINGER_BREAD_AMMO.get());
				ammoStackCopy = ammoStack.copy();
			}

			if (!loadProjectile(livingEntity, itemStack, ammoStack, i > 0, creativeMode)) {
				return false;
			}
		}
		return true;
	}

	private static boolean loadProjectile(LivingEntity livingEntity, ItemStack itemStack, ItemStack ammoStack, boolean multishot, boolean creativeMode) {
		if (ammoStack.isEmpty()) {
			return false;
		}
		else {
			boolean flag = creativeMode && ammoStack.getItem() instanceof ArrowItem;
			ItemStack newAmmoStack;

			if (!flag && !creativeMode && !multishot) {
				newAmmoStack = ammoStack.split(1);

				if (ammoStack.isEmpty() && livingEntity instanceof Player) {
					((Player) livingEntity).getInventory().removeItem(ammoStack);
				}
			}
			else {
				newAmmoStack = ammoStack.copy();
			}
			addChargedProjectile(itemStack, newAmmoStack);
			return true;
		}
	}

	public static boolean isCharged(ItemStack itemStack) {
		CompoundTag compoundtag = itemStack.getTag();
		return compoundtag != null && compoundtag.getBoolean(TAG_CHARGED);
	}

	public static void setCharged(ItemStack itemStack, boolean charged) {
		CompoundTag compoundtag = itemStack.getOrCreateTag();
		compoundtag.putBoolean(TAG_CHARGED, charged);
	}

	private static void addChargedProjectile(ItemStack itemStack, ItemStack ammoStack) {
		CompoundTag compoundTag = itemStack.getOrCreateTag();
		ListTag listTag;

		if (compoundTag.contains(TAG_CHARGED_PROJECTILES, 9)) {
			listTag = compoundTag.getList(TAG_CHARGED_PROJECTILES, 10);
		}
		else {
			listTag = new ListTag();
		}

		// Huh
		CompoundTag compoundtag1 = new CompoundTag();
		ammoStack.save(compoundtag1);
		listTag.add(compoundtag1);
		compoundTag.put(TAG_CHARGED_PROJECTILES, listTag);
	}

	private static List<ItemStack> getChargedProjectiles(ItemStack itemStack) {
		List<ItemStack> list = Lists.newArrayList();
		CompoundTag compoundTag = itemStack.getTag();

		if (compoundTag != null && compoundTag.contains(TAG_CHARGED_PROJECTILES, 9)) {
			ListTag listTag = compoundTag.getList(TAG_CHARGED_PROJECTILES, 10);

			if (!listTag.isEmpty()) {
				for(int i = 0; i < listTag.size(); ++i) {
					CompoundTag compoundTag1 = listTag.getCompound(i);
					list.add(ItemStack.of(compoundTag1));
				}
			}
		}
		return list;
	}

	private static void clearChargedProjectiles(ItemStack itemStack) {
		CompoundTag compoundTag = itemStack.getTag();

		if (compoundTag != null) {
			ListTag listTag = compoundTag.getList(TAG_CHARGED_PROJECTILES, 9);
			listTag.clear();
			compoundTag.put(TAG_CHARGED_PROJECTILES, listTag);
		}
	}

	public static boolean containsChargedProjectile(ItemStack itemStack, Item item) {
		return getChargedProjectiles(itemStack).stream().anyMatch((stack) -> stack.is(item));
	}

	private static void shootProjectile(Level level, LivingEntity livingEntity, InteractionHand hand, ItemStack itemStack, ItemStack projectileStack, float shotPitch, boolean creativeMode, float shootingPower, float speedMult, float spread) {
		if (!level.isClientSide) {
			Projectile projectile = new GingerBreadAmmoEntity(livingEntity, level);

			if (livingEntity instanceof CrossbowAttackMob crossbowMob) {
				crossbowMob.shootCrossbowProjectile(crossbowMob.getTarget(), itemStack, projectile, spread);
			}
			else {
				Vec3 upVec = livingEntity.getUpVector(1.0F);
				Quaternion quaternion = new Quaternion(new Vector3f(upVec), spread, true);
				Vec3 viewVec = livingEntity.getViewVector(1.0F);
				Vector3f viewVecCopy = new Vector3f(viewVec);
				viewVecCopy.transform(quaternion);
				projectile.shoot(viewVecCopy.x(), viewVecCopy.y(), viewVecCopy.z(), shootingPower, speedMult);
			}

			itemStack.hurtAndBreak(1, livingEntity, (entity) -> {
				entity.broadcastBreakEvent(hand);
			});
			level.addFreshEntity(projectile);
			level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, shotPitch);
		}
		level.addParticle(ParticleTypes.EXPLOSION, livingEntity.getX(), livingEntity.getEyeY(), livingEntity.getZ(), 0.0D, 0.0D, 0.0D);
	}

	public static void performShooting(Level level, LivingEntity livingEntity, InteractionHand hand, ItemStack itemStack, float shootingPower, float speedMult) {
		List<ItemStack> list = getChargedProjectiles(itemStack);
		float[] shotPitches = getShotPitches(livingEntity.getRandom());

		for(int i = 0; i < list.size(); ++i) {
			ItemStack projectileStack = list.get(i);
			boolean creativeMode = livingEntity instanceof Player && ((Player) livingEntity).getAbilities().instabuild;

			if (!projectileStack.isEmpty()) {
				float spread;

				switch (i) {
					default -> spread = 0.0F;
					case 1 -> spread = -10.0F;
					case 2 -> spread = 10.0F;
				}
				shootProjectile(level, livingEntity, hand, itemStack, projectileStack, shotPitches[i], creativeMode, shootingPower, speedMult, spread);
			}
		}
		onCrossbowShot(level, livingEntity, itemStack);
	}

	private static float[] getShotPitches(Random random) {
		boolean flag = random.nextBoolean();
		return new float[]{1.0F, getRandomShotPitch(flag, random), getRandomShotPitch(!flag, random)};
	}

	private static float getRandomShotPitch(boolean flag, Random random) {
		float f = flag ? 0.63F : 0.43F;
		return 1.0F / (random.nextFloat() * 0.5F + 1.8F) + f;
	}

	private static void onCrossbowShot(Level level, LivingEntity livingEntity, ItemStack itemStack) {
		if (livingEntity instanceof ServerPlayer serverPlayer) {
			if (!level.isClientSide) {
				CriteriaTriggers.SHOT_CROSSBOW.trigger(serverPlayer, itemStack);
			}
			serverPlayer.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
		}
		clearChargedProjectiles(itemStack);
	}

	@Override
	public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int remainingUseTicks) {
		if (!level.isClientSide) {
			int quickChargeLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, itemStack);
			SoundEvent startSound = this.getStartSound(quickChargeLevel);
			SoundEvent loadingSound = quickChargeLevel == 0 ? SoundEvents.CROSSBOW_LOADING_MIDDLE : null;
			float f = (float) (itemStack.getUseDuration() - remainingUseTicks) / (float)getChargeDuration(itemStack);

			if (f < 0.2F) {
				this.startSoundPlayed = false;
				this.midLoadSoundPlayed = false;
			}

			if (f >= 0.2F && !this.startSoundPlayed) {
				this.startSoundPlayed = true;
				level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), startSound, SoundSource.PLAYERS, 0.5F, 1.0F);
			}

			if (f >= 0.5F && loadingSound != null && !this.midLoadSoundPlayed) {
				this.midLoadSoundPlayed = true;
				level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), loadingSound, SoundSource.PLAYERS, 0.5F, 1.0F);
			}
		}
	}

	@Override
	public int getUseDuration(ItemStack itemStack) {
		return getChargeDuration(itemStack) + 3;
	}

	public static int getChargeDuration(ItemStack itemStack) {
		int quickChargeLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.QUICK_CHARGE, itemStack);

		return quickChargeLevel == 0
				? 25
				: 25 - 5 * quickChargeLevel;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemStack) {
		return UseAnim.BOW;
	}

	private SoundEvent getStartSound(int quickChargeLevel) {
		return switch (quickChargeLevel) {
			case 1 -> SoundEvents.CROSSBOW_QUICK_CHARGE_1;
			case 2 -> SoundEvents.CROSSBOW_QUICK_CHARGE_2;
			case 3 -> SoundEvents.CROSSBOW_QUICK_CHARGE_3;
			default -> SoundEvents.CROSSBOW_LOADING_START;
		};
	}

	private static float getPowerForTime(int useDuration, ItemStack itemStack) {
		float f = (float) useDuration / (float) getChargeDuration(itemStack);

		if (f > 1.0F) {
			f = 1.0F;
		}
		return f;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
		List<ItemStack> chargedProjectiles = getChargedProjectiles(itemStack);

		if (isCharged(itemStack) && !chargedProjectiles.isEmpty()) {
			ItemStack projectile = chargedProjectiles.get(0);
			components.add((new TranslatableComponent("item.minecraft.crossbow.projectile")).append(" ").append(projectile.getDisplayName()));

			if (tooltipFlag.isAdvanced() && projectile.is(Items.FIREWORK_ROCKET)) {
				List<Component> list = Lists.newArrayList();
				Items.FIREWORK_ROCKET.appendHoverText(projectile, level, list, tooltipFlag);

				if (!list.isEmpty()) {
					for(int i = 0; i < list.size(); ++i) {
						list.set(i, (new TextComponent("  ")).append(list.get(i)).withStyle(ChatFormatting.GRAY));
					}
					components.addAll(list);
				}
			}
		}
	}

	@Override
	public boolean useOnRelease(ItemStack itemStack) {
		return itemStack.is(this);
	}

	@Override
	public int getDefaultProjectileRange() {
		return 8;
	}
}