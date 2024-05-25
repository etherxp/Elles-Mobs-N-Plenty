package net.findsnow.ellesmobsnplenty.block.signs;

import net.findsnow.ellesmobsnplenty.block.entity.ModSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModWallHangingSignBlock extends WallHangingSignBlock {
  public ModWallHangingSignBlock(Settings settings, WoodType woodType) {
    super(settings, woodType);
  }

  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new ModSignBlockEntity(pos, state);
  }
}
