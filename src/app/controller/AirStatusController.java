package app.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import app.views.AirStatusControllerView;

public class AirStatusController {
    private static final Scanner scanner = new Scanner(System.in);
    public static void processingAirStatusControl() {
        boolean flag = true;

        while (flag) {
            System.out.print("Input current height: ");
            try {
                double currentHeight = scanner.nextDouble();
                scanner.nextLine();

                AirStatusControllerView.sendTelemetry(currentHeight);
                flag = ifNeedContain();
            } catch (InputMismatchException error) {
                System.out.println("Something went wrong, maybe your input is incorrect. Height must be double or int");
                scanner.nextLine();
            }
        }
    }

    private static boolean ifNeedContain() {
        while (true) {
            System.out.println("Do you want to check another height? (yes/no)");
            String answer = scanner.nextLine();
            switch (answer) {
                case "no":
                    return false;
                case "yes":
                    return true;
                default:
                    System.out.println("I don't understand you, please input 'yes' or 'no'.");
                    break;
            }
        }
    }
}
