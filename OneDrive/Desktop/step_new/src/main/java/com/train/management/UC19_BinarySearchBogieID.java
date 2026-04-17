package com.train.management;

import java.util.Arrays;

/**
 * UC19: Binary Search for Bogie ID (Optimized Searching)
 */
public class UC19_BinarySearchBogieID {
    
    public static boolean binarySearch(String[] array, String key) {
        if (array == null || array.length == 0 || key == null) return false;
        
        System.out.println("Sorting array before binary search to ensure precondition...");
        Arrays.sort(array);
        
        int low = 0;
        int high = array.length - 1;
        System.out.println("Searching for: " + key);
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(array[mid]);
            System.out.println("Checking mid index " + mid + " value: " + array[mid]);
            
            if (comparison == 0) {
                System.out.println("Match found at index " + mid + "!");
                return true;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Match not found.");
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC19: Binary Search for Bogie ID ---");
        
        String[] ids = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        System.out.println("Unsorted Bogie IDs: " + Arrays.toString(ids));
        
        boolean found = binarySearch(ids, "BG205");
        System.out.println("\nSearch for BG205 resulted in: " + found);
    }
}
