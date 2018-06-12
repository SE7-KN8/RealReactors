package se7kn8.realreactors.common.block.tile;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.animation.TimeValues;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import se7kn8.realreactors.RealReactors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityCrusher extends TileEntity implements ITickable {

	private IAnimationStateMachine asm;
	private final TimeValues.VariableValue cycleLength = new TimeValues.VariableValue(4);

	private final ItemStackHandler inputHandler = new ItemStackHandler() {
		@Override
		protected void onContentsChanged(int slot) {
			super.onContentsChanged(slot);
			markDirty();
		}
	};
	private final ItemStackHandler outputHandler = new ItemStackHandler() {
		@Override
		protected void onContentsChanged(int slot) {
			super.onContentsChanged(slot);
			markDirty();
		}
	};

	public TileEntityCrusher() {
		asm = RealReactors.proxy.loadASM(new ResourceLocation(RealReactors.MOD_ID, "asms/block/crusher.json"), ImmutableMap.of(
				"cycle_length", cycleLength
		));
	}

	@Override
	public boolean hasFastRenderer() {
		return true;
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return true;
		} else if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return CapabilityAnimation.ANIMATION_CAPABILITY.cast(asm);
		} else if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && facing == EnumFacing.NORTH) {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(inputHandler);
		} else if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && facing == EnumFacing.SOUTH) {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(outputHandler);
		}
		return super.getCapability(capability, facing);
	}

	public void toggleState() {
		if (asm.currentState().equals("default")) {
			asm.transition("moving");
		} else if (asm.currentState().equals("moving")) {
			asm.transition("default");
		}
	}


	private int workTime;
	private int totalWorkTime;
	private int power;

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.workTime = compound.getInteger("WorkTime");
		this.totalWorkTime = compound.getInteger("TotalWorkTime");
		this.power = compound.getInteger("Power");
		this.inputHandler.deserializeNBT(compound.getCompoundTag("InputHandler"));
		this.outputHandler.deserializeNBT(compound.getCompoundTag("OutputHandler"));
	}

	@Override
	@Nonnull
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("WorkTime", this.workTime);
		compound.setInteger("TotalWorkTime", this.totalWorkTime);
		compound.setInteger("Power", this.power);
		compound.setTag("InputHandler", inputHandler.serializeNBT());
		compound.setTag("OutputHandler", outputHandler.serializeNBT());

		return compound;
	}

	public boolean isWorking() {
		return workTime > 0;
	}

	public int getWorkTime(ItemStack input) {
		return 200;
	}

	private boolean canWork() {
		return power > 0;
	}

	public void crushItem() {
		if (this.canWork()) {
			/*ItemStack input = this.inventory.get(0);
			ItemStack result = new ItemStack(Blocks.EMERALD_BLOCK);
			ItemStack output = this.inventory.get(1);
			if (output.isEmpty()) {
				this.inventory.set(1, result.copy());
			} else if (output.getItem() == result.getItem()) {
				output.grow(result.getCount());
			}
			input.shrink(1);*/
		}
	}

	@Override
	public void update() {
		//TODO
	}

	@Nullable
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound compound = new NBTTagCompound();
		this.writeToNBT(compound);
		return new SPacketUpdateTileEntity(this.pos, 3, compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		this.readFromNBT(pkt.getNbtCompound());
	}
}
