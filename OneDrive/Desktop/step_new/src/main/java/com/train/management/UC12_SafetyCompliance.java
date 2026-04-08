package com.train.management;

import java.util.ArrayList;
import java.util.List;

/**
 * UC12: Safety Compliance Check for Goods Bogies
 * Business Rule: Cylindrical bogies must carry Petroleum only
 * Demonstrates stream validation with allMatch()
 */
public class UC12_SafetyCompliance {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC12: Safety Compliance Check for Goods Bogies ---");
        System.out.println();

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        System.out.println("Creating goods bogie objects...");
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));
        System.out.println();

        System.out.println("Goods bogies in the train:");
        for (int i = 0; i < goodsBogies.size(); i++) {
            System.out.println((i + 1) + ". " + goodsBogies.get(i));
        }
        System.out.println();

        // Key line: Validate using allMatch with business rule
        System.out.println("Checking safety compliance...");
        boolean isSafe = goodsBogies.stream()
            .allMatch(b -> !"Cylindrical".equals(b.getType()) || 
                          "Petroleum".equals(b.getCargo()));
        System.out.println("Safety compliance check result: " + 
            (isSafe ? "SAFE" : "UNSAFE"));
        System.out.println();

        if (isSafe) {
            System.out.println("✓ All goods bogies comply with safety rules.");
        } else {
            System.out.println("✗ Safety violation detected! Cylindrical bogies must carry Petroleum only.");
        }
        System.out.println();

        System.out.println("Key Benefits of Stream Validation:");
        System.out.println("✓ Enforces business rules declaratively");
        System.out.println("✓ Prevents unsafe configurations early");
        System.out.println("✓ Uses functional programming for validation");
        System.out.println("✓ Improves code readability and safety");
        System.out.println("✓ Builds foundation for domain rule enforcement");
        System.out.println();
    }
}
