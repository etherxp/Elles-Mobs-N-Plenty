package net.findsnow.ellesmobsnplenty;

import net.fabricmc.api.ModInitializer;

import net.findsnow.ellesmobsnplenty.block.ModBlocks;
import net.findsnow.ellesmobsnplenty.entity.ModBoats;
import net.findsnow.ellesmobsnplenty.entity.ModEntities;
import net.findsnow.ellesmobsnplenty.item.ModItemGroup;
import net.findsnow.ellesmobsnplenty.item.ModItems;
import net.findsnow.ellesmobsnplenty.particle.ModParticles;
import net.findsnow.ellesmobsnplenty.recipe.ModRecipes;
import net.findsnow.ellesmobsnplenty.screen.ModScreenHandlers;
import net.findsnow.ellesmobsnplenty.sound.ModSounds;
import net.findsnow.ellesmobsnplenty.util.ModRegistries;
import net.findsnow.ellesmobsnplenty.world.ModFeatures;
import net.findsnow.ellesmobsnplenty.world.decorators.ModTreeDecorator;
import net.findsnow.ellesmobsnplenty.world.gen.ModWorldGeneration;
import net.findsnow.ellesmobsnplenty.world.tree.ModTrunkPlacerTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EllesMobsNPlenty implements ModInitializer {
	public static final String MOD_ID = "ellesmobsnplenty";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.RegisterModStuff();
		ModWorldGeneration.generatorModWorldGeneration();
		ModParticles.RegisterParticles();
		ModSounds.registerSounds();
		ModEntities.registerModEntities();
		ModScreenHandlers.registerScreenHandler();
		ModRecipes.registerRecipes();
		ModTreeDecorator.register();
		ModFeatures.register();
		ModTrunkPlacerTypes.register();
		ModBoats.registerBoats();
	}
}