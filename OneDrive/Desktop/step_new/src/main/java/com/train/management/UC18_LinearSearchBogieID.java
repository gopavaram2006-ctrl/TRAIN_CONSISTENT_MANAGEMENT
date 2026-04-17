package com.train.management;

import java.util.Arrays;

/**
 * UC18: Linear Search for Bogie ID (Array-Based Searching)
 */
public class UC18_LinearSearchBogieID {
    
    public static boolean linearSearch(String[] array, String key) {
        if (array == null || key == null) return false;
        System.out.println("Beginning linear search for ID: " + key);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Checking index " + i + ": " + array[i]);
            if (key.equals(array[i])) {
                System.out.println("Match found at index " + i + "!");
                return true;
            }
        }
        System.out.println("Match not found.");
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC18: Linear Search for Bogie ID ---");
        
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};
        System.out.println("Bogie IDs: " + Arrays.toString(ids));
        
        boolean found = linearSearch(ids, "BG309");
        System.out.println("\nSearch for BG309 resulted in: " + found);
    }
}
