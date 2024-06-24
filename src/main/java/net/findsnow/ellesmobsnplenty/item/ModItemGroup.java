package net.findsnow.ellesmobsnplenty.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
  public static final ItemGroup ELLES_MOBS_N_PLENTY = Registry.register(Registries.ITEM_GROUP,
          new Identifier(EllesMobsNPlenty.MOD_ID, "elles_mobs_n_plenty"),
          FabricItemGroup.builder().displayName(Text.translatable("itemGroup.elles_mobs_n_plenty_group"))
                  .icon(() -> new ItemStack(ModItems.NEPHRITE)).entries((displayContext, entries) -> {
                    // Items
                    entries.add(ModItems.CRAB_CLAW);
                    entries.add(ModItems.RAW_CRAB);
                    entries.add(ModItems.COOKED_CRAB);
                    entries.add(ModItems.NEPHRITE);
                    entries.add(ModItems.RAW_NEPHRITE);
                    entries.add(ModItems.NEPHRITE_NUGGET);
                    entries.add(ModItems.NEPHRITE_PICKAXE);
                    entries.add(ModItems.NEPHRITE_AXE);
                    entries.add(ModItems.NEPHRITE_SHOVEL);
                    entries.add(ModItems.NEPHRITE_HOE);
                    entries.add(ModItems.NEPHRITE_SWORD);
                    entries.add(ModItems.NEPHRITE_HELMET);
                    entries.add(ModItems.NEPHRITE_CHESTPLATE);
                    entries.add(ModItems.NEPHRITE_LEGGINGS);
                    entries.add(ModItems.NEPHRITE_BOOTS);

                    // Blocks
                    entries.add(ModBlocks.NEPHRITE_BLOCK);
                    entries.add(ModBlocks.RAW_NEPHRITE_BLOCK);
                    entries.add(ModBlocks.FROSTITE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_FROSTITE_ORE);
                    entries.add(ModBlocks.NEPHRITE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
                    entries.add(ModBlocks.GREEN_MUSHROOM_LAMP);
                    entries.add(ModBlocks.BLUE_MUSHROOM_LAMP);
                    entries.add(ModBlocks.CHOMPER_BLOCK);
                    entries.add(ModBlocks.ANCIENT_FURNACE);
                    entries.add(ModBlocks.LUCILLE_TULIP);
                    entries.add(ModBlocks.FLAURELLE);
                    entries.add(ModBlocks.LUCI_FUNGUS_SHELF_BLOCk);
                    entries.add(ModBlocks.LUCI_MUSHROOM);
                    entries.add(ModBlocks.CHRYSALIS_BLOCK);

                    // Luci Wood
                    entries.add(ModBlocks.LUCI_PLANKS);
                    entries.add(ModBlocks.LUCI_STAIRS);
                    entries.add(ModBlocks.LUCI_SLABS);
                    entries.add(ModBlocks.LUCI_BUTTON);
                    entries.add(ModBlocks.LUCI_PRESSURE_PLATE);
                    entries.add(ModBlocks.LUCI_FENCE);
                    entries.add(ModBlocks.LUCI_FENCE_GATE);
                    entries.add(ModBlocks.LUCI_WALL);
                    entries.add(ModBlocks.LUCI_DOOR);
                    entries.add(ModBlocks.LUCI_TRAPDOOR);
                    entries.add(ModBlocks.LUCI_LOG);
                    entries.add(ModBlocks.HOLLOW_LUCI_LOG);
                    entries.add(ModBlocks.STRIPPED_LUCI_LOG);
                    entries.add(ModBlocks.LUCI_LEAVES);
                    entries.add(ModBlocks.BLOSSOMING_LUCI_LEAVES);
                    entries.add(ModBlocks.STRIPPED_LUCI_WOOD);
                    entries.add(ModBlocks.LUCI_WOOD);
                    entries.add(ModBlocks.LUCI_SAPLING);
                    entries.add(ModBlocks.BLOSSOMING_LUCI_SAPLING);
                    entries.add(ModItems.LUCI_SIGN);
                    entries.add(ModItems.LUCI_HANGING_SIGN);
                    entries.add(ModBlocks.BLOSSOMING_LUCI_VINE);
                    entries.add(ModItems.LUCI_BOAT);
                    entries.add(ModItems.LUCI_CHEST_BOAT);

                    // Music Discs
                    entries.add(ModItems.NIGHT_TIME_MUSIC_DISC);

                    // Frostite
                    entries.add(ModItems.FROSTITE);

                    entries.add(ModItems.CRAB_SPAWN_EGG);
                    entries.add(ModItems.TURTLE_SPAWN_EGG);
                    entries.add(ModItems.BUTTERFLY_SPAWN_EGG);
                    entries.add(ModItems.CATERPILLAR_SPAWN_EGG);
                  }).build());

  public static void registerItemGroups() {
    // I don't know what this does

  }
}
