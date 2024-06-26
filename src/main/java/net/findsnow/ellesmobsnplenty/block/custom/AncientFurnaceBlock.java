package net.findsnow.ellesmobsnplenty.block.custom;

import net.findsnow.ellesmobsnplenty.block.entity.AncientFurnaceBlockEntity;
import net.findsnow.ellesmobsnplenty.block.entity.ModBlockEntities;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AncientFurnaceBlock extends AbstractFurnaceBlock {
  public AncientFurnaceBlock(Settings settings) {
    super(settings);
  }

  @Override
  protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
    BlockEntity blockEntity = world.getBlockEntity(pos);
    if (blockEntity instanceof AncientFurnaceBlockEntity) {
      player.openHandledScreen(((NamedScreenHandlerFactory) blockEntity));
      player.incrementStat(Stats.INTERACT_WITH_FURNACE);
    }
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new AncientFurnaceBlockEntity(pos, state);
  }

  @Nullable
  @Override
  public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    return checkType(world, type, ModBlockEntities.ANCIENT_FURNACE_BE);
  }

  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    if (!state.get(LIT).booleanValue()) {
      return;
    }
    double d = (double)pos.getX() + 0.5;
    double e = pos.getY();
    double f = (double)pos.getZ() + 0.5;
    if (random.nextDouble() < 0.1) {
      world.playSound(d, e, f, SoundEvents.BLOCK_BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
    }
    Direction direction = state.get(FACING);
    Direction.Axis axis = direction.getAxis();
    double g = 0.52;
    double h = random.nextDouble() * 0.6 - 0.3;
    double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : h;
    double j = random.nextDouble() * 9.0 / 16.0;
    double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : h;
    world.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
  }
}
