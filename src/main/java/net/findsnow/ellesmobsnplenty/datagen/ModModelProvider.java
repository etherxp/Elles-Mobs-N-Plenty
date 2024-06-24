package net.findsnow.ellesmobsnplenty.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.findsnow.ellesmobsnplenty.block.custom.BlossomingLuciVineBlock;
import net.findsnow.ellesmobsnplenty.block.custom.ChomperBlock;
import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.block.custom.LuciPetals;
import net.findsnow.ellesmobsnplenty.block.mushrooms.BlueMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.block.mushrooms.GreenMushroomLampBlock;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
  public ModModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    // Blocks
    blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LUCI_MUSHROOM);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NEPHRITE_BLOCK);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_NEPHRITE_BLOCK);
    blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.LUCILLE_TULIP, ModBlocks.POTTED_LUCILLE_TULIP, BlockStateModelGenerator.TintType.NOT_TINTED);
    blockStateModelGenerator.registerCooker(ModBlocks.ANCIENT_FURNACE, TexturedModel.ORIENTABLE);
    blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LUCI_FUNGUS_SHELF_BLOCk);
    blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLOSSOMING_LUCI_VINE);
    blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.LUCI_PETAL);

    // Custom Blocks
    registerChomper(blockStateModelGenerator);
    registerGreenMushroomLamp(blockStateModelGenerator);
    registerBlueMushroomLamp(blockStateModelGenerator);

    // Ores
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NEPHRITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_NEPHRITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTITE_ORE);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FROSTITE_ORE);

    // Luci Wood
    BlockStateModelGenerator.BlockTexturePool luciTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LUCI_PLANKS);
    luciTexturePool.stairs(ModBlocks.LUCI_STAIRS);
    luciTexturePool.slab(ModBlocks.LUCI_SLABS);
    luciTexturePool.button(ModBlocks.LUCI_BUTTON);
    luciTexturePool.pressurePlate(ModBlocks.LUCI_PRESSURE_PLATE);
    luciTexturePool.fence(ModBlocks.LUCI_FENCE);
    luciTexturePool.fenceGate(ModBlocks.LUCI_FENCE_GATE);
    luciTexturePool.wall(ModBlocks.LUCI_WALL);

    blockStateModelGenerator.registerDoor(ModBlocks.LUCI_DOOR);
    blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.LUCI_TRAPDOOR);
    luciTexturePool.family(BlockFamilies.register(ModBlocks.LUCI_PLANKS).sign(ModBlocks.LUCI_SIGN, ModBlocks.LUCI_WALL_SIGN).build());
    blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_LUCI_LOG, ModBlocks.LUCI_HANGING_SIGN, ModBlocks.LUCI_WALL_HANGING_SIGN);

    blockStateModelGenerator.registerLog(ModBlocks.LUCI_LOG).log(ModBlocks.LUCI_LOG).wood(ModBlocks.LUCI_WOOD);
    blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_LUCI_LOG).log(ModBlocks.STRIPPED_LUCI_LOG).wood(ModBlocks.STRIPPED_LUCI_WOOD);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOSSOMING_LUCI_LEAVES);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUCI_LEAVES);

    blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.LUCI_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BLOSSOMING_LUCI_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
  }

  // Custom Registers
  private void registerChomper(BlockStateModelGenerator blockStateModelGenerator) {
    Identifier identifier = ModelIds.getBlockModelId(ModBlocks.CHOMPER_BLOCK);
    Identifier identifier2 = ModelIds.getBlockSubModelId(ModBlocks.CHOMPER_BLOCK, "_open");
    blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHOMPER_BLOCK)
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
            .coordinate(BlockStateModelGenerator.createBooleanModelMap(ChomperBlock.OPEN, identifier2, identifier)));
  }

  private void registerGreenMushroomLamp(BlockStateModelGenerator blockStateModelGenerator) {
    Identifier identifier = ModelIds.getBlockModelId(ModBlocks.GREEN_MUSHROOM_LAMP);
    Identifier identifier2 = ModelIds.getBlockSubModelId(ModBlocks.GREEN_MUSHROOM_LAMP, "_lit");
    blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GREEN_MUSHROOM_LAMP)
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
            .coordinate(BlockStateModelGenerator.createBooleanModelMap(GreenMushroomLampBlock.CLICKED, identifier2, identifier)));
  }

  private void registerBlueMushroomLamp(BlockStateModelGenerator blockStateModelGenerator) {
    Identifier identifier = ModelIds.getBlockModelId(ModBlocks.BLUE_MUSHROOM_LAMP);
    Identifier identifier2 = ModelIds.getBlockSubModelId(ModBlocks.BLUE_MUSHROOM_LAMP, "_lit");
    blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.BLUE_MUSHROOM_LAMP)
            .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
            .coordinate(BlockStateModelGenerator.createBooleanModelMap(BlueMushroomLampBlock.CLICKED, identifier2, identifier)));
  }


  // Item Models
  @Override
  public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.CRAB_CLAW, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_CRAB, Models.GENERATED);
    itemModelGenerator.register(ModItems.COOKED_CRAB, Models.GENERATED);
    itemModelGenerator.register(ModItems.FROSTITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_NEPHRITE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_NUGGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NIGHT_TIME_MUSIC_DISC, Models.GENERATED);

    itemModelGenerator.register(ModItems.NEPHRITE_PICKAXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_SWORD, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_AXE, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_SHOVEL, Models.HANDHELD);
    itemModelGenerator.register(ModItems.NEPHRITE_HOE, Models.HANDHELD);

    itemModelGenerator.register(ModItems.NEPHRITE_HELMET, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_CHESTPLATE, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_LEGGINGS, Models.GENERATED);
    itemModelGenerator.register(ModItems.NEPHRITE_BOOTS, Models.GENERATED);

    itemModelGenerator.register(ModBlocks.LUCI_SAPLING.asItem(), Models.GENERATED);
    itemModelGenerator.register(ModBlocks.CHRYSALIS_BLOCK.asItem(), Models.GENERATED);
    itemModelGenerator.register(ModBlocks.LUCI_FUNGUS_SHELF_BLOCk.asItem(), Models.GENERATED);
    itemModelGenerator.register(ModBlocks.BLOSSOMING_LUCI_SAPLING.asItem(), Models.GENERATED);
    itemModelGenerator.register(ModBlocks.LUCI_MUSHROOM.asItem(), Models.GENERATED);

    itemModelGenerator.register(ModItems.LUCI_BOAT, Models.GENERATED);
    itemModelGenerator.register(ModItems.LUCI_CHEST_BOAT, Models.GENERATED);

    // Spawn Eggs
    itemModelGenerator.register(ModItems.CRAB_SPAWN_EGG,
            new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    itemModelGenerator.register(ModItems.TURTLE_SPAWN_EGG,
            new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    itemModelGenerator.register(ModItems.BUTTERFLY_SPAWN_EGG,
            new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    itemModelGenerator.register(ModItems.CATERPILLAR_SPAWN_EGG,
            new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

  }
}