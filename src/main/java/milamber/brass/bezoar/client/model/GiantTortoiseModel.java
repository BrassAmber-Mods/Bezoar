package milamber.brass.bezoar.client.model;// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import milamber.brass.bezoar.Bezoar;
import milamber.brass.bezoar.entity.mobs.GiantTortoiseEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class GiantTortoiseModel<Type extends GiantTortoiseEntity> extends EntityModel<Type> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ResourceLocation TEXTURE = new ResourceLocation(Bezoar.MOD_ID, "textures/entity/giant_tortoise.png");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(TEXTURE, "main");
	private final ModelPart turtle;

	public GiantTortoiseModel(ModelPart root) {
		this.turtle = root.getChild("turtle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition turtle = partdefinition.addOrReplaceChild("turtle", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, -1.0F));

		PartDefinition body = turtle.addOrReplaceChild("body", CubeListBuilder.create().texOffs(14, 74).addBox(-27.5F, -12.0F, 4.0F, 38.0F, 40.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(176, 14).addBox(-23.5F, -9.0F, 16.0F, 30.0F, 32.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(184, 50).addBox(-8.5F, -16.0F, 2.0F, 0.0F, 52.0F, 26.0F, new CubeDeformation(0.0F))
				.texOffs(62, 2).addBox(-19.5F, -12.0F, -1.0F, 22.0F, 36.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -5.0F, 1.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition head = turtle.addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 0).addBox(-5.5F, -12.0F, -12.0F, 12.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -11.0F));

		PartDefinition leg_r_front = turtle.addOrReplaceChild("leg_r_front", CubeListBuilder.create().texOffs(128, 24).addBox(-15.0F, -7.0F, -17.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -2.0F, 10.0F));

		PartDefinition leg_l_front = turtle.addOrReplaceChild("leg_l_front", CubeListBuilder.create().texOffs(128, 0).addBox(8.0F, -7.0F, -17.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -2.0F, 10.0F));

		PartDefinition leg_l_back = turtle.addOrReplaceChild("leg_l_back", CubeListBuilder.create().texOffs(129, 0).addBox(16.5F, -6.0F, 24.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -3.0F, -5.0F));

		PartDefinition leg_r_back = turtle.addOrReplaceChild("leg_r_back", CubeListBuilder.create().texOffs(128, 24).addBox(-11.5F, -6.0F, 12.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -3.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		turtle.render(poseStack, buffer, packedLight, packedOverlay);
	}
}