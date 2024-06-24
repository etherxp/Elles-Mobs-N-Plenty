package net.findsnow.ellesmobsnplenty.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.findsnow.ellesmobsnplenty.world.ModPlacedFeatures;
import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {
  public static void generateFlowers() {
    // Luci Biomes
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LUCI_REGION_1),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUCI_MUSHROOM_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LUCI_REGION_1),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CLOVER_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LUCI_REGION_1),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TALL_CLOVER_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.LUCI_REGION_1),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUCI_LEAF_PILE_PLACED_KEY);


    // Plains
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.MEADOW),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FLAURELLE_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CLOVER_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST),
            GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TALL_CLOVER_PLACED_KEY);
  }
}
