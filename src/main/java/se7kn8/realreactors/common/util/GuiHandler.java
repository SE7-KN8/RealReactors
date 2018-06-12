package se7kn8.realreactors.common.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.client.gui.machine.GuiCrusher;
import se7kn8.realreactors.common.block.tile.TileEntityCrusher;
import se7kn8.realreactors.common.container.machine.ContainerCrusher;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

	@Nullable
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case RealReactors.GUI_ID_CRUSHER:
				return new ContainerCrusher(player.inventory, (TileEntityCrusher) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Nullable
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case RealReactors.GUI_ID_CRUSHER:
				return new GuiCrusher(player.inventory, (TileEntityCrusher) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
}
