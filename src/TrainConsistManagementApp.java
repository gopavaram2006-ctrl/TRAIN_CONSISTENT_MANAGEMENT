import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // UC3: Track Unique Bogie IDs (Set – HashSet)
        System.out.println("=== Train Consist Management App (UC3) ===");

        java.util.Set<String> bogieIds = new java.util.HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("Bogie IDs added (including duplicates): BG101, BG102, BG103, BG101, BG102");
        System.out.println("Unique bogie IDs stored in HashSet: " + bogieIds);
        System.out.println("Distinct bogie count: " + bogieIds.size());
    }
}