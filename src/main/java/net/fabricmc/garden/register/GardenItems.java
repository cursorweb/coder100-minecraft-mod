package net.fabricmc.garden.register;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GardenItems {
    private static final Item BAD_APPLE = new Item(
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

    private static final Item ROTTEN_CARROT = new Item(
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

    private static final Item GOLDEN_POTATO = new Item(
            new Item.Settings()
                    .group(ItemGroup.FOOD)
                    .food(
                            new FoodComponent.Builder()
                                    .hunger(5)
                                    .saturationModifier(6.0f)
                                    .alwaysEdible()
                                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5 * 20), 1)
                                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 120 * 20, 1), 1)
                                    .build()
                    )
    );

    private static final Identifier OAK_LEAVES_LOOT_TABLE_ID = Blocks.OAK_LEAVES.getLootTableId();
    private static final Identifier DARK_OAK_LEAVES_LOOT_TABLE_ID = Blocks.DARK_OAK_LEAVES.getLootTableId();
    private static final Identifier CARROTS_LOOT_TABLE_ID = Blocks.CARROTS.getLootTableId();

    public static void init() {
        registerItems();
        registerLootTable();
    }

    private static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("garden", "bad_apple"), BAD_APPLE);
        Registry.register(Registry.ITEM, new Identifier("garden", "rotten_carrot"), ROTTEN_CARROT);

        Registry.register(Registry.ITEM, new Identifier("garden", "golden_potato"), GOLDEN_POTATO);
    }

    private static void registerLootTable() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && (OAK_LEAVES_LOOT_TABLE_ID.equals(id) || DARK_OAK_LEAVES_LOOT_TABLE_ID.equals(id))) {
                tableBuilder.pool(
                        LootPool
                                .builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.01f).build())
                                .with(ItemEntry.builder(BAD_APPLE))
                );
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && CARROTS_LOOT_TABLE_ID.equals(id)) {
                tableBuilder.pool(
                        LootPool
                                .builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.02f).build())
                                .with(ItemEntry.builder(ROTTEN_CARROT))
                );
            }
        });
    }
}
