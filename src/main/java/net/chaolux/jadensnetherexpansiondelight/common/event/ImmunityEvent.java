package net.chaolux.jadensnetherexpansiondelight.common.event;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@EventBusSubscriber(modid = "jadensnetherexpansiondelight")
public class ImmunityEvent {
    private static final Map<ResourceLocation, Set<Holder<MobEffect>>> IMMUNITIES=new HashMap<>();
    static {
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "speed_immunity"), Set.of(MobEffects.MOVEMENT_SPEED));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "slowness_immunity"), Set.of(MobEffects.MOVEMENT_SLOWDOWN));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "strength_immunity"), Set.of(MobEffects.DAMAGE_BOOST));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "jump_boost_immunity"), Set.of(MobEffects.JUMP));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "regeneration_immunity"), Set.of(MobEffects.REGENERATION));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "fire_resistance_immunity"), Set.of(MobEffects.FIRE_RESISTANCE));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "water_breathing_immunity"), Set.of(MobEffects.WATER_BREATHING));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "invisibility_immunity"), Set.of(MobEffects.INVISIBILITY));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "weakness_immunity"), Set.of(MobEffects.WEAKNESS));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "poison_immunity"), Set.of(MobEffects.POISON));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "resistance_immunity"), Set.of(MobEffects.DAMAGE_RESISTANCE));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "absorption_immunity"), Set.of(MobEffects.ABSORPTION));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "haste_immunity"), Set.of(MobEffects.DIG_SPEED));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "mining_fatigue_immunity"), Set.of(MobEffects.DIG_SLOWDOWN));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "darkness_immunity"), Set.of(MobEffects.DARKNESS));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "levitation_immunity"), Set.of(MobEffects.LEVITATION));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "hunger_immunity"), Set.of(MobEffects.HUNGER));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "wither_immunity"), Set.of(MobEffects.WITHER));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "luck_immunity"), Set.of(MobEffects.LUCK));
        IMMUNITIES.put(ResourceLocation.fromNamespaceAndPath("netherexp", "unluck_immunity"), Set.of(MobEffects.UNLUCK));
    }

    @SubscribeEvent
    public static void onImmunityEffect(MobEffectEvent.Applicable event) {
        LivingEntity entity=event.getEntity();
        MobEffectInstance effectInstance=event.getEffectInstance();
        if(entity == null || effectInstance == null) return;
        Holder<MobEffect> effect=effectInstance.getEffect();
        for(MobEffectInstance instance : entity.getActiveEffects()) {
            Holder<MobEffect> effectHolder=instance.getEffect();
            for(Map.Entry<ResourceLocation,Set<Holder<MobEffect>>> entry : IMMUNITIES.entrySet()) {
                var immunity=BuiltInRegistries.MOB_EFFECT.getHolder(entry.getKey());
                if(immunity.isEmpty()) continue;
                if (effectHolder.equals(immunity.get()) && entry.getValue().contains(effect)) {
                    event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
                    return;
                }
            }
        }
    }
}
