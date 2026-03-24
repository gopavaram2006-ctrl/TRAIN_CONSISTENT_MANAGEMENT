import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
        System.out.println("=== Train Consist Management App (UC5) ===");

        java.util.LinkedHashSet<String> formation = new java.util.LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("Bogies added (including duplicate): Engine, Sleeper, Cargo, Guard, Sleeper");
        System.out.println("Final train formation (unique, ordered): " + formation);
    }
}