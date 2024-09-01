package vergesst.demomod.demo.Util;
/*
需要改动
 */

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class ItemGroupUtil {
//    using this method to add quantity of items into one itemGroup
    public static ItemGroup itemGroupCreator(String namespace, String name, String display, List<Item> itemList){
        return Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(namespace, name),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(itemList.get(0)))
                        .displayName(Text.translatable(display))
                        .entries(
                                (content, entries) -> {
                                    for(Item item : itemList){
                                        entries.add(new ItemStack(item));
                                    }
                                }
                        )
                        .build()
        );
    }
//    use this to register an itemGroup
    public static ItemGroup itemGroupCreator(String namespace, String name, String display, Item item){
        return Registry.register(
                Registries.ITEM_GROUP,
                new Identifier(namespace, name),
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(item))
                        .displayName(Text.translatable(display))
                        .entries(
                                (context, entries) -> {
                                    entries.add(new ItemStack(item));
                                }
                        )
                        .build()
        );
    }
    @Deprecated
//    cause nullPointerException
    public static void itemGroupCreator(RegistryKey<ItemGroup> groupKey, String display, List<Item> itemList){
        Registry.register(
                Registries.ITEM_GROUP,
                groupKey,
                ItemGroup.create(ItemGroup.Row.TOP, 0).displayName(Text.translatable(display))
                        .icon(() -> {
                            return new ItemStack(itemList.get(0));
                        })
                        .entries(
                                ((displayContext, entries) -> {
                                    for(Item item : itemList){
                                        entries.add(new ItemStack(item));
                                    }
                                })
                        ).build()
        );
    }
    public static void itemGroupRegister(){
        ItemGroup demo = itemGroupCreator(MOD_ID, "demo", "Demo", ItemUtil.groupedItems.get("demo"));
    }
}
