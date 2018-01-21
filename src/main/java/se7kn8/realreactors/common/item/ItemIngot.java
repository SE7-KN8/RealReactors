package se7kn8.realreactors.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import se7kn8.realreactors.common.entity.item.AlkaliMetalItemEntity;

import javax.annotation.Nullable;

public class ItemIngot extends ItemMeta {

	public static final String[] SUBTYPES = new String[]{
			/* 0 */ "boron",
			/* 1 */ "boron_steel",
			/* 2 */ "chromium",
			/* 3 */ "chromium_steel",
			/* 4 */ "graphite",
			/* 5 */ "potassium",
			/* 6 */ "sodium",
			/* 7 */ "steel"};

	public ItemIngot() {
		super("ingot", SUBTYPES);
	}

	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		switch (stack.getItemDamage()){
			case 5:
			case 6:
				return true;
			default:
				return false;
		}
	}

	@Nullable
	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) {
		switch (itemstack.getItemDamage()){
			case 5:
				return new AlkaliMetalItemEntity(world, location.posX, location.posY, location.posZ, itemstack)
						.setAirExplosionMultiplier(2)
						.setWaterExplosionMultiplier(20)
						.setAirReactionTime(250)
						.setWaterReactionTime(50);
			case 6:
				return new AlkaliMetalItemEntity(world, location.posX, location.posY, location.posZ, itemstack)
						.setAirExplosionMultiplier(1)
						.setWaterExplosionMultiplier(10)
						.setAirReactionTime(500)
						.setWaterReactionTime(50);
			default:
				return null;
		}
	}
}
