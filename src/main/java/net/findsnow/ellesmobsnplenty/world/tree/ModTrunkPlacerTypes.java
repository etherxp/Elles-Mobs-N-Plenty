package net.findsnow.ellesmobsnplenty.world.tree;

import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.mixin.TrunkPlacerTypeInvoker;
import net.findsnow.ellesmobsnplenty.world.tree.custom.LuciTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
  public static final TrunkPlacerType<?> FALLEN_LUCI_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("fallen_luci_trunk",
          LuciTrunkPlacer.CODEC);

  public static void register() {
    EllesMobsNPlenty.LOGGER.info("Registering Trunk Placer for " + EllesMobsNPlenty.MOD_ID);
  }
}
