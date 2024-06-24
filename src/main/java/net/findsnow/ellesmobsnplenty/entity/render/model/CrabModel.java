package net.findsnow.ellesmobsnplenty.entity.render.model;

import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.findsnow.ellesmobsnplenty.entity.render.animations.ModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class CrabModel<T extends CrabEntity> extends SinglePartEntityModel<T> {
  private final ModelPart crab;
  private final ModelPart head;

	public CrabModel(ModelPart root) {
    this.crab = root.getChild("crab");
    this.head = crab.getChild("body").getChild("head");
  }
  public static TexturedModelData getTexturedModelData() {
    ModelData modelData = new ModelData();
    ModelPartData modelPartData = modelData.getRoot();
    ModelPartData crab = modelPartData.addChild("crab", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

    ModelPartData body = crab.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

    ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.25F, 2.0F));

    ModelPartData torso = head.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -1.0F, 9.0F, 4.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -5.0F));

    ModelPartData eyes = head.addChild("eyes", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -5.0F));

    ModelPartData left_eye = eyes.addChild("left_eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData cube_r1 = left_eye.addChild("cube_r1", ModelPartBuilder.create().uv(26, 27).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

    ModelPartData right_eye = eyes.addChild("right_eye", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData cube_r2 = right_eye.addChild("cube_r2", ModelPartBuilder.create().uv(21, 27).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -3.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

    ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData right_legs = legs.addChild("right_legs", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, -2.5F, 1.5F));

    ModelPartData right_first = right_legs.addChild("right_first", ModelPartBuilder.create(), ModelTransform.pivot(0.1213F, 0.2071F, -1.0F));

    ModelPartData cube_r3 = right_first.addChild("cube_r3", ModelPartBuilder.create().uv(17, 27).cuboid(-0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6109F, 1.1036F, 0.0F, 0.0F, 0.0F, -0.7854F));

    ModelPartData right_middle = right_legs.addChild("right_middle", ModelPartBuilder.create(), ModelTransform.pivot(0.1213F, 0.2071F, 1.0F));

    ModelPartData cube_r4 = right_middle.addChild("cube_r4", ModelPartBuilder.create().uv(17, 27).cuboid(-0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6109F, 1.1036F, 0.0F, 0.0F, 0.0F, -0.7854F));

    ModelPartData right_last = right_legs.addChild("right_last", ModelPartBuilder.create(), ModelTransform.pivot(0.1213F, 0.2071F, 3.0F));

    ModelPartData cube_r5 = right_last.addChild("cube_r5", ModelPartBuilder.create().uv(17, 27).cuboid(-0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6109F, 1.1036F, 0.0F, 0.0F, 0.0F, -0.7854F));

    ModelPartData left_legs = legs.addChild("left_legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData left_first = left_legs.addChild("left_first", ModelPartBuilder.create(), ModelTransform.pivot(-3.4822F, -2.6893F, 0.5F));

    ModelPartData cube_r6 = left_first.addChild("cube_r6", ModelPartBuilder.create().uv(18, 27).cuboid(0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.25F, 1.5F, 0.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData left_middle = left_legs.addChild("left_middle", ModelPartBuilder.create(), ModelTransform.pivot(-3.6287F, -2.8358F, 2.5F));

    ModelPartData cube_r7 = left_middle.addChild("cube_r7", ModelPartBuilder.create().uv(18, 27).cuboid(0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.1036F, 1.6464F, 0.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData left_last = left_legs.addChild("left_last", ModelPartBuilder.create(), ModelTransform.pivot(-3.6287F, -2.8358F, 4.5F));

    ModelPartData cube_r8 = left_last.addChild("cube_r8", ModelPartBuilder.create().uv(18, 27).cuboid(0.5F, -2.0F, -0.5F, 0.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.1036F, 1.6464F, 0.0F, 0.0F, 0.0F, 0.7854F));

    ModelPartData claws = body.addChild("claws", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

    ModelPartData right_claw = claws.addChild("right_claw", ModelPartBuilder.create(), ModelTransform.of(-8.25F, -2.5F, -4.75F, 3.1207F, -0.2982F, -3.0935F));

    ModelPartData right_lower = right_claw.addChild("right_lower", ModelPartBuilder.create().uv(15, 24).mirrored().cuboid(-6.9996F, 0.05F, -2.0004F, 7.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
            .uv(0, 24).mirrored().cuboid(-6.9996F, 0.05F, 1.9996F, 7.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
            .uv(0, 19).mirrored().cuboid(-6.9996F, 2.05F, -2.0004F, 7.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0004F, 0.95F, 0.0004F, -0.0436F, 0.0F, 0.0F));

    ModelPartData cube_r9 = right_lower.addChild("cube_r9", ModelPartBuilder.create().uv(0, 5).cuboid(-6.5908F, 0.2907F, -2.0834F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.9172F, -0.2407F, -4.5902F, 0.0F, 1.5708F, 0.0F));

    ModelPartData cube_r10 = right_lower.addChild("cube_r10", ModelPartBuilder.create().uv(9, 27).mirrored().cuboid(-6.5908F, 0.2907F, -2.0834F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0828F, -0.2407F, -4.5902F, 0.0F, 1.5708F, 0.0F));

    ModelPartData right_upper = right_claw.addChild("right_upper", ModelPartBuilder.create().uv(0, 14).mirrored().cuboid(-6.9996F, -3.85F, -2.0004F, 7.0F, 0.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
            .uv(23, 19).mirrored().cuboid(-6.9996F, -3.85F, -2.0004F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
            .uv(23, 14).mirrored().cuboid(-6.9996F, -3.85F, 1.9996F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.0004F, 0.85F, 0.0004F, -0.0436F, 0.0F, 0.0F));

    ModelPartData cube_r11 = right_upper.addChild("cube_r11", ModelPartBuilder.create().uv(0, 0).cuboid(-6.5908F, -1.7093F, -2.0834F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0828F, -2.1407F, -4.5902F, 0.0F, 1.5708F, 0.0F));

    ModelPartData cube_r12 = right_upper.addChild("cube_r12", ModelPartBuilder.create().uv(0, 27).cuboid(-6.5908F, -1.7093F, -2.0834F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.9172F, -2.1407F, -4.5902F, 0.0F, 1.5708F, 0.0F));

    ModelPartData left_claw = claws.addChild("left_claw", ModelPartBuilder.create(), ModelTransform.of(9.5F, -2.25F, -4.5F, 3.0972F, 0.3441F, 3.1207F));

    ModelPartData left_lower = left_claw.addChild("left_lower", ModelPartBuilder.create().uv(15, 24).cuboid(-0.0004F, 0.05F, -2.0004F, 7.0F, 2.0F, 0.0F, new Dilation(0.0F))
            .uv(0, 24).cuboid(-0.0004F, 0.05F, 1.9996F, 7.0F, 2.0F, 0.0F, new Dilation(0.0F))
            .uv(0, 19).cuboid(-0.0004F, 2.05F, -2.0004F, 7.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0004F, 0.95F, 0.0004F));

    ModelPartData cube_r13 = left_lower.addChild("cube_r13", ModelPartBuilder.create().uv(0, 5).cuboid(2.5908F, 0.2907F, -2.0834F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.9172F, -0.2407F, -4.5902F, 0.0F, -1.5708F, 0.0F));

    ModelPartData cube_r14 = left_lower.addChild("cube_r14", ModelPartBuilder.create().uv(9, 27).cuboid(2.5908F, 0.2907F, -2.0834F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0828F, -0.2407F, -4.5902F, 0.0F, -1.5708F, 0.0F));

    ModelPartData left_upper = left_claw.addChild("left_upper", ModelPartBuilder.create().uv(0, 14).cuboid(-0.0004F, -3.85F, -2.0004F, 7.0F, 0.0F, 4.0F, new Dilation(0.0F))
            .uv(23, 19).cuboid(-0.0004F, -3.85F, -2.0004F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F))
            .uv(23, 14).cuboid(-0.0004F, -3.85F, 1.9996F, 7.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0004F, 0.85F, 0.0004F));

    ModelPartData cube_r15 = left_upper.addChild("cube_r15", ModelPartBuilder.create().uv(0, 0).cuboid(2.5908F, -1.7093F, -2.0834F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0828F, -2.1407F, -4.5902F, 0.0F, -1.5708F, 0.0F));

    ModelPartData cube_r16 = left_upper.addChild("cube_r16", ModelPartBuilder.create().uv(0, 27).cuboid(2.5908F, -1.7093F, -2.0834F, 4.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.9172F, -2.1407F, -4.5902F, 0.0F, -1.5708F, 0.0F));
    return TexturedModelData.of(modelData, 64, 64);
  }

  @Override
  public void setAngles(CrabEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    this.getPart().traverse().forEach(ModelPart::resetTransform);
    this.animateMovement(ModAnimations.crab_walk, limbSwing, limbSwingAmount, 3f, 3f);
    this.updateAnimation(entity.idleAnimationState, ModAnimations.crab_idle, ageInTicks, 1f);
    this.updateAnimation(entity.waveAnimationState, ModAnimations.crab_wave, ageInTicks, 1f);
    this.updateAnimation(entity.snipAnimationState, ModAnimations.crab_snip, ageInTicks, 1f);
    this.updateAnimation(entity.climbAnimationState, ModAnimations.crab_climb, ageInTicks, 1f);
  }
  @Override
  public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
    crab.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
  }

  @Override
  public ModelPart getPart() {
    return crab;
  }
}