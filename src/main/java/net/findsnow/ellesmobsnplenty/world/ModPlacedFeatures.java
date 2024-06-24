package net.findsnow.ellesmobsnplenty.world;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
  public static final RegistryKey<PlacedFeature> LUCERO_PLACED_KEY = registerKey("lucero_placed");
  public static final RegistryKey<PlacedFeature> NEPHRITE_ORE_PLACED_KEY = registerKey("nephrite_placed");
  public static final RegistryKey<PlacedFeature> FROSTITE_ORE_PLACED_KEY = registerKey("frostite_placed");
  public static final RegistryKey<PlacedFeature> BLOSSOMING_LUCI_KEY = registerKey("blossoming_luci_placed");
  public static final RegistryKey<PlacedFeature> LUCI_PETAL_PLACED_KEY = registerKey("luci_petal_placed");
  public static final RegistryKey<PlacedFeature> FLAURELLE_PLACED_KEY = registerKey("flaurelle_placed");
  public static final RegistryKey<PlacedFeature> LUCI_LEAF_PILE_PLACED_KEY = registerKey("luci_pile_placed");
  public static final RegistryKey<PlacedFeature> LUCI_MUSHROOM_PLACED_KEY = registerKey("luci_mushroom_placed");
  public static final RegistryKey<PlacedFeature> CLOVER_PLACED_KEY = registerKey("clover_placed");
  public static final RegistryKey<PlacedFeature> TALL_CLOVER_PLACED_KEY = registerKey("tall_clover_placed");

  public static void bootstrap(Registerable<PlacedFeature> context) {
    var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

    register(context, LUCERO_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUCERO_KEY),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), ModBlocks.LUCI_SAPLING));

    register(context, BLOSSOMING_LUCI_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLOSSOMING_LUCI_KEY),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(1, 0.5f, 1), ModBlocks.BLOSSOMING_LUCI_SAPLING));

    register(context, LUCI_PETAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUCI_PETALS),
            RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    register(context, LUCI_LEAF_PILE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUCI_LEAF_PILE),
            RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    register(context, FLAURELLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLAURELLE),
            RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    register(context, LUCI_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUCI_MUSHROOM),
            RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    register(context, CLOVER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CLOVER),
            RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    register(context, TALL_CLOVER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TALL_CLOVER),
            RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    register(context, NEPHRITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NEPHRITE_ORE_KEY),
            ModOrePlacement.modifiersWithCount(6, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    register(context, FROSTITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FROSTITE_ORE_KEY),
            ModOrePlacement.modifiersWithCount(6, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
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
