package se7kn8.realreactors.common.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import se7kn8.realreactors.RealReactors;

import javax.annotation.Nonnull;

public class AlkaliMetalItemEntity extends EntityItem {

	private int airReactionTime = 100;
	private int waterReactionTime = 100;
	private int airExplosionMultiplier = 10;
	private int waterExplosionMultiplier = 10;
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
		setPickupDelay(100);
	}

	public AlkaliMetalItemEntity(World world, double x, double y, double z) {
		super(world, x, y, z);
		setPickupDelay(100);
	}

	public AlkaliMetalItemEntity(World world, double x, double y, double z, ItemStack stack) {
		super(world, x, y, z, stack);
		setPickupDelay(100);
	}

	@Override
	public boolean attackEntityFrom(@Nonnull DamageSource source, float amount) {
		return false;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
		RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
		RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);

		if (this.world.getBlockState(getPosition()).getBlock() == Blocks.WATER) {
			RealReactors.proxy.spawnParticle(EnumParticleTypes.SMOKE_LARGE, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
			RealReactors.proxy.spawnParticle(EnumParticleTypes.FLAME, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);
			RealReactors.proxy.spawnParticle(EnumParticleTypes.FLAME, posX + rand(), posY, posZ + rand(), 0, 0.1, 0);

			if(getAge() > waterReactionTime){
				world.setBlockState(getPosition(), Blocks.AIR.getDefaultState());
				world.createExplosion(this, posX, posY, posZ, waterExplosionMultiplier, true);
				this.setDead();
				if(waterReactionStack != ItemStack.EMPTY){
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

	}

	private double rand() {
		double rand = Math.random();


		if (Math.random() < 0.5) {
			rand = -rand;
			rand+=0.2;
		}else{
			rand-=0.2;
		}

		return rand;
	}

}
