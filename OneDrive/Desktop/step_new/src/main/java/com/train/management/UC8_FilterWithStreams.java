package com.train.management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC8: Filter Passenger Bogies Using Streams
 * Demonstrates stream-based filtering with empty state handling
 */
public class UC8_FilterWithStreams {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC8: Filter Passenger Bogies Using Streams ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating passenger bogie objects...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        System.out.println();

        System.out.println("All passenger bogies:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Stream filtering
        System.out.println("Filtering bogies with seating capacity > 60...");
        List<Bogie> filteredBogies = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());
        System.out.println("Filtering completed.");
        System.out.println();

        System.out.println("Filtered bogies (capacity > 60):");
        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the filter criteria.");
        } else {
            for (int i = 0; i < filteredBogies.size(); i++) {
                System.out.println((i + 1) + ". " + filteredBogies.get(i));
            }
        }
        System.out.println();

        System.out.println("Key Benefits of Stream API:");
        System.out.println("✓ Declarative filtering without manual loops");
        System.out.println("✓ Concise and readable business logic");
        System.out.println("✓ Functional programming style");
        System.out.println("✓ Improves code maintainability");
        System.out.println("✓ Prepares for advanced stream operations");
        System.out.println();
    }
}
