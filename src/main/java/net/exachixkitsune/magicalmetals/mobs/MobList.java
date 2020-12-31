package net.exachixkitsune.magicalmetals.mobs;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

public class MobList {
	// I'm using the same sort of idea as Botania here
	public static final EntityType<Butterfly_Tree_Entity> BUTTERFLY_TREE = EntityType.Builder.<Butterfly_Tree_Entity>create(
			Butterfly_Tree_Entity::new, EntityClassification.CREATURE)
			.size(0.5f, 0.5f)
			.setShouldReceiveVelocityUpdates(false)
			.build("");
	public static final EntityType<Butterfly_Crop_Entity> BUTTERFLY_CROP = EntityType.Builder.<Butterfly_Crop_Entity>create(
			Butterfly_Crop_Entity::new, EntityClassification.CREATURE)
			.size(0.5f, 0.5f)
			.setShouldReceiveVelocityUpdates(false)
			.build("");
	public static final EntityType<Butterfly_Grass_Entity> BUTTERFLY_GRASS = EntityType.Builder.<Butterfly_Grass_Entity>create(
			Butterfly_Grass_Entity::new, EntityClassification.CREATURE)
			.size(0.5f, 0.5f)
			.setShouldReceiveVelocityUpdates(false)
			.build("");
	
	public static void setup() {
		GlobalEntityTypeAttributes.put(BUTTERFLY_TREE, MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 10)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 1)
				.createMutableAttribute(Attributes.FLYING_SPEED, 1)
				.create());
		GlobalEntityTypeAttributes.put(BUTTERFLY_CROP, MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 10)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 1)
				.createMutableAttribute(Attributes.FLYING_SPEED, 1)
				.create());
		GlobalEntityTypeAttributes.put(BUTTERFLY_GRASS, MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 10)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 1)
				.createMutableAttribute(Attributes.FLYING_SPEED, 1)
				.create());
	}
}
