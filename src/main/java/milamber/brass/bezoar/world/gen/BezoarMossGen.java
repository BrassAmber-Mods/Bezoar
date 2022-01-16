package milamber.brass.bezoar.world.gen;

import milamber.brass.bezoar.world.features.BezoarPlacements;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Set;

public class BezoarMossGen {
    public static void generateMoss(final BiomeLoadingEvent event) {
        // get list of biomeTypes of the biome being loaded
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        // Get the BiomeGenerationSettingsBuilder (objects which contains data for all already loaded vanilla features)
        BiomeGenerationSettingsBuilder biomeGen = event.getGeneration();

        biomeGen.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, BezoarPlacements.MOSS_SPREAD);
    }
}
