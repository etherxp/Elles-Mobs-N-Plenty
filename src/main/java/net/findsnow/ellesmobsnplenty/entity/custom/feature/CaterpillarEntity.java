package net.findsnow.ellesmobsnplenty.entity.custom.feature;

import com.mojang.datafixers.kinds.IdF;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CaterpillarEntity extends AnimalEntity {
  public final AnimationState idleAnimationState = new AnimationState();
  private int idleAnimationTimeout = 0;
  public int chrysalisTime = this.random.nextInt(3000) + 2000;

  public CaterpillarEntity(EntityType<? extends AnimalEntity> entityType, World world) {
    super(entityType, world);
    this.experiencePoints = 2;
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

  @Override
  public boolean isClimbing() {
    BlockPos caterpillarPos = this.getBlockPos();
    BlockState blockState = this.getWorld().getBlockState(caterpillarPos);
    Block block = blockState.getBlock();

    if (block == Blocks.OAK_LOG || block == Blocks.BIRCH_LOG || block == Blocks.SPRUCE_LOG ||
            block == Blocks.JUNGLE_LOG || block == Blocks.ACACIA_LOG || block == Blocks.DARK_OAK_LOG
            || block == ModBlocks.LUCI_LOG) {
      return true;
    }

    return super.isClimbing();
  }

  protected void initCustomGoals() {
    this.goalSelector.add(1, new SwimGoal(this));
    this.goalSelector.add(2, new TemptGoal(this, 0.3, Ingredient.fromTag(ItemTags.FLOWERS), false));
    this.goalSelector.add(3, new LookAroundGoal(this));
    this.goalSelector.add(2, new WanderAroundGoal(this, 0.3));
  }

  public static DefaultAttributeContainer.Builder createCaterpillarAttributes() {
    return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10);
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
    if (!this.getWorld().isClient && this.isAlive() && --this.chrysalisTime <= 0) {
      World world = this.getWorld();
      BlockPos blockPos = this.findNearestLog();
      if (blockPos != null) {
        this.playSound(SoundEvents.ENTITY_TURTLE_EGG_CRACK, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
        this.emitGameEvent(GameEvent.BLOCK_PLACE);
        BlockState blockState = ModBlocks.CHRYSALIS_BLOCK.getDefaultState();
        world.setBlockState(blockPos, blockState, Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, blockState));
        this.discard();
      } else {
        this.playSound(SoundEvents.ENTITY_TURTLE_EGG_CRACK, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
        this.emitGameEvent(GameEvent.BLOCK_PLACE);
        BlockPos blockPos2 = this.getBlockPos();
        BlockState blockState = ModBlocks.CHRYSALIS_BLOCK.getDefaultState();
        world.setBlockState(blockPos2, blockState, Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos2, GameEvent.Emitter.of(this, blockState));
        this.discard();
      }
    }
    super.tick();
    if (this.getWorld().isClient()) {
      this.setupAnimationStates();
    }
  }

  @Nullable
  @Override
  public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
    return null;
  }

  protected void updateLimbs(float v) {
    float f;
    if (this.getPose() == EntityPose.STANDING) {
      f = Math.min(v * 6.0F, 1.0F);
    } else {
      f = 0.0F;
    }
    this.limbAnimator.updateLimbs(f, 0.2F);
  }

  @Nullable
  @Override
  protected SoundEvent getAmbientSound() {
    return SoundEvents.ENTITY_COD_AMBIENT;
  }

  @Nullable
  @Override
  protected SoundEvent getHurtSound(DamageSource source) {
    return SoundEvents.ENTITY_COD_HURT;
  }


  private BlockPos findNearestLog() {
    BlockPos caterpillarPos = this.getBlockPos();
    int searchRadius = 7;
    for (int x = -searchRadius; x <= searchRadius; x++) {
      for (int y = -searchRadius; y <= searchRadius; y++) {
        for (int z = -searchRadius; z <= searchRadius; z++) {
          BlockPos blockPos = caterpillarPos.add(x, y, z);
          BlockState blockState = this.getWorld().getBlockState(blockPos);
          Block block = blockState.getBlock();

          if (block == Blocks.OAK_LOG || block == Blocks.BIRCH_LOG || block == Blocks.SPRUCE_LOG ||
                  block == Blocks.JUNGLE_LOG || block == Blocks.ACACIA_LOG || block == Blocks.DARK_OAK_LOG
          || block == ModBlocks.LUCI_LOG) {
            return blockPos;
          }
        }
      }
    }
    return null;
  }
}
