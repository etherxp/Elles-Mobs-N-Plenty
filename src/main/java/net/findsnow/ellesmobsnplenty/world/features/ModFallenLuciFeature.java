package net.findsnow.ellesmobsnplenty.world.features;

import com.mojang.serialization.Codec;
import net.findsnow.ellesmobsnplenty.block.hollow.HollowLuciLogBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import static net.minecraft.command.argument.BlockStateArgumentType.blockState;

public class ModFallenLuciFeature extends Feature<ModFallenLuciFeatureConfig> {
  public static BlockState MOSS = Blocks.MOSS_CARPET.getDefaultState();

  public ModFallenLuciFeature(Codec<ModFallenLuciFeatureConfig> codec) {
    super(codec);
  }

  @Override
  public boolean generate(FeatureContext<ModFallenLuciFeatureConfig> context) {
    BlockPos blockPos = context.getOrigin();
    StructureWorldAccess structureWorldAccess = context.getWorld();
    Random random = context.getRandom();
    ModFallenLuciFeatureConfig modFallenLuciFeatureConfig = context.getConfig();
    BlockState blockState = modFallenLuciFeatureConfig.stateProvider.get(random, blockPos);
    int size = random.nextInt(3) + 4;
    Direction.Axis axis = Direction.Axis.pickRandomAxis(random);
    if (blockState.getProperties().add(Properties.AXIS)) {
      blockState = blockState.with(HollowLuciLogBlock.AXIS, axis);
    }
    boolean validSpot = true;
    for (int i = 0; i < size; ++i) {
      BlockPos cur = blockPos.offset(axis, i);
      validSpot = validSpot && structureWorldAccess.isAir(cur) && structureWorldAccess.getBlockState(cur.down()).isIn(BlockTags.DIRT);
    }
    if (validSpot) {
      for (int i = 0; i < size; i++) {
        BlockPos cur = blockPos.offset(axis, i);
        BlockPos above = cur.up();
        boolean mossy = random.nextFloat() > .33 && structureWorldAccess.isAir(above);
        structureWorldAccess.setBlockState(cur, blockState.with(HollowLuciLogBlock.COVER,
                mossy ? HollowLuciLogBlock.Cover.MOSSY : HollowLuciLogBlock.Cover.NONE), 4);
        if (mossy) {
          structureWorldAccess.setBlockState(above, MOSS, 4);
        }
      }
    }
    return validSpot;
  }
}
