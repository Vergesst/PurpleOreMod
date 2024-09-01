package vergesst.demomod.demo.Global;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import vergesst.demomod.demo.Feature.Enchantment.Frost;
import vergesst.demomod.demo.Util.EnchantUtil;

import java.lang.reflect.InvocationTargetException;

public class GlobalEnchant {
    public static Frost FROST;

    public static void register() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FROST = EnchantUtil.enchantRegister("frost", Frost.class, Enchantment.Rarity.COMMON, EnchantmentTarget.TRIDENT, EquipmentSlot.MAINHAND);
    }
}