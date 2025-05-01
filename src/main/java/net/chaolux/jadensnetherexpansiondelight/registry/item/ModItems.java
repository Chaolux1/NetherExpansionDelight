package net.chaolux.jadensnetherexpansiondelight.registry.item;


import net.minecraft.item.Item;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Items;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DogFoodItem;

import java.util.function.Supplier;

public class ModItems {
    public static final Supplier<Item> BANSHEE_COOKIE;
    public static final Supplier<Item> BANSHEE_POWDER_ICE_CREAM;
    public static final Supplier<Item> BLUE_SCALE_FUNGUS_ROLL;
    public static final Supplier<Item> CEREBRAGE_ROLLS;
    public static final Supplier<Item> COOKED_HOGHAM_SLICE;
    public static final Supplier<Item> GLOWCHEESE_ROLL;
    public static final Supplier<Item> GLOWCHEESE_SANDWICH;
    public static final Supplier<Item> GLOWCHEESE_SLICE;
    public static final Supplier<Item> HOGHAM_SLICE;
    public static final Supplier<Item> HOGHAM_STEW;
    public static final Supplier<Item> HONEY_GLAZED_HOGHAM;
    public static final Supplier<Item> LIGHTSPORES_CHEESECAKE;
    public static final Supplier<Item> LIGHTSPORES_JUICE;
    public static final Supplier<Item> LIGHTSPORES_POPSICLE;
    public static final Supplier<Item> NETHER_DOG_FOOD;
    public static final Supplier<Item> NETHER_HAMBURGER;
    public static final Supplier<Item> NIGHTSPORES_CHEESECAKE;
    public static final Supplier<Item> NIGHTSPORES_JUICE;
    public static final Supplier<Item> NIGHTSPORES_POPSICLE;
    public static final Supplier<Item> OCHRE_COOKIE;
    public static final Supplier<Item> OCHRE_SAUCE;
    public static final Supplier<Item> PASTA_WITH_COOKED_HOGHAM;
    public static final Supplier<Item> PEARLESCENT_COOKIE;
    public static final Supplier<Item> PEARLESCENT_SAUCE;
    public static final Supplier<Item> RED_SCALE_FUNGUS_ROLL;
    public static final Supplier<Item> SMELT_GLOWCHEESE;
    public static final Supplier<Item> VERDANT_COOKIE;
    public static final Supplier<Item> VERDANT_SAUCE;
    public static final Supplier<Item> WISP_CUSTARD;
    public static final Supplier<Item> WISP_DUMPLINGS;
    public static final Supplier<Item> WISP_PIE;
    public static final Supplier<Item> WRAITHING_FLESH_SLICE;
    public static final Supplier<Item> WRAITHING_FLESH_STEW;

    public static Supplier<Item> registerWithTab(String name, Supplier<Item> itemSupplier) {
        Identifier id = new Identifier("jadensnetherexpansiondelight", name);
        Item item = itemSupplier.get();
        Registry.register(Registries.ITEM, id, item);
        return () -> Registries.ITEM.get(id);
    }

    public static Item.Settings bowlFoodItem(FoodComponent food) {
        return (new Item.Settings()).food(food).recipeRemainder(Items.BOWL).maxCount(16);
    }

