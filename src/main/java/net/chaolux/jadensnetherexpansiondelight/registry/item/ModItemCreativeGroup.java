package net.chaolux.jadensnetherexpansiondelight.registry.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemCreativeGroup {
    public static void touch() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(event -> {
            event.add(ModItems.BANSHEE_COOKIE.get());
            event.add(ModItems.BANSHEE_POWDER_ICE_CREAM.get());
            event.add(ModItems.BLUE_SCALE_FUNGUS_ROLL.get());
            event.add(ModItems.CEREBRAGE_ROLLS.get());
            event.add(ModItems.COOKED_HOGHAM_SLICE.get());
            event.add(ModItems.GLOWCHEESE_ROLL.get());
            event.add(ModItems.GLOWCHEESE_SANDWICH.get());
            event.add(ModItems.GLOWCHEESE_SLICE.get());
            event.add(ModItems.HOGHAM_SLICE.get());
            event.add(ModItems.HOGHAM_STEW.get());
            event.add(ModItems.HONEY_GLAZED_HOGHAM.get());
            event.add(ModItems.LIGHTSPORES_CHEESECAKE.get());
            event.add(ModItems.LIGHTSPORES_JUICE.get());
            event.add(ModItems.LIGHTSPORES_POPSICLE.get());
            event.add(ModItems.NETHER_DOG_FOOD.get());
            event.add(ModItems.NETHER_HAMBURGER.get());
            event.add(ModItems.NIGHTSPORES_CHEESECAKE.get());
            event.add(ModItems.NIGHTSPORES_JUICE.get());
            event.add(ModItems.NIGHTSPORES_POPSICLE.get());
            event.add(ModItems.OCHRE_COOKIE.get());
            event.add(ModItems.OCHRE_SAUCE.get());
            event.add(ModItems.PASTA_WITH_COOKED_HOGHAM.get());
            event.add(ModItems.PEARLESCENT_COOKIE.get());
            event.add(ModItems.PEARLESCENT_SAUCE.get());
            event.add(ModItems.RED_SCALE_FUNGUS_ROLL.get());
            event.add(ModItems.SMELT_GLOWCHEESE.get());
            event.add(ModItems.VERDANT_COOKIE.get());
            event.add(ModItems.VERDANT_SAUCE.get());
            event.add(ModItems.WISP_CUSTARD.get());
            event.add(ModItems.WISP_DUMPLINGS.get());
            event.add(ModItems.WISP_PIE.get());
            event.add(ModItems.WRAITHING_FLESH_SLICE.get());
            event.add(ModItems.WRAITHING_FLESH_STEW.get());
        });
    }
}
