package com.train.management;

/**
 * Custom exception for invalid bogie capacity.
 * Used in UC14
 */
public class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}
