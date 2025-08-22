package net.chaolux.jadensnetherexpansiondelight.common.event;

import net.chaolux.jadensnetherexpansiondelight.registry.item.ModItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = "jadensnetherexpansiondelight", bus = Bus.FORGE)
public class EatEffectsEvent {
    private static final Set<ResourceLocation> FOOD=new LinkedHashSet<>(Set.of(new ResourceLocation("jadensnetherexpansiondelight","lightspores_juice"),new ResourceLocation("jadensnetherexpansiondelight","lightspores_popsicle"),new ResourceLocation("jadensnetherexpansiondelight","banshee_powder_ice_cream"),new ResourceLocation("jadensnetherexpansiondelight","wisp_dumplings"),new ResourceLocation("jadensnetherexpansiondelight","wisp_custard"),new ResourceLocation("jadensnetherexpansiondelight","cerebrage_rolls"),new ResourceLocation("jadensnetherexpansiondelight","spores_salad"),new ResourceLocation("jadensnetherexpansiondelight","hogham_stew"),new ResourceLocation("jadensnetherexpansiondelight","wrapped_wither_rose"),new ResourceLocation("jadensnetherexpansiondelight","nightspores_juice"),new ResourceLocation("jadensnetherexpansiondelight","nightspores_popsicle"),new ResourceLocation("jadensnetherexpansiondelight","ochre_sauce"),new ResourceLocation("jadensnetherexpansiondelight","verdant_sauce"),new ResourceLocation("jadensnetherexpansiondelight","pearlescent_sauce"),new ResourceLocation("jadensnetherexpansiondelight","nether_hamburger"),new ResourceLocation("jadensnetherexpansiondelight","honey_glazed_hogham"),new ResourceLocation("jadensnetherexpansiondelight","wraithing_flesh_stew"),new ResourceLocation("jadensnetherexpansiondelight","pasta_with_cooked_hogham"),new ResourceLocation("jadensnetherexpansiondelight","cooked_wraithing_flesh"),new ResourceLocation("jadensnetherexpansiondelight","glowcheese_sandwich")));
    private static final Set<ResourceLocation> BIOME=new LinkedHashSet<>(Set.of(new ResourceLocation("netherexp","black_ice_glaciers"),new ResourceLocation("minecraft","nether_wastes"),new ResourceLocation("minecraft","warped_forest"),new ResourceLocation("minecraft","crimson_forest"),new ResourceLocation("minecraft","soul_sand_valley"),new ResourceLocation("minecraft","basalt_deltas")));
    private static final List<ResourceLocation> EFFECT=new ArrayList<>(List.of(new ResourceLocation("netherexp","speed_immunity"),new ResourceLocation("netherexp","slowness_immunity"),new ResourceLocation("netherexp","strength_immunity"),new ResourceLocation("netherexp","jump_boost_immunity"),new ResourceLocation("netherexp","regeneration_immunity"),new ResourceLocation("netherexp","fire_resistance_immunity"),new ResourceLocation("netherexp","water_breathing_immunity"),new ResourceLocation("netherexp","invisibility_immunity"),new ResourceLocation("netherexp","weakness_immunity"),new ResourceLocation("netherexp","poison_immunity"),new ResourceLocation("netherexp","resistance_immunity"),new ResourceLocation("netherexp","absorption_immunity"),new ResourceLocation("netherexp","haste_immunity"),new ResourceLocation("netherexp","mining_fatigue_immunity"),new ResourceLocation("netherexp","darkness_immunity"),new ResourceLocation("netherexp","levitation_immunity"),new ResourceLocation("netherexp","hunger_immunity"),new ResourceLocation("netherexp","wither_immunity"),new ResourceLocation("netherexp","luck_immunity"),new ResourceLocation("netherexp","unluck_immunity")));

    @SubscribeEvent
    public static void onItemEaten(LivingEntityUseItemEvent.Finish event) {
        LivingEntity entity=event.getEntity();
        if(!(entity instanceof Player player)) return;
        if(player.level().isClientSide) return;
        ItemStack stack=event.getItem();
        if(stack.isEmpty() || !stack.isEdible()) return;
        ResourceLocation foodKey=ForgeRegistries.ITEMS.getKey(stack.getItem());
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
        MobEffect effects_first= ForgeRegistries.MOB_EFFECTS.getValue(resourceLocation_first);
        MobEffect effects_second= ForgeRegistries.MOB_EFFECTS.getValue(resourceLocation_second);
        if(effects_first !=null) {
            player.addEffect(new MobEffectInstance(effects_first,1200,0));
        }
        if(effects_second !=null) {
            player.addEffect(new MobEffectInstance(effects_second,1200,0));
        }
    }

}
