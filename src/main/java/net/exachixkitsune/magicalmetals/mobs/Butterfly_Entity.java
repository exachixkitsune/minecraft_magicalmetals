package net.exachixkitsune.magicalmetals.mobs;

import javax.annotation.Nullable;

import net.exachixkitsune.magicalmetals.mobs.goals.Butterfly_Goal_SitOnHome;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public abstract class Butterfly_Entity extends AnimalEntity implements IFlyingAnimal {
	// Tree-focused butterfly.
		// Flies around, never going more than NUM_BLOCKS_FROM_HOME from it's home.
		// When it finds a sapling, stops at it 
		
		protected static final int maxRangeFromHome = 16;
		protected static final double goalSpeed = 0.5;
		private static final int initialAge = 5*60*20; // Age is 300 seconds/ 5 minutes
		protected static final int pollinateRechargeMax = 5*20; // Pollinate once every 5 seconds.
		protected int currentPollinateRecharge = 0; // Pollinate recharge counter - needs to be 0 to allow for pollination
		protected static final int pollinateChargeTime = 1*20; // Needs to be near an object for 1s to pollinate
		protected int currentPollinateCharge = 0; // Timer that a butterfly needs to be near an object for it to be grown
		protected BlockPos targetPos = null;
		
		public Butterfly_Entity(EntityType<? extends AnimalEntity> type, World worldIn) {
			super(type, worldIn);
			
			// Make it fly!
			// taken from mysticalworld:OwlEntity
			this.moveController = new FlyingMovementController(this, 5, false);
			
			// Give no XP on death to prevent farming
			this.experienceValue = 0;
			
			// Using the following property in order to give the mob a max age 
			this.setGrowingAge(initialAge);
			
			// Pollination values
			currentPollinateRecharge= 0;
			currentPollinateCharge = pollinateChargeTime;
			targetPos = null;
		}

		// Copied from
		// https://github.com/MysticMods/MysticalWorld/blob/1.16/src/main/java/epicsquid/mysticalworld/entity/OwlEntity.java
		// This is what I needed to make flying ACTUALLY work
		@Override
		protected PathNavigator createNavigator(World worldIn) {
			FlyingPathNavigator pathnavigateflying = new FlyingPathNavigator(this, worldIn);
			pathnavigateflying.setCanOpenDoors(false);
			pathnavigateflying.setCanEnterDoors(true);
			pathnavigateflying.setCanSwim(false);
			return pathnavigateflying;
		}
		
		// Same as createNavigator, taken from mysticalworld:OwlEntity
		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		
		// Don't make a sound on death/hit
		@Override
		protected SoundEvent getDeathSound() {
			return null;
		}

		@Override
		protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
			return null;
		}

		public void setHomePos(BlockPos newHome) {
			this.setHomePosAndDistance(newHome, maxRangeFromHome);
		}

		@Override
		public void livingTick() {
			super.livingTick();
			if (!world.isRemote()) {
				int myAge = this.getGrowingAge();
				if (myAge == 0) {
					// Kill via 0 health - remove doesn't do pretty effects =(
					this.setHealth(0);
				}

				if (this.getHomePosition().withinDistance(new BlockPos(0, 0, 0), 1.0)) {
					this.setHealth(0);
				}
				
				
				if (currentPollinateRecharge > 0 ) {
					// Decrement currentPollinateCharge
					--currentPollinateRecharge;
				}
				else {
					// Can Pollinate
					// Is the target not null
					if (targetPos != null) {
						if (targetPos.distanceSq(this.getPosition()) < (9.0D)) {
							// Close enough!
							// Is the object a sapling still?
							BlockState thisBlockState = world.getBlockState(targetPos);
							Block thisBlock = thisBlockState.getBlock();
							if (PollinateBlockCheck(thisBlock)) {
								
								--currentPollinateCharge;
								if (currentPollinateCharge <= 0) {
									doPollinate(thisBlock, thisBlockState);
								}
							} else {
								// If it's not valid, remove it as the target
								this.setTargetPos(null);
								currentPollinateCharge = pollinateChargeTime;
							}
						}
					}
				}
			}
		}
		
		// PollinateBlockCheck is ran BEFORE doPollinate, so you can do type conversions in doPollinate safely.
		// Unless you use these in a different way
		protected abstract boolean PollinateBlockCheck(Block thisBlock);
		protected abstract void doPollinate(Block thisBlock, BlockState thisBlockState);
		
		@Nullable
		@Override
		public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
			// Auto-generated method stub
			return null;
		}
		
		public void setTargetPos(BlockPos newTarget) {
			targetPos = newTarget;
		}
		
		@Override
		protected void registerGoals() {
			// Goal are:
			this.goalSelector.addGoal(1, new PanicGoal(this, goalSpeed));
			// Number 2 goals should be the specific search goal for a butterfly.
			this.goalSelector.addGoal(3, new Butterfly_Goal_SitOnHome(this, goalSpeed, maxRangeFromHome, 5));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, goalSpeed));
		}
		
		// When the server shuts down, this entity should be deleted
		// Why? Because otherwise the blocks recreate this entity.
		
}
