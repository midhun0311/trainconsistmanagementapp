import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("\nPassenger Bogies after adding:");
        System.out.println(passengerBogies);

        // Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Display bogies after removal
        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        // Check if Sleeper exists
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nDoes Sleeper bogie exist? " + exists);

        // Final list state
        System.out.println("\nFinal Passenger Bogies List:");
        System.out.println(passengerBogies);
    }
}