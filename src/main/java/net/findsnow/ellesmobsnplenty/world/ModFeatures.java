package net.findsnow.ellesmobsnplenty.world;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.world.features.ModFallenLuciFeature;
import net.findsnow.ellesmobsnplenty.world.features.ModFallenLuciFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModFeatures {
  public static final RegistryKey<Feature<?>> FEATURES = RegistryKey.of(RegistryKeys.FEATURE, new Identifier(EllesMobsNPlenty.MOD_ID));


  private static <C extends FeatureConfig, F extends Feature<C>> F registerFeature(String name, F feature) {
    return Registry.register(Registries.FEATURE, new Identifier(EllesMobsNPlenty.MOD_ID), feature);
  }

  public static void register() {}
}
