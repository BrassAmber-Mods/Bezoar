package milamber.brass.bezoar.client.render;

import milamber.brass.bezoar.Bezoar;
import milamber.brass.bezoar.client.model.GiantHornetModel;
import milamber.brass.bezoar.entity.mobs.AbstractGiantHornetEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FloralHornetRenderer<Type extends AbstractGiantHornetEntity> extends MobRenderer<Type, GiantHornetModel<Type>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Bezoar.MOD_ID, "textures/entity/floral_hornet.png");

    public FloralHornetRenderer(EntityRendererProvider.Context context) {
        super(context,
                new GiantHornetModel<>(
                        context.bakeLayer(new ModelLayerLocation(TEXTURE, "main")),
                        new ModelLayerLocation(TEXTURE, "main")
                ),
                .7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
}

