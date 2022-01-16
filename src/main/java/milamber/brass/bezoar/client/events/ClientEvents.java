package milamber.brass.bezoar.client.events;

import milamber.brass.bezoar.Bezoar;
import milamber.brass.bezoar.client.model.GiantTortoiseModel;
import milamber.brass.bezoar.client.render.*;
import milamber.brass.bezoar.BezoarEntityTypes;
import milamber.brass.bezoar.client.model.GiantHornetModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Bezoar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    private ClientEvents() {}

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BezoarEntityTypes.HONEY_HORNET.get(), HoneyHornetRenderer::new);
        event.registerEntityRenderer(BezoarEntityTypes.MOSSY_HORNET.get(), MossyHornetRenderer::new);
        event.registerEntityRenderer(BezoarEntityTypes.SPIKEY_HORNET.get(), SpikeyHornetRenderer::new);
        event.registerEntityRenderer(BezoarEntityTypes.FLORAL_HORNET.get(), FloralHornetRenderer::new);
        event.registerEntityRenderer(BezoarEntityTypes.GIANT_TORTOISE.get(), GiantTortoiseRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(HoneyHornetRenderer.TEXTURE, "main"), GiantHornetModel::createBodyLayer);
        event.registerLayerDefinition(new ModelLayerLocation(MossyHornetRenderer.TEXTURE, "main"), GiantHornetModel::createBodyLayer);
        event.registerLayerDefinition(new ModelLayerLocation(SpikeyHornetRenderer.TEXTURE, "main"), GiantHornetModel::createBodyLayer);
        event.registerLayerDefinition(new ModelLayerLocation(FloralHornetRenderer.TEXTURE, "main"), GiantHornetModel::createBodyLayer);
        event.registerLayerDefinition(GiantTortoiseModel.LAYER_LOCATION, GiantTortoiseModel::createBodyLayer);
    }

}
