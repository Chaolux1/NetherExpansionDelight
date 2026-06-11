package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.jadenxgamer.netherexp.registry.JNEMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodValues {
    public static final FoodProperties BANSHEE_COOKIE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).effect(() -> new MobEffectInstance(JNEMobEffects.INVISIBILITY_IMMUNITY, 200, 0, false, false), 1.0F).build();
    public static final FoodProperties BANSHEE_POWDER_ICE_CREAM = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.4F).effect(() -> new MobEffectInstance(JNEMobEffects.INVISIBILITY_IMMUNITY, 1600, 0, false, false), 1.0F).build();
    public static final FoodProperties BLUE_SCALE_FUNGUS_ROLL = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.4F).effect(() -> new MobEffectInstance(JNEMobEffects.HUNGER_IMMUNITY, 600, 0, false, false), 1.0F).build();
    public static final FoodProperties CEREBRAGE_ROLLS = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.7F).build();
    public static final FoodProperties COOKED_HOGHAM_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.7F).fast().build();
    public static final FoodProperties GLOWCHEESE_ROLL = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.6F).build();
    public static final FoodProperties GLOWCHEESE_SANDWICH = (new FoodProperties.Builder()).nutrition(9).saturationModifier(0.9F).build();
    public static final FoodProperties GLOWCHEESE_SLICE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.1F).fast().build();
    public static final FoodProperties HOGHAM_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).fast().build();
    public static final FoodProperties HOGHAM_STEW = (new FoodProperties.Builder()).nutrition(10).saturationModifier(0.9F).effect(() -> new MobEffectInstance(JNEMobEffects.WITHER_IMMUNITY, 400, 0, false, false), 1.0F).build();
    public static final FoodProperties HONEY_GLAZED_HOGHAM_BLOCK = (new FoodProperties.Builder()).nutrition(14).saturationModifier(1.2F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3200, 0, false, false), 1.0F).effect(() -> new MobEffectInstance(JNEMobEffects.WITHER_IMMUNITY, 5200, 0, false, false), 1.0F).build();
    public static final FoodProperties LIGHTSPORES_CHEESECAKE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).effect(() -> new MobEffectInstance(ModEffects.COMFORT, 1200, 0, false, false), 1.0F).build();
    public static final FoodProperties LIGHTSPORES_JUICE = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.8F).effect(() -> new MobEffectInstance(JNEMobEffects.MINING_FATIGUE_IMMUNITY, 800, 0, false, false), 1.0F).build();
    public static final FoodProperties LIGHTSPORES_POPSICLE = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.4F).effect(() -> new MobEffectInstance(JNEMobEffects.MINING_FATIGUE_IMMUNITY, 1000, 0, false, false), 1.0F).build();
    public static final FoodProperties NETHER_DOG_FOOD = (new FoodProperties.Builder()).nutrition(8).saturationModifier(0.7F).effect(() -> new MobEffectInstance(JNEMobEffects.WITHER_IMMUNITY, 1200, 0, false, false), 1.0F).build();
    public static final FoodProperties NETHER_HAMBURGER = (new FoodProperties.Builder()).nutrition(9).saturationModifier(0.9F).build();
    public static final FoodProperties NIGHTSPORES_CHEESECAKE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).effect(() -> new MobEffectInstance(ModEffects.COMFORT, 1200, 0, false, false), 1.0F).build();
    public static final FoodProperties NIGHTSPORES_JUICE = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.8F).effect(() -> new MobEffectInstance(JNEMobEffects.WEAKNESS_IMMUNITY, 600, 0, false, false), 1.0F).build();
    public static final FoodProperties NIGHTSPORES_POPSICLE = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.4F).effect(() -> new MobEffectInstance(JNEMobEffects.SLOWNESS_IMMUNITY, 800, 0, false, false), 1.0F).build();
    public static final FoodProperties OCHRE_COOKIE = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.1F).build();
    public static final FoodProperties OCHRE_SAUCE = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.6F).effect(() -> new MobEffectInstance(JNEMobEffects.POISON_IMMUNITY, 800, 0, false, false), 1.0F).build();
    public static final FoodProperties PASTA_WITH_COOKED_HOGHAM = (new FoodProperties.Builder()).nutrition(9).saturationModifier(1.1F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 2200, 0, false, false), 1.0F).effect(() -> new MobEffectInstance(JNEMobEffects.WITHER_IMMUNITY, 400, 0, false, false), 1.0F).build();
    public static final FoodProperties PEARLESCENT_COOKIE = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.1F).build();
    public static final FoodProperties PEARLESCENT_SAUCE = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.6F).effect(() -> new MobEffectInstance(JNEMobEffects.LEVITATION_IMMUNITY, 800, 0, false, false), 1.0F).build();
    public static final FoodProperties RED_SCALE_FUNGUS_ROLL = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.4F).effect(() -> new MobEffectInstance(JNEMobEffects.HUNGER_IMMUNITY, 600, 0, false, false), 1.0F).build();
    public static final FoodProperties SMELT_GLOWCHEESE = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.7F).effect(() -> new MobEffectInstance(JNEMobEffects.DARKNESS_IMMUNITY, 800, 0, false, false), 1.0F).build();
    public static final FoodProperties VERDANT_COOKIE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3F).build();
    public static final FoodProperties VERDANT_SAUCE = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.6F).effect(() -> new MobEffectInstance(JNEMobEffects.UNLUCK_IMMUNITY, 600, 0, false, false), 1.0F).build();
    public static final FoodProperties WISP_CUSTARD = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.7F).effect(() -> new MobEffectInstance(JNEMobEffects.WEAKNESS_IMMUNITY, 700, 0, false, false), 1.0F).build();
    public static final FoodProperties WISP_DUMPLINGS = (new FoodProperties.Builder()).nutrition(8).saturationModifier(1.1F).build();
    public static final FoodProperties WISP_PIE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.4F).effect(() -> new MobEffectInstance(ModEffects.COMFORT, 1200, 0, false, false), 1.0F).build();
    public static final FoodProperties WRAITHING_FLESH_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1F).fast().build();
    public static final FoodProperties WRAITHING_FLESH_STEW = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.8F).effect(() -> new MobEffectInstance(JNEMobEffects.WEAKNESS_IMMUNITY, 500, 0, false, false), 1.0F).effect(() -> new MobEffectInstance(JNEMobEffects.WITHER_IMMUNITY, 500, 0, false, false), 1.0F).effect(() -> new MobEffectInstance(JNEMobEffects.SLOWNESS_IMMUNITY, 500, 0, false, false), 1.0F).effect(() -> new MobEffectInstance(JNEMobEffects.DARKNESS_IMMUNITY, 500, 0, false, false), 1.0F).effect(() -> new MobEffectInstance(JNEMobEffects.POISON_IMMUNITY, 500, 0, false, false), 1.0F).build();
    public static final FoodProperties SPORES_SALAD = (new FoodProperties.Builder()).nutrition(8).saturationModifier(0.8F).build();
    public static final FoodProperties COOKED_WRAITHING_FLESH = (new FoodProperties.Builder()).nutrition(5).saturationModifier(0.1F).effect(() -> new MobEffectInstance(JNEMobEffects.MINING_FATIGUE_IMMUNITY, 1200, 0, false, false), 1.0F).build();
    public static final FoodProperties COOKED_WRAITHING_FLESH_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).effect(() -> new MobEffectInstance(JNEMobEffects.SLOWNESS_IMMUNITY, 600, 0, false, false), 1.0F).build();
    public static final FoodProperties WRAPPED_WITHER_ROSE = (new FoodProperties.Builder()).nutrition(7).saturationModifier(0.3F).effect(() -> new MobEffectInstance(JNEMobEffects.WITHER_IMMUNITY, 2500, 0, false, false), 1.0F).build();
}