package net.fabricmc.garden;

import net.minecraft.item.Item;

public class BadApple extends Item {

    public BadApple(Settings settings) {
        super(settings);
    }

    /*
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.eatFood(world, user.getStackInHand(hand));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20 * 30));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 60));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 60, 2));
        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
    */


}
