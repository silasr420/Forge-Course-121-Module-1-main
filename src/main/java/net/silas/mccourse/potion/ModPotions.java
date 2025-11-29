package net.silas.mccourse.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Potion> FESTIVE_POTION = POTIONS.register("festive_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FESTIVE_EFFECT.getHolder().get(), 6000, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
