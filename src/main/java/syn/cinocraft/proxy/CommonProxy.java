package syn.cinocraft.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import syn.cinocraft.ModBlocks;
import syn.cinocraft.ModItems;
import syn.cinocraft.items.ItemCinoIngot;
import syn.cinocraft.worldgen.OreGenerator;

import static syn.cinocraft.ModItems.itemCinoIngot;
import static syn.cinocraft.mymod.instance;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        GameRegistry.registerWorldGenerator(OreGenerator.instance, 5);
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e) {
        GameRegistry.addSmelting(ModBlocks.blockCinoOre, new ItemStack(itemCinoIngot, 1), 0.5f);
        OreDictionary.registerOre("oreCino", ModBlocks.blockCinoOre);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        ModBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().register(new ItemCinoIngot());

        event.getRegistry().register(new ItemBlock(ModBlocks.blockCinoBlock).setRegistryName(ModBlocks.blockCinoBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.cinofurnace).setRegistryName(ModBlocks.cinofurnace.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockCinoOre).setRegistryName(ModBlocks.blockCinoOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockCinoideOre).setRegistryName(ModBlocks.blockCinoideOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockCinoiteOre).setRegistryName(ModBlocks.blockCinoiteOre.getRegistryName()));

    }
}
