import java.awt.Color;
import java.util.List;

public class AppliancesTester {

    public static void main(String[] args) {
        WashingMachine washer = new WashingMachine("SpinPro-2000", Color.WHITE, 220);

        try {
            washer.powerOn();                 
            washer.setSpinRpm(1200);
            washer.runCycle();
            System.out.println("Status=" + washer.powerStatus() + ", watts=" + washer.watts());
        } catch (PowerException e) {
            System.out.println("Unexpected power error: " + e.getMessage());
        }

        try {
            WashingMachine coldStart = new WashingMachine("ColdStart", Color.WHITE, 110);
            coldStart.runCycle(); 
        } catch (PowerException e) {
            System.out.println("Observed PowerException: " + e.getMessage());
        }

        try {
            washer.setSpinRpm(2000);
        } catch (InvalidSetting | ClassCastException e) {
            System.out.println("Invalid spin rpm or class issue: " + e.getMessage());
        }

        try {
            washer.powerOn();
            washer.setSpinRpm(800);
            washer.runCycle();
        } catch (PowerException e) {
            System.out.println("Power error: " + e.getMessage());
        } finally {
            List<Powerable> one = List.of(washer);
            Powerable.safeShutdownAll(one);
            System.out.println("Finally: ensured OFF, status=" + washer.powerStatus());
        }

    }
}