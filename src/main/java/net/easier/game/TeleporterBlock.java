package net.easier.game;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class TeleporterBlock extends Block implements BlockEntityProvider {

    public TeleporterBlock (Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new TeleporterBlockEntity();
    }
}
