/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.entity;

import moriyashiine.anthropophagy.common.entity.ai.goal.*;
import moriyashiine.anthropophagy.common.entity.ai.pathing.BetterMobNavigation;
import moriyashiine.anthropophagy.common.init.ModEntityTypes;
import moriyashiine.anthropophagy.common.init.ModSoundEvents;
import moriyashiine.anthropophagy.common.tag.ModBlockTags;
import moriyashiine.anthropophagy.common.tag.ModEntityTypeTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class PigluttonEntity extends HostileEntity {
	private static final int DAMAGE_THRESHOLD = 20;

	private static final TrackedData<Boolean> EATING = DataTracker.registerData(PigluttonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
	private static final TrackedData<Integer> ATTACK_INDEX = DataTracker.registerData(PigluttonEntity.class, TrackedDataHandlerRegistry.INTEGER);

	public boolean canAttack = false;
	public int overhealAmount = 0, stalkTicks = 0;
	private float damageTaken = 0;
	private int fleeingTicks = 0;

	private int attackTicks = 0, eatingTicks = 0;

	public AnimationState idleAnimationState = new AnimationState();
	public AnimationState attackLeftAnimationState = new AnimationState();
	public AnimationState attackRightAnimationState = new AnimationState();
	public AnimationState attackTusksAnimationState = new AnimationState();
	public AnimationState eatAnimationState = new AnimationState();

	public PigluttonEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
		navigation = new BetterMobNavigation(this, getWorld(), 3);
		experiencePoints = 30;
		setPathfindingPenalty(PathNodeType.LEAVES, 0);
		setPathfindingPenalty(PathNodeType.WATER, -1);
	}

	public static DefaultAttributeContainer.Builder buildAttributes() {
		return HostileEntity.createHostileAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 80)
				.add(EntityAttributes.GENERIC_ARMOR, 14)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 32)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6)
				.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.8)
				.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64)
				.add(EntityAttributes.GENERIC_STEP_HEIGHT, 1);
	}

	public static boolean canSpawn(EntityType<PigluttonEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
		return random.nextInt(8) == 0 && HostileEntity.canSpawnInDark(type, world, spawnReason, pos, random);
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		setEating(nbt.getBoolean("Eating"));
		setAttackIndex(nbt.getInt("AttackIndex"));
		canAttack = nbt.getBoolean("CanAttack");
		damageTaken = nbt.getFloat("DamageTaken");
		overhealAmount = nbt.getInt("OverhealAmount");
		stalkTicks = nbt.getInt("StalkTicks");
		fleeingTicks = nbt.getInt("FleeingTicks");
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putBoolean("Eating", isEating());
		nbt.putInt("AttackIndex", getAttackIndex());
		nbt.putBoolean("CanAttack", canAttack);
		nbt.putFloat("DamageTaken", damageTaken);
		nbt.putInt("OverhealAmount", overhealAmount);
		nbt.putInt("StalkTicks", stalkTicks);
		nbt.putInt("FleeingTicks", fleeingTicks);
	}

	@Override
	protected void initDataTracker(DataTracker.Builder builder) {
		super.initDataTracker(builder);
		builder.add(EATING, false);
		builder.add(ATTACK_INDEX, 0);
	}

	@Override
	protected void initGoals() {
		goalSelector.add(0, new SwimGoal(this));
		goalSelector.add(1, new EatFleshGoal(this));
		goalSelector.add(2, new StalkGoal(this));
		goalSelector.add(2, new FleeGoal(this));
		goalSelector.add(3, new PigluttonMeleeAttackGoal(this, 1, true));
		goalSelector.add(4, new PigluttonWanderAroundFarGoal(this, 1 / 6F));
		goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 16));
		goalSelector.add(5, new LookAroundGoal(this));
		targetSelector.add(0, new RevengeGoal(this));
		targetSelector.add(1, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, false, living -> !isBusy() && living.getType().isIn(ModEntityTypeTags.PIGLUTTON_TARGETS)));
	}

	@Override
	public void tick() {
		super.tick();
		if (getWorld().isClient) {
			idleAnimationState.startIfNotRunning(age);
			int index = getAttackIndex();
			attackLeftAnimationState.setRunning(attackTicks > 0 && index == 0, age);
			attackRightAnimationState.setRunning(attackTicks > 0 && index == 1, age);
			attackTusksAnimationState.setRunning(attackTicks > 0 && index == 2, age);
			eatAnimationState.setRunning(eatingTicks > 0, age);
		}
	}

	@Override
	protected void mobTick() {
		super.mobTick();
		if (fleeingTicks > 0 && --fleeingTicks % 20 == 0) {
			getWorld().playSound(null, getBlockPos(), ModSoundEvents.ENTITY_PIGLUTTON_FLEE, getSoundCategory(), getSoundVolume() * 4, getSoundPitch());
		}
		if (attackTicks > 0 && --attackTicks == 0 && getTarget() != null && distanceTo(getTarget()) < 4.5) {
			tryAttack(getTarget());
		}
		if (eatingTicks > 0) {
			eatingTicks--;
			if (eatingTicks <= 35 && eatingTicks >= 15 && eatingTicks % 5 == 0) {
				EatFleshGoal.playEffects(this, getMainHandStack(), getEyePos().add(getRotationVector().multiply(1.2)));
			}
			if (eatingTicks == 15) {
				EatFleshGoal.heal(this, getMainHandStack(), true);
			}
			if (eatingTicks == 14) {
				getMainHandStack().decrement(1);
			}
			if (eatingTicks == 0) {
				setEating(false);
			}
		}
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		if (!getWorld().isClient && (horizontalCollision || (verticalCollision && !groundCollision)) && getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
			Box box = getBoundingBox().expand(0.2);
			for (BlockPos pos : BlockPos.iterate(MathHelper.floor(box.minX), MathHelper.floor(box.minY), MathHelper.floor(box.minZ), MathHelper.floor(box.maxX), MathHelper.floor(box.maxY), MathHelper.floor(box.maxZ))) {
				BlockState state = getWorld().getBlockState(pos);
				float hardness = state.getHardness(getWorld(), pos);
				if (hardness >= 0 && (hardness < 0.5F || state.isIn(ModBlockTags.PIGLUTTON_BREAKABLE))) {
					getWorld().breakBlock(pos, true);
				}
			}
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.ENTITY_PIGLUTTON_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSoundEvents.ENTITY_PIGLUTTON_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ENTITY_PIGLUTTON_DEATH;
	}

	@Override
	protected Box getAttackBox() {
		return super.getAttackBox().expand(0.25, 0, 0.25);
	}

	@Override
	protected float modifyAppliedDamage(DamageSource source, float amount) {
		float damage = super.modifyAppliedDamage(source, amount);
		damageTaken += damage;
		fleeingTicks = 0;
		if (damageTaken >= DAMAGE_THRESHOLD) {
			damageTaken = 0;
			fleeingTicks = 160;
		}
		return damage;
	}

	@Override
	public boolean cannotDespawn() {
		return true;
	}

	@Override
	public boolean disablesShield() {
		return true;
	}

	@Override
	public void onTrackedDataSet(TrackedData<?> data) {
		super.onTrackedDataSet(data);
		if (data == EATING) {
			if (dataTracker.get(EATING)) {
				eatingTicks = 65;
			} else {
				eatingTicks = 0;
			}
		}
		if (data == ATTACK_INDEX) {
			attackTicks = 10;
		}
	}

	@Override
	public void setPitch(float pitch) {
		if (eatingTicks == 0) {
			super.setPitch(pitch);
		}
	}

	@Override
	public void setYaw(float yaw) {
		if (eatingTicks == 0) {
			super.setYaw(yaw);
		}
	}

	@Override
	public void setBodyYaw(float bodyYaw) {
		if (eatingTicks == 0) {
			super.setBodyYaw(bodyYaw);
		}
	}

	@Override
	public void setHeadYaw(float headYaw) {
		if (eatingTicks == 0) {
			super.setHeadYaw(headYaw);
		}
	}

	public int getAttackIndex() {
		return dataTracker.get(ATTACK_INDEX);
	}

	private void setAttackIndex(int index) {
		dataTracker.set(ATTACK_INDEX, index);
	}

	public boolean isEating() {
		return dataTracker.get(EATING);
	}

	public void setEating(boolean eating) {
		dataTracker.set(EATING, eating);
	}

	public void attack() {
		int index = getAttackIndex();
		index++;
		if (index > 2) {
			index = 0;
		}
		setAttackIndex(index);
	}

	public boolean isFleeing() {
		return fleeingTicks > 0;
	}

	public boolean isBusy() {
		return isFleeing() || eatingTicks > 0;
	}

	public static void attemptSpawn(LivingEntity living, int cannibalLevel, boolean ownFlesh) {
		if (living.getWorld().isClient) {
			return;
		}
		float chance = (Math.min(90, cannibalLevel) - 40) / 800F;
		if (ownFlesh) {
			chance *= 3;
		}
		if (living.getRandom().nextFloat() < chance) {
			PigluttonEntity piglutton = ModEntityTypes.PIGLUTTON.create(living.getWorld());
			if (piglutton != null) {
				final int minH = 16, maxH = 32;
				for (int i = 0; i < 8; i++) {
					int dX = living.getRandom().nextBetween(minH, maxH) * (living.getRandom().nextBoolean() ? 1 : -1);
					int dY = living.getRandom().nextBetween(-6, 6);
					int dZ = living.getRandom().nextBetween(minH, maxH) * (living.getRandom().nextBoolean() ? 1 : -1);
					if (piglutton.teleport(living.getX() + dX, living.getY() + dY, living.getZ() + dZ, false)) {
						living.getWorld().spawnEntity(piglutton);
						piglutton.setTarget(living);
						living.getWorld().playSoundFromEntity(null, piglutton, ModSoundEvents.ENTITY_PIGLUTTON_SPAWN, SoundCategory.HOSTILE, 1, 1);
						return;
					}
				}
			}
		}
	}
}
