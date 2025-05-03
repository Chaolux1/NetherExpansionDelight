package net.chaolux.jadensnetherexpansiondelight.registry.block;

import net.chaolux.jadensnetherexpansiondelight.registry.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.HoneyGlazedHamBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS;

    public static final RegistryObject<Block> LIGHTSPORES_CHEESECAKE;
    public static final RegistryObject<Block> NIGHTSPORES_CHEESECAKE;
    public static final RegistryObject<Block> WISP_PIE;
    public static final RegistryObject<Block> HONEY_GLAZED_HOGHAM_BLOCK;

    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "jadensnetherexpansiondelight");

        LIGHTSPORES_CHEESECAKE = BLOCKS.register("lightspores_cheesecake", () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.LIGHTSPORES_CHEESECAKE_SLICE    ));
        NIGHTSPORES_CHEESECAKE = BLOCKS.register("nightspores_cheesecake", () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.NIGHTSPORES_CHEESECAKE_SLICE));
        WISP_PIE = BLOCKS.register("wisp_pie", () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.WISP_PIE_SLICE));
        HONEY_GLAZED_HOGHAM_BLOCK = BLOCKS.register("honey_glazed_hogham_block", () -> new HoneyGlazedHamBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.HONEY_GLAZED_HOGHAM, true));
    }
}
