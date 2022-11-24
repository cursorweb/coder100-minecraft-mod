package net.fabricmc.garden;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Garden implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("gardenmod");
	public static final Item BAD_APPLE = new BadApple(
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

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.ITEM, new Identifier("garden", "bad_apple"), BAD_APPLE);
	}
}
