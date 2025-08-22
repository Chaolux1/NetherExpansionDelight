package net.chaolux.jadensnetherexpansiondelight.common.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@EventBusSubscriber(modid = "jadensnetherexpansiondelight", bus = Bus.FORGE)
public class ImmunityEvent {
    private static final Map<ResourceLocation, Set<MobEffect>> IMMUNITIES=new HashMap<>();
    static {
        IMMUNITIES.put(new ResourceLocation("netherexp", "speed_immunity"), Set.of(MobEffects.MOVEMENT_SPEED));
        IMMUNITIES.put(new ResourceLocation("netherexp", "slowness_immunity"), Set.of(MobEffects.MOVEMENT_SLOWDOWN));
        IMMUNITIES.put(new ResourceLocation("netherexp", "strength_immunity"), Set.of(MobEffects.DAMAGE_BOOST));
        IMMUNITIES.put(new ResourceLocation("netherexp", "jump_boost_immunity"), Set.of(MobEffects.JUMP));
        IMMUNITIES.put(new ResourceLocation("netherexp", "regeneration_immunity"), Set.of(MobEffects.REGENERATION));
        IMMUNITIES.put(new ResourceLocation("netherexp", "fire_resistance_immunity"), Set.of(MobEffects.FIRE_RESISTANCE));
        IMMUNITIES.put(new ResourceLocation("netherexp", "water_breathing_immunity"), Set.of(MobEffects.WATER_BREATHING));
        IMMUNITIES.put(new ResourceLocation("netherexp", "invisibility_immunity"), Set.of(MobEffects.INVISIBILITY));
        IMMUNITIES.put(new ResourceLocation("netherexp", "weakness_immunity"), Set.of(MobEffects.WEAKNESS));
        IMMUNITIES.put(new ResourceLocation("netherexp", "poison_immunity"), Set.of(MobEffects.POISON));
        IMMUNITIES.put(new ResourceLocation("netherexp", "resistance_immunity"), Set.of(MobEffects.DAMAGE_RESISTANCE));
        IMMUNITIES.put(new ResourceLocation("netherexp", "absorption_immunity"), Set.of(MobEffects.ABSORPTION));
        IMMUNITIES.put(new ResourceLocation("netherexp", "haste_immunity"), Set.of(MobEffects.DIG_SPEED));
        IMMUNITIES.put(new ResourceLocation("netherexp", "mining_fatigue_immunity"), Set.of(MobEffects.DIG_SLOWDOWN));
        IMMUNITIES.put(new ResourceLocation("netherexp", "darkness_immunity"), Set.of(MobEffects.DARKNESS));
        IMMUNITIES.put(new ResourceLocation("netherexp", "levitation_immunity"), Set.of(MobEffects.LEVITATION));
        IMMUNITIES.put(new ResourceLocation("netherexp", "hunger_immunity"), Set.of(MobEffects.HUNGER));
        IMMUNITIES.put(new ResourceLocation("netherexp", "wither_immunity"), Set.of(MobEffects.WITHER));
        IMMUNITIES.put(new ResourceLocation("netherexp", "luck_immunity"), Set.of(MobEffects.LUCK));
        IMMUNITIES.put(new ResourceLocation("netherexp", "unluck_immunity"), Set.of(MobEffects.UNLUCK));
    }

    @SubscribeEvent
    public static void onImmunityEffect(MobEffectEvent.Applicable event) {
        LivingEntity entity=event.getEntity();
        MobEffectInstance effectInstance=event.getEffectInstance();
        if(entity == null || effectInstance == null) return;
        MobEffect effect=effectInstance.getEffect();
        for(MobEffectInstance instance : entity.getActiveEffects()) {
            for(Map.Entry<ResourceLocation,Set<MobEffect>> entry : IMMUNITIES.entrySet()) {
                ResourceLocation resourceLocation=entry.getKey();
                MobEffect mobEffect= ForgeRegistries.MOB_EFFECTS.getValue(resourceLocation);
                if(mobEffect == null) continue;
                if(instance.getEffect() == mobEffect) {
                    if(entry.getValue().contains(effect)) {
                        event.setResult(Event.Result.DENY);
                        return;
                    }
                }
            }
        }
    }
}
