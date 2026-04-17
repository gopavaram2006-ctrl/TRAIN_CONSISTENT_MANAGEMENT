package com.train.management;

import java.util.Arrays;

/**
 * UC17: Sort Bogie Names Using Arrays.sort()
 */
public class UC17_SortBogieNames {
    
    public static void sortBogieNames(String[] names) {
        if (names == null || names.length <= 1) {
            return;
        }
        Arrays.sort(names);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC17: Sort Bogie Names Using Arrays.sort() ---");
        
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("Original array: " + Arrays.toString(names));
        sortBogieNames(names);
        System.out.println("Sorted array:   " + Arrays.toString(names));
    }
}
