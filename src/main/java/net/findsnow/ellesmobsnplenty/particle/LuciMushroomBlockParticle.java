package net.findsnow.ellesmobsnplenty.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.SimplexNoiseSampler;

import java.util.concurrent.ThreadLocalRandom;

public class LuciMushroomBlockParticle extends SpriteBillboardParticle {
  private SpriteProvider spriteProvider;
  private int directionChangeTimer;  private static final int minOffTime = 20 * 2;
  private static final int maxOffTime = 20 * 4;
  private static final int minOnTime = 10;
  private static final int maxOnTime = 20;

  private final SimplexNoiseSampler noise;
  private int ageOffset = 0;
  private int ticksUntilNextSwitch = 40;
  private boolean isOn = false;

  public LuciMushroomBlockParticle(ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
    super(clientWorld, x, y, z);
    this.setSprite(spriteProvider);

    this.gravityStrength = 0;
    this.velocityX = 0;
    this.velocityY = 0;
    this.velocityZ = 0;

    this.alpha = 0;
    this.red = 187f / 255f;
    this.green = 1f;
    this.blue = 107f / 255f;

    if (world.getRandom().nextInt(10) == 1) {
      this.red = 107f / 255f;
      this.green = 250f / 255f;
      this.blue = 1f;

      if (world.getRandom().nextInt(10) == 1) {
        this.red = 1f;
        this.green = 124f / 255f;
        this.blue = 107f / 255f;
      }
    }

    this.maxAge = 200;
    this.scale = 0.25f;

    this.noise = new SimplexNoiseSampler(random);
  }

  @Override
  public ParticleTextureSheet getType() {
    return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
  }

  @Override
  public float getSize(float tickDelta) {
    float ageFraction = ((float)this.age + tickDelta) / (float)this.maxAge;
    return this.scale * (1.0f - ageFraction * ageFraction * 0.5f);
  }

  @Override
  public void tick() {
    super.tick();

    if (this.onGround) {
      this.ageOffset += 5;
    }

    if (--this.ticksUntilNextSwitch <= 0) {
      if (this.isOn) {
        this.isOn = false;
        this.ticksUntilNextSwitch = this.random.nextBetween(minOffTime, maxOffTime);
      } else {
        this.isOn = true;
        this.ticksUntilNextSwitch = this.random.nextBetween(minOnTime, maxOnTime);
      }
    }

    this.alpha = this.isOn && (this.maxAge - this.age) > 3 ? Math.min(1, this.alpha + 0.33f) : Math.max(0, this.alpha - 0.33f);

    float speedFactor = 0.05f;
    float noiseFactor = 0.001f;
    this.velocityX = this.noise.sample(this.age * noiseFactor, this.age * noiseFactor) * speedFactor;
    this.velocityY = this.noise.sample((this.age + this.ageOffset) * noiseFactor - 50f, (this.age + this.ageOffset) * noiseFactor + 100f) * speedFactor * 0.5f;
    this.velocityZ = this.noise.sample(this.age * noiseFactor + 100f, this.age * noiseFactor - 50f) * speedFactor;

    speedFactor = 0.1f + (float)Math.sin(Math.PI + this.age / 30f) * 0.2f;
    noiseFactor = 0.033f;
    this.velocityX += this.noise.sample(this.age * noiseFactor, this.age * noiseFactor) * speedFactor * 0.5f;
    this.velocityY += this.noise.sample((this.age + this.ageOffset) * noiseFactor - 50f, (this.age + this.ageOffset) * noiseFactor + 100f) * speedFactor;
    this.velocityZ += this.noise.sample(this.age * noiseFactor + 100f, this.age * noiseFactor - 50f) * speedFactor * 0.5f;
  }

  @Override
  public int getBrightness(float tint) {
    float ageFraction = ((float)this.age + tint) / (float)this.maxAge;
    ageFraction = MathHelper.clamp(ageFraction, 0.0f, 1.0f);
    int baseBrightness = super.getBrightness(tint);
    int j = baseBrightness & 0xFF;
    int k = baseBrightness >> 16 & 0xFF;
    if ((j += (int)(ageFraction * 15.0f * 16.0f)) > 240) {
      j = 240;
    }
    return j | k << 16;
  }

  @Environment(value= EnvType.CLIENT)
  public static class Factory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;

    public Factory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }

    @Override
    public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z,
                                   double velocityX, double velocityY, double velocityZ) {
      LuciMushroomBlockParticle luciMushroomBlockParticle = new LuciMushroomBlockParticle
              (clientWorld, x, y, z, velocityX, velocityY, velocityZ, spriteProvider);
      luciMushroomBlockParticle.setSprite(this.spriteProvider);
      return luciMushroomBlockParticle;
    }
  }
}