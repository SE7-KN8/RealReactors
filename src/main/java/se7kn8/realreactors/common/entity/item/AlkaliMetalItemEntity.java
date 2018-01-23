package se7kn8.realreactors.common.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import se7kn8.realreactors.RealReactors;

import javax.annotation.Nonnull;

public class AlkaliMetalItemEntity extends EntityItem {

	private int airReactionTime;
	private int waterReactionTime;
	private int airExplosionMultiplier;
	private int waterExplosionMultiplier;
	private ItemStack airReactionStack = ItemStack.EMPTY;
	private ItemStack waterReactionStack = ItemStack.EMPTY;

	public AlkaliMetalItemEntity setWaterExplosionMultiplier(int waterExplosionMultiplier) {
		this.waterExplosionMultiplier = waterExplosionMultiplier;
		return this;
	}

	public AlkaliMetalItemEntity setAirExplosionMultiplier(int airExplosionMultiplier) {
		this.airExplosionMultiplier = airExplosionMultiplier;
		return this;
	}

	public AlkaliMetalItemEntity setAirReactionTime(int airReactionTime) {
		this.airReactionTime = airReactionTime;
		return this;
	}

	public AlkaliMetalItemEntity setWaterReactionTime(int waterReactionTime) {
		this.waterReactionTime = waterReactionTime;
		return this;
	}

	public AlkaliMetalItemEntity setAirReactionStack(ItemStack airReactionStack) {
		this.airReactionStack = airReactionStack;
		return this;
	}

	public AlkaliMetalItemEntity setWaterReactionStack(ItemStack waterReactionStack) {
		this.waterReactionStack = waterReactionStack;
		return this;
	}

	public AlkaliMetalItemEntity(World world) {
		super(world);
	}

	public AlkaliMetalItemEntity(World world, double x, double y, double z, double motX, double motY, double motZ, ItemStack stack) {
		super(world, x, y, z, stack);
		this.motionX = motX;
		this.motionY = motY;
		this.motionZ = motZ;
		setPickupDelay(40);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		boolean isInWater = this.world.getBlockState(getPosition()).getBlock() == Blocks.WATER;

		if (RealReactors.isEffectiveServer()) {
			System.out.println("water: " + waterReactionTime);
			System.out.println("air: " + airReactionTime);
			System.out.println("age: " + getAge());

			if (isInWater) {
				if (getAge() > waterReactionTime) {
					world.setBlockState(getPosition(), Blocks.AIR.getDefaultState());
					world.createExplosion(this, posX, posY, posZ, waterExplosionMultiplier, true);
					this.setDead();
					if (waterReactionStack != ItemStack.EMPTY) {
						EntityItem item = new EntityItem(world, posX, posY, posZ, waterReactionStack);
						world.spawnEntity(item);
					}

				}

			} else if (getAge() > airReactionTime) {
				world.createExplosion(this, posX, posY, posZ, airExplosionMultiplier, true);
				this.setDead();
				if (airReactionStack != ItemStack.EMPTY) {
					EntityItem item = new EntityItem(world, posX, posY, posZ, airReactionStack);
					world.spawnEntity(item);
				}
			}
		} else {

			RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
			RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
			RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);

			if (isInWater) {
				RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_LARGE, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
				RealReactors.proxy.spawnParticle(EnumParticleTypes.FLAME, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
				RealReactors.proxy.spawnParticle(EnumParticleTypes.FLAME, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
			}
		}
	}

	private double rand() {
		double rand = Math.random();


		if (Math.random() < 0.5) {
			rand = -rand;
			rand += 0.2;
		} else {
			rand -= 0.2;
		}

		return rand;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		NBTTagCompound tagCompound = new NBTTagCompound();
		tagCompound.setInteger("airReactionTime", airReactionTime);
		tagCompound.setInteger("airExplosionMultiplier", airExplosionMultiplier);
		tagCompound.setInteger("waterReactionTime", waterReactionTime);
		tagCompound.setInteger("waterExplosionMultiplier", waterExplosionMultiplier);

		NBTTagCompound airReactionStackCompound = new NBTTagCompound();
		airReactionStack.writeToNBT(airReactionStackCompound);
		tagCompound.setTag("airReactionStack", airReactionStackCompound);

		NBTTagCompound waterReactionStackCompound = new NBTTagCompound();
		waterReactionStack.writeToNBT(waterReactionStackCompound);
		tagCompound.setTag("waterReactionStack", waterReactionStackCompound);

		compound.setTag("alkaliMetal", tagCompound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		NBTTagCompound tagCompound = compound.getCompoundTag("alkaliMetal");
		airReactionTime = tagCompound.getInteger("airReactionTime");
		airExplosionMultiplier = tagCompound.getInteger("airExplosionMultiplier");
		waterReactionTime = tagCompound.getInteger("waterReactionTime");
		waterExplosionMultiplier = tagCompound.getInteger("waterExplosionMultiplier");

		NBTTagCompound airReactionStackCompound = tagCompound.getCompoundTag("airReactionStack");
		NBTTagCompound waterReactionStackCompound = tagCompound.getCompoundTag("waterReactionStack");

		airReactionStack = new ItemStack(airReactionStackCompound);
		waterReactionStack = new ItemStack(waterReactionStackCompound);
	}

	@Override
	public boolean isEntityInvulnerable(@Nonnull DamageSource source) {
		return true;
	}
}
