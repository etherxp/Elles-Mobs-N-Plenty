package net.findsnow.ellesmobsnplenty.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.util.ModBiomeTags;
import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.BiomeKeys;

import java.util.Random;

public class ModEntitySpawns {

  public static void addSpawns() {
    BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.LUCI_REGION_1),
            SpawnGroup.CREATURE, ModEntities.BUTTERFLY, 80, 5, 8);
    SpawnRestriction.register(ModEntities.BUTTERFLY, SpawnRestriction.Location.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
  }
}
