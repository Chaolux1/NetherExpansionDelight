package net.chaolux.jadensnetherexpansiondelight;

import com.mojang.logging.LogUtils;
import net.chaolux.jadensnetherexpansiondelight.registry.block.ModBlocks;
import net.chaolux.jadensnetherexpansiondelight.registry.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(NetherExpansionDelight.MOD_ID)
public class NetherExpansionDelight
{
    public static final String MOD_ID = "jadensnetherexpansiondelight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NetherExpansionDelight()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.COOKED_WRAITHING_FLESH);
            event.accept(ModItems.COOKED_WRAITHING_FLESH_SLICE);
            event.accept(ModItems.WRAITHING_FLESH_SLICE);
            event.accept(ModItems.HOGHAM_SLICE);
            event.accept(ModItems.COOKED_HOGHAM_SLICE);
            event.accept(ModItems.GLOWCHEESE_SLICE);
            event.accept(ModItems.SMELT_GLOWCHEESE);
            event.accept(ModItems.GLOWCHEESE_SANDWICH);
            event.accept(ModItems.NETHER_HAMBURGER);
            event.accept(ModItems.BLUE_SCALE_FUNGUS_ROLL);
            event.accept(ModItems.RED_SCALE_FUNGUS_ROLL);
            event.accept(ModItems.GLOWCHEESE_ROLL);
            event.accept(ModItems.OCHRE_COOKIE);
            event.accept(ModItems.OCHRE_SAUCE);
            event.accept(ModItems.VERDANT_COOKIE);
            event.accept(ModItems.VERDANT_SAUCE);
            event.accept(ModItems.PEARLESCENT_COOKIE);
            event.accept(ModItems.PEARLESCENT_SAUCE);
            event.accept(ModItems.NIGHTSPORES_JUICE);
            event.accept(ModItems.NIGHTSPORES_POPSICLE);
            event.accept(ModItems.NIGHTSPORES_CHEESECAKE);
            event.accept(ModItems.NIGHTSPORES_CHEESECAKE_SLICE);
            event.accept(ModItems.LIGHTSPORES_JUICE);
            event.accept(ModItems.LIGHTSPORES_POPSICLE);
            event.accept(ModItems.LIGHTSPORES_CHEESECAKE);
            event.accept(ModItems.LIGHTSPORES_CHEESECAKE_SLICE);
            event.accept(ModItems.BANSHEE_POWDER_ICE_CREAM);
            event.accept(ModItems.BANSHEE_COOKIE);
            event.accept(ModItems.WISP_DUMPLINGS);
            event.accept(ModItems.WISP_CUSTARD);
            event.accept(ModItems.WISP_PIE);
            event.accept(ModItems.WISP_PIE_SLICE);
            event.accept(ModItems.CEREBRAGE_ROLLS);
            event.accept(ModItems.WRAPPED_WITHER_ROSE);
            event.accept(ModItems.SPORES_SALAD);
            event.accept(ModItems.HOGHAM_STEW);
            event.accept(ModItems.PASTA_WITH_COOKED_HOGHAM);
            event.accept(ModItems.WRAITHING_FLESH_STEW);
            event.accept(ModItems.HONEY_GLAZED_HOGHAM_BLOCK);
            event.accept(ModItems.HONEY_GLAZED_HOGHAM);
            event.accept(ModItems.NETHER_DOG_FOOD);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ECTO_KNIFE);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ECTO_INGOT);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
