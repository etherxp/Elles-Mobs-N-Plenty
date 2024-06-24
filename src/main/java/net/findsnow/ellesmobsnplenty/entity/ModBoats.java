package net.findsnow.ellesmobsnplenty.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.findsnow.ellesmobsnplenty.world.biome.ModBiomes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
  public static final Identifier LUCI_BOAT_ID = new Identifier(EllesMobsNPlenty.MOD_ID, "luci_boat");
  public static final Identifier LUCI_CHEST_BOAT_ID = new Identifier(EllesMobsNPlenty.MOD_ID, "luci_chest_boat");


  public static final RegistryKey<TerraformBoatType> LUCI_BOAT_KEY = TerraformBoatTypeRegistry.createKey(LUCI_BOAT_ID);

  public static void registerBoats() {
    TerraformBoatType luciBoat = new TerraformBoatType.Builder()
            .item(ModItems.LUCI_BOAT)
            .chestItem(ModItems.LUCI_CHEST_BOAT)
            .planks(ModBlocks.LUCI_PLANKS.asItem())
            .build();
    Registry.register(TerraformBoatTypeRegistry.INSTANCE, LUCI_BOAT_KEY, luciBoat);
  }
 }
