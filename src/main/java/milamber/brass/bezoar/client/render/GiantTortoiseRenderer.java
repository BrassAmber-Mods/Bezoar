package milamber.brass.bezoar.client.render;

import milamber.brass.bezoar.client.model.GiantTortoiseModel;
import milamber.brass.bezoar.entity.mobs.GiantTortoiseEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GiantTortoiseRenderer <Type extends GiantTortoiseEntity> extends MobRenderer<Type, GiantTortoiseModel<Type>> {

    public GiantTortoiseRenderer(EntityRendererProvider.Context context) {
        super(context,
                new GiantTortoiseModel<>(context.bakeLayer(
                        GiantTortoiseModel.LAYER_LOCATION)
                ), .7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return GiantTortoiseModel.TEXTURE;
    }
}
