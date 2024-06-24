package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.ButterflyEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ButterflyModel <T extends ButterflyEntity> extends SinglePartEntityModel<T> {
  private final ModelPart butterfly;

  public ButterflyModel(ModelPart root) {
    this.butterfly = root.getChild("butterfly");
  }

  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData butterfly = modelPartData.addChild("butterfly", ModelPartBuilder.create(), ModelTransform.of(0.0F, 23.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

    ModelPartData body = butterfly.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

    ModelPartData bone = body.addChild("bone", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData wings = body.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 0.0F, 0.0F));

    ModelPartData left_wing = wings.addChild("left_wing", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, -1.0F, -0.5F));

    ModelPartData cube_r1 = left_wing.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, 0.0F, -3.5F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

    ModelPartData right_wing = wings.addChild("right_wing", ModelPartBuilder.create(), ModelTransform.pivot(6.0F, -1.0F, 0.0F));

    ModelPartData cube_r2 = right_wing.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, 0.0F, -4.0F, 5.0F, 0.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));
    return TexturedModelData.of(modelData, 32, 32);
  }

  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
    butterfly.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }

  @Override
  public ModelPart getPart() {
    return butterfly;
  }

  @Override
  public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);

    this.updateAnimation(entity.idleAnimationState, ModAnimations.butterfly_idle, ageInTicks, 1f);
    this.animateMovement(ModAnimations.flying, limbSwing, limbSwingAmount, 3f, 3f);
  }
}