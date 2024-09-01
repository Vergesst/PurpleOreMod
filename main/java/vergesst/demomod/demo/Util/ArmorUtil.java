package vergesst.demomod.demo.Util;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

/*
Util classes sre used to provide INTERFACES for activities.
So register method should be removed.
 */

public class ArmorUtil {
    public static ArmorItem armorCreator(String namespace, String name, String targetId, ArmorMaterial material, ArmorItem.Type t) {
        ArmorItem item = new ArmorItem(material, t, new Item.Settings());
        ItemUtil.groupedItems.get(targetId).add(item);
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                item
        );
    }
    public static ArmorItem armorCreator(String namespace, String name, RegistryKey<ItemGroup> key, Item target, ArmorMaterial material, ArmorItem.Type t) {
        ArmorItem item = new ArmorItem(material, t, new Item.Settings());
        ItemUtil.addToItemGroup(key, target, item);
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                item
        );
    }
}
