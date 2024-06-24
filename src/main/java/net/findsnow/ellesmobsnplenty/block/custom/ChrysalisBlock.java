package net.findsnow.ellesmobsnplenty.block.custom;

import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SnifferEggBlock;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

public class ChrysalisBlock extends Block {
  public static final IntProperty HATCH = Properties.HATCH;
  private static final int HATCHING_TIME = 1000;
  private static final int BOOSTED_HATCHING_TIME = 500;
  private static final int MAX_RANDOM_CRACK_TIME_OFFSET = 150;
  public static final VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 9, 11);

  public ChrysalisBlock(Settings settings) {
    super(settings);
    this.setDefaultState(this.stateManager.getDefaultState().with(HATCH, 0));
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(HATCH);
  }

  public int getHatchStage(BlockState state) {
    return state.get(HATCH);
  }

  private boolean isReadyToHatch(BlockState state) {
    return this.getHatchStage(state) == 2;
  }
  @Override
  public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    if (!this.isReadyToHatch(state)) {
      world.playSound(null, pos, SoundEvents.BLOCK_SNIFFER_EGG_CRACK, SoundCategory.BLOCKS, 0.7f, 0.9f + random.nextFloat() * 0.2f);
      world.setBlockState(pos, (BlockState) state.with(HATCH, this.getHatchStage(state) + 1), Block.NOTIFY_LISTENERS);
      return;
    }
    world.playSound(null, pos, SoundEvents.BLOCK_SNIFFER_EGG_HATCH, SoundCategory.BLOCKS, 0.7f, 0.9f + random.nextFloat() * 0.2f);
    world.breakBlock(pos, false);
    ModEntities.BUTTERFLY.spawn(world, pos, SpawnReason.MOB_SUMMONED);
  }

  @Override
  public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
    boolean bl = ChrysalisBlock.isAboveHatchBooster(world, pos);
    if (!world.isClient() && bl) {
      world.syncWorldEvent(WorldEvents.SNIFFER_EGG_CRACKS, pos, 0);
    }
    int i = bl ? 12000 : 24000;
    int j = i / 3;
    world.emitGameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Emitter.of(state));
    world.scheduleBlockTick(pos, this, j + world.random.nextInt(300));
  }

  @Override
  public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
    return false;
  }

  public static boolean isAboveHatchBooster(BlockView world, BlockPos pos) {
    return world.getBlockState(pos.down()).isIn(BlockTags.LOGS) || world.getBlockState(pos.down()).isIn(BlockTags.LEAVES);
  }
}
