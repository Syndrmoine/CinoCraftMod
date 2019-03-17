package syn.cinocraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import syn.cinocraft.items.ItemCinoIngot;

public class ModItems {

    @GameRegistry.ObjectHolder("cinocraft:cino_ingot")
    public static ItemCinoIngot itemCinoIngot;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemCinoIngot.initModel();

    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemCinoIngot());

    }
}