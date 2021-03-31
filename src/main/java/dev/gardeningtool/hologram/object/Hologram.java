package dev.gardeningtool.hologram.object;

import dev.gardeningtool.hologram.task.HologramTask;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class Hologram {
    private final Location location;
    private List<String> lines;
    private HologramTask task;
    private List<ArmorStand> ents;

    public Hologram(Location location, List<String> lines) {
        this.lines = lines.stream()
                .map(t -> ChatColor.translateAlternateColorCodes('&', t))
                .collect(Collectors.toList());
        this.location = location;
        this.ents = new ArrayList<>();
        spawn();
    }

    private void spawn() {
        if (ents != null) {
            ents.forEach(Entity::remove);
        }
        ents = new ArrayList<>();

        Location loc = location.clone();
        for (String str : lines) {
            ArmorStand hologram = location.getWorld().spawn(location, ArmorStand.class);
            hologram.setGravity(false);
            hologram.setVisible(false);
            hologram.setSmall(true);
            hologram.setCustomName(str);
            hologram.setCustomNameVisible(true);

            ents.add(hologram);

            loc = loc.clone();
            loc.add(0, -0.23, 0);
        }
    }

    public void setTask(HologramTask task) {
        this.task = task;
    }

    public boolean hasTask() {
        return task != null;
    }

    public void setLines(List<String> lines) {
        this.lines = lines.stream()
                .map(t -> ChatColor.translateAlternateColorCodes('&', t))
                .collect(Collectors.toList());
        spawn();
    }
}
