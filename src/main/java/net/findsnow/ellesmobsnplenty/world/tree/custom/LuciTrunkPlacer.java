package net.findsnow.ellesmobsnplenty.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.findsnow.ellesmobsnplenty.block.hollow.HollowLuciLogBlock;
import net.findsnow.ellesmobsnplenty.world.features.ModFallenLuciFeatureConfig;
import net.findsnow.ellesmobsnplenty.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class LuciTrunkPlacer extends TrunkPlacer {
  public static final Codec<LuciTrunkPlacer> CODEC = RecordCodecBuilder.create(luciTrunkPlacerInstance ->
          fillTrunkPlacerFields(luciTrunkPlacerInstance).apply(luciTrunkPlacerInstance, LuciTrunkPlacer::new));


  public LuciTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
    super(baseHeight, firstRandomHeight, secondRandomHeight);
  }

  @Override
  protected TrunkPlacerType<?> getType() {
    return ModTrunkPlacerTypes.FALLEN_LUCI_TRUNK_PLACER;
  }

  @Override
  public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
    int trunkLength = random.nextInt(3) + 3;

    for (int i = 0; i < trunkLength; i++) {
      setToDirt(world, replacer, random, startPos.offset(Direction.EAST, i), config);
      setToDirt(world, replacer, random, startPos.offset(Direction.WEST, i), config);
      setToDirt(world, replacer, random, startPos.offset(Direction.NORTH, i), config);
      setToDirt(world, replacer, random, startPos.offset(Direction.SOUTH, i), config);

      if (i == 0) {
        getAndSetState(world, replacer, random, startPos, config);
      } else if (i == trunkLength - 1) {
        getAndSetState(world, replacer, random, startPos.up(i), config);
      }
    }

    return List.of();
  }
}
