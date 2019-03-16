package syn.cinocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;
import syn.cinocraft.proxy.CommonProxy;

@Mod(modid = mymod.MODID, name = mymod.MODNAME, version = mymod.MODVERSION, dependencies = "required-after:forge@[11.16.0.1865,)", useMetadata = true)
public class mymod {

    public static final String MODID = "cinocraft";
    public static final String MODNAME = "CinoCraft";
    public static final String MODVERSION = "0.0.1a";

    @SidedProxy(clientSide = "syn.cinocraft.proxy.ClientProxy", serverSide = "syn.cinocraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTab = new CreativeTabs("cinocraft") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.cinofurnace);
        }
    };


    @Mod.Instance
    public static mymod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
