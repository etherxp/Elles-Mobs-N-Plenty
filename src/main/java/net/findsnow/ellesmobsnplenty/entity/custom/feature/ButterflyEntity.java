package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class ButterflyEntity extends AnimalEntity implements Flutterer {
  public final AnimationState butterflyAnimationState = new AnimationState();
  public final AnimationState idleAnimationState = new AnimationState();
  private int idleAnimationTimeout = 0;

  public ButterflyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
    super(entityType, world);
    this.experiencePoints = 2;
    this.moveControl = new FlightMoveControl(this, 15, true);
    this.lookControl = new ButterflyLookControl(this);
    this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0F);
    this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 15.0F);
    this.setPathfindingPenalty(PathNodeType.FENCE, -1.0F);
    this.setPathfindingPenalty(PathNodeType.COCOA, -1.0F);
    this.setPathfindingPenalty(PathNodeType.LAVA, -1.0F);
  }

  @Override
  protected void initGoals() {
    this.initCustomGoals();
  }

  protected void initCustomGoals() {
    this.goalSelector.add(1, new AnimalMateGoal(this, 1.0));
    this.goalSelector.add(2, new TemptGoal(this, 1.2, Ingredient.fromTag(ItemTags.FLOWERS), false));
    this.goalSelector.add(3, new ButterflyWanderGoal());
    this.goalSelector.add(3, new LookAroundGoal(this));
  }

  public static DefaultAttributeContainer.Builder createButterflyAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.26f)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 13)
            .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.7f);
  }

  @Override
  public float getPathfindingFavor(BlockPos pos, WorldView worldView) {
    if (worldView.getBlockState(pos).isAir()) {
      return 10.0f;
    }
    return 0.0f;
  }

  @Override
  public boolean isBreedingItem(ItemStack stack) {
    return stack.isIn(ItemTags.FLOWERS);
  }

  private void setupAnimationStates() {
    if (this.idleAnimationTimeout <= 0) {
      this.idleAnimationTimeout = this.random.nextInt(40) + 80;
      this.idleAnimationState.start(this.age);
    } else {
      --this.idleAnimationTimeout;
    }
  }

  @Override
  public void tick() {
    super.tick();
    if (this.getWorld().isClient()) {
      this.setupAnimationStates();
    }
    if (this.isTouchingWater()) {
      this.setVelocity(this.getVelocity().add(0.0, 0.01, 0.0));
    }
  }

  @Nullable
  @Override
  public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
    return ModEntities.CATERPILLAR.spawn(world, ButterflyEntity.this.getBlockPos(), SpawnReason.MOB_SUMMONED);
  }

  @Nullable
  @Override
  protected SoundEvent getAmbientSound() {
    return SoundEvents.ENTITY_PARROT_FLY;
  }

  @Nullable
  @Override
  protected SoundEvent getHurtSound(DamageSource source) {
    return SoundEvents.ENTITY_AXOLOTL_HURT;
  }

  @Override
  protected EntityNavigation createNavigation(World world) {
    BirdNavigation birdNavigation = new BirdNavigation(this, world) {

      @Override
      public boolean isValidPosition(BlockPos pos) {
        return !this.world.getBlockState(pos.down()).isAir();
      }

      @Override
      public void tick() {
        super.tick();
      }
    };
    birdNavigation.setCanPathThroughDoors(false);
    birdNavigation.setCanSwim(false);
    birdNavigation.setCanEnterOpenDoors(true);
    return birdNavigation;
  }

  @Override
  public boolean isInAir() {
    return !this.isOnGround();
  }

  @Override
  protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
  }


  // Shoutout to Jaiz for this
  static class ButterflyLookControl extends LookControl {
    ButterflyLookControl(MobEntity mobEntity) {
      super(mobEntity);
    }

    @Override
    public void tick() {
      super.tick();
    }
  }

  class ButterflyWanderGoal extends Goal {
    ButterflyWanderGoal() {
      this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
      return ButterflyEntity.this.navigation.isIdle() && ButterflyEntity.this.random.nextInt(10) == 1;
    }

    @Override
    public boolean shouldContinue() {
      return ButterflyEntity.this.navigation.isFollowingPath();
    }
    @Override
    public void start() {
      Vec3d vec3d = this.getRandomLocation();
      if (vec3d != null) {
        ButterflyEntity.this.navigation.startMovingAlong(ButterflyEntity.this.navigation.findPathTo(BlockPos.ofFloored(vec3d), 1), 1.0);
      }
  }
    @Nullable
    private Vec3d getRandomLocation() {
      Vec3d vec3d2;
      vec3d2 = ButterflyEntity.this.getRotationVec(0.0f);
      int i = 8;
      Vec3d vec3d3 = AboveGroundTargeting.find(ButterflyEntity.this, 4, 14, vec3d2.x, vec3d2.z, 1.5707964f, 3, 1);
      if (vec3d3 != null) {
        return vec3d3;
      }return NoPenaltySolidTargeting.find(ButterflyEntity.this, 4, 8, -2, vec3d2.x, vec3d2.z, 1.5707963705062866);}
  }
}
