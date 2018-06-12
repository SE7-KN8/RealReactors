package se7kn8.realreactors.client.gui.machine;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import se7kn8.realreactors.RealReactors;
import se7kn8.realreactors.common.block.tile.TileEntityCrusher;
import se7kn8.realreactors.common.container.machine.ContainerCrusher;

public class GuiCrusher extends GuiContainer {
	private static final ResourceLocation TEXTURE = new ResourceLocation(RealReactors.MOD_ID, "textures/gui/container/machine/crusher.png");
	private InventoryPlayer player;
	private TileEntityCrusher crusher;

	public GuiCrusher(InventoryPlayer player, TileEntityCrusher crusher) {
		super(new ContainerCrusher(player, crusher));
		this.player = player;
		this.crusher = crusher;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String customName = new TextComponentTranslation("tile.crusher").getFormattedText();
		this.fontRenderer.drawString(customName, this.xSize / 2 - this.fontRenderer.getStringWidth(customName) / 2, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
