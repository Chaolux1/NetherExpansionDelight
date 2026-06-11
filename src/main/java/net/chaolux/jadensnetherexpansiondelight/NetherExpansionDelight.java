package net.chaolux.jadensnetherexpansiondelight;

import com.mojang.logging.LogUtils;
import net.chaolux.jadensnetherexpansiondelight.registry.block.ModBlocks;
import net.chaolux.jadensnetherexpansiondelight.registry.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(NetherExpansionDelight.MODID)
public class NetherExpansionDelight {
    public static final String MODID = "jadensnetherexpansiondelight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NetherExpansionDelight(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.COOKED_WRAITHING_FLESH.get());
            event.accept(ModItems.COOKED_WRAITHING_FLESH_SLICE.get());
            event.accept(ModItems.WRAITHING_FLESH_SLICE.get());
            event.accept(ModItems.HOGHAM_SLICE.get());
            event.accept(ModItems.COOKED_HOGHAM_SLICE.get());
            event.accept(ModItems.GLOWCHEESE_SLICE.get());
            event.accept(ModItems.SMELT_GLOWCHEESE.get());
            event.accept(ModItems.GLOWCHEESE_SANDWICH.get());
            event.accept(ModItems.NETHER_HAMBURGER.get());
            event.accept(ModItems.BLUE_SCALE_FUNGUS_ROLL.get());
            event.accept(ModItems.RED_SCALE_FUNGUS_ROLL.get());
            event.accept(ModItems.GLOWCHEESE_ROLL.get());
            event.accept(ModItems.OCHRE_COOKIE.get());
            event.accept(ModItems.OCHRE_SAUCE.get());
            event.accept(ModItems.VERDANT_COOKIE.get());
            event.accept(ModItems.VERDANT_SAUCE.get());
            event.accept(ModItems.PEARLESCENT_COOKIE.get());
            event.accept(ModItems.PEARLESCENT_SAUCE.get());
            event.accept(ModItems.NIGHTSPORES_JUICE.get());
            event.accept(ModItems.NIGHTSPORES_POPSICLE.get());
            event.accept(ModItems.NIGHTSPORES_CHEESECAKE.get());
            event.accept(ModItems.NIGHTSPORES_CHEESECAKE_SLICE.get());
            event.accept(ModItems.LIGHTSPORES_JUICE.get());
            event.accept(ModItems.LIGHTSPORES_POPSICLE.get());
            event.accept(ModItems.LIGHTSPORES_CHEESECAKE.get());
            event.accept(ModItems.LIGHTSPORES_CHEESECAKE_SLICE.get());
            event.accept(ModItems.BANSHEE_POWDER_ICE_CREAM.get());
            event.accept(ModItems.BANSHEE_COOKIE.get());
            event.accept(ModItems.WISP_DUMPLINGS.get());
            event.accept(ModItems.WISP_CUSTARD.get());
            event.accept(ModItems.WISP_PIE.get());
            event.accept(ModItems.WISP_PIE_SLICE.get());
            event.accept(ModItems.CEREBRAGE_ROLLS.get());
            event.accept(ModItems.WRAPPED_WITHER_ROSE.get());
            event.accept(ModItems.SPORES_SALAD.get());
            event.accept(ModItems.HOGHAM_STEW.get());
            event.accept(ModItems.PASTA_WITH_COOKED_HOGHAM.get());
            event.accept(ModItems.WRAITHING_FLESH_STEW.get());
            event.accept(ModItems.HONEY_GLAZED_HOGHAM_BLOCK.get());
            event.accept(ModItems.HONEY_GLAZED_HOGHAM.get());
            event.accept(ModItems.NETHER_DOG_FOOD.get());
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ECTO_KNIFE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ECTO_INGOT.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
