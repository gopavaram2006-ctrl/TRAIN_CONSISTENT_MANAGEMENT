package com.train.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UC9: Group Bogies by Type (Collectors.groupingBy)
 * Demonstrates grouping collections using stream collectors
 */
public class UC9_GroupByType {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC9: Group Bogies by Type (Collectors.groupingBy) ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating bogie objects with duplicates...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        System.out.println();

        System.out.println("All bogies in the train:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Group by name
        System.out.println("Grouping bogies by type...");
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
            .collect(Collectors.groupingBy(Bogie::getName));
        System.out.println("Grouping completed.");
        System.out.println();

        System.out.println("Grouped bogies by type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            String type = entry.getKey();
            List<Bogie> group = entry.getValue();
            System.out.println("Type: " + type + " (" + group.size() + " bogies)");
            for (int i = 0; i < group.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + group.get(i));
            }
            System.out.println();
        }

        System.out.println("Key Benefits of Collectors.groupingBy:");
        System.out.println("✓ Transforms flat data into categorized structures");
        System.out.println("✓ Enables structured reporting and analysis");
        System.out.println("✓ Introduces advanced stream collectors");
        System.out.println("✓ Improves data organization for dashboards");
        System.out.println("✓ Builds foundation for analytics operations");
        System.out.println();
    }
}
