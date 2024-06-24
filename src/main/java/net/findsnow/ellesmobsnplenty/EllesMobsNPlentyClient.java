package net.findsnow.ellesmobsnplenty;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.block.entity.ModBlockEntities;
import net.findsnow.ellesmobsnplenty.entity.ModBoats;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.entity.render.layer.ModModelLayers;
import net.findsnow.ellesmobsnplenty.entity.render.model.ButterflyModel;
import net.findsnow.ellesmobsnplenty.entity.render.model.CaterpillarModel;
import net.findsnow.ellesmobsnplenty.entity.render.model.CrabModel;
import net.findsnow.ellesmobsnplenty.entity.render.model.TurtleModel;
import net.findsnow.ellesmobsnplenty.entity.render.renderer.ButterflyRenderer;
import net.findsnow.ellesmobsnplenty.entity.render.renderer.CaterpillarRenderer;
import net.findsnow.ellesmobsnplenty.entity.render.renderer.CrabRenderer;
import net.findsnow.ellesmobsnplenty.entity.render.renderer.TurtleRenderer;
import net.findsnow.ellesmobsnplenty.particle.*;
import net.findsnow.ellesmobsnplenty.screen.AncientFurnaceScreen;
import net.findsnow.ellesmobsnplenty.screen.ModScreenHandlers;
import net.findsnow.ellesmobsnplenty.util.ModWoodTypes;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class EllesMobsNPlentyClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_SAPLING, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOSSOMING_LUCI_SAPLING, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_DOOR, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCILLE_TULIP, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LUCILLE_TULIP, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAURELLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_FLAURELLE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOSSOMING_LUCI_VINE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_PETAL, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_MUSHROOM, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUCI_LEAF_PILE, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLOVER, RenderLayer.getCutout());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_CLOVER, RenderLayer.getCutout());

    ParticleFactoryRegistry.getInstance().register(ModParticles.FALLING_LEAVES_PARTICLE, FallingLeavesParticle.Factory::new);
    ParticleFactoryRegistry.getInstance().register(ModParticles.LUCI_MUSHROOM_PARTICLE, LuciMushroomBlockParticle.Factory::new);
    ParticleFactoryRegistry.getInstance().register(ModParticles.BLOSSOMING_FALLING_LEAVES, BlossomingFallingLeavesParticle.Factory::new);
    ParticleFactoryRegistry.getInstance().register(ModParticles.FIREFLY, FireflyParticle.Factory::new);

    TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.LUCI, TexturedRenderLayers.getSignTextureId(ModWoodTypes.LUCI));
    BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
    BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

    HandledScreens.register(ModScreenHandlers.ANCIENT_FURNACE_SCREEN_HANDLER, AncientFurnaceScreen::new);


    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRAB, CrabModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.CRAB, CrabRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TURTLE, TurtleModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.TURTLE, TurtleRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BUTTERFLY, ButterflyModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.BUTTERFLY, ButterflyRenderer::new);
    EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CATERPILLAR, CaterpillarModel::getTexturedModelData);
    EntityRendererRegistry.register(ModEntities.CATERPILLAR, CaterpillarRenderer::new);

    TerraformBoatClientHelper.registerModelLayers(ModBoats.LUCI_BOAT_ID, false);

    ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
      if (world == null || pos == null) {
        return FoliageColors.getDefaultColor();
      }
      return BiomeColors.getFoliageColor(world, pos);
    }, ModBlocks.LUCI_LEAVES);
    }
  }
