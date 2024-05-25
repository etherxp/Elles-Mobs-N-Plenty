package net.findsnow.ellesmobsnplenty.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
  public static final DefaultParticleType FALLING_LEAVES_PARTICLE =
          registerParticle("falling_leaves_particle", FabricParticleTypes.simple());

  public static final DefaultParticleType FIREFLY =
          registerParticle("firefly", FabricParticleTypes.simple());

  public static void RegisterFirefly() {
    registerParticle("firefly", FIREFLY);
  }

  private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
    return Registry.register(Registries.PARTICLE_TYPE, new Identifier(EllesMobsNPlenty.MOD_ID, name), particleType);
  }

  public static void RegisterParticles() {
    EllesMobsNPlenty.LOGGER.info("Registering particles for " + EllesMobsNPlenty.MOD_ID);
  }
}
