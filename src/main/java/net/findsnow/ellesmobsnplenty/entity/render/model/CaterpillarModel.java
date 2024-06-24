package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.ButterflyEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CaterpillarEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class CaterpillarModel <T extends CaterpillarEntity> extends SinglePartEntityModel<T> {
  private final ModelPart caterpillar;

  public CaterpillarModel(ModelPart root) {
    this.caterpillar = root.getChild("caterpillar");
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData caterpillar = modelPartData.addChild("caterpillar", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

    ModelPartData body = caterpillar.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData bone = body.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -0.5F));

    ModelPartData front_body = bone.addChild("front_body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -6.75F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 2.25F));

    ModelPartData ears = front_body.addChild("ears", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.7071F, -5.0F));

    ModelPartData left_ear = ears.addChild("left_ear", ModelPartBuilder.create(), ModelTransform.pivot(-0.9571F, -0.25F, -1.25F));

    ModelPartData cube_r1 = left_ear.addChild("cube_r1", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.0429F, -0.0429F, 0.0F, 0.0F, 0.0F, -0.7854F));

    ModelPartData right_ear = ears.addChild("right_ear", ModelPartBuilder.create(), ModelTransform.pivot(0.9571F, -0.25F, -1.25F));

    ModelPartData cube_r2 = right_ear.addChild("cube_r2", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0429F, -0.0429F, 0.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData back_body = bone.addChild("back_body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 2.5F));
    return TexturedModelData.of(modelData, 32, 32);
  }

  @Override
  public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);

    this.updateAnimation(entity.idleAnimationState, ModAnimations.caterpillar_idle, ageInTicks, 1f);
    this.animateMovement(ModAnimations.caterpillar_walk, limbSwing, limbSwingAmount, 8f, 100f);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
    caterpillar.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }

  @Override
  public ModelPart getPart() {
    return caterpillar;
  }
}