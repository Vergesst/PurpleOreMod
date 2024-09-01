package vergesst.demomod.demo.Util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class EnchantUtil {
//    public static <T> T enchantmentCreator(String enchantName, Class<T> clazz){
//        return Registry.register()
//    }
    public static <T extends Enchantment> T enchantRegister(String name, T enchantment) {
        return Registry.register(
                Registries.ENCHANTMENT,
                new Identifier(MOD_ID, name),
                enchantment
        );
    }
    public static <T extends Enchantment> T enchantRegister(String name, Class<T> clazz, Enchantment.Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = clazz.getDeclaredConstructor(Enchantment.Rarity.class, EnchantmentTarget.class, EquipmentSlot[].class);
        constructor.setAccessible(true);
        T enchant = clazz.cast(constructor.newInstance(weight, target, slotTypes));
        return Registry.register(
                Registries.ENCHANTMENT,
                new Identifier(MOD_ID, name),
                enchant
        );
    }
}
