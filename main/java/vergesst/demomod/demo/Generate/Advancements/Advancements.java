package vergesst.demomod.demo.Generate.Advancements;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.advancement.criterion.PlayerHurtEntityCriterion;
import net.minecraft.advancement.criterion.TravelCriterion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WardenBrain;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class Advancements implements Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        Items.DIRT,
                        Text.literal("your first dirt block!"),
                        Text.literal("you make a 3 by 3"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK, // 选项: TASK, CHALLENGE, GOAL
                        true, // 在右上角显示
                        true, // 在聊天框中提示
                        false // 在进度页面里隐藏
                )
                .criterion("got_dirt", InventoryChangedCriterion.Conditions.items(Items.DIRT))
                .build(advancementConsumer, MOD_ID + "/root");

        Advancement gotOakAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.OAK_LOG,
                        Text.literal("get an oak log"),
                        Text.literal("get oak"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("got_oak_log", InventoryChangedCriterion.Conditions.items(Items.OAK_LOG))
                .build(advancementConsumer, MOD_ID + "/got_wood");
        Advancement killWardenAdvancement = Advancement.Builder.create().parent(gotOakAdvancement)
                .display(
                        Items.REINFORCED_DEEPSLATE,
                        Text.literal("Defeat Deep Dark"),
                        Text.literal("Kill a warden in a ancient city"),
                        new Identifier("textures/gui/advancements/background/adventure.png"),
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("kill_warden", OnKilledCriterion.Conditions.createPlayerKilledEntity(new EntityPredicate.Builder().type(EntityType.WARDEN)))
                .build(advancementConsumer, MOD_ID + "/kill_warden");
        Advancement killedByWardenAdvancement = Advancement.Builder.create()
                .display(
                        Items.OAK_LOG,
                        Text.literal(" "),
                        Text.literal(" "),
                        new Identifier("textures/gui/advancements/background/minecraft.png"),
                        AdvancementFrame.TASK,
                        false,
                        true,
                        false
                )
                .criterion("killed_by_warden", OnKilledCriterion.Conditions.createEntityKilledPlayer(new EntityPredicate.Builder().type(EntityType.WARDEN)))
                .build(advancementConsumer, MOD_ID);
//        Advancement viaCertainGate =
//        Advancement reachDeepDark = Advancement.Builder.create()
//                .display(
//                        Items.OAK_LOG,
//                        Text.literal(" "),
//                        Text.literal(" "),
//                        new Identifier("textures/gui/advancements/background/minecraft.png"),
//                        AdvancementFrame.TASK,
//                        false,
//                        false,
//                        false
//                )
//                .criterion("reach_deep_dark", TravelCriterion.Conditions.)
    }
}

