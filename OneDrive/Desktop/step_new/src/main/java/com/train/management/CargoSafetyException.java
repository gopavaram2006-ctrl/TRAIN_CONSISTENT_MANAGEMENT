package com.train.management;

/**
 * Custom runtime exception for unsafe cargo assignments.
 * Used in UC15
 * 
 * This is an unchecked exception (extends RuntimeException)
 * because cargo safety violations can occur at runtime during
 * operational conditions, not just at object creation.
 */
public class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }

    public CargoSafetyException(String message, Throwable cause) {
        super(message, cause);
    }
}
