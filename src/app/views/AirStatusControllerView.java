package app.views;
import app.exceptions.height.LowerLimitHeightException;
import app.exceptions.height.UpperLimitHeightException;
import app.model.AirStatusTelemetry;

import java.util.Hashtable;

public class AirStatusControllerView {
     public static void sendTelemetry (double currentHeight) {
         try {
             Hashtable<String,Double> telemetryData = AirStatusTelemetry.telemetryResultData(currentHeight);
             telemetryData.forEach((key, value) -> System.out.println( key + ": " + value));
         }
         catch (LowerLimitHeightException | UpperLimitHeightException err) {
             System.out.println(err.getMessage());
         }
     }
}
