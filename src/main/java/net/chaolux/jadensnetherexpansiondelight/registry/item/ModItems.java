package net.chaolux.jadensnetherexpansiondelight.registry.item;

import net.chaolux.jadensnetherexpansiondelight.common.item.*;
import net.chaolux.jadensnetherexpansiondelight.registry.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DogFoodItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.function.Supplier;

import static vectorwing.farmersdelight.common.registry.ModItems.basicItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS;

    public static final RegistryObject<Item> BANSHEE_COOKIE;
    public static final RegistryObject<Item> BANSHEE_POWDER_ICE_CREAM;
    public static final RegistryObject<Item> BLUE_SCALE_FUNGUS_ROLL;
    public static final RegistryObject<Item> CEREBRAGE_ROLLS;
    public static final RegistryObject<Item> COOKED_HOGHAM_SLICE;
    public static final RegistryObject<Item> GLOWCHEESE_ROLL;
    public static final RegistryObject<Item> GLOWCHEESE_SANDWICH;
    public static final RegistryObject<Item> GLOWCHEESE_SLICE;
    public static final RegistryObject<Item> HOGHAM_SLICE;
    public static final RegistryObject<Item> HOGHAM_STEW;
    public static final RegistryObject<Item> HONEY_GLAZED_HOGHAM;
    public static final RegistryObject<Item> HONEY_GLAZED_HOGHAM_BLOCK;
    public static final RegistryObject<Item> LIGHTSPORES_CHEESECAKE_SLICE;
    public static final RegistryObject<Item> LIGHTSPORES_CHEESECAKE;
    public static final RegistryObject<Item> LIGHTSPORES_JUICE;
    public static final RegistryObject<Item> LIGHTSPORES_POPSICLE;
    public static final RegistryObject<Item> NETHER_DOG_FOOD;
    public static final RegistryObject<Item> NETHER_HAMBURGER;
    public static final RegistryObject<Item> NIGHTSPORES_CHEESECAKE_SLICE;
    public static final RegistryObject<Item> NIGHTSPORES_CHEESECAKE;
    public static final RegistryObject<Item> NIGHTSPORES_JUICE;
    public static final RegistryObject<Item> NIGHTSPORES_POPSICLE;
    public static final RegistryObject<Item> OCHRE_COOKIE;
    public static final RegistryObject<Item> OCHRE_SAUCE;
    public static final RegistryObject<Item> PASTA_WITH_COOKED_HOGHAM;
    public static final RegistryObject<Item> PEARLESCENT_COOKIE;
    public static final RegistryObject<Item> PEARLESCENT_SAUCE;
    public static final RegistryObject<Item> RED_SCALE_FUNGUS_ROLL;
    public static final RegistryObject<Item> SMELT_GLOWCHEESE;
    public static final RegistryObject<Item> VERDANT_COOKIE;
    public static final RegistryObject<Item> VERDANT_SAUCE;
    public static final RegistryObject<Item> WISP_CUSTARD;
    public static final RegistryObject<Item> WISP_DUMPLINGS;
    public static final RegistryObject<Item> WISP_PIE_SLICE;
    public static final RegistryObject<Item> WISP_PIE;
    public static final RegistryObject<Item> WRAITHING_FLESH_SLICE;
    public static final RegistryObject<Item> WRAITHING_FLESH_STEW;
    public static final RegistryObject<Item> COOKED_WRAITHING_FLESH;
    public static final RegistryObject<Item> COOKED_WRAITHING_FLESH_SLICE;
    public static final RegistryObject<Item> ECTO_INGOT;
    public static final RegistryObject<Item> ECTO_KNIFE;
    public static final RegistryObject<Item> SPORES_SALAD;
    public static final RegistryObject<Item> WRAPPED_WITHER_ROSE;

    public static RegistryObject<Item> registerWithTab(String name, Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        return block;
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return (new Item.Properties()).food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties drinkItem(FoodProperties food) {
        return (new Item.Properties()).food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    public static Item.Properties stickItem(FoodProperties food) {
        return (new Item.Properties()).food(food).craftRemainder(Items.STICK);
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return (new Item.Properties()).food(food);
    }

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "jadensnetherexpansiondelight");

        HOGHAM_STEW = registerWithTab("hogham_stew", () -> new HoghamStewItem(bowlFoodItem(FoodValues.HOGHAM_STEW)));
        OCHRE_SAUCE = registerWithTab("ochre_sauce", () -> new ConsumableItem(bowlFoodItem(FoodValues.OCHRE_SAUCE), true));
        PASTA_WITH_COOKED_HOGHAM = registerWithTab("pasta_with_cooked_hogham", () -> new PastaWithCookedHoghamItem(bowlFoodItem(FoodValues.PASTA_WITH_COOKED_HOGHAM)));
        PEARLESCENT_SAUCE = registerWithTab("pearlescent_sauce", () -> new ConsumableItem(bowlFoodItem(FoodValues.PEARLESCENT_SAUCE), true));
        SMELT_GLOWCHEESE = registerWithTab("smelt_glowcheese", () -> new ConsumableItem(bowlFoodItem(FoodValues.SMELT_GLOWCHEESE), true));
        VERDANT_SAUCE = registerWithTab("verdant_sauce", () -> new ConsumableItem(bowlFoodItem(FoodValues.VERDANT_SAUCE), true));
        WRAITHING_FLESH_STEW = registerWithTab("wraithing_flesh_stew", () -> new WraithingFleshStewItem(bowlFoodItem(FoodValues.WRAITHING_FLESH_STEW)));
        SPORES_SALAD = registerWithTab("spores_salad", () -> new ConsumableItem(bowlFoodItem(FoodValues.SPORES_SALAD)));

        LIGHTSPORES_JUICE = registerWithTab("lightspores_juice", () -> new LightsporesJuiceItem(drinkItem(FoodValues.LIGHTSPORES_JUICE)));
        NIGHTSPORES_JUICE = registerWithTab("nightspores_juice", () -> new NightsporesJuiceItem(drinkItem(FoodValues.NIGHTSPORES_JUICE)));
        WISP_CUSTARD = registerWithTab("wisp_custard", () -> new DrinkableItem(drinkItem(FoodValues.WISP_CUSTARD), true));

        BANSHEE_POWDER_ICE_CREAM = registerWithTab("banshee_powder_ice_cream", () -> new BansheePowderIceCreamItem(stickItem(FoodValues.BANSHEE_POWDER_ICE_CREAM)));
        LIGHTSPORES_POPSICLE = registerWithTab("lightspores_popsicle", () -> new LightsporesPopsicleItem(stickItem(FoodValues.LIGHTSPORES_POPSICLE)));
        NIGHTSPORES_POPSICLE = registerWithTab("nightspores_popsicle", () -> new NightsporesPopsicleItem(stickItem(FoodValues.NIGHTSPORES_POPSICLE)));

        BANSHEE_COOKIE = registerWithTab("banshee_cookie", () -> new Item(foodItem(FoodValues.BANSHEE_COOKIE)));
        BLUE_SCALE_FUNGUS_ROLL = registerWithTab("blue_scale_fungus_roll", () -> new BlueScaleFungusRollItem(foodItem(FoodValues.BLUE_SCALE_FUNGUS_ROLL)));
        CEREBRAGE_ROLLS = registerWithTab("cerebrage_rolls", () -> new Item(foodItem(FoodValues.CEREBRAGE_ROLLS)));
        COOKED_HOGHAM_SLICE = registerWithTab("cooked_hogham_slice", () -> new Item(foodItem(FoodValues.COOKED_HOGHAM_SLICE)));
        GLOWCHEESE_ROLL = registerWithTab("glowcheese_roll", () -> new Item(foodItem(FoodValues.GLOWCHEESE_ROLL)));
        GLOWCHEESE_SANDWICH = registerWithTab("glowcheese_sandwich", () -> new Item(foodItem(FoodValues.GLOWCHEESE_SANDWICH)));
        GLOWCHEESE_SLICE = registerWithTab("glowcheese_slice", () -> new Item(foodItem(FoodValues.GLOWCHEESE_SLICE)));
        HOGHAM_SLICE = registerWithTab("hogham_slice", () -> new Item(foodItem(FoodValues.HOGHAM_SLICE)));
        NETHER_HAMBURGER = registerWithTab("nether_hamburger", () -> new NetherHamburgerItem(foodItem(FoodValues.NETHER_HAMBURGER)));
        OCHRE_COOKIE = registerWithTab("ochre_cookie", () -> new Item(foodItem(FoodValues.OCHRE_COOKIE)));
        PEARLESCENT_COOKIE = registerWithTab("pearlescent_cookie", () -> new Item(foodItem(FoodValues.PEARLESCENT_COOKIE)));
        RED_SCALE_FUNGUS_ROLL = registerWithTab("red_scale_fungus_roll", () -> new RedScaleFungusRollItem(foodItem(FoodValues.RED_SCALE_FUNGUS_ROLL)));
        VERDANT_COOKIE = registerWithTab("verdant_cookie", () -> new Item(foodItem(FoodValues.VERDANT_COOKIE)));
        WISP_DUMPLINGS = registerWithTab("wisp_dumplings", () -> new Item(foodItem(FoodValues.WISP_DUMPLINGS)));
        WRAITHING_FLESH_SLICE = registerWithTab("wraithing_flesh_slice", () -> new Item(foodItem(FoodValues.WRAITHING_FLESH_SLICE)));
        COOKED_WRAITHING_FLESH = registerWithTab("cooked_wraithing_flesh", () -> new Item(foodItem(FoodValues.COOKED_WRAITHING_FLESH)));
        COOKED_WRAITHING_FLESH_SLICE = registerWithTab("cooked_wraithing_flesh_slice", () -> new Item(foodItem(FoodValues.COOKED_WRAITHING_FLESH_SLICE)));
        WRAPPED_WITHER_ROSE = registerWithTab("wrapped_wither_rose", () -> new Item(foodItem(FoodValues.WRAPPED_WITHER_ROSE)));

        LIGHTSPORES_CHEESECAKE = registerWithTab("lightspores_cheesecake", () -> new BlockItem((Block) ModBlocks.LIGHTSPORES_CHEESECAKE.get(), basicItem()));
        LIGHTSPORES_CHEESECAKE_SLICE = registerWithTab("lightspores_cheesecake_slice", () -> new Item(foodItem(FoodValues.LIGHTSPORES_CHEESECAKE_SLICE)));
        NIGHTSPORES_CHEESECAKE = registerWithTab("nightspores_cheesecake", () -> new BlockItem((Block)ModBlocks.NIGHTSPORES_CHEESECAKE.get(), basicItem()));
        NIGHTSPORES_CHEESECAKE_SLICE = registerWithTab("nightspores_cheesecake_slice", () -> new Item(foodItem(FoodValues.NIGHTSPORES_CHEESECAKE_SLICE)));
        WISP_PIE = registerWithTab("wisp_pie", () -> new BlockItem((Block)ModBlocks.WISP_PIE.get(), basicItem()));
        WISP_PIE_SLICE = registerWithTab("wisp_pie_slice", () -> new Item(foodItem(FoodValues.WISP_PIE_SLICE)));

        HONEY_GLAZED_HOGHAM_BLOCK = registerWithTab("honey_glazed_hogham_block", () -> new BlockItem((Block)ModBlocks.HONEY_GLAZED_HOGHAM_BLOCK.get(), basicItem().stacksTo(1)));
        HONEY_GLAZED_HOGHAM = registerWithTab("honey_glazed_hogham", () -> new ConsumableItem(bowlFoodItem(FoodValues.HONEY_GLAZED_HOGHAM_BLOCK), true));

        NETHER_DOG_FOOD = registerWithTab("nether_dog_food", () -> new DogFoodItem(bowlFoodItem(FoodValues.NETHER_DOG_FOOD)));

        ECTO_INGOT = registerWithTab("ecto_ingot", () -> new Item(basicItem()));
        ECTO_KNIFE = registerWithTab("ecto_knife", () -> new KnifeItem(Tiers.NETHERITE, 0.5F, -2.0F, basicItem()));

    }
}
