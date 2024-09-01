package vergesst.demomod.demo.Feature;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.List;

public class DemoItemGroup {
    private static RegistryKey<ItemGroup> register(String id){
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(id));
    }
    public static RegistryKey<ItemGroup> GOD = register("god");
    public static RegistryKey<ItemGroup> DEMO;
    public static void register(List<Item> itemList){
    }
}
