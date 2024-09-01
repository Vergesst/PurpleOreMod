package vergesst.demomod.demo.Global;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum GlobalToolMaterial implements ToolMaterial {

    PURPLE_NETHERITE (5, 4095, 9.5F, 4.5F, 15, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{GlobalItems.PURPLE_NETHERITE_INGOT});
    });

//   member arguments
//   miningLevel, itemDurability, miningSpeed, attackDamage, enchantAbility
//   Integer, Integer, Float, Float, Integer
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantAbility;
    private final Lazy<Ingredient> repairMaterial;

//    Constructor
    GlobalToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantAbility, Supplier<Ingredient> repairMaterial) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantAbility = enchantAbility;
        this.repairMaterial = new Lazy<>(repairMaterial);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantAbility;
    }

    @Override
    public Ingredient getRepairIngredient() {
//        why should be written like this
        return (Ingredient) this.repairMaterial.get();
    }
}
