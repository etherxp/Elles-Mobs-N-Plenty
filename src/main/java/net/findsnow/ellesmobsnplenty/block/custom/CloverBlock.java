package net.findsnow.ellesmobsnplenty.block.custom;

import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class CloverBlock extends PlantBlock {
  public static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 2, 16);
  public CloverBlock(Settings settings) {
    super(settings);
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }

  protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
    return floor.isFullCube(world, pos);
  }

  @Override
  public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    BlockPos blockPos = pos.down();
    return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
  }
}
