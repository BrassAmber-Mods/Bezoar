package milamber.brass.bezoar.events;

import milamber.brass.bezoar.BezoarEntityTypes;
import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.AbstractGiantHornetEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = BezoarMod.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BezoarEntityTypes.JUNGLE_HORNET.get(), AbstractGiantHornetEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(BezoarEntityTypes.JUNGLE_HORNET.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                    AbstractGiantHornetEntity::canSpawn);
        });
    }


}
