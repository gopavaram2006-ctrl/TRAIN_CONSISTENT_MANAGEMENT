package com.train.management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC13: Performance Comparison (Loops vs Streams)
 * Demonstrates benchmarking to compare imperative vs declarative styles
 */
public class UC13_PerformanceComparison {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC13: Performance Comparison (Loops vs Streams) ---");
        System.out.println();

        // Create a large list of bogies for testing
        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating 10,000 bogies for performance testing...");
        for (int i = 0; i < 10000; i++) {
            String name = (i % 3 == 0) ? "Sleeper" : 
                         (i % 3 == 1) ? "AC Chair" : "First Class";
            int capacity = 30 + (i % 100);
            bogies.add(new Bogie(name, capacity));
        }
        System.out.println("Created " + bogies.size() + " bogies for performance testing.");
        System.out.println();

        // Measure loop-based filtering
        long startTime = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopFiltered.add(bogie);
            }
        }
        long loopTime = System.nanoTime() - startTime;

        // Measure stream-based filtering
        startTime = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());
        long streamTime = System.nanoTime() - startTime;

        System.out.println("Performance Comparison Results:");
        System.out.println("Loop-based filtering: " + loopFiltered.size() + 
            " bogies, Time: " + loopTime + " ns");
        System.out.println("Stream-based filtering: " + streamFiltered.size() + 
            " bogies, Time: " + streamTime + " ns");
        System.out.println();

        if (loopTime < streamTime) {
            System.out.println("✓ Loop-based approach was faster in this test.");
        } else if (streamTime < loopTime) {
            System.out.println("✓ Stream-based approach was faster in this test.");
        } else {
            System.out.println("✓ Both approaches had similar performance in this test.");
        }
        System.out.println();

        System.out.println("Key Benefits of Performance Benchmarking:");
        System.out.println("✓ Introduces measurement-driven optimization");
        System.out.println("✓ Compares imperative vs declarative styles");
        System.out.println("✓ Avoids premature performance assumptions");
        System.out.println("✓ Builds awareness of execution costs");
        System.out.println("✓ Encourages evidence-based development decisions");
        System.out.println();
    }
}
