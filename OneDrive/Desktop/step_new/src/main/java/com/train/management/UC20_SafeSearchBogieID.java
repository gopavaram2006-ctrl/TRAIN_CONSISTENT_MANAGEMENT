package com.train.management;

import java.util.Arrays;

/**
 * UC20: Exception Handling During Search Operations (Fail-Fast)
 */
public class UC20_SafeSearchBogieID {
    
    public static boolean safeSearch(String[] array, String key) {
        // Fail-Fast: Throw exception if the state is invalid for searching
        if (array == null || array.length == 0) {
            throw new IllegalStateException("Search operation failed: Bogie array is empty or null.");
        }
        if (key == null) return false;
        
        System.out.println("Validating bogie array state: Found " + array.length + " elements. Proceeding...");
        
        // Ensure array is sorted before binary search
        String[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        
        int low = 0;
        int high = sortedArray.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(sortedArray[mid]);
            
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
        System.out.println("--- UC20: Safe Search (Fail-Fast Validation) ---");
        
        System.out.println("\nTesting Empty Array Exception:");
        try {
            safeSearch(new String[]{}, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Caught Exception safely: " + e.getMessage());
        }
        
        System.out.println("\nTesting Valid Active Search:");
        String[] ids = {"BG309", "BG101", "BG550", "BG205"};
        boolean found = safeSearch(ids, "BG101");
        System.out.println("Search for BG101 resulted in: " + found);
    }
}
