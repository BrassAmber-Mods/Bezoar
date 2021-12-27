package milamber.brass.bezoar.client.entity;


import milamber.brass.bezoar.entity.item.Trophy_Frame;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Trophy_Frame_Renderer extends EntityRenderer<Trophy_Frame> {
    private static final ModelResourceLocation LOCATION_MODEL = new ModelResourceLocation("trophy");
    private static final ModelResourceLocation LOCATION_MODEL_MAP = new ModelResourceLocation("trophy");
    private final Minecraft mc = Minecraft.getInstance();
    private final net.minecraft.client.renderer.ItemRenderer itemRenderer;

    public Trophy_Frame_Renderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
        super(renderManagerIn);
        this.itemRenderer = itemRendererIn;
    }

    public void render(Trophy_Frame entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        Direction direction = entityIn.getHorizontalFacing();
        Vector3d vector3d = this.getRenderOffset(entityIn, partialTicks);
        matrixStackIn.translate(-vector3d.getX(), -vector3d.getY(), -vector3d.getZ());
        double d0 = 0.46875D;
        matrixStackIn.translate((double)direction.getXOffset() * 0.46875D, (double)direction.getYOffset() * 0.46875D, (double)direction.getZOffset() * 0.46875D);
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(entityIn.rotationPitch));
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - entityIn.rotationYaw));
        boolean flag = entityIn.isInvisible();
        if (!flag) {
            BlockRendererDispatcher blockrendererdispatcher = this.mc.getBlockRendererDispatcher();
            ModelManager modelmanager = blockrendererdispatcher.getBlockModelShapes().getModelManager();
            ModelResourceLocation modelresourcelocation = entityIn.getDisplayedItem().getItem() instanceof FilledMapItem ? LOCATION_MODEL_MAP : LOCATION_MODEL;
            matrixStackIn.push();
            matrixStackIn.translate(-0.5D, -0.5D, -0.5D);
            blockrendererdispatcher.getBlockModelRenderer().renderModelBrightnessColor(matrixStackIn.getLast(), bufferIn.getBuffer(Atlases.getSolidBlockType()), (BlockState)null, modelmanager.getModel(modelresourcelocation), 1.0F, 1.0F, 1.0F, packedLightIn, OverlayTexture.NO_OVERLAY);
            matrixStackIn.pop();
        }

        ItemStack itemstack = entityIn.getDisplayedItem();
        if (!itemstack.isEmpty()) {
            MapData mapdata = FilledMapItem.getMapData(itemstack, entityIn.world);
            if (flag) {
                matrixStackIn.translate(0.0D, 0.0D, 0.5D);
            } else {
                matrixStackIn.translate(0.0D, 0.0D, 0.4375D);
            }

            int i = mapdata != null ? entityIn.getRotation() % 4 * 2 : entityIn.getRotation();
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees((float)i * 360.0F / 8.0F));
            if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new milamber.brass.bezoar.events.RenderItemInTrophyFrameEvent(entityIn, this, matrixStackIn, bufferIn, packedLightIn))) {
                if (mapdata != null) {
                    matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180.0F));
                    float f = 0.0078125F;
                    matrixStackIn.scale(0.0078125F, 0.0078125F, 0.0078125F);
                    matrixStackIn.translate(-64.0D, -64.0D, 0.0D);
                    matrixStackIn.translate(0.0D, 0.0D, -1.0D);
                    if (mapdata != null) {
                        this.mc.gameRenderer.getMapItemRenderer().renderMap(matrixStackIn, bufferIn, mapdata, true, packedLightIn);
                    }
                } else {
                    matrixStackIn.scale(0.5F, 0.5F, 0.5F);
                    this.itemRenderer.renderItem(itemstack, ItemCameraTransforms.TransformType.FIXED, packedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
                }
            }
        }

        matrixStackIn.pop();
    }

    public Vector3d getRenderOffset(Trophy_Frame entityIn, float partialTicks) {
        return new Vector3d((double)((float)entityIn.getHorizontalFacing().getXOffset() * 0.3F), -0.25D, (double)((float)entityIn.getHorizontalFacing().getZOffset() * 0.3F));
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(Trophy_Frame entity) {
        return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
    }

    protected boolean canRenderName(Trophy_Frame entity) {
        if (Minecraft.isGuiEnabled() && !entity.getDisplayedItem().isEmpty() && entity.getDisplayedItem().hasDisplayName() && this.renderManager.pointedEntity == entity) {
            double d0 = this.renderManager.squareDistanceTo(entity);
            float f = entity.isDiscrete() ? 32.0F : 64.0F;
            return d0 < (double)(f * f);
        } else {
            return false;
        }
    }

    protected void renderName(Trophy_Frame entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.renderName(entityIn, entityIn.getDisplayedItem().getDisplayName(), matrixStackIn, bufferIn, packedLightIn);
    }
}
