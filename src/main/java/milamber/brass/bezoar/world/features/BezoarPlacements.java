package milamber.brass.bezoar.world.features;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class BezoarPlacements {

    public static final PlacedFeature MOSS_SPREAD = PlacementUtils.register("moss_spread",
            BezoarConfiguredFeatures.ORE_MOSS.placed(
                   commonOrePlacement(30, HeightRangePlacement.uniform(VerticalAnchor.bottom(),
                                    VerticalAnchor.absolute(100)
                            )
                    )
            )
    );

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

}
