package net.findsnow.ellesmobsnplenty.entity.render.layer;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
public static final EntityModelLayer CRAB =
        new EntityModelLayer(new Identifier(EllesMobsNPlenty.MOD_ID, "crab"), "main");
  public static final EntityModelLayer TURTLE =
          new EntityModelLayer(new Identifier(EllesMobsNPlenty.MOD_ID, "turtle"), "main");
  public static final EntityModelLayer BUTTERFLY =
          new EntityModelLayer(new Identifier(EllesMobsNPlenty.MOD_ID, "butterfly"), "main");
  public static final EntityModelLayer CATERPILLAR =
          new EntityModelLayer(new Identifier(EllesMobsNPlenty.MOD_ID, "caterpillar"), "main");

}
