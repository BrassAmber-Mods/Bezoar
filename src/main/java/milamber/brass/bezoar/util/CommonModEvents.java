package milamber.brass.bezoar.util;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.ModEntityTypes;
import milamber.brass.bezoar.entity.custom.Giant_Hornet;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = BezoarMod.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.JUNGLE_HORNET.get(), Giant_Hornet.createAttributes().build());
    }
}
