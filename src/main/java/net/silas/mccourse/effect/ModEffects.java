package net.silas.mccourse.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.mccourse.MCCourseMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MCCourseMod.MOD_ID);

    public static final RegistryObject<MobEffect> FESTIVE_EFFECT = MOB_EFFECTS.register("festive",
            () -> new FestiveEffect(MobEffectCategory.BENEFICIAL, 0x077601));

    public static void  register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
