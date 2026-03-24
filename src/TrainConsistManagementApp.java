import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // UC4: Maintain Ordered Bogie IDs (LinkedList)
        System.out.println("=== Train Consist Management App (UC4) ===");

        java.util.LinkedList<String> consist = new java.util.LinkedList<>();

        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("Initial train consist: " + consist);

        // Insert pantry car at index 2 (0-based)
        consist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at position 2: " + consist);

        // Remove first and last bogies
        consist.removeFirst();
        consist.removeLast();
        System.out.println("After removing first and last bogies: " + consist);

        // Final ordered consist
        System.out.println("Final ordered train consist: " + consist);
    }
}