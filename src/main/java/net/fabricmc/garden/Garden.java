package net.fabricmc.garden;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Garden implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("gardenmod");
    public static final Item BAD_APPLE = new Item(
            new Item.Settings()
                    .group(ItemGroup.FOOD)
                    .food(
                            new FoodComponent.Builder()
                                    .hunger(8)
                                    .saturationModifier(4.8f)
                                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20), 1)
                                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 30 * 20), 1)
                                    .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 30 * 20), 1)
                                    .build()
                    )
    );

    public static final Item ROTTEN_CARROT = new Item(
            new Item.Settings()
                    .group(ItemGroup.FOOD)
                    .food(
                            new FoodComponent.Builder()
                                    .hunger(6)
                                    .saturationModifier(7.2f)
                                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 15 * 20), 0.5f)
                                    .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 15 * 20), 0.5f)
                                    .build()
                    )
    );

    public static final ColoredBlock BLACK_BLOCK = new ColoredBlock();

    public static final ColoredBlock WHITE_BLOCK = new ColoredBlock(true);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        Registry.register(Registry.ITEM, new Identifier("garden", "bad_apple"), BAD_APPLE);
        Registry.register(Registry.ITEM, new Identifier("garden", "rotten_carrot"), ROTTEN_CARROT);

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
