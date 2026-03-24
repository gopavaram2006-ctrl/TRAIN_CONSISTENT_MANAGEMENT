import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // UC1: Initialize Train and Display Consist Summary
        System.out.println("=== Train Consist Management App ===");
        List<String> bogies = new ArrayList<>();
        System.out.println("Initial bogie count: " + bogies.size());

        // UC2: Add Passenger Bogies to Train (ArrayList Operations)
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");
        System.out.println("Passenger bogies added: " + bogies);

        // Remove a bogie
        bogies.remove("AC Chair");
        System.out.println("After removing AC Chair: " + bogies);

        // Check existence
        if (bogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists in the consist.");
        } else {
            System.out.println("Sleeper bogie does not exist.");
        }
    }
}