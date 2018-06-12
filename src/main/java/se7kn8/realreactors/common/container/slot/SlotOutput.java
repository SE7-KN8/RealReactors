package se7kn8.realreactors.common.container.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class SlotOutput extends SlotItemHandler {
	private EntityPlayer player;
	private int removeCount;

	public SlotOutput(IItemHandler itemHandler, int index, int xPosition, int yPosition, EntityPlayer player) {
		super(itemHandler, index, xPosition, yPosition);
		this.player = player;
	}

	@Override
	@Nonnull
	public ItemStack decrStackSize(int amount) {
		if (this.getHasStack()) {
			this.removeCount += Math.min(amount, this.getStack().getCount());
		}
		return super.decrStackSize(amount);
	}

	@Override
	@Nonnull
	public ItemStack onTake(EntityPlayer thePlayer, @Nonnull ItemStack stack) {
		stack.onCrafting(this.player.world, this.player, this.removeCount);
		this.removeCount = 0;
		return super.onTake(thePlayer, stack);
	}

	@Override
	public boolean isItemValid(@Nonnull ItemStack stack) {
		return false;
	}


}
