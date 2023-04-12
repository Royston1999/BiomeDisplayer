package org.polly51104.biomedisplayer.mixin;

import net.minecraft.client.MinecraftClient;
import org.polly51104.biomedisplayer.client.BiomeDisplayerClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class EndTickMixin {
    @Inject(at = @At("RETURN"), method = "tick")
    private void onEndTick(CallbackInfo info) {
        BiomeDisplayerClient client = BiomeDisplayerClient.getInstance();
        while (client.getKeyBinding().wasPressed()) {
            client.getBiomeOverlay().setIsEnabled(!client.getBiomeOverlay().getIsEnabled());
        }
    }
}
