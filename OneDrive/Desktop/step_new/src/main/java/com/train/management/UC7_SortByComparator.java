package com.train.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UC7: Sort Bogies by Capacity (Comparator)
 * Demonstrates use of Comparator for custom sorting
 */
public class UC7_SortByComparator {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC7: Sort Bogies by Capacity (Comparator) ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating passenger bogie objects...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        System.out.println();

        System.out.println("Bogies before sorting (insertion order):");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Sort by capacity using Comparator
        System.out.println("Sorting bogies by seating capacity...");
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("Sorting completed.");
        System.out.println();

        System.out.println("Bogies after sorting by capacity (ascending):");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        System.out.println("Key Benefits of Comparator:");
        System.out.println("✓ Introduces object-based collection handling");
        System.out.println("✓ Enables custom sorting based on business rules");
        System.out.println("✓ Improves train planning and capacity analysis");
        System.out.println("✓ Demonstrates separation of data and logic");
        System.out.println("✓ Prepares for enterprise-level sorting operations");
        System.out.println();
    }
}
