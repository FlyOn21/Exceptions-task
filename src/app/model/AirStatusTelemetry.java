package app.model;

import java.util.Hashtable;
import app.exceptions.height.UpperLimitHeightException;
import app.exceptions.height.LowerLimitHeightException;
import app.config.Config;
import app.utils.TelemetryRandomGenerator;

public class AirStatusTelemetry {
    public static Hashtable<String,Double> telemetryResultData(double currentHeight) throws UpperLimitHeightException, LowerLimitHeightException {
        Hashtable<String,Double> telemetryData = new Hashtable<>();
        if (currentHeight >= Config.LOWER_LIMIT_OF_HEIGHT && currentHeight <= Config.UPPER_LIMIT_OF_HEIGHT) {
            for (String paramName : Config.TELEMETRY_PARAMS_CHECK_ARRAY) {
                double randomResult = TelemetryRandomGenerator.generateRandomTelemetryParams(paramName);
                telemetryData.put(paramName, randomResult);
            }
        } else if (currentHeight < Config.LOWER_LIMIT_OF_HEIGHT) {
            throw new LowerLimitHeightException("ERROR: Height is very low, need increase height");
        } else if (currentHeight > Config.UPPER_LIMIT_OF_HEIGHT) {
            throw new UpperLimitHeightException("ERROR: Height is very big, need decrease height");
        }
        return telemetryData;
    }
}
