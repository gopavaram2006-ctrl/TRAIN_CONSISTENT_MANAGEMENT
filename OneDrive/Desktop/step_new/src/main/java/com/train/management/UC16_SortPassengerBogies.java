package com.train.management;

import java.util.Arrays;

/**
 * UC16: Sort Passenger Bogies by Capacity (Bubble Sort – Algorithm Intro)
 */
public class UC16_SortPassengerBogies {

    /**
     * Sorts an array of passenger bogie capacities using Bubble Sort.
     * @param capacities The array of capacities to sort.
     */
    public static void bubbleSort(int[] capacities) {
        if (capacities == null || capacities.length <= 1) {
            return;
        }
        int n = capacities.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap capacities[j] and capacities[j+1]
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC16: Sort Passenger Bogies by Capacity (Bubble Sort) ---");
        System.out.println();

        int[] capacities = {72, 56, 24, 70, 60};
        System.out.println("Original array: " + Arrays.toString(capacities));
        
        System.out.println("Sorting capacities using Bubble Sort...");
        bubbleSort(capacities);
        
        System.out.println("Sorted array:   " + Arrays.toString(capacities));
    }
}
