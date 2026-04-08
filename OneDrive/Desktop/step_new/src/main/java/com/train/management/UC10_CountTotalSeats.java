package com.train.management;

import java.util.ArrayList;
import java.util.List;

/**
 * UC10: Count Total Seats in Train (reduce)
 * Demonstrates stream aggregation for quantitative metrics
 */
public class UC10_CountTotalSeats {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC10: Count Total Seats in Train (reduce) ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating bogie objects...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        System.out.println();

        System.out.println("Bogies in the train:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Aggregate using mapToInt and sum
        System.out.println("Calculating total seating capacity...");
        int totalSeats = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();
        System.out.println("Total seating capacity: " + totalSeats + " seats");
        System.out.println();

        System.out.println("Key Benefits of Stream reduce:");
        System.out.println("✓ Enables functional aggregation of data");
        System.out.println("✓ Provides quantitative metrics for planning");
        System.out.println("✓ Replaces manual summation loops");
        System.out.println("✓ Improves code readability and safety");
        System.out.println("✓ Builds foundation for advanced analytics");
        System.out.println();
    }
}
