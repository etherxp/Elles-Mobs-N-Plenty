package net.findsnow.ellesmobsnplenty.world;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

  public static final RegistryKey<PlacedFeature> LUCERO_PLACED_KEY = registerKey("lucero_placed");

  public static void bootstrap(Registerable<PlacedFeature> context) {
    var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    register(context, LUCERO_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUCERO_KEY),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.5f, 4), ModBlocks.LUCERO_SAPLING));
  }


  public static RegistryKey<PlacedFeature> registerKey(String name) {
    return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(EllesMobsNPlenty.MOD_ID, name));
  }

  private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                               List<PlacementModifier> modifiers) {
    context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
  }

  private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                 PlacementModifier... modifiers) {
    register(context, key, configuration, List.of(modifiers));
  }
}
