package syn.cinocraft;

import net.minecraftforge.fml.common.registry.GameRegistry;
import syn.cinocraft.machines.cinofurnace.BlockCinoFurnace;

public class ModBlocks {

    @GameRegistry.ObjectHolder("cinocraft:cinofurnace")
    public static BlockCinoFurnace cinofurnace;

    public static void initModels() {
        cinofurnace.initModel();
    }
}
