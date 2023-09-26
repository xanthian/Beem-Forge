package net.noobnarb.mixin;

import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BeehiveBlockEntity.class)
public abstract class BeehiveBlockEntityMixin extends BlockEntity {
    public BeehiveBlockEntityMixin(BlockEntityType<?> type) {
        super(type);
    }

    @Unique
    public double getSquaredRenderDistance() {
        return 65536.0D;
    }
}