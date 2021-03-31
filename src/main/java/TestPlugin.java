import dev.gardeningtool.hologram.object.Hologram;
import dev.gardeningtool.hologram.provider.HologramProvider;
import dev.gardeningtool.hologram.task.HologramTask;
import dev.gardeningtool.hologram.unit.ServerTimeUnit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class TestPlugin extends JavaPlugin implements Listener {

    private final HologramProvider provider = new ProviderTest(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Hologram hologram = new Hologram(event.getPlayer().getLocation(), String.format("&3&l%s", event.getPlayer().getName()));
        HologramTask task = new HologramTask(ServerTimeUnit.TICKS, 20, () -> {
            hologram.setName(String.format("&c&l%s%d", event.getPlayer().getName(), event.getPlayer().getTicksLived()));
        });
        hologram.setTask(task);
        provider.registerHologram(hologram);
    }
}
