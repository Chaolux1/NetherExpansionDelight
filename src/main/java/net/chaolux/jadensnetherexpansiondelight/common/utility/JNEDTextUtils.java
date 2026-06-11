package net.chaolux.jadensnetherexpansiondelight.common.utility;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class JNEDTextUtils {
    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("jadensnetherexpansiondelight." + key, args);
    }
}
