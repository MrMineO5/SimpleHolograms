package dev.gardeningtool.hologram.task;

import dev.gardeningtool.hologram.unit.ServerTimeUnit;
import lombok.Getter;

@Getter
public class HologramTask {
    private final long delay;
    private final Runnable runnableTask;

    public HologramTask(ServerTimeUnit unit, int delay, Runnable task) {
        this.delay = (long) unit.getMultiplierFromMillis() * delay;
        this.runnableTask = task;
    }
}
