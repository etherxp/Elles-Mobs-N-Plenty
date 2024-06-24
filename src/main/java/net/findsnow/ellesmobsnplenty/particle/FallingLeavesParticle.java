package net.findsnow.ellesmobsnplenty.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.FluidState;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

@Environment(value= EnvType.CLIENT)
public class FallingLeavesParticle
        extends SpriteBillboardParticle { ;
  private float field_43369;
  private final float field_43370;
  private final float field_43371;
  public boolean stuckInGround = false;
  public boolean inWater = false;
  protected final float windCoefficient;
  public static final double WATER_FRICTION = 0.075;
  public static final int FADE_DURATION = 7;

  protected FallingLeavesParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider) {
    super(world, x, y, z);
    float f;
    this.setSprite(spriteProvider.getSprite(this.random.nextInt(12), 12));
    this.field_43369 = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
    this.field_43370 = this.random.nextFloat();
    this.field_43371 = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
    this.maxAge = 300;
    this.gravityStrength = 7.5E-4f;
    this.scale = f = this.random.nextBoolean() ? 0.10f : 0.095f;
    this.setBoundingBoxSpacing(f, f);
    this.velocityMultiplier = 1.0f;
    this.windCoefficient = 0.6f + random.nextFloat() * 0.4f;
  }


  @Override
  public ParticleTextureSheet getType() {
    return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
  }

  @Override
  public void tick() {
    this.prevPosX = this.x;
    this.prevPosY = this.y;
    this.prevPosZ = this.z;
    age++;
    if (age >= maxAge + 1 - FADE_DURATION) {
      alpha -= 1F / FADE_DURATION;
    }

    if (age >= maxAge) {
      markDead();
      return;
    }
    if (this.dead) {
      return;
    }

    BlockPos blockPos = BlockPos.ofFloored(x, y, z);
    FluidState fluidState = world.getFluidState(blockPos);
    if (fluidState.isIn(FluidTags.LAVA)) {
      double waterY = blockPos.getY() + fluidState.getHeight(world, blockPos);
      if (waterY >= y) {
        world.addParticle(ParticleTypes.LAVA, x, y, z, 0.0, 0.0, 0.0);
        markDead();
        return;
      }
    }

    float f = 300 - this.maxAge;
    float g = Math.min(f / 300.0f, 1.0f);
    double d = Math.cos(Math.toRadians(this.field_43370 * 60.0f)) * 2.0 * Math.pow(g, 1.25);
    double e = Math.sin(Math.toRadians(this.field_43370 * 60.0f)) * 2.0 * Math.pow(g, 1.25);
    this.velocityX += d * (double)0.0025f;
    this.velocityZ += e * (double)0.0025f;
    this.velocityY -= this.gravityStrength;
    this.field_43369 += this.field_43371 / 20.0f;
    this.prevAngle = this.angle;
    this.angle += this.field_43369 / 20.0f;

    // Stop moving when the particle hits the ground or lands in water
    if (onGround || fluidState.isIn(FluidTags.WATER)) {
      velocityX = 0.0;
      velocityY = 0.0;
      velocityZ = 0.0;
      angle = prevAngle;
      return;
    }

    this.move(this.velocityX, this.velocityY, this.velocityZ);
    if (onGround && Math.abs(velocityY) < 1E-5) {
      stuckInGround = true;
      markDead();
    }if (fluidState.isIn(FluidTags.WATER)) {
      double waterY;
      if ((waterY = blockPos.getY() + fluidState.getHeight(world, blockPos)) >= y - 0.1) {
        if (!inWater) {
          inWater = true;
          if (Math.abs(waterY - y) < 0.2)
            y = waterY;
          velocityY *= 0.1;
          velocityX *= 0.5;
          velocityZ *= 0.5;
        } else {
          double depth = Math.max(waterY + 0.1 - y, 0);
          velocityY += depth * windCoefficient / 30.0f;
        }
        if (!fluidState.isStill()) {
          Vec3d pushVel = fluidState.getVelocity(world, blockPos).multiply(0.4);
          velocityX += (pushVel.x - velocityX) * windCoefficient / 60.0f;
          velocityZ += (pushVel.z - velocityZ) * windCoefficient / 60.0f;
        }
        velocityX *= (1 - WATER_FRICTION);
        velocityY *= (1 - WATER_FRICTION);
        velocityZ *= (1 - WATER_FRICTION);
      }
    } else {
      inWater = false;
    }
    if (this.dead) {
      return;
    }
    this.velocityX *= this.velocityMultiplier;
    this.velocityY *= this.velocityMultiplier;
    this.velocityZ *= this.velocityMultiplier;
    move(velocityX, velocityY, velocityZ);
  }

  @Override
  public void move(double dx, double dy, double dz) {
    if (stuckInGround) {
      velocityX = 0.0;
      velocityY = 0.0;
      velocityZ = 0.0;
      angle = prevAngle;
      return;
    }
    if (inWater) {
      velocityX *= 0.8;
      velocityY *= 0.8;
      velocityZ *= 0.8;
      return;
    }
    super.move(dx, dy, dz);
  }

  public static class Factory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;
    public Factory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }
    public Particle createParticle(DefaultParticleType type, ClientWorld clientWorld,
                                   double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
      return new FallingLeavesParticle(clientWorld, x, y, z, this.spriteProvider);
    }
  }
}
