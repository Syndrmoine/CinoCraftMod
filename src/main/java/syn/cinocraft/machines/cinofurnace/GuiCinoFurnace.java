package syn.cinocraft.machines.cinofurnace;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import syn.cinocraft.mymod;

public class GuiCinoFurnace extends GuiContainer {

    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(mymod.MODID, "textures/gui/guicinofurnace.png");
    private TileCinoFurnace furnace;


    public GuiCinoFurnace(TileCinoFurnace tileEntity, ContainerCinoFurnace container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;

        furnace = tileEntity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if (furnace.getProgress() > 0) {
            int percentage = 100 - furnace.getProgress() * 100 / TileCinoFurnace.MAX_PROGRESS;
            drawString(mc.fontRenderer, "Progress: " + percentage + "%", guiLeft + 10, guiTop + 50, 0xffffff);
        }
    }

    @Override
    public void drawScreen(int mouseX, int  mouseY, float partialTicks){
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}

