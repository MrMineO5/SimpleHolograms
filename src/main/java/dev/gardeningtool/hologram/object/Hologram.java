package dev.gardeningtool.hologram.object;

import dev.gardeningtool.hologram.task.HologramTask;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.*;

@Getter
public final class Hologram {

    private final Location location;
    private String name;
    private ArmorStand hologram;
    private HologramTask task;

    public Hologram(Location location, String name) {
        this.name = ChatColor.translateAlternateColorCodes('&', name);
        this.location = location;
        spawn();
    }

    private void spawn() {
        Entity entity = location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        hologram = (ArmorStand) entity;
        hologram.setGravity(false);
        hologram.setVisible(false);
        hologram.setSmall(true);
        hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
        hologram.setCustomNameVisible(true);
    }

    public void setTask(HologramTask task) {
        this.task = task;
    }

    public boolean hasTask() {
        return task != null;
    }

    public void setName(String name) {
        this.name = name;
        hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', name));
    }

}
