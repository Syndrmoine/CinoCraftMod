package syn.cinocraft.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import syn.cinocraft.ModBlocks;
import syn.cinocraft.machines.cinofurnace.BlockCinoFurnace;
import syn.cinocraft.machines.cinofurnace.GuiCinoFurnace;
import syn.cinocraft.machines.cinofurnace.TileCinoFurnace;
import syn.cinocraft.mymod;

import static syn.cinocraft.mymod.instance;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockCinoFurnace());
        GameRegistry.registerTileEntity(TileCinoFurnace.class, mymod.MODID + "_cinofurnace");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.cinofurnace).setRegistryName(ModBlocks.cinofurnace.getRegistryName()));
    }
}
