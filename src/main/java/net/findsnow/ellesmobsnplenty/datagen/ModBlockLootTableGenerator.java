package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.item.Items;

public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
  public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
    super(dataOutput);
  }

  @Override
  public void generate() {
    addDrop(ModBlocks.NEPHRITE_BLOCK);
    addDrop(ModBlocks.RAW_NEPHRITE_BLOCK);
    addDrop(ModBlocks.GREEN_MUSHROOM_LAMP);
    addDrop(ModBlocks.BLUE_MUSHROOM_LAMP);
    addDrop(ModBlocks.LUCI_PLANKS);
    addDrop(ModBlocks.LUCI_BUTTON);
    addDrop(ModBlocks.LUCI_PRESSURE_PLATE);
    addDrop(ModBlocks.LUCI_FENCE);
    addDrop(ModBlocks.LUCI_FENCE_GATE);
    addDrop(ModBlocks.LUCI_WALL);
    addDrop(ModBlocks.LUCI_SLABS, slabDrops(ModBlocks.LUCI_PLANKS));
    addDrop(ModBlocks.LUCI_TRAPDOOR);
    addDrop(ModBlocks.LUCI_DOOR, doorDrops(ModBlocks.LUCI_DOOR));
    addDrop(ModBlocks.LUCI_LOG);
    addDrop(ModBlocks.LUCI_WOOD);
    addDrop(ModBlocks.LUCI_FUNGUS_SHELF_BLOCk, dropsWithShears(Items.BROWN_MUSHROOM_BLOCK));
    addDrop(ModBlocks.LUCI_LEAVES, leavesDrops(ModBlocks.LUCI_LEAVES, ModBlocks.LUCI_SAPLING, 0.1f));
    addDrop(ModBlocks.BLOSSOMING_LUCI_LEAVES, leavesDrops(ModBlocks.BLOSSOMING_LUCI_LEAVES, ModBlocks.LUCI_SAPLING, 0.1f));
    addDrop(ModBlocks.STRIPPED_LUCI_LOG);
    addDrop(ModBlocks.STRIPPED_LUCI_WOOD);
    addDrop(ModBlocks.CHOMPER_BLOCK);
    addDrop(ModBlocks.LUCI_MUSHROOM);

    addDrop(ModBlocks.NEPHRITE_ORE, oreDrops(ModBlocks.NEPHRITE_ORE, ModItems.RAW_NEPHRITE));
    addDrop(ModBlocks.DEEPSLATE_NEPHRITE_ORE, oreDrops(ModBlocks.NEPHRITE_ORE, ModItems.RAW_NEPHRITE));
  }
}
