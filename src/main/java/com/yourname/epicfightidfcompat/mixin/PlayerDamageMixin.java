package com.yourname.epicfightidfcompat.mixin;

import com.yourname.epicfightidfcompat.compat.DamageHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.entity.player.Player;

@Mixin(Player.class)
public abstract class PlayerDamageMixin {
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void onHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        amount = DamageHandler.handleDamage(amount);
        
    }
}
