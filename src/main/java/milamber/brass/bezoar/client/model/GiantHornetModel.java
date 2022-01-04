package milamber.brass.bezoar.client.model;// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import milamber.brass.bezoar.entity.AbstractGiantHornetEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GiantHornetModel<Type extends AbstractGiantHornetEntity> extends EntityModel<Type> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static ModelLayerLocation LAYER_LOCATION;
	private final ModelPart hornet;

	public GiantHornetModel(ModelPart root, ModelLayerLocation location) {
		this.hornet = root.getChild("jungle_hornet");
		this.LAYER_LOCATION = location;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition jungle_hornet = partdefinition.addOrReplaceChild("jungle_hornet", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 20.0F, -15.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition body = jungle_hornet.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition spines_back_r1 = body.addOrReplaceChild("spines_back_r1", CubeListBuilder.create().texOffs(21, 19).addBox(0.5F, -9.2836F, -15.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 16.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition spines_lower_r1 = body.addOrReplaceChild("spines_lower_r1", CubeListBuilder.create().texOffs(25, 23).addBox(0.5F, -5.2836F, -6.9859F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 16.0F, -1.7453F, 0.0F, 0.0F));

		PartDefinition stinger_r1 = body.addOrReplaceChild("stinger_r1", CubeListBuilder.create().texOffs(65, 0).addBox(0.5F, -0.2836F, -3.9859F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 16.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition abdomen_lower_r1 = body.addOrReplaceChild("abdomen_lower_r1", CubeListBuilder.create().texOffs(10, 0).addBox(-2.0F, -2.3768F, -0.4376F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 17.0F, -1.7017F, 0.0F, 0.0F));

		PartDefinition abdomen_r1 = body.addOrReplaceChild("abdomen_r1", CubeListBuilder.create().texOffs(90, 24).addBox(-3.0F, -3.9737F, -0.5814F, 7.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 11.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition torso_r1 = body.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(87, 4).addBox(-2.0F, -2.6795F, -1.1433F, 5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.0F, 5.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition wing_right = body.addOrReplaceChild("wing_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 15.0F));

		PartDefinition wing_right_r1 = wing_right.addOrReplaceChild("wing_right_r1", CubeListBuilder.create().texOffs(34, 42).addBox(-10.113F, -1.0F, -0.4617F, 12.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -26.0F, -8.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition wing_left = body.addOrReplaceChild("wing_left", CubeListBuilder.create(), PartPose.offset(-2.0F, -3.0F, 6.0F));

		PartDefinition wing_left_r1 = wing_left.addOrReplaceChild("wing_left_r1", CubeListBuilder.create().texOffs(35, 20).addBox(-1.9351F, 0.0F, -0.3087F, 12.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -24.0F, 1.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -25.0F, 5.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition madibles_left_r1 = head.addOrReplaceChild("madibles_left_r1", CubeListBuilder.create().texOffs(5, 22).addBox(-0.3513F, -1.347F, -2.217F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 6.1591F, -7.6438F, 0.3415F, 0.456F, 0.1553F));

		PartDefinition madibles_left_r2 = head.addOrReplaceChild("madibles_left_r2", CubeListBuilder.create().texOffs(5, 22).addBox(-1.0587F, -2.6014F, -2.6624F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 7.1591F, -6.6438F, 0.3415F, -0.456F, -0.1553F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(93, 46).addBox(-7.0F, -2.7296F, -8.6976F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.1591F, -0.6438F, 0.3054F, 0.0F, 0.0F));

		PartDefinition right_antennae = head.addOrReplaceChild("right_antennae", CubeListBuilder.create(), PartPose.offset(-1.0F, 28.1591F, 6.3562F));

		PartDefinition right_antennae_lower_r1 = right_antennae.addOrReplaceChild("right_antennae_lower_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.3007F, -0.0792F, -0.9074F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -31.0F, -12.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition right_antennae_r1 = right_antennae.addOrReplaceChild("right_antennae_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5859F, -0.3285F, -0.9074F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -29.0F, -12.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition left_antennae = head.addOrReplaceChild("left_antennae", CubeListBuilder.create(), PartPose.offset(0.0F, 28.1591F, 6.3562F));

		PartDefinition left_antennae_lower_r1 = left_antennae.addOrReplaceChild("left_antennae_lower_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1993F, 0.2208F, -0.9074F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -31.0F, -12.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition left_antennae_r1 = left_antennae.addOrReplaceChild("left_antennae_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8088F, -0.37F, -0.9074F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -29.0F, -12.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(1.0F, -20.0F, 12.0F));

		PartDefinition arm_right_lower = arms.addOrReplaceChild("arm_right_lower", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 3.1591F, 1.3562F, 0.0F, 0.0F, -0.1309F));

		PartDefinition arm_r1 = arm_right_lower.addOrReplaceChild("arm_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.5886F, 0.6095F, 1.7491F));

		PartDefinition shoulder_r1 = arm_right_lower.addOrReplaceChild("shoulder_r1", CubeListBuilder.create().texOffs(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.587F, 0.1732F, 1.7484F));

		PartDefinition arm_left_lower = arms.addOrReplaceChild("arm_left_lower", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 3.1591F, 1.3562F, 0.0F, 0.0F, -0.1745F));

		PartDefinition arm_r2 = arm_left_lower.addOrReplaceChild("arm_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.5886F, 0.6095F, 1.7491F));

		PartDefinition shoulder_r2 = arm_left_lower.addOrReplaceChild("shoulder_r2", CubeListBuilder.create().texOffs(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.587F, 0.1732F, 1.7484F));

		PartDefinition arm_left_mid = arms.addOrReplaceChild("arm_left_mid", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 0.1591F, -0.6438F, 0.0F, 0.0F, -0.1745F));

		PartDefinition arm_r3 = arm_left_mid.addOrReplaceChild("arm_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.5886F, 0.6095F, 1.7491F));

		PartDefinition shoulder_r3 = arm_left_mid.addOrReplaceChild("shoulder_r3", CubeListBuilder.create().texOffs(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.587F, 0.1732F, 1.7484F));

		PartDefinition arm_right_mid = arms.addOrReplaceChild("arm_right_mid", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 0.1591F, -0.6438F, 0.0F, 0.0F, -0.1309F));

		PartDefinition arm_r4 = arm_right_mid.addOrReplaceChild("arm_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.5886F, 0.6095F, 1.7491F));

		PartDefinition shoulder_r4 = arm_right_mid.addOrReplaceChild("shoulder_r4", CubeListBuilder.create().texOffs(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 1.587F, 0.1732F, 1.7484F));

		PartDefinition arm_left_top = arms.addOrReplaceChild("arm_left_top", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, -2.0F, -5.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition hand_r1 = arm_left_top.addOrReplaceChild("hand_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.0013F, -2.7525F, -1.3579F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1827F, 1.9681F, 0.3562F, 1.5854F, -0.0013F, 1.7388F));

		PartDefinition arm_r5 = arm_left_top.addOrReplaceChild("arm_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.747F, -1.0802F, -1.3579F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1827F, 1.9681F, 0.3562F, 1.5886F, 0.6095F, 1.7491F));

		PartDefinition shoulder_r5 = arm_left_top.addOrReplaceChild("shoulder_r5", CubeListBuilder.create().texOffs(0, 58).addBox(-3.5347F, -1.7552F, -2.3562F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1827F, 1.9681F, 0.3562F, 1.587F, 0.1732F, 1.7484F));

		PartDefinition arm_right_top = arms.addOrReplaceChild("arm_right_top", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -3.0567F, -3.4821F, 0.0F, 0.0F, -0.1745F));

		PartDefinition hand_r2 = arm_right_top.addOrReplaceChild("hand_r2", CubeListBuilder.create().texOffs(0, 0).addBox(2.0013F, -2.7525F, -0.9091F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3662F, 3.0088F, -1.1617F, 1.5854F, -0.0013F, 1.7388F));

		PartDefinition arm_r6 = arm_right_top.addOrReplaceChild("arm_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-0.747F, -1.0802F, -0.9091F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3662F, 3.0088F, -1.1617F, 1.5886F, 0.6095F, 1.7491F));

		PartDefinition shoulder_r6 = arm_right_top.addOrReplaceChild("shoulder_r6", CubeListBuilder.create().texOffs(0, 58).addBox(-3.5347F, -1.7552F, -1.9074F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3662F, 3.0088F, -1.1617F, 1.587F, 0.1732F, 1.7484F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hornet.render(poseStack, buffer, packedLight, packedOverlay);
	}
}