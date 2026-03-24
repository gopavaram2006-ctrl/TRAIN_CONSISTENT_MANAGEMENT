import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // UC6: Map Bogie to Capacity (HashMap)
        System.out.println("=== Train Consist Management App (UC6) ===");

        java.util.HashMap<String, Integer> bogieCapacity = new java.util.HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 50);
        bogieCapacity.put("First Class", 30);

        System.out.println("Bogie-Capacity Mapping:");
        for (java.util.Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " seats");
        }
    }
}