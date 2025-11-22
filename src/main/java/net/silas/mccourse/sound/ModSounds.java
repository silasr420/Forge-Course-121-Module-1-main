package net.silas.mccourse.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.mccourse.MCCourseMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCCourseMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CHAINSAW_CUT = registerSoundEvent("chainsaw_cut");
    public static final RegistryObject<SoundEvent> CHAINSAW_PULL = registerSoundEvent("chainsaw_pull");

    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final ForgeSoundType MAGIC_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.MAGIC_BLOCK_BREAK, ModSounds.MAGIC_BLOCK_STEP, ModSounds.MAGIC_BLOCK_PLACE, ModSounds.MAGIC_BLOCK_HIT, ModSounds.MAGIC_BLOCK_FALL);

    public static final RegistryObject<SoundEvent> UP_HOUSETOP = registerSoundEvent("up_housetop");
    public static final ResourceKey<JukeboxSong> UP_HOUSETOP_KEY = createSong("up_housetop");

    /*
    Up on a Housetop by Kevin MacLeod | https://incompetech.com/
    Music promoted by https://www.chosic.com/free-music/all/
    Creative Commons CC BY 3.0
    https://creativecommons.org/licenses/by/3.0/

     */

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, name));
    }

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);

    }
}
