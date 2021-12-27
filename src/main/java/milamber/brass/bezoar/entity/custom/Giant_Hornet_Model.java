package milamber.brass.bezoar.entity.custom;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class Giant_Hornet_Model<T extends Giant_Hornet> extends EntityModel<T> {
	private final ModelRenderer jungle_hornet;

	public Giant_Hornet_Model() {
		textureWidth = 128;
		textureHeight = 64;

		jungle_hornet = new ModelRenderer(this);
		jungle_hornet.setRotationPoint(0.0F, 20.0F, -15.0F);
		setRotationAngle(jungle_hornet, -0.2182F, 0.0F, 0.0F);


		ModelRenderer body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		jungle_hornet.addChild(body);


		ModelRenderer spines_back_r1 = new ModelRenderer(this);
		spines_back_r1.setRotationPoint(0.0F, -10.0F, 16.0F);
		body.addChild(spines_back_r1);
		setRotationAngle(spines_back_r1, -1.0472F, 0.0F, 0.0F);
		spines_back_r1.setTextureOffset(21, 19).addBox(0.5F, -9.2836F, -15.0F, 0.0F, 5.0F, 11.0F, 0.0F, false);

		ModelRenderer spines_lower_r1 = new ModelRenderer(this);
		spines_lower_r1.setRotationPoint(0.0F, -10.0F, 16.0F);
		body.addChild(spines_lower_r1);
		setRotationAngle(spines_lower_r1, -1.7453F, 0.0F, 0.0F);
		spines_lower_r1.setTextureOffset(25, 23).addBox(0.5F, -5.2836F, -6.9859F, 0.0F, 5.0F, 7.0F, 0.0F, false);

		ModelRenderer stinger_r1 = new ModelRenderer(this);
		stinger_r1.setRotationPoint(0.0F, -10.0F, 16.0F);
		body.addChild(stinger_r1);
		setRotationAngle(stinger_r1, -0.3054F, 0.0F, 0.0F);
		stinger_r1.setTextureOffset(65, 0).addBox(0.5F, -0.2836F, -3.9859F, 0.0F, 13.0F, 7.0F, 0.0F, false);

		ModelRenderer abdomen_lower_r1 = new ModelRenderer(this);
		abdomen_lower_r1.setRotationPoint(0.0F, -17.0F, 17.0F);
		body.addChild(abdomen_lower_r1);
		setRotationAngle(abdomen_lower_r1, -1.7017F, 0.0F, 0.0F);
		abdomen_lower_r1.setTextureOffset(10, 0).addBox(-2.0F, -2.3768F, -0.4376F, 5.0F, 5.0F, 8.0F, 0.0F, false);

		ModelRenderer abdomen_r1 = new ModelRenderer(this);
		abdomen_r1.setRotationPoint(0.0F, -24.0F, 11.0F);
		body.addChild(abdomen_r1);
		setRotationAngle(abdomen_r1, -1.0472F, 0.0F, 0.0F);
		abdomen_r1.setTextureOffset(90, 24).addBox(-3.0F, -3.9737F, -0.5814F, 7.0F, 7.0F, 11.0F, 0.0F, false);

		ModelRenderer torso_r1 = new ModelRenderer(this);
		torso_r1.setRotationPoint(0.0F, -25.0F, 5.0F);
		body.addChild(torso_r1);
		setRotationAngle(torso_r1, -0.1309F, 0.0F, 0.0F);
		torso_r1.setTextureOffset(87, 4).addBox(-2.0F, -2.6795F, -1.1433F, 5.0F, 7.0F, 10.0F, 0.0F, false);

		ModelRenderer wing_right = new ModelRenderer(this);
		wing_right.setRotationPoint(0.0F, 0.0F, 15.0F);
		body.addChild(wing_right);


		ModelRenderer wing_right_r1 = new ModelRenderer(this);
		wing_right_r1.setRotationPoint(-2.0F, -26.0F, -8.0F);
		wing_right.addChild(wing_right_r1);
		setRotationAngle(wing_right_r1, 0.0F, -0.48F, 0.0F);
		wing_right_r1.setTextureOffset(34, 42).addBox(-10.113F, -1.0F, -0.4617F, 12.0F, 0.0F, 20.0F, 0.0F, false);

		ModelRenderer wing_left = new ModelRenderer(this);
		wing_left.setRotationPoint(-2.0F, -3.0F, 6.0F);
		body.addChild(wing_left);


		ModelRenderer wing_left_r1 = new ModelRenderer(this);
		wing_left_r1.setRotationPoint(5.0F, -24.0F, 1.0F);
		wing_left.addChild(wing_left_r1);
		setRotationAngle(wing_left_r1, 0.0F, 0.48F, 0.0F);
		wing_left_r1.setTextureOffset(35, 20).addBox(-1.9351F, 0.0F, -0.3087F, 12.0F, 0.0F, 20.0F, 0.0F, false);

		ModelRenderer head = new ModelRenderer(this);
		head.setRotationPoint(1.0F, -25.0F, 5.0F);
		body.addChild(head);
		setRotationAngle(head, -0.0873F, 0.0F, 0.0F);


		ModelRenderer madibles_left_r1 = new ModelRenderer(this);
		madibles_left_r1.setRotationPoint(2.0F, 6.1591F, -7.6438F);
		head.addChild(madibles_left_r1);
		setRotationAngle(madibles_left_r1, 0.3415F, 0.456F, 0.1553F);
		madibles_left_r1.setTextureOffset(5, 22).addBox(-0.3513F, -1.347F, -2.217F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		ModelRenderer madibles_left_r2 = new ModelRenderer(this);
		madibles_left_r2.setRotationPoint(-3.0F, 7.1591F, -6.6438F);
		head.addChild(madibles_left_r2);
		setRotationAngle(madibles_left_r2, 0.3415F, -0.456F, -0.1553F);
		madibles_left_r2.setTextureOffset(5, 22).addBox(-1.0587F, -2.6014F, -2.6624F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		ModelRenderer head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(3.0F, 0.1591F, -0.6438F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.3054F, 0.0F, 0.0F);
		head_r1.setTextureOffset(93, 46).addBox(-7.0F, -2.7296F, -8.6976F, 7.0F, 7.0F, 9.0F, 0.0F, false);

		ModelRenderer right_antennae = new ModelRenderer(this);
		right_antennae.setRotationPoint(-1.0F, 28.1591F, 6.3562F);
		head.addChild(right_antennae);


		ModelRenderer right_antennae_lower_r1 = new ModelRenderer(this);
		right_antennae_lower_r1.setRotationPoint(-7.0F, -31.0F, -12.0F);
		right_antennae.addChild(right_antennae_lower_r1);
		setRotationAngle(right_antennae_lower_r1, 0.0F, 0.0F, -0.5236F);
		right_antennae_lower_r1.setTextureOffset(0, 0).addBox(-6.3007F, -0.0792F, -0.9074F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer right_antennae_r1 = new ModelRenderer(this);
		right_antennae_r1.setRotationPoint(-2.0F, -29.0F, -12.0F);
		right_antennae.addChild(right_antennae_r1);
		setRotationAngle(right_antennae_r1, 0.0F, 0.0F, 0.3054F);
		right_antennae_r1.setTextureOffset(0, 0).addBox(-5.5859F, -0.3285F, -0.9074F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer left_antennae = new ModelRenderer(this);
		left_antennae.setRotationPoint(0.0F, 28.1591F, 6.3562F);
		head.addChild(left_antennae);


		ModelRenderer left_antennae_lower_r1 = new ModelRenderer(this);
		left_antennae_lower_r1.setRotationPoint(7.0F, -31.0F, -12.0F);
		left_antennae.addChild(left_antennae_lower_r1);
		setRotationAngle(left_antennae_lower_r1, 0.0F, 0.0F, 0.5236F);
		left_antennae_lower_r1.setTextureOffset(0, 0).addBox(-0.1993F, 0.2208F, -0.9074F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer left_antennae_r1 = new ModelRenderer(this);
		left_antennae_r1.setRotationPoint(2.0F, -29.0F, -12.0F);
		left_antennae.addChild(left_antennae_r1);
		setRotationAngle(left_antennae_r1, 0.0F, 0.0F, -0.3054F);
		left_antennae_r1.setTextureOffset(0, 0).addBox(-0.8088F, -0.37F, -0.9074F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer arms = new ModelRenderer(this);
		arms.setRotationPoint(1.0F, -20.0F, 12.0F);
		body.addChild(arms);


		ModelRenderer arm_right_lower = new ModelRenderer(this);
		arm_right_lower.setRotationPoint(-4.0F, 3.1591F, 1.3562F);
		arms.addChild(arm_right_lower);
		setRotationAngle(arm_right_lower, 0.0F, 0.0F, -0.1309F);


		ModelRenderer arm_r1 = new ModelRenderer(this);
		arm_r1.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_right_lower.addChild(arm_r1);
		setRotationAngle(arm_r1, 1.5886F, 0.6095F, 1.7491F);
		arm_r1.setTextureOffset(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer shoulder_r1 = new ModelRenderer(this);
		shoulder_r1.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_right_lower.addChild(shoulder_r1);
		setRotationAngle(shoulder_r1, 1.587F, 0.1732F, 1.7484F);
		shoulder_r1.setTextureOffset(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		ModelRenderer arm_left_lower = new ModelRenderer(this);
		arm_left_lower.setRotationPoint(4.0F, 3.1591F, 1.3562F);
		arms.addChild(arm_left_lower);
		setRotationAngle(arm_left_lower, 0.0F, 0.0F, -0.1745F);


		ModelRenderer arm_r2 = new ModelRenderer(this);
		arm_r2.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_left_lower.addChild(arm_r2);
		setRotationAngle(arm_r2, 1.5886F, 0.6095F, 1.7491F);
		arm_r2.setTextureOffset(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer shoulder_r2 = new ModelRenderer(this);
		shoulder_r2.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_left_lower.addChild(shoulder_r2);
		setRotationAngle(shoulder_r2, 1.587F, 0.1732F, 1.7484F);
		shoulder_r2.setTextureOffset(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		ModelRenderer arm_left_mid = new ModelRenderer(this);
		arm_left_mid.setRotationPoint(4.0F, 0.1591F, -0.6438F);
		arms.addChild(arm_left_mid);
		setRotationAngle(arm_left_mid, 0.0F, 0.0F, -0.1745F);


		ModelRenderer arm_r3 = new ModelRenderer(this);
		arm_r3.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_left_mid.addChild(arm_r3);
		setRotationAngle(arm_r3, 1.5886F, 0.6095F, 1.7491F);
		arm_r3.setTextureOffset(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer shoulder_r3 = new ModelRenderer(this);
		shoulder_r3.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_left_mid.addChild(shoulder_r3);
		setRotationAngle(shoulder_r3, 1.587F, 0.1732F, 1.7484F);
		shoulder_r3.setTextureOffset(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		ModelRenderer arm_right_mid = new ModelRenderer(this);
		arm_right_mid.setRotationPoint(-4.0F, 0.1591F, -0.6438F);
		arms.addChild(arm_right_mid);
		setRotationAngle(arm_right_mid, 0.0F, 0.0F, -0.1309F);


		ModelRenderer arm_r4 = new ModelRenderer(this);
		arm_r4.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_right_mid.addChild(arm_r4);
		setRotationAngle(arm_r4, 1.5886F, 0.6095F, 1.7491F);
		arm_r4.setTextureOffset(0, 0).addBox(-0.577F, 3.9163F, -0.9871F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer shoulder_r4 = new ModelRenderer(this);
		shoulder_r4.setRotationPoint(0.0F, 0.0F, -4.0F);
		arm_right_mid.addChild(shoulder_r4);
		setRotationAngle(shoulder_r4, 1.587F, 0.1732F, 1.7484F);
		shoulder_r4.setTextureOffset(0, 58).addBox(-1.2687F, 2.7014F, -1.9705F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		ModelRenderer arm_left_top = new ModelRenderer(this);
		arm_left_top.setRotationPoint(4.0F, -2.0F, -5.0F);
		arms.addChild(arm_left_top);
		setRotationAngle(arm_left_top, 0.0F, 0.0F, -0.1745F);


		ModelRenderer hand_r1 = new ModelRenderer(this);
		hand_r1.setRotationPoint(-0.1827F, 1.9681F, 0.3562F);
		arm_left_top.addChild(hand_r1);
		setRotationAngle(hand_r1, 1.5854F, -0.0013F, 1.7388F);
		hand_r1.setTextureOffset(0, 0).addBox(2.0013F, -2.7525F, -1.3579F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer arm_r5 = new ModelRenderer(this);
		arm_r5.setRotationPoint(-0.1827F, 1.9681F, 0.3562F);
		arm_left_top.addChild(arm_r5);
		setRotationAngle(arm_r5, 1.5886F, 0.6095F, 1.7491F);
		arm_r5.setTextureOffset(0, 0).addBox(-0.747F, -1.0802F, -1.3579F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer shoulder_r5 = new ModelRenderer(this);
		shoulder_r5.setRotationPoint(-0.1827F, 1.9681F, 0.3562F);
		arm_left_top.addChild(shoulder_r5);
		setRotationAngle(shoulder_r5, 1.587F, 0.1732F, 1.7484F);
		shoulder_r5.setTextureOffset(0, 58).addBox(-3.5347F, -1.7552F, -2.3562F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		ModelRenderer arm_right_top = new ModelRenderer(this);
		arm_right_top.setRotationPoint(-4.0F, -3.0567F, -3.4821F);
		arms.addChild(arm_right_top);
		setRotationAngle(arm_right_top, 0.0F, 0.0F, -0.1745F);


		ModelRenderer hand_r2 = new ModelRenderer(this);
		hand_r2.setRotationPoint(-0.3662F, 3.0088F, -1.1617F);
		arm_right_top.addChild(hand_r2);
		setRotationAngle(hand_r2, 1.5854F, -0.0013F, 1.7388F);
		hand_r2.setTextureOffset(0, 0).addBox(2.0013F, -2.7525F, -0.9091F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer arm_r6 = new ModelRenderer(this);
		arm_r6.setRotationPoint(-0.3662F, 3.0088F, -1.1617F);
		arm_right_top.addChild(arm_r6);
		setRotationAngle(arm_r6, 1.5886F, 0.6095F, 1.7491F);
		arm_r6.setTextureOffset(0, 0).addBox(-0.747F, -1.0802F, -0.9091F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer shoulder_r6 = new ModelRenderer(this);
		shoulder_r6.setRotationPoint(-0.3662F, 3.0088F, -1.1617F);
		arm_right_top.addChild(shoulder_r6);
		setRotationAngle(shoulder_r6, 1.587F, 0.1732F, 1.7484F);
		shoulder_r6.setTextureOffset(0, 58).addBox(-3.5347F, -1.7552F, -1.9074F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Giant_Hornet entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}


	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		jungle_hornet.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}