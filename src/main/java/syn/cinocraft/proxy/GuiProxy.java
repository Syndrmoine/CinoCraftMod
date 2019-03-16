package syn.cinocraft.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import syn.cinocraft.machines.cinofurnace.ContainerCinoFurnace;
import syn.cinocraft.machines.cinofurnace.GuiCinoFurnace;
import syn.cinocraft.machines.cinofurnace.TileCinoFurnace;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileCinoFurnace) {
            return new ContainerCinoFurnace(player.inventory, (TileCinoFurnace) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileCinoFurnace) {
            TileCinoFurnace containerTileEntity = (TileCinoFurnace) te;
            return new GuiCinoFurnace(containerTileEntity, new ContainerCinoFurnace(player.inventory, containerTileEntity));
        }
        return null;
    }
}
