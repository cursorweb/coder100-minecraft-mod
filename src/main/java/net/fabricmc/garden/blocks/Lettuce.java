package net.fabricmc.garden.blocks;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class Lettuce extends CropBlock {
    public Lettuce(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return super.getSeedsItem();
    }
}
