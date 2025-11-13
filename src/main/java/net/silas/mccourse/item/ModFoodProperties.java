package net.silas.mccourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible()
            .effect(new MobEffectInstance(MobEffects.LUCK, 6000), 1)
            .effect(new MobEffectInstance(MobEffects.LEVITATION, 200), 1)
            .effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 240), 1)
            .build();

}
