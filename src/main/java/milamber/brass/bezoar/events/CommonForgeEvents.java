package milamber.brass.bezoar.events;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.BezoarEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = BezoarMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoading(BiomeLoadingEvent event) {
        BezoarMod.LOGGER.log(Level.DEBUG, event.getName());
        if (event.getName().equals(new ResourceLocation("minecraft:lush_caves")) || event.getCategory().equals(BiomeCategory.JUNGLE) || event.getCategory().equals(BiomeCategory.SWAMP)) {
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(BezoarEntityTypes.JUNGLE_HORNET.get(), 90, 1,2));
        }

    }
}
