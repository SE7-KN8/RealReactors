package se7kn8.realreactors.common.container.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import se7kn8.realreactors.common.block.tile.TileEntityCrusher;
import se7kn8.realreactors.common.container.slot.SlotOutput;

import javax.annotation.Nonnull;

public class ContainerCrusher extends Container {
	private TileEntityCrusher crusher;
	private int power;
	private int workTime;
	private int totalWorkTime;

	public ContainerCrusher(InventoryPlayer player, TileEntityCrusher crusher) {
		this.crusher = crusher;

		this.addSlotToContainer(new SlotItemHandler(crusher.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH), 0, 56, 34));
		this.addSlotToContainer(new SlotOutput(crusher.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.SOUTH), 0, 116, 35, player.player));

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		for (int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(@Nonnull EntityPlayer playerIn) {
		return true;
	}

	@Override
	@Nonnull
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		return ItemStack.EMPTY;
	}
}
