package net.findsnow.ellesmobsnplenty.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.findsnow.ellesmobsnplenty.EllesMobsNPlenty;
import net.findsnow.ellesmobsnplenty.block.custom.*;
import net.findsnow.ellesmobsnplenty.block.hollow.HollowLuciLogBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.BlueMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.GreenMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.LuciMushroomBlock;
import net.findsnow.ellesmobsnplenty.block.signs.ModHangingSignBlock;
import net.findsnow.ellesmobsnplenty.block.signs.ModStandingSignBlock;
import net.findsnow.ellesmobsnplenty.block.signs.ModWallHangingSignBlock;
import net.findsnow.ellesmobsnplenty.block.signs.ModWallSignBlock;
import net.findsnow.ellesmobsnplenty.util.ModWoodTypes;
import net.findsnow.ellesmobsnplenty.world.tree.BlossomingLuciSaplingGenerator;
import net.findsnow.ellesmobsnplenty.world.tree.LuceroSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

  // Blocks
  public static final Block NEPHRITE_BLOCK = registerBlock("nephrite_block",
          new Block(FabricBlockSettings.copy(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
  public static final Block BLOSSOMING_LUCI_VINE = registerBlock("blossoming_luci_vine",
          new BlossomingLuciVineBlock(FabricBlockSettings.copy(Blocks.CHERRY_LEAVES).sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque().noCollision().ticksRandomly()
                  .pistonBehavior(PistonBehavior.DESTROY)));
  public static final Block GREEN_MUSHROOM_LAMP = registerBlock("green_mushroom_lamp",
          new GreenMushroomLampBlock(FabricBlockSettings.create().mapColor(MapColor.EMERALD_GREEN).sounds(BlockSoundGroup.FUNGUS).luminance(
                  state -> state.get(GreenMushroomLampBlock.CLICKED) ? 7 : 0)));
  public static final Block BLUE_MUSHROOM_LAMP = registerBlock("blue_mushroom_lamp",
          new BlueMushroomLampBlock(FabricBlockSettings.create().mapColor(MapColor.DIAMOND_BLUE).sounds(BlockSoundGroup.FUNGUS).luminance(
                  state -> state.get(GreenMushroomLampBlock.CLICKED) ? 7 : 0)));
  public static final Block RAW_NEPHRITE_BLOCK = registerBlock("raw_nephrite_block",
          new Block(FabricBlockSettings.copy(Blocks.RAW_GOLD_BLOCK)));
  public static final Block LUCI_FUNGUS_SHELF_BLOCk = registerBlock("luci_fungus_shelf_block",
          new LuciFungusShelfBlock(FabricBlockSettings.copy(Blocks.MUSHROOM_STEM).nonOpaque()));
  public static final Block CHOMPER_BLOCK = registerBlock("chomper_block",
          new ChomperBlock(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
  public static final Block ANCIENT_FURNACE = registerBlock("ancient_furnace",
          new AncientFurnaceBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
                  .luminance(state -> state.get(AncientFurnaceBlock.LIT)? 13 : 0).mapColor(MapColor.EMERALD_GREEN)));
  public static final Block CHRYSALIS_BLOCK = registerBlock("chrysalis_block",
          new ChrysalisBlock(FabricBlockSettings.copy(Blocks.HONEY_BLOCK).sounds(BlockSoundGroup.HONEY)));

  // Foliage
  public static final Block LUCILLE_TULIP = registerBlock("lucille_tulip",
          new FlowerBlock(StatusEffects.SATURATION,4, FabricBlockSettings.copy(Blocks.WHITE_TULIP)));
  public static final Block POTTED_LUCILLE_TULIP = registerBlockWithoutBlockItem("potted_lucille_tulip",
          new FlowerPotBlock(LUCILLE_TULIP, FabricBlockSettings.copy(Blocks.POTTED_WHITE_TULIP)));

  public static final Block LUCI_LEAF_PILE = registerBlock("luci_leaf_pile",
          new LuciLeafPileBlock(FabricBlockSettings.copy(Blocks.CHERRY_LEAVES)));
  public static final Block CLOVER = registerBlock("clover_block",
          new CloverBlock(FabricBlockSettings.copy(Blocks.CHERRY_LEAVES).noCollision()));
  public static final Block TALL_CLOVER = registerBlock("tall_clover_block",
          new CloverBlock(FabricBlockSettings.copy(Blocks.CHERRY_LEAVES).noCollision()));

  public static final Block FLAURELLE = registerBlock("flaurelle",
          new FlowerBlock(StatusEffects.SATURATION,4, FabricBlockSettings.copy(Blocks.WHITE_TULIP)));
  public static final Block POTTED_FLAURELLE = registerBlockWithoutBlockItem("potted_flaurelle",
          new FlowerPotBlock(LUCILLE_TULIP, FabricBlockSettings.copy(Blocks.POTTED_WHITE_TULIP)));
  public static final Block LUCI_PETAL = registerBlock("luci_petals",
  new LuciPetals(FabricBlockSettings.copy(Blocks.PINK_PETALS).nonOpaque().noCollision()));


  // Mushrooms
  public static final Block LUCI_MUSHROOM = registerBlock("luci_mushroom_block",
          new LuciMushroomBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.FUNGUS).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).noCollision()));



  // Wood Blocks
  public static final Block LUCI_LOG = registerBlock("luci_log",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.CHERRY_LOG)));
  public static final Block HOLLOW_LUCI_LOG = registerBlock("hollow_luci_log",
          new HollowLuciLogBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LOG).nonOpaque()));
  public static final Block LUCI_WOOD = registerBlock("luci_wood",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.CHERRY_WOOD)));
  public static final Block STRIPPED_LUCI_LOG = registerBlock("stripped_luci_log",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_LOG)));
  public static final Block STRIPPED_LUCI_WOOD = registerBlock("stripped_luci_wood",
          new LuciLogBlock(ModBlocks.LUCI_LEAVES, ModBlocks.BLOSSOMING_LUCI_LEAVES, FabricBlockSettings.copyOf(Blocks.STRIPPED_CHERRY_WOOD)));
  public static final Block LUCI_LEAVES = registerBlock("luci_leaves",
          new LuciLeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque().mapColor(MapColor.EMERALD_GREEN)));
  public static final Block BLOSSOMING_LUCI_LEAVES = registerBlock("blossoming_luci_leaves",
          new BlossomingLuciLeavesBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES).nonOpaque().mapColor(MapColor.EMERALD_GREEN)));
  public static final Block LUCI_SAPLING = registerBlock("luci_sapling",
          new SaplingBlock(new LuceroSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
  public static final Block BLOSSOMING_LUCI_SAPLING = registerBlock("blossoming_luci_sapling",
          new SaplingBlock(new BlossomingLuciSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
  public static final Block LUCI_PLANKS = registerBlock("luci_planks",
          new Block(FabricBlockSettings.copy(Blocks.CHERRY_PLANKS)));
  public static final Block LUCI_STAIRS = registerBlock("luci_stairs",
          new StairsBlock(ModBlocks.LUCI_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.CHERRY_STAIRS)));
  public static final Block LUCI_SLABS = registerBlock("luci_slabs",
          new SlabBlock(FabricBlockSettings.copy(Blocks.CHERRY_SLAB)));
  public static final Block LUCI_BUTTON = registerBlock("luci_button",
          new ButtonBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_BUTTON), BlockSetType.OAK, 10, true));
  public static final Block LUCI_FENCE = registerBlock("luci_fence",
          new FenceBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE)));
  public static final Block LUCI_FENCE_GATE = registerBlock("luci_fence_gate",
          new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE_GATE), WoodType.OAK));
  public static final Block LUCI_WALL = registerBlock("luci_wall",
          new WallBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
  public static final Block LUCI_DOOR = registerBlock("luci_door",
          new DoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_DOOR), BlockSetType.OAK));
  public static final Block LUCI_TRAPDOOR = registerBlock("luci_trapdoor",
          new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_TRAPDOOR), BlockSetType.OAK));
  public static final Block LUCI_PRESSURE_PLATE = registerBlock("luci_pressure_plate",
          new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                  FabricBlockSettings.copyOf(Blocks.CHERRY_PRESSURE_PLATE), BlockSetType.OAK));

  // Signs
  public static final Block LUCI_SIGN = registerBlockWithoutBlockItem("luci_sign",
          new ModStandingSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_SIGN), ModWoodTypes.LUCI));
  public static final Block LUCI_WALL_SIGN = registerBlockWithoutBlockItem("luci_wall_sign",
          new ModWallSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WALL_SIGN), ModWoodTypes.LUCI));
  public static final Block LUCI_HANGING_SIGN = registerBlockWithoutBlockItem("luci_hanging_sign",
          new ModHangingSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_HANGING_SIGN), ModWoodTypes.LUCI));
  public static final Block LUCI_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("luci_wall_hanging_sign",
          new ModWallHangingSignBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_WALL_HANGING_SIGN), ModWoodTypes.LUCI));

  // Ore Blocks
  public static final Block NEPHRITE_ORE = registerBlock("nephrite_ore",
          new Block(FabricBlockSettings.copy(Blocks.STONE)));
  public static final Block DEEPSLATE_NEPHRITE_ORE = registerBlock("deepslate_nephrite_ore",
          new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE)));
  public static final Block FROSTITE_ORE = registerBlock("frostite_ore",
          new Block(FabricBlockSettings.copy(Blocks.STONE)));
  public static final Block DEEPSLATE_FROSTITE_ORE = registerBlock("deepslate_frostite_ore",
          new Block(FabricBlockSettings.copy(Blocks.DEEPSLATE)));


  // Helper Methods

  private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, new Identifier(EllesMobsNPlenty.MOD_ID, name), block);
  }
  private static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, new Identifier(EllesMobsNPlenty.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
  }
  public static void registerModBlocks() {
    EllesMobsNPlenty.LOGGER.info("Registering Mod Blocks for " + EllesMobsNPlenty.MOD_ID);
  }

  public static Block registerBlockWithoutBlockItem(String name, Block block) {
    return Registry.register(Registries.BLOCK, new Identifier(EllesMobsNPlenty.MOD_ID, name), block);
  }
}
