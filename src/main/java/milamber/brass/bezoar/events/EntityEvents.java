package milamber.brass.bezoar.events;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = BezoarMod.MOD_ID)
public class EntityEvents {
    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent event) {
        if (event.getName() == null)
            return;
        MobSpawnInfoBuilder spawns = event.getSpawns();

        if (event.getCategory().equals(Biome.Category.JUNGLE)) {
            spawns.withSpawner(EntityClassification.MONSTER,
                    new MobSpawnInfo.Spawners(ModEntityTypes.JUNGLE_HORNET.get(), 5, 3, 5));
        }
    }
}