    public static Item.Settings drinkItem(FoodComponent food) {
        return (new Item.Settings()).food(food).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16);
    }

    public static Item.Settings stickItem(FoodComponent food) {
        return (new Item.Settings()).food(food).recipeRemainder(Items.STICK);
    }

    public static Item.Settings foodItem(FoodComponent food) {
        return (new Item.Settings()).food(food);
    }

    static {
        HOGHAM_STEW = registerWithTab("hogham_stew", () -> new ConsumableItem(bowlFoodItem(FoodValues.HOGHAM_STEW)));
        OCHRE_SAUCE = registerWithTab("ochre_sauce", () -> new ConsumableItem(bowlFoodItem(FoodValues.OCHRE_SAUCE), true));
        PASTA_WITH_COOKED_HOGHAM = registerWithTab("pasta_with_cooked_hogham", () -> new ConsumableItem(bowlFoodItem(FoodValues.PASTA_WITH_COOKED_HOGHAM), true));
        PEARLESCENT_SAUCE = registerWithTab("pearlescent_sauce", () -> new ConsumableItem(bowlFoodItem(FoodValues.PEARLESCENT_SAUCE), true));
        SMELT_GLOWCHEESE = registerWithTab("smelt_glowcheese", () -> new ConsumableItem(bowlFoodItem(FoodValues.SMELT_GLOWCHEESE), true));
        VERDANT_SAUCE = registerWithTab("verdant_sauce", () -> new ConsumableItem(bowlFoodItem(FoodValues.VERDANT_SAUCE), true));
        WRAITHING_FLESH_STEW = registerWithTab("wraithing_flesh_stew", () -> new ConsumableItem(bowlFoodItem(FoodValues.WRAITHING_FLESH_STEW), true));
        HONEY_GLAZED_HOGHAM = registerWithTab("honey_glazed_hogham", () -> new ConsumableItem(bowlFoodItem(FoodValues.HONEY_GLAZED_HOGHAM), true));

        LIGHTSPORES_JUICE = registerWithTab("lightspores_juice", () -> new ConsumableItem(drinkItem(FoodValues.LIGHTSPORES_JUICE), true));
        NIGHTSPORES_JUICE = registerWithTab("nightspores_juice", () -> new ConsumableItem(drinkItem(FoodValues.NIGHTSPORES_JUICE), true));
        WISP_CUSTARD = registerWithTab("wisp_custard", () -> new ConsumableItem(drinkItem(FoodValues.WISP_CUSTARD), true));

        BANSHEE_POWDER_ICE_CREAM = registerWithTab("banshee_powder_ice_cream", () -> new ConsumableItem(stickItem(FoodValues.BANSHEE_POWDER_ICE_CREAM), true));
        LIGHTSPORES_POPSICLE = registerWithTab("lightspores_popsicle", () -> new ConsumableItem(stickItem(FoodValues.LIGHTSPORES_POPSICLE), true));
        NIGHTSPORES_POPSICLE = registerWithTab("nightspores_popsicle", () -> new ConsumableItem(stickItem(FoodValues.NIGHTSPORES_POPSICLE), true));

        BANSHEE_COOKIE = registerWithTab("banshee_cookie", () -> new Item(foodItem(FoodValues.BANSHEE_COOKIE)));
        BLUE_SCALE_FUNGUS_ROLL = registerWithTab("blue_scale_fungus_roll", () -> new Item(foodItem(FoodValues.BLUE_SCALE_FUNGUS_ROLL)));
        CEREBRAGE_ROLLS = registerWithTab("cerebrage_rolls", () -> new Item(foodItem(FoodValues.CEREBRAGE_ROLLS)));
        COOKED_HOGHAM_SLICE = registerWithTab("cooked_hogham_slice", () -> new Item(foodItem(FoodValues.COOKED_HOGHAM_SLICE)));
        GLOWCHEESE_ROLL = registerWithTab("glowcheese_roll", () -> new Item(foodItem(FoodValues.GLOWCHEESE_ROLL)));
        GLOWCHEESE_SANDWICH = registerWithTab("glowcheese_sandwich", () -> new Item(foodItem(FoodValues.GLOWCHEESE_SANDWICH)));
        GLOWCHEESE_SLICE = registerWithTab("glowcheese_slice", () -> new Item(foodItem(FoodValues.GLOWCHEESE_SLICE)));
        HOGHAM_SLICE = registerWithTab("hogham_slice", () -> new Item(foodItem(FoodValues.HOGHAM_SLICE)));
        LIGHTSPORES_CHEESECAKE = registerWithTab("lightspores_cheesecake", () -> new Item(foodItem(FoodValues.LIGHTSPORES_CHEESECAKE)));
        NETHER_HAMBURGER = registerWithTab("nether_hamburger", () -> new Item(foodItem(FoodValues.NETHER_HAMBURGER)));
        NIGHTSPORES_CHEESECAKE = registerWithTab("nightspores_cheesecake", () -> new Item(foodItem(FoodValues.NIGHTSPORES_CHEESECAKE)));
        OCHRE_COOKIE = registerWithTab("ochre_cookie", () -> new Item(foodItem(FoodValues.OCHRE_COOKIE)));
        PEARLESCENT_COOKIE = registerWithTab("pearlescent_cookie", () -> new Item(foodItem(FoodValues.PEARLESCENT_COOKIE)));
        RED_SCALE_FUNGUS_ROLL = registerWithTab("red_scale_fungus_roll", () -> new Item(foodItem(FoodValues.RED_SCALE_FUNGUS_ROLL)));
        VERDANT_COOKIE = registerWithTab("verdant_cookie", () -> new Item(foodItem(FoodValues.VERDANT_COOKIE)));
        WISP_DUMPLINGS = registerWithTab("wisp_dumplings", () -> new Item(foodItem(FoodValues.WISP_DUMPLINGS)));
        WISP_PIE = registerWithTab("wisp_pie", () -> new Item(foodItem(FoodValues.WISP_PIE)));
        WRAITHING_FLESH_SLICE = registerWithTab("wraithing_flesh_slice", () -> new Item(foodItem(FoodValues.WRAITHING_FLESH_SLICE)));

        NETHER_DOG_FOOD = registerWithTab("nether_dog_food", () -> new DogFoodItem(bowlFoodItem(FoodValues.NETHER_DOG_FOOD)));
    }

    public static void touch() {
    }
}
