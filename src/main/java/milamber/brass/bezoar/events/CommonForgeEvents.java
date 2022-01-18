package milamber.brass.bezoar.events;

import milamber.brass.bezoar.Bezoar;
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

@Mod.EventBusSubscriber(modid = Bezoar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoading(BiomeLoadingEvent event) {
        Bezoar.LOGGER.log(Level.DEBUG, event.getName());
        if (event.getName().equals(new ResourceLocation("minecraft:lush_caves")) || event.getCategory().equals(BiomeCategory.JUNGLE) || event.getCategory().equals(BiomeCategory.SWAMP)) {
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(BezoarEntityTypes.HONEY_HORNET.get(), 90, 1,2));
        }
        if (event.getName().equals(new ResourceLocation("minecraft:lush_caves")) || event.getCategory().equals(BiomeCategory.JUNGLE) || event.getCategory().equals(BiomeCategory.SWAMP)) {
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(BezoarEntityTypes.MOSSY_HORNET.get(), 90, 1,2));
        }
        if (event.getName().equals(new ResourceLocation("minecraft:lush_caves")) || event.getCategory().equals(BiomeCategory.JUNGLE) || event.getCategory().equals(BiomeCategory.SWAMP)) {
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(BezoarEntityTypes.SPIKEY_HORNET.get(), 90, 1,2));
        }
        if (event.getName().equals(new ResourceLocation("minecraft:lush_caves")) || event.getCategory().equals(BiomeCategory.JUNGLE) || event.getCategory().equals(BiomeCategory.SWAMP)) {
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(BezoarEntityTypes.FLORAL_HORNET.get(), 90, 1,2));
        }
        if (event.getName().equals(new ResourceLocation("minecraft:lush_caves")) || event.getCategory().equals(BiomeCategory.JUNGLE)) {
            event.getSpawns().addSpawn(MobCategory.CREATURE,
                    new MobSpawnSettings.SpawnerData(BezoarEntityTypes.GIANT_TORTOISE.get(), 40, 1,2));
        }

    }
}
