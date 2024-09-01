package vergesst.demomod.demo.Global;

import net.minecraft.item.*;
import vergesst.demomod.demo.Annotations.WrongCode;
import vergesst.demomod.demo.Feature.SoulFireChargeItem;
import vergesst.demomod.demo.Feature.purpleNetheriteItem;
import vergesst.demomod.demo.Util.ArmorUtil;
import vergesst.demomod.demo.Util.BlockUtil;
import vergesst.demomod.demo.Util.ItemUtil;
import vergesst.demomod.demo.Util.ToolUtil;

import java.lang.reflect.InvocationTargetException;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class GlobalItems {
//    like class ITEMS in minecraft, the globalItems class here is aimed for better management of items in this modification

    public static Item ORE_DASH;
    public static Item PURPLE_NETHERITE_INGOT;
    public static Item PURPLE_HELMET;
    public static Item PURPLE_CHESTPLATE;
    public static Item INFESTED_PINK;
    public static Item PURPLE_ORE;
    public static Item PURPLE_BLOCK;
    public static Item ORIENT_BLOCK;

/*Tools are listed as below*/
    public static ToolItem PURPLE_PICKAXE;
    public static SwordItem GRAND_DIAMOND_SWORD;

/*Fire Charge*/
    public static SoulFireChargeItem SOUL_FIRE_CHARGE_ITEM;
/*Shields*/
//    public static DemoShield DEMO_SHIELD;

//    to register items like the original ItemUtil class
    public static void itemRegister() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ORE_DASH = ItemUtil.itemCreator(MOD_ID, "purple_ore_dash", ItemGroups.INGREDIENTS, Items.NETHERITE_INGOT);
        PURPLE_NETHERITE_INGOT = ItemUtil.itemCreator(MOD_ID, "purple_netherite_ingot", purpleNetheriteItem.class, ItemGroups.INGREDIENTS, Items.NETHERITE_INGOT);
        PURPLE_HELMET = ArmorUtil.armorCreator(MOD_ID, "purple_netherite_helmet", ItemGroups.COMBAT, Items.NETHERITE_BOOTS, GlobalMaterials.PURPLE_NETHERITE, ArmorItem.Type.HELMET);
        PURPLE_CHESTPLATE = ArmorUtil.armorCreator(MOD_ID, "purple_netherite_chestplate", ItemGroups.COMBAT, GlobalItems.PURPLE_HELMET, GlobalMaterials.PURPLE_NETHERITE, ArmorItem.Type.CHESTPLATE);

        //From blocks
        INFESTED_PINK = BlockUtil.blockItemCreator("demo", MOD_ID, "infested_pink", GlobalBlocks.INFESTED_PINK);
        PURPLE_BLOCK = BlockUtil.blockItemCreator(MOD_ID, "purple_block", GlobalBlocks.PURPLE_BLOCK, ItemGroups.BUILDING_BLOCKS, Items.NETHERITE_BLOCK);
        PURPLE_ORE = BlockUtil.blockItemCreator(MOD_ID, "purple_ore", GlobalBlocks.PURPLE_ORE, ItemGroups.NATURAL, Items.DEEPSLATE_DIAMOND_ORE);
//        Here is wrong code
//        ORIENT_BLOCK = BlockUtil.blockItemCreator(MOD_ID, "orient_block_model.json", GlobalBlocks.ORIENT_BLOCK, ItemGroups.BUILDING_BLOCKS, Items.NETHERITE_BLOCK);
        ORIENT_BLOCK = BlockUtil.blockItemCreator(MOD_ID, "orient_block", GlobalBlocks.ORIENT_BLOCK, ItemGroups.BUILDING_BLOCKS, Items.NETHERITE_BLOCK);

        //Tools
        PURPLE_PICKAXE = ToolUtil.toolCreator("purple_pickaxe", GlobalToolMaterial.PURPLE_NETHERITE, ItemGroups.TOOLS, Items.NETHERITE_HOE, 3, 0.1F, PickaxeItem.class);
        GRAND_DIAMOND_SWORD = ToolUtil.toolCreator("grand_diamond_sword", ToolMaterials.DIAMOND, ItemGroups.COMBAT, Items.DIAMOND_SWORD, 12, 1.5f, SwordItem.class);

        //Fire Charge
        SOUL_FIRE_CHARGE_ITEM = ItemUtil.itemCreator(MOD_ID, "soul_fire_charge", SoulFireChargeItem.class, ItemGroups.TOOLS, Items.FIRE_CHARGE);
        //Shield
//        DEMO_SHIELD = ItemUtil.itemCreator("demo_shield", DemoShield.class);
    }
}
