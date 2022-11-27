package net.fabricmc.garden.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class ColoredBlock extends Block {
    public ColoredBlock(boolean light) {
        super(
                FabricBlockSettings
                        .of(Material.STONE)
                        .nonOpaque()
                        .luminance(light ? 15 : 0)
                        .strength(1.8f, 1.8f)
        );
    }

    public ColoredBlock() {
        this(false);
    }
}
