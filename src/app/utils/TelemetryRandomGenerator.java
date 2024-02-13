package app.utils;

import java.util.Random;

public class TelemetryRandomGenerator {
    private static final double rangeMinTemperature = -50.0;
    private static final double rangeMaxTemperature = 50.0;

    private static final double rangeMinHumidity = 0;
    private static final double rangeMaxHumidity = 100.0;

    private static final Random random = new Random();

    private static double generateRandomDouble(double rangeMin, double rangeMax) {
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }

    public static double generateRandomTelemetryParams(String paramName) {
        return switch (paramName) {
            case "temperature" -> generateRandomDouble(rangeMinTemperature, rangeMaxTemperature);
            case "humidity" -> generateRandomDouble(rangeMinHumidity, rangeMaxHumidity);
            default -> throw new IllegalArgumentException("Invalid parameter name: " + paramName);
        };
    }
}
