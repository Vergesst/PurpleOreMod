package vergesst.demomod.demo.Generate.Advancements.Criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.util.Identifier;

public class ArrivalCriterion extends AbstractCriterion<ArrivalCriterion.Conditions> {

    @Override
    protected Conditions conditionsFromJson(JsonObject obj, LootContextPredicate playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return null;
    }

    @Override
    public Identifier getId() {
        return null;
    }

    public static class Conditions extends AbstractCriterionConditions {

        public Conditions(Identifier id, LootContextPredicate entity) {
            super(id, entity);
        }
    }
}
