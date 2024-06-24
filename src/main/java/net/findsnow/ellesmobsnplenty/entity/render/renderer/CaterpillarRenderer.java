package net.findsnow.ellesmobsnplenty.entity.render.renderer;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.ButterflyEntity;
import net.findsnow.ellesmobsnplenty.entity.custom.feature.CaterpillarEntity;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.ButterflyModel;
import net.findsnow.ellesmobsnplenty.entity.render.model.CaterpillarModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CaterpillarRenderer extends MobEntityRenderer<CaterpillarEntity, CaterpillarModel<CaterpillarEntity>> {
  private static final Identifier TEXTURE = new Identifier(EllesMobsNPlenty.MOD_ID, "textures/entity/caterpillar/caterpillar_green.png");

  public CaterpillarRenderer(EntityRendererFactory.Context context) {
    super(context, new CaterpillarModel<>(context.getPart(ModModelLayers.CATERPILLAR)), 0.2f);
  }

  @Override
  public Identifier getTexture(CaterpillarEntity entity) {
    return TEXTURE;
  }

  @Override
  public void render(CaterpillarEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
    if(livingEntity.isBaby()) {
      matrixStack.scale(0.5f, 0.5f, 0.5f);
    } else {
      matrixStack.scale(1.0f, 1.0f, 1.0f);
    }
    super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
  }
}
