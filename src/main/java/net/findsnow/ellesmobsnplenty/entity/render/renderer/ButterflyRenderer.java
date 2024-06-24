package net.findsnow.ellesmobsnplenty.entity.render.renderer;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.ButterflyEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.TurtleEntity;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.ButterflyModel;
import net.findsnow.ellesmobsnplenty.entity.render.model.TurtleModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ButterflyRenderer extends MobEntityRenderer<ButterflyEntity, ButterflyModel<ButterflyEntity>> {
private static final Identifier TEXTURE = new Identifier(EllesMobsNPlenty.MOD_ID, "textures/entity/butterfly/butterfly_default.png");

public ButterflyRenderer(EntityRendererFactory.Context context) {
  super(context, new ButterflyModel<>(context.getPart(ModModelLayers.BUTTERFLY)), 0.2f);
}

@Override
public void render(ButterflyEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
  if(livingEntity.isBaby()) {
    matrixStack.scale(0.5f, 0.5f, 0.5f);
  } else {
    matrixStack.scale(1.0f, 1.0f, 1.0f);
  }
  super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
}

  @Override
  public Identifier getTexture(ButterflyEntity entity) {
    return TEXTURE;
  }
}
