package net.chaolux.jadensnetherexpansiondelight.common.event;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = "jadensnetherexpansiondelight")
public class EatEffectsEvent {
    private static final Set<ResourceLocation> FOOD=new LinkedHashSet<>(Set.of(ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","lightspores_juice"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","lightspores_popsicle"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","banshee_powder_ice_cream"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","wisp_dumplings"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","wisp_custard"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","cerebrage_rolls"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","spores_salad"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","hogham_stew"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","wrapped_wither_rose"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","nightspores_juice"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","nightspores_popsicle"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","ochre_sauce"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","verdant_sauce"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","pearlescent_sauce"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","nether_hamburger"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","honey_glazed_hogham"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","wraithing_flesh_stew"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","pasta_with_cooked_hogham"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","cooked_wraithing_flesh"),ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","glowcheese_sandwich")));
    private static final Set<ResourceLocation> BIOME=new LinkedHashSet<>(Set.of(ResourceLocation.fromNamespaceAndPath("netherexp","black_ice_glaciers"),ResourceLocation.fromNamespaceAndPath("minecraft","nether_wastes"),ResourceLocation.fromNamespaceAndPath("minecraft","warped_forest"),ResourceLocation.fromNamespaceAndPath("minecraft","crimson_forest"),ResourceLocation.fromNamespaceAndPath("minecraft","soul_sand_valley"),ResourceLocation.fromNamespaceAndPath("minecraft","basalt_deltas")));
    private static final List<ResourceLocation> EFFECT=new ArrayList<>(List.of(ResourceLocation.fromNamespaceAndPath("netherexp","speed_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","slowness_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","strength_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","jump_boost_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","regeneration_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","fire_resistance_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","water_breathing_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","invisibility_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","weakness_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","poison_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","resistance_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","absorption_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","haste_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","mining_fatigue_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","darkness_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","levitation_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","hunger_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","wither_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","luck_immunity"),ResourceLocation.fromNamespaceAndPath("netherexp","unluck_immunity")));

    @SubscribeEvent
    public static void onItemEaten(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity=event.getEntity();
        if(!(entity instanceof Player player)) return;
        if(player.level().isClientSide) return;
        ItemStack stack=event.getItem();
        if(stack.isEmpty() || !stack.has(DataComponents.FOOD)) return;
        ResourceLocation foodKey= BuiltInRegistries.ITEM.getKey(stack.getItem());
        if(foodKey == null || !FOOD.contains(foodKey)) return;
        ResourceLocation biomeKey=player.level().getBiome(player.blockPosition()).unwrapKey().map(ResourceKey::location).orElse(null);
        if(biomeKey == null || !BIOME.contains(biomeKey)) return;
        if(EFFECT.size() < 2) return;
        RandomSource randomSource=player.getRandom();
        ResourceLocation resourceLocation_first=EFFECT.get(randomSource.nextInt(EFFECT.size()));
        ResourceLocation resourceLocation_second;
        do {
            resourceLocation_second=EFFECT.get(randomSource.nextInt(EFFECT.size()));
        } while (resourceLocation_second.equals(resourceLocation_first));
        BuiltInRegistries.MOB_EFFECT.getHolder(resourceLocation_first).ifPresent(effect -> player.addEffect(new MobEffectInstance(effect,1200,0)));
        BuiltInRegistries.MOB_EFFECT.getHolder(resourceLocation_second).ifPresent(effect -> player.addEffect(new MobEffectInstance(effect,1200,0)));
    }

}
