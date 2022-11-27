package net.fabricmc.garden.register;

//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.garden.blocks.ColoredBlock;
//import net.fabricmc.garden.blocks.Lettuce;
//import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GardenBlocks {
    private static final ColoredBlock BLACK_BLOCK = new ColoredBlock();
    private static final ColoredBlock WHITE_BLOCK = new ColoredBlock(true);

//    private static final Block LETTUCE = new Lettuce(FabricBlockSettings.copyOf(Blocks.WHEAT).nonOpaque());

    public static void init() {
        registerBlocks();
    }

    private static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("garden", "black_block"), BLACK_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("garden", "black_block"), new BlockItem(
                BLACK_BLOCK,
                new Item.Settings()
                        .group(ItemGroup.BUILDING_BLOCKS)
        ));

        Registry.register(Registry.BLOCK, new Identifier("garden", "white_block"), WHITE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("garden", "white_block"), new BlockItem(
                WHITE_BLOCK,
                new Item.Settings()
                        .group(ItemGroup.BUILDING_BLOCKS)
        ));
    }
}
