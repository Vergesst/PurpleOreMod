package vergesst.demomod.demo.Feature;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface ImplementedInventory extends Inventory{
    /**
    * 从此物品栏中检索物品
    * 每次被调用的时候返回相同实例
    */
    DefaultedList<ItemStack> getContents();
    /**
     * 从物品列表创建物品栏
     */
    static ImplementedInventory of(DefaultedList<ItemStack> items) {
        return () -> items;
    }
    /**
     * 根据指定的尺寸创建新的物品栏
     */
    static ImplementedInventory ofSize(int size) {
        return of(DefaultedList.ofSize(size, ItemStack.EMPTY));
    }
    /**
     * 返回物品栏的大小
     */
    @Override
    default int size(){
        return getContents().size();
    }
    /**
     * check whether the Inventory is empty
     */
    @Override
    default boolean isEmpty(){
        for(int i = 0;i < size();i++){
            ItemStack item = getContents().get(i);
            if(!item.isEmpty())
                return false;
        }
        return true;
    }
    /**
     * check Items in itemStack
     */
    @Override
    default ItemStack getStack(int slot) {
        return getContents().get(slot);
    }
    /**
     * remove items from the ItemStack
     * @param slot remove from here
     * @param count the number of items to be removed
     */
    @Override
    default ItemStack removeStack(int slot, int count) {
        ItemStack stack = getStack(slot);
        if(!stack.isEmpty()){
            markDirty();
        }
        return stack;
    }
    /**
     * remove all items from the inventory column slot
     * @param slot remove from here
     */
    default ItemStack removeStack(int slot){
        return Inventories.removeStack(getContents(), slot);
    }
    /**
     * replace current item heap to provided item heap
     * @param slot the stack for alternate
     * @param stack the new stack after replacement, if heap is too big for this inventory column,
     *              ({@link Inventory#getMaxCountPerStack()}), then compress the maxim number of inventory column
     */
    @Override
    default void setStack(int slot, ItemStack stack) {
        getContents().set(slot, stack);
        if(stack.getCount() > getMaxCountPerStack()){
            stack.setCount(getMaxCountPerStack());
        }
    }/**
     * clear the inventory column
     */
    @Override
    default void clear() {
        getContents().clear();
    }
    /**
     * 将方块状态标记为脏。
     * 更改物品栏之后必须调用，所以游戏正确地储存物品栏内容并提取邻近方块物品栏改变。
     */
    @Override
    default void markDirty() {
        // 需要行为时，覆盖此方法。
    }

    /**
     * @return true 如果玩家可以使用物品栏，否则为 false。i
     */
    @Override
    default boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

}
