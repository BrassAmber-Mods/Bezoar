package milamber.brass.bezoar.entity.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Trophy_Frame_Model<T extends Trophy_Frame> extends EntityModel {
    private final ModelRenderer trophy;

    public Trophy_Frame_Model() {
        textureWidth = 128;
        textureHeight = 64;

        trophy = new ModelRenderer(this);
        trophy.setRotationPoint(0.0F, 27.0F, 0.0F);
        trophy.setTextureOffset(0, 0).addBox(-16.0F, -32.0F, 0.0F, 32.0F, 12.0F, 1.0F, 0.0F, false);
        trophy.setTextureOffset(0, 13).addBox(-14.0F, -20.0F, 0.0F, 28.0F, 7.0F, 1.0F, 0.0F, false);
        trophy.setTextureOffset(0, 21).addBox(-12.0F, -13.0F, 0.0F, 24.0F, 4.0F, 1.0F, 0.0F, false);
        trophy.setTextureOffset(0, 26).addBox(-9.0F, -9.0F, 0.0F, 18.0F, 3.0F, 1.0F, 0.0F, false);
        trophy.setTextureOffset(0, 30).addBox(-7.0F, -6.0F, 0.0F, 14.0F, 2.0F, 1.0F, 0.0F, false);
        trophy.setTextureOffset(0, 33).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        trophy.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

