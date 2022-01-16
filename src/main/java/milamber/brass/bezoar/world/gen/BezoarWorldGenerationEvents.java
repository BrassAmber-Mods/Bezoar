package milamber.brass.bezoar.world.gen;


import milamber.brass.bezoar.Bezoar;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bezoar.MOD_ID)
public class BezoarWorldGenerationEvents {

    private static void BezoarWorldGenerationEvents() {}

    @SubscribeEvent
    public static void  BrassGeodesWorldGeneration(final BiomeLoadingEvent event) {
        BezoarMossGen.generateMoss(event);
    }
}
