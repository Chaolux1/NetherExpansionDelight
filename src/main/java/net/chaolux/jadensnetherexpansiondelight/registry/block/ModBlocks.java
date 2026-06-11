package net.chaolux.jadensnetherexpansiondelight.registry.block;

import net.chaolux.jadensnetherexpansiondelight.registry.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.BlockShapes;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.RotatedFeastBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS;

    public static final Supplier<Block> LIGHTSPORES_CHEESECAKE;
    public static final Supplier<Block> NIGHTSPORES_CHEESECAKE;
    public static final Supplier<Block> WISP_PIE;
    public static final Supplier<Block> HONEY_GLAZED_HOGHAM_BLOCK;

    static {
        BLOCKS = DeferredRegister.create(Registries.BLOCK, "jadensnetherexpansiondelight");

        LIGHTSPORES_CHEESECAKE = BLOCKS.register("lightspores_cheesecake", () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModItems.LIGHTSPORES_CHEESECAKE_SLICE    ));
        NIGHTSPORES_CHEESECAKE = BLOCKS.register("nightspores_cheesecake", () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModItems.NIGHTSPORES_CHEESECAKE_SLICE));
        WISP_PIE = BLOCKS.register("wisp_pie", () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModItems.WISP_PIE_SLICE));
        HONEY_GLAZED_HOGHAM_BLOCK = BLOCKS.register("honey_glazed_hogham_block", () -> new RotatedFeastBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), ModItems.HONEY_GLAZED_HOGHAM, true, BlockShapes.HONEY_GLAZED_HAM_SHAPES, BlockShapes.TRAY_SHAPE));
    }
}
