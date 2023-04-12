package org.polly51104.biomedisplayer.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiomeDisplayerClient implements ClientModInitializer {

    private static BiomeDisplayerClient instance;
    public static final Logger LOGGER = LoggerFactory.getLogger("biomedisplayer"); // logger pog

    private final KeyBinding keyBinding = createOverlayKeybinding();
    private final BiomeOverlay biomeOverlay = new BiomeOverlay();

    @Override
    public void onInitializeClient() { // called when game loads
        setInstance(this);
        LOGGER.info("BiomeDisplayer initialised");
    }

    private static KeyBinding createOverlayKeybinding() {
        return new KeyBinding(
            "key.biomedisplayer.toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_B,
            "category.biomedisplayer.test"
        );
    }

    private static void setInstance(BiomeDisplayerClient newInstance) {
        instance = newInstance;
    }

    public static BiomeDisplayerClient getInstance() {
        return instance;
    }

    public KeyBinding getKeyBinding(){
        return instance.keyBinding;
    }

    public BiomeOverlay getBiomeOverlay() {
        return instance.biomeOverlay;
    }
}
