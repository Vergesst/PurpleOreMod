package vergesst.demomod.demo.CusBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/*
only to detect whether this block will work in a new world
 */
public class InfestedBlock extends Block {
    public InfestedBlock(AbstractBlock.Settings settings) {
        super(settings);
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        this.spawnBreakParticles(world, player, pos, state);
        SilverfishEntity silverfishEntity = EntityType.SILVERFISH.create(world);
        assert silverfishEntity != null;
        silverfishEntity.setPosition(pos.getX() + .5, pos.getY(), pos.getZ() + .5);
        world.spawnEntity(silverfishEntity);
    }
    //to get sample tool tip sentences
    private String getDescription(){
        return this.getTranslationKey().replace("block.demo.","");
    }
//    Annotation Nullable is used to imply this parameter could be matched with a null value
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable(this.getDescription()).formatted(Formatting.GRAY));
    }
}
