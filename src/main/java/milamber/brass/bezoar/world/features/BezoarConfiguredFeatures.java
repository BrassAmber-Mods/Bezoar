package milamber.brass.bezoar.world.features;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.Random;

import static net.minecraft.data.worldgen.features.OreFeatures.NATURAL_STONE;

public class BezoarConfiguredFeatures {

    public static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, name, configuredFeature);
    }

    public static Random RANDOM = new Random();

    public static final ConfiguredFeature<?, ?> ORE_MOSS = FeatureUtils.register("ore_moss",
            Feature.ORE.configured(
                    new OreConfiguration(NATURAL_STONE, Blocks.MOSS_BLOCK.defaultBlockState(), RANDOM.nextInt(2,5))));

}
