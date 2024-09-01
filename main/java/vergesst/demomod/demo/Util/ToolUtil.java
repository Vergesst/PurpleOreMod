package vergesst.demomod.demo.Util;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class ToolUtil {
    public static <T extends ToolItem> T toolCreator(String toolName, ToolMaterial material, int attackDamage, float attackSpeed, Class<T> toolClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = toolClass.getConstructor(ToolMaterial.class, int.class, float.class, Item.Settings.class);
        constructor.setAccessible(true);
        return Registry.register(
                Registries.ITEM,
                new Identifier(MOD_ID, toolName),
                toolClass.cast(constructor.newInstance(material, attackDamage, attackSpeed, new Item.Settings()))
        );
    }
    public static <T extends ToolItem> T toolCreator(String toolName, ToolMaterial material, RegistryKey<ItemGroup> group, Item target, int attackDamage, float attackSpeed, Class<T> toolClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = toolClass.getConstructor(ToolMaterial.class, int.class, float.class, Item.Settings.class);
        constructor.setAccessible(true);
        T tool = toolClass.cast(constructor.newInstance(material, attackDamage, attackSpeed, new Item.Settings()));
        ItemUtil.addToItemGroup(group, target, tool);
        return Registry.register(
                Registries.ITEM,
                new Identifier(MOD_ID, toolName),
                tool
        );
    }
}
