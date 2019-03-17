package syn.cinocraft.config;

import net.minecraftforge.common.config.Config;
import syn.cinocraft.mymod;

@Config(modid = mymod.MODID, category = "cinofurnace")
public class CinoFurnaceConfig {

    @Config.Comment(value = "Number of ticks for one smelting operation")
    public static int MAX_PROGRESS = 2000;
}
