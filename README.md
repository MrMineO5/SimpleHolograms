# SimpleHolograms
 A very simple and straightforward holograms library for Spigot plugins.
 
 ### Usage
 
 Using this in your own plugins is pretty simple. Below, you can find some code demonstrating how to use this to create a simple hologram when the player joins that updates every 20 ticks with how long the player has lived, displayed in ticks.
 
 The first thing you'll need is a class that extends `HologramProvider`.
 
 ```java
public class ProviderTest extends HologramProvider {

    public ProviderTest(JavaPlugin plugin) {
        super(plugin);
    }
}
```

Then, you'll need an instance of the provider class somewhere else in your plugin, typically in your main class.

```java
public class TestPlugin extends JavaPlugin implements Listener {

    private final HologramProvider provider = new ProviderTest(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ExampleListener(this), this);
    }

}
```

And now for our event listener and hologram setup

```java
public class ExampleListener implements Listener {

    private final HologramProvider provider;

    public ExampleListener(HologramProvider provider) {
        this.provider = provider;
    }   

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Hologram hologram = new Hologram(player.getLocation(), String.format("&3&l%s", player.getName()));
        HologramTask task = new HologramTask(ServerTimeUnit.TICKS, 20, () -> {
            hologram.setName(String.format("&c&l%s - %d", player.getName(), player.getTicksLived()));
        });
        hologram.setTask(task);
        provider.registerHologram(hologram);
    }

}
```
