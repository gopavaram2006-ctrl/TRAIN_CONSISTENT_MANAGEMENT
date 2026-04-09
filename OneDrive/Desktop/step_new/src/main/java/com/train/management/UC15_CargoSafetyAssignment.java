package com.train.management;

import java.util.ArrayList;
import java.util.List;

/**
 * UC15: Safe Cargo Assignment Using try-catch-finally
 * 
 * Demonstrates structured exception handling for runtime safety violations.
 * Unlike UC14 which validates at object creation, UC15 handles dynamic cargo
 * assignment during runtime with robust error handling using try-catch-finally.
 * 
 * Key Concepts:
 * - try: Attempts the cargo assignment
 * - catch: Handles CargoSafetyException gracefully
 * - finally: Ensures logging/cleanup always happens
 * - RuntimeException: Unchecked exceptions for operational safety
 * - throw: Signals unsafe conditions
 */
public class UC15_CargoSafetyAssignment {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC15: Safe Cargo Assignment Using try-catch-finally ---");
        System.out.println();

        List<GoodsBogie> trainBogies = new ArrayList<>();

        // Test 1: Create initial goods bogies
        System.out.println("Creating goods bogies...");
        GoodsBogie rectangularBogie1 = new GoodsBogie("Rectangular", "Grain");
        GoodsBogie cylindricalBogie1 = new GoodsBogie("Cylindrical", "Empty");
        GoodsBogie rectangularBogie2 = new GoodsBogie("Rectangular", "Steel");

        trainBogies.add(rectangularBogie1);
        trainBogies.add(cylindricalBogie1);
        trainBogies.add(rectangularBogie2);

        System.out.println("✓ Created " + trainBogies.size() + " goods bogies");
        System.out.println();

        // Test 2: Safe cargo assignment - Petroleum to Cylindrical bogie
        System.out.println("--- Test 1: Safe Assignment ---");
        System.out.println("Attempting to assign Petroleum to Cylindrical bogie...");
        assignCargoSafely(cylindricalBogie1, "Petroleum");
        System.out.println();

        // Test 3: Unsafe cargo assignment - Petroleum to Rectangular bogie
        System.out.println("--- Test 2: Unsafe Assignment Detection ---");
        System.out.println("Attempting to assign Petroleum to Rectangular bogie...");
        assignCargoSafely(rectangularBogie1, "Petroleum");
        System.out.println();

        // Test 4: Safe cargo assignment - Coal to Rectangular bogie
        System.out.println("--- Test 3: Another Safe Assignment ---");
        System.out.println("Attempting to assign Coal to Rectangular bogie...");
        assignCargoSafely(rectangularBogie2, "Coal");
        System.out.println();

        // Test 5: Demonstrate multiple operations with exceptions
        System.out.println("--- Test 4: Sequential Operations ---");
        System.out.println("Processing multiple cargo assignments...");
        System.out.println();

        String[][] cargoAssignments = {
            {"Rectangular", "Chemicals"},
            {"Cylindrical", "Fuel"},
            {"Rectangular", "Petroleum"}, // This will fail
            {"Cylindrical", "Petroleum"}  // This will succeed
        };

        int successCount = 0;
        int failureCount = 0;

        for (String[] assignment : cargoAssignments) {
            try {
                String bogieType = assignment[0];
                String cargo = assignment[1];
                GoodsBogie tempBogie = new GoodsBogie(bogieType, "Initial");
                
                System.out.println("Processing: " + cargo + " → " + bogieType + " bogie");
                assignCargoSafely(tempBogie, cargo);
                successCount++;
                
            } catch (CargoSafetyException e) {
                failureCount++;
                System.out.println("  ✗ Assignment failed (expected)");
            }
            System.out.println();
        }

        System.out.println("--- Summary ---");
        System.out.println("Total assignments processed: " + cargoAssignments.length);
        System.out.println("✓ Successful assignments: " + successCount);
        System.out.println("✗ Failed assignments (caught): " + failureCount);
        System.out.println();

        System.out.println("Current train bogies:");
        for (GoodsBogie bogie : trainBogies) {
            System.out.println("- " + bogie);
        }
        System.out.println();

        System.out.println("Key Benefits of try-catch-finally:");
        System.out.println("✓ Catches runtime safety violations without crashing");
        System.out.println("✓ Provides controlled error feedback to operators");
        System.out.println("✓ Ensures cleanup and logging via finally block");
        System.out.println("✓ Allows application to continue after failures");
        System.out.println("✓ Implements graceful failure handling");
        System.out.println("✓ Demonstrates difference between checked and unchecked exceptions");
        System.out.println();
    }

    /**
     * Safe wrapper to assign cargo with exception handling.
     * Demonstrates the try-catch-finally pattern in action.
     * 
     * @param bogie The goods bogie to assign cargo to
     * @param cargo The cargo type to assign
     */
    private static void assignCargoSafely(GoodsBogie bogie, String cargo) {
        try {
            // Try to assign cargo - may throw CargoSafetyException
            bogie.assignCargo(cargo);
            
        } catch (CargoSafetyException e) {
            // Catch and handle the safety exception
            System.out.println("  ⚠ [HANDLER] Exception caught: " + e.getMessage());
            System.out.println("  ⚠ [HANDLER] Cargo assignment rejected");
            
        } finally {
            // Finally block always executes - for audit trail and logging
            System.out.println("  [AUDIT] Cargo assignment attempt logged for bogie type: " + bogie.getType());
        }
    }
}
