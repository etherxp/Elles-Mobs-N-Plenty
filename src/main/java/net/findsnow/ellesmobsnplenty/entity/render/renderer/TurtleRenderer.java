package net.findsnow.ellesmobsnplenty.entity.render.renderer;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CrabEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.TurtleEntity;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.TurtleModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class TurtleRenderer extends MobEntityRenderer<TurtleEntity, TurtleModel<TurtleEntity>> {
  private static final Identifier TEXTURE = new Identifier(EllesMobsNPlenty.MOD_ID, "textures/entity/turtle/turtle_texture.png");

  public TurtleRenderer(EntityRendererFactory.Context context) {
    super(context, new TurtleModel<>(context.getPart(ModModelLayers.TURTLE)), 0.2f);
  }

  @Override
  public Identifier getTexture(TurtleEntity entity) {
    return TEXTURE;
  }

  @Override
  public void render(TurtleEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    if (livingEntity.isBaby()) {
      matrixStack.scale(0.5f, 0.5f, 0.5f);
    } else {
      matrixStack.scale(1.0f, 1.0f, 1.0f);
    }
    super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
  }
}
