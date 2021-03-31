package dev.gardeningtool.hologram.unit;

import lombok.Getter;

@Getter
public enum ServerTimeUnit {

    MILLIS(1), TICKS(50), SECONDS(1000), MINUTES(60000), HOURS(3600000);

    private final int multiplierFromMillis;

    ServerTimeUnit(int multiplierFromMillis) {
        this.multiplierFromMillis = multiplierFromMillis;
    }
}
