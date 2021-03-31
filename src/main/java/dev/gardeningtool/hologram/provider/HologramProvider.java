package dev.gardeningtool.hologram.provider;

import dev.gardeningtool.hologram.object.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HologramProvider {

    private final Map<Integer, Hologram> taskIDs = new HashMap<>();
    private final List<Hologram> managedHolograms = new ArrayList<>();
    private final JavaPlugin plugin;

    public HologramProvider(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerHologram(Hologram hologram) {
        managedHolograms.add(hologram);

        if (hologram.hasTask()) {
            taskIDs.put(Bukkit.getScheduler().runTaskTimer(plugin, () -> hologram.getTask().getRunnableTask().run(), 0L, hologram.getTask().getDelay() / 50).getTaskId(), hologram);
        }
    }

    public List<Hologram> getManagedHolograms() {
        return managedHolograms;
    }

    public Map<Integer, Hologram> getHologramTaskIDs() {
        return taskIDs;
    }

}
