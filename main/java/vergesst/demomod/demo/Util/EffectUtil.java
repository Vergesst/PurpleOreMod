package vergesst.demomod.demo.Util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class EffectUtil {
    public static <T extends StatusEffect> T effectCreator(String name, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return Registry.register(
                Registries.STATUS_EFFECT,
                new Identifier(MOD_ID, name),
                clazz.cast(constructor.newInstance())
        );
    }
}
