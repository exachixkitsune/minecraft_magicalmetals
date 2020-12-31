package net.exachixkitsune.magicalmetals.mobs.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.exachixkitsune.magicalmetals.mobs.Butterfly_Entity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class Butterfly_Model<T extends Butterfly_Entity> extends EntityModel<T> {

	public ModelRenderer body;
	public ModelRenderer lwing;
	public ModelRenderer rwing;
	
	public Butterfly_Model() {
		textureWidth = 20;
		textureHeight = 23;
		
		// Initial version from https://github.com/McJty/YouTubeModding14/blob/master/src/main/java/com/mcjty/mytutorial/entities/WeirdMobModel.java
		// Using same sort of multibox system as https://github.com/MysticMods/MysticalWorld/blob/1.16/src/main/java/epicsquid/mysticalworld/entity/model/OwlModel.java
		body = new ModelRenderer(this, 0, 0);
		body.addBox(-2, 16, -3, 4, 4, 6);
		lwing = new ModelRenderer(this, 0, 10);
		lwing.setRotationPoint(2, 16, 0);
		lwing.setTextureOffset(0, 18).addBox(0, 0,  1, 4, 1, 4, 0, 0, 0);
		lwing.setTextureOffset(0, 16).addBox(0, 0,  0, 3, 1, 1);
		lwing.setTextureOffset(0, 10).addBox(0, 0, -5, 5, 1, 5);
		rwing = new ModelRenderer(this, 0, 10);
		rwing.setRotationPoint(-2, 16, 0);
		rwing.setTextureOffset(0, 18).addBox(-4, 0,  1, 4, 1, 4, true);
		rwing.setTextureOffset(0, 16).addBox(-3, 0,  0, 3, 1, 1, true);
		rwing.setTextureOffset(0, 10).addBox(-5, 0, -5, 5, 1, 5, true);
	}
	
	// Flap Parameters
	final static float flapsize_large = (2.0F/8.0F) * (float)Math.PI;
	final static float flapsize_small = (0.5F/8.0F) * (float)Math.PI;
	final static float flapspeed_slow = 2 * 20;
	final static float flapspeed_fast = 5;
	
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch) {
		// Auto-generated method stub
		// Set the wing angles
		// If sat, wing angles are up
		float wingangle = 0.0F;
		if (entityIn.isOnGround()) {
			wingangle = flapsize_small * (float)Math.sin( ageInTicks / flapspeed_slow );
		}
		else {
			wingangle = flapsize_large * (float)Math.sin( ageInTicks / flapspeed_fast );
		}
		rwing.rotateAngleZ = wingangle;
		// link the two
		lwing.rotateAngleZ = -1.0F * rwing.rotateAngleZ;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		lwing.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		rwing.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

}
