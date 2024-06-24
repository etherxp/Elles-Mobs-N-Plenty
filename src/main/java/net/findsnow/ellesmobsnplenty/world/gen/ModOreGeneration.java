package net.findsnow.ellesmobsnplenty.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.findsnow.ellesmobsnplenty.world.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
  public static void generateOres() {
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NEPHRITE_ORE_PLACED_KEY);
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.FROSTITE_ORE_PLACED_KEY);
  }
}
