package syn.cinocraft.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import syn.cinocraft.mymod;

public class ItemCinoIngot extends Item {

    public ItemCinoIngot() {
        setTranslationKey(mymod.MODID + ".cino_ingot");
        setRegistryName("cino_ingot");
        setCreativeTab(mymod.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}