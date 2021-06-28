package rmc.mixins.eidolon_newmagic.inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import elucent.eidolon.ritual.DaylightRitual;
import elucent.eidolon.ritual.MoonlightRitual;
import elucent.eidolon.ritual.Ritual;
import elucent.eidolon.ritual.RitualRegistry;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = RitualRegistry.class)
public abstract class RitualRegistryMixin {

    @Inject(method = "Lelucent/eidolon/ritual/RitualRegistry;register(Lnet/minecraft/item/Item;Lelucent/eidolon/ritual/Ritual;)Lelucent/eidolon/ritual/Ritual;",
            remap = false,
            cancellable = true,
            at = @At(value = "HEAD"))
    private static void disableDaylightRitual(Item sacrifice, Ritual ritual, CallbackInfoReturnable<Ritual> mixin) {
        if (ritual instanceof DaylightRitual) {
            mixin.setReturnValue(ritual);
        }
    }

    @Inject(method = "Lelucent/eidolon/ritual/RitualRegistry;register(Lnet/minecraft/tags/ITag;Lelucent/eidolon/ritual/Ritual;)Lelucent/eidolon/ritual/Ritual;",
            remap = false,
            cancellable = true,
            at = @At(value = "HEAD"))
    private static void disableMoonlightRitual(ITag<?> sacrifice, Ritual ritual, CallbackInfoReturnable<Ritual> mixin) {
        if (ritual instanceof MoonlightRitual) {
            mixin.setReturnValue(ritual);
        }
    }

}