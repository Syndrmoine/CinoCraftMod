package syn.cinocraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import syn.cinocraft.blocks.BlockCinoBlock;
import syn.cinocraft.machines.cinofurnace.BlockCinoFurnace;
import syn.cinocraft.machines.cinofurnace.TileCinoFurnace;
import syn.cinocraft.worldgen.BlockCinoOre;
import syn.cinocraft.worldgen.BlockCinoideOre;
import syn.cinocraft.worldgen.BlockCinoiteOre;

public class ModBlocks {

    @GameRegistry.ObjectHolder("cinocraft:cinofurnace")
    public static BlockCinoFurnace cinofurnace;

    @GameRegistry.ObjectHolder("cinocraft:cino_ore")
    public static BlockCinoOre blockCinoOre;

    @GameRegistry.ObjectHolder("cinocraft:cinoite_ore")
    public static BlockCinoiteOre blockCinoiteOre;

    @GameRegistry.ObjectHolder("cinocraft:cinoide_ore")
    public static BlockCinoideOre blockCinoideOre;

    @GameRegistry.ObjectHolder("cinocraft:cino_block")
    public static BlockCinoBlock blockCinoBlock;



    public static void initModels() {

        cinofurnace.initModel();
        blockCinoOre.initModel();
        blockCinoiteOre.initModel();
        blockCinoideOre.initModel();
        blockCinoBlock.initModel();
    }



    public static void register(IForgeRegistry<Block> registry) {
        registry.register(new BlockCinoOre());
        registry.register(new BlockCinoiteOre());
        registry.register(new BlockCinoideOre());
        registry.register(new BlockCinoBlock());


        registry.register(new BlockCinoFurnace());
        GameRegistry.registerTileEntity(TileCinoFurnace.class, mymod.MODID + "_cinofurnace");
    }
}
