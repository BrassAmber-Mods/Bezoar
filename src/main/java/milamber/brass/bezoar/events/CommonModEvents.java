package milamber.brass.bezoar.events;

import milamber.brass.bezoar.BezoarEntityTypes;
import milamber.brass.bezoar.Bezoar;
import milamber.brass.bezoar.entity.mobs.AbstractGiantHornetEntity;
import milamber.brass.bezoar.entity.mobs.*;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Bezoar.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BezoarEntityTypes.HONEY_HORNET.get(), AbstractGiantHornetEntity.createAttributes().build());
        event.put(BezoarEntityTypes.MOSSY_HORNET.get(), MossyHornetEntity.createAttributes().build());
        event.put(BezoarEntityTypes.SPIKEY_HORNET.get(), SpikeyHornetEntity.createAttributes().build());
        event.put(BezoarEntityTypes.FLORAL_HORNET.get(), FloralHornetEntity.createAttributes().build());
        event.put(BezoarEntityTypes.GIANT_TORTOISE.get(), GiantTortoiseEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(BezoarEntityTypes.HONEY_HORNET.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                    AbstractGiantHornetEntity::canSpawn);
        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(BezoarEntityTypes.MOSSY_HORNET.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                    MossyHornetEntity::canSpawn);
        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(BezoarEntityTypes.SPIKEY_HORNET.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                    SpikeyHornetEntity::canSpawn);
        });
        event.enqueueWork(() -> {
            SpawnPlacements.register(BezoarEntityTypes.FLORAL_HORNET.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                    FloralHornetEntity::canSpawn);
        });
    }


}
