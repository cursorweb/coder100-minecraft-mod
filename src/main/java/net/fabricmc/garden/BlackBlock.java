package net.fabricmc.garden;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class BlackBlock extends Block {
    public BlackBlock() {
        super(
                FabricBlockSettings
                        .of(Material.STONE)
                        .nonOpaque()
                        .requiresTool()
                        .strength(1.8f, 1.8f)
        );
    }
}
