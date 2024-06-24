package net.findsnow.ellesmobsnplenty.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.ButterflyEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CaterpillarEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.TurtleEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
  public static final EntityType<CrabEntity> CRAB = Registry.register(Registries.ENTITY_TYPE,
          new Identifier(EllesMobsNPlenty.MOD_ID, "crab"),
          FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrabEntity::new)
                  .dimensions(EntityDimensions.fixed(0.40f, 0.40f)).build());

  public static final EntityType<TurtleEntity> TURTLE = Registry.register(Registries.ENTITY_TYPE,
          new Identifier(EllesMobsNPlenty.MOD_ID, "turtle"),
          FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TurtleEntity::new)
                  .dimensions(EntityDimensions.fixed(0.40f, 0.40f)).build());

  public static final EntityType<ButterflyEntity> BUTTERFLY = Registry.register(Registries.ENTITY_TYPE,
          new Identifier(EllesMobsNPlenty.MOD_ID, "butterfly"),
          FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ButterflyEntity::new)
                  .dimensions(EntityDimensions.fixed(0.40f, 0.40f)).build());

  public static final EntityType<CaterpillarEntity> CATERPILLAR = Registry.register(Registries.ENTITY_TYPE,
          new Identifier(EllesMobsNPlenty.MOD_ID, "caterpillar"),
          FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CaterpillarEntity::new)
                  .dimensions(EntityDimensions.fixed(0.40f, 0.40f)).build());

  public static void registerModEntities() {
    EllesMobsNPlenty.LOGGER.info("Registering Entities for " + EllesMobsNPlenty.MOD_ID);
  }
}
