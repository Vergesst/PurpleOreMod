package vergesst.demomod.demo.Util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BlockUtil {
    public static Block blockCreator(String namespace, String name, float hardness, float resistance){
        return Registry.register(
                Registries.BLOCK,
                new Identifier(namespace, name),
                new Block(FabricBlockSettings.create().strength(hardness, resistance))
        );
    }
    public static <T extends Block> T blockCreator(String namespace, String name, float hardness, float resistance, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getDeclaredConstructor(AbstractBlock.Settings.class);
        constructor.setAccessible(true);
        return Registry.register(
                Registries.BLOCK,
                new Identifier(namespace, name),
                clazz.cast(constructor.newInstance(FabricBlockSettings.create().strength(hardness, resistance)))
        );
    }
    public static Item blockItemCreator(String namespace, String name, Block block, RegistryKey<ItemGroup> itemGroup, Item targetItem){
//        ItemUtil.push(targetId, ItemUtil.groupedItems);
        Item blockItem = new BlockItem(block, new Item.Settings());
        ItemUtil.addToItemGroup(itemGroup, targetItem, blockItem);
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                blockItem
        );
    }
    public static Item blockItemCreator(String targetId, String namespace, String name, Block block){
        Item blockItem = new BlockItem(block, new Item.Settings());
        ItemUtil.push(targetId, ItemUtil.groupedItems);
        ItemUtil.groupedItems.get(targetId).add(blockItem);
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                blockItem
        );
    }
    public static Item blockItemCreator(String namespace, String name, Block block){
        return Registry.register(
                Registries.ITEM,
                new Identifier(namespace, name),
                new BlockItem(block, new Item.Settings())
        );
    }
//    public static void blockRegister() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        InfestedBlock block = blockCreator(MOD_ID, "infested_pink", 1.0F, 13.0F, InfestedBlock.class);
//        Item item = blockItemCreator("demo", MOD_ID, "infested_pink", block);
//        Block purpleOreBlock = blockCreator(MOD_ID, "purple_ore", 5.0F, 25.0F);
//        Item purpleOre = blockItemCreator(MOD_ID, "purple_ore", purpleOreBlock, ItemGroups.NATURAL, Items.DEEPSLATE_DIAMOND_ORE);
//        Block purpleBlock = blockCreator(MOD_ID, "purple_block", 5.0F, 25.0F);
//        Item purpleBlockItem = blockItemCreator(MOD_ID, "purple_block",purpleBlock ,ItemGroups.BUILDING_BLOCKS, Items.NETHERITE_BLOCK);
//    }
}
