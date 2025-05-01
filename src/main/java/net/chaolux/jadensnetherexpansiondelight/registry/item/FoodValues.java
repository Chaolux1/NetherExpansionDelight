package net.chaolux.jadensnetherexpansiondelight.registry.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import vectorwing.farmersdelight.common.registry.ModEffects;


public class FoodValues {
    public static final FoodComponent BANSHEE_COOKIE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0, false, false), 1.0F).build();
    public static final FoodComponent BANSHEE_POWDER_ICE_CREAM = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.4F).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1600, 0, false, false), 1.0F).build();
    public static final FoodComponent BLUE_SCALE_FUNGUS_ROLL = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.4F).statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 600, 0, false, false), 1.0F).build();
    public static final FoodComponent CEREBRAGE_ROLLS = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.7F).build();
    public static final FoodComponent COOKED_HOGHAM_SLICE = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.7F).snack().meat().build();
    public static final FoodComponent GLOWCHEESE_ROLL = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.6F).build();
    public static final FoodComponent GLOWCHEESE_SANDWICH = (new FoodComponent.Builder()).hunger(9).saturationModifier(0.9F).build();
    public static final FoodComponent GLOWCHEESE_SLICE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.1F).snack().build();
    public static final FoodComponent HOGHAM_SLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).snack().meat().build();
    public static final FoodComponent HOGHAM_STEW = (new FoodComponent.Builder()).hunger(10).saturationModifier(0.9F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 0, false, false), 1.0F).build();
    public static final FoodComponent HONEY_GLAZED_HOGHAM = (new FoodComponent.Builder()).hunger(14).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 3200, 0, false, false), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5200, 0, false, false), 1.0F).build();
    public static final FoodComponent LIGHTSPORES_CHEESECAKE = (new FoodComponent.Builder()).hunger(11).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), 1200, 0, false, false), 1.0F).build();
    public static final FoodComponent LIGHTSPORES_JUICE = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 800, 0, false, false), 1.0F).build();
    public static final FoodComponent LIGHTSPORES_POPSICLE = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.4F).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1000, 0, false, false), 1.0F).build();
    public static final FoodComponent NETHER_DOG_FOOD = (new FoodComponent.Builder()).hunger(8).saturationModifier(0.7F).meat().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 0, false, false), 1.0F).build();
    public static final FoodComponent NETHER_HAMBURGER = (new FoodComponent.Builder()).hunger(9).saturationModifier(0.9F).build();
    public static final FoodComponent NIGHTSPORES_CHEESECAKE = (new FoodComponent.Builder()).hunger(11).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), 1200, 0, false, false), 1.0F).build();
    public static final FoodComponent NIGHTSPORES_JUICE = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 0, false, false), 1.0F).build();
    public static final FoodComponent NIGHTSPORES_POPSICLE = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.4F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 800, 0, false, false), 1.0F).build();
    public static final FoodComponent OCHRE_COOKIE = (new FoodComponent.Builder()).hunger(4).saturationModifier(0.1F).build();
    public static final FoodComponent OCHRE_SAUCE = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 800, 0, false, false), 1.0F).build();
    public static final FoodComponent PASTA_WITH_COOKED_HOGHAM = (new FoodComponent.Builder()).hunger(9).saturationModifier(1.1F).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), 2200, 0, false, false), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 0, false, false), 1.0F).build();
    public static final FoodComponent PEARLESCENT_COOKIE = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.1F).build();
    public static final FoodComponent PEARLESCENT_SAUCE = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 800, 0, false, false), 1.0F).build();
    public static final FoodComponent RED_SCALE_FUNGUS_ROLL = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.4F).statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 600, 0, false, false), 1.0F).build();
    public static final FoodComponent SMELT_GLOWCHEESE = (new FoodComponent.Builder()).hunger(6).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 800, 0, false, false), 1.0F).build();
    public static final FoodComponent VERDANT_COOKIE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.3F).build();
    public static final FoodComponent VERDANT_SAUCE = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.6F).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 600, 0, false, false), 1.0F).build();
    public static final FoodComponent WISP_CUSTARD = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.7F).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 700, 0, false, false), 1.0F).build();
    public static final FoodComponent WISP_DUMPLINGS = (new FoodComponent.Builder()).hunger(8).saturationModifier(1.1F).build();
    public static final FoodComponent WISP_PIE = (new FoodComponent.Builder()).hunger(10).saturationModifier(0.9F).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), 1200, 0, false, false), 1.0F).build();
    public static final FoodComponent WRAITHING_FLESH_SLICE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.1F).snack().meat().build();
    public static final FoodComponent WRAITHING_FLESH_STEW = (new FoodComponent.Builder()).hunger(7).saturationModifier(0.8F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 500, 0, false, false), 1.0F).build();
}