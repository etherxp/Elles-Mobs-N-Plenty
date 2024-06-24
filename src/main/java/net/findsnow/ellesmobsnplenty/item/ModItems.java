package net.findsnow.ellesmobsnplenty.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.entity.ModBoats;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

  // Items
  public static final Item FROSTITE = registerItem("frostite",
          new Item(new FabricItemSettings()));

  public static final Item LUCI_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.LUCI_BOAT_ID, ModBoats.LUCI_BOAT_KEY, false);
  public static final Item LUCI_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.LUCI_CHEST_BOAT_ID, ModBoats.LUCI_BOAT_KEY, true);

  public static final Item NEPHRITE = registerItem("nephrite",
          new Item(new FabricItemSettings()));
  public static final Item RAW_NEPHRITE = registerItem("raw_nephrite",
          new Item(new FabricItemSettings()));
  public static final Item NEPHRITE_NUGGET = registerItem("nephrite_nugget",
          new Item(new FabricItemSettings()));
  public static final Item LUCI_SIGN = registerItem("luci_sign",
          new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.LUCI_SIGN, ModBlocks.LUCI_WALL_SIGN));
  public static final Item LUCI_HANGING_SIGN = registerItem("luci_hanging_sign",
          new HangingSignItem(ModBlocks.LUCI_HANGING_SIGN, ModBlocks.LUCI_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));
  public static final Item CRAB_CLAW = registerItem("crab_claw",
          new Item(new FabricItemSettings()));

  // Spawn Eggs
  public static final Item CRAB_SPAWN_EGG = registerItem("crab_spawn_egg",
          new SpawnEggItem(ModEntities.CRAB, 0x831414, 0xf24b4b, new FabricItemSettings()));
  public static final Item TURTLE_SPAWN_EGG = registerItem("turtle_spawn_egg",
          new SpawnEggItem(ModEntities.TURTLE, 0x16372a, 0x418651, new FabricItemSettings()));
  public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg",
          new SpawnEggItem(ModEntities.BUTTERFLY, 0x3b8827, 0x462f2f, new FabricItemSettings()));
  public static final Item CATERPILLAR_SPAWN_EGG = registerItem("caterpillar_spawn_egg",
          new SpawnEggItem(ModEntities.CATERPILLAR, 0x185d25, 0x65992e, new FabricItemSettings()));


  // Food
  public static final Item RAW_CRAB = registerItem("raw_crab",
          new Item(new FabricItemSettings()));
  public static final Item COOKED_CRAB = registerItem("cooked_crab",
          new Item(new FabricItemSettings()));


  // Tools
  public static final Item NEPHRITE_PICKAXE = registerItem("nephrite_pickaxe",
          new PickaxeItem(ModToolMaterial.NEPHRITE, 1, 1f, new FabricItemSettings()));
  public static final Item NEPHRITE_SWORD = registerItem("nephrite_sword",
          new SwordItem(ModToolMaterial.NEPHRITE, 7, 1.6f, new FabricItemSettings()));
  public static final Item NEPHRITE_AXE = registerItem("nephrite_axe",
          new AxeItem(ModToolMaterial.NEPHRITE, 5, -1f, new FabricItemSettings()));
  public static final Item NEPHRITE_HOE = registerItem("nephrite_hoe",
          new HoeItem(ModToolMaterial.NEPHRITE, 0, 0f, new FabricItemSettings()));
  public static final Item NEPHRITE_SHOVEL = registerItem("nephrite_shovel",
          new ShovelItem(ModToolMaterial.NEPHRITE, 0, 0f, new FabricItemSettings()));

  // Armor
  public static final Item NEPHRITE_HELMET = registerItem("nephrite_helmet",
          new ArmorItem(ModArmorMaterials.NEPHRITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
  public static final Item NEPHRITE_CHESTPLATE = registerItem("nephrite_chestplate",
          new ArmorItem(ModArmorMaterials.NEPHRITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
  public static final Item NEPHRITE_LEGGINGS = registerItem("nephrite_leggings",
          new ArmorItem(ModArmorMaterials.NEPHRITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
  public static final Item NEPHRITE_BOOTS = registerItem("nephrite_boots",
          new ArmorItem(ModArmorMaterials.NEPHRITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

  // Music
  public static final Item NIGHT_TIME_MUSIC_DISC = registerItem("night_time_music_disc",
          new MusicDiscItem(9, ModSounds.NIGHT_TIME, new FabricItemSettings().maxCount(1), 156));



  // Helpers
  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(EllesMobsNPlenty.MOD_ID, name), item);
  }

  private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    // Items
    entries.add(NEPHRITE);
    entries.add(FROSTITE);
    entries.add(RAW_NEPHRITE);
    entries.add(NEPHRITE_NUGGET);
    entries.add(CRAB_CLAW);
    entries.add(RAW_CRAB);
    entries.add(COOKED_CRAB);

    // Blocks
    entries.add(ModBlocks.NEPHRITE_BLOCK);
    entries.add(ModBlocks.RAW_NEPHRITE_BLOCK);
    entries.add(ModBlocks.FROSTITE_ORE);
    entries.add(ModBlocks.DEEPSLATE_FROSTITE_ORE);
    entries.add(ModBlocks.NEPHRITE_ORE);
    entries.add(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
    entries.add(ModBlocks.CHOMPER_BLOCK);
    entries.add(ModBlocks.LUCI_PLANKS);
    entries.add(ModBlocks.LUCI_STAIRS);
    entries.add(ModBlocks.LUCI_WALL);
  }


  public static void registerModItems() {
    EllesMobsNPlenty.LOGGER.info("Registering mod items for " + EllesMobsNPlenty.MOD_ID);
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
  }



}
