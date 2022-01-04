package milamber.brass.bezoar.client.events;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.client.render.AbstractHornetRenderer;
import milamber.brass.bezoar.client.render.JungleHornetRenderer;
import milamber.brass.bezoar.BezoarEntityTypes;
import milamber.brass.bezoar.client.model.GiantHornetModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BezoarMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    private ClientEvents() {}

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BezoarEntityTypes.JUNGLE_HORNET.get(), JungleHornetRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(AbstractHornetRenderer.TEXTURE, "main"), GiantHornetModel::createBodyLayer);
    }


}
