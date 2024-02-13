package app;
import app.controller.AirStatusController;
public class App {

    public void run() {
        AirStatusController.processingAirStatusControl();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
