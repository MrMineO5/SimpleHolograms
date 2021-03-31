package dev.gardeningtool.hologram;

import dev.gardeningtool.hologram.provider.HologramProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class HologramManager {

    private static final Map<HologramProvider, JavaPlugin> providers = new HashMap<>();

    public static void registerHologramProvider(HologramProvider hologramProvider, JavaPlugin javaPlugin) {
        providers.put(hologramProvider, javaPlugin);
    }
}
