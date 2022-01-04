package milamber.brass.bezoar.client.render;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.client.model.GiantHornetModel;
import milamber.brass.bezoar.entity.AbstractGiantHornetEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class AbstractHornetRenderer<Type extends AbstractGiantHornetEntity> extends MobRenderer<Type, GiantHornetModel<Type>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BezoarMod.MOD_ID, "textures/entity/jungle_hornet.png");

    public AbstractHornetRenderer(EntityRendererProvider.Context context, ResourceLocation location) {
        super(context,
                new GiantHornetModel<>(
                        context.bakeLayer(new ModelLayerLocation((location == null) ? TEXTURE : location, "main")),
                        new ModelLayerLocation((location == null) ? TEXTURE : location, "main")
                ),
                .7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}
