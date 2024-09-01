package vergesst.demomod.demo.Util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class ItemUtil {
    public static Map<String, List<Item>> groupedItems = new HashMap<>();

    static void push(String targetGroupId, Map<String, List<Item>> groupedItems){
        if(!groupedItems.containsKey(targetGroupId)){
            groupedItems.put(targetGroupId, new ArrayList<>());
        }
    }
    static void addToItemGroup(RegistryKey<ItemGroup> group,Item target, Item item) {
        if(target == null){
            ItemGroupEvents.modifyEntriesEvent(group).register(
                    context -> context.add(item)
            );
        } else {
            ItemGroupEvents.modifyEntriesEvent(group).register(
                    context -> context.addAfter(target, item)
            );
        }
    }
    public static Item itemCreator(String namespace, String name, RegistryKey<ItemGroup> group, Item targetItem){
        Item item = new Item(new Item.Settings());
        addToItemGroup(group, targetItem, item);
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                item
        );
    }
    public static <T extends Item> T itemCreator(String namespace, String name, Class<T> clazz, RegistryKey<ItemGroup> group, Item targetItem) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getConstructor(Item.Settings.class);
        constructor.setAccessible(true);
        T item = clazz.cast(constructor.newInstance(new Item.Settings()));
        addToItemGroup(group, targetItem, item);
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                item
        );
    }

    public static Item itemCreator(String namespace, String name, String targetGroupId){
        Item item = new Item(new Item.Settings());
        push(targetGroupId, groupedItems);
        groupedItems.get(targetGroupId).add(item);
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                item
        );
    }
    public static <T extends Item> T itemCreator(String name, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getConstructor(Item.Settings.class);
        constructor.setAccessible(true);
        T tmp = clazz.cast(constructor.newInstance(new Item.Settings()));
        return Registry.register(
                Registries.ITEM,
                new Identifier(MOD_ID, name),
                tmp
        );
    }
}
