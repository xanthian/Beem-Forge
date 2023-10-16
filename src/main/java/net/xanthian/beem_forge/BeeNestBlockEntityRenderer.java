package net.xanthian.beem_forge;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class BeeNestBlockEntityRenderer implements BlockEntityRenderer<BeehiveBlockEntity> {

    public static final ResourceLocation BEAM_TEXTURE = new ResourceLocation("beem:textures/entity/beem.png");
    public static final DyeColor BEAM_COLOR = DyeColor.YELLOW;

    @Override
    public void render(BeehiveBlockEntity pBlockEntity, float pPartialTick, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pBlockEntity.getLevel().getBlockState(pBlockEntity.getBlockPos()).getBlock().equals(Blocks.BEE_NEST) && ClientEvents.beem) {
            long time = pBlockEntity.getLevel().getDayTime();
            BeaconRenderer.renderBeaconBeam(pPoseStack, pBuffer, BEAM_TEXTURE, pPartialTick, 1.0f, time, 0, 256, BEAM_COLOR.getTextureDiffuseColors(), 0.25F, 0.35F);
            BeaconRenderer.renderBeaconBeam(pPoseStack, pBuffer, BEAM_TEXTURE, pPartialTick, 1.0f, time, 0, -256, BEAM_COLOR.getTextureDiffuseColors(), 0.25F, 0.35F);
        }
    }

    @Override
    public int getViewDistance() {
        return 256;
    }
}