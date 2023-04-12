package org.polly51104.biomedisplayer.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;


public class BiomeOverlay {

    private boolean isEnabled = false; // is my overlay enabled

    public void onHudRender(MatrixStack matrixStack) { // called every tick in game
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            if (client.options.debugEnabled || !isEnabled) return; // checks to see if f3 is open or if my overlay is on
            BlockPos blockPos = client.cameraEntity.getBlockPos(); // gets my position

            RegistryEntry<Biome> biomeRegistryEntry = client.world.getBiome(blockPos); // gets biome entry for my position
            String biomestring = "biome: " + getBiomeString(biomeRegistryEntry); // gets biome name
            client.textRenderer.draw(matrixStack, biomestring, 0f, 0f, 0xffffff); // renders the text to the top left of the screen in white
        }
    }

    private String getBiomeString(RegistryEntry<Biome> biome) {
        return biome.getKey().map(biomeKey -> biomeKey.getValue().toString().split(":")[1]).orElse("unknown");
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean value) {
        isEnabled = value;
    }
}
