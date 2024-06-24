package net.findsnow.ellesmobsnplenty.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModFallenLuciFeatureConfig implements FeatureConfig {
  
  public static final Codec<ModFallenLuciFeatureConfig> CODEC = RecordCodecBuilder.create(
          instance -> instance.group(
                  BlockStateProvider.TYPE_CODEC.fieldOf("state_provider").forGetter
                          (modFallenLuciFeatureConfig -> modFallenLuciFeatureConfig.stateProvider)).apply(instance, stateProvider1 -> new ModFallenLuciFeatureConfig()));
  public BlockStateProvider stateProvider = null;
  
  public ModFallenLuciFeatureConfig() {
    this.stateProvider = stateProvider;
  }
}
