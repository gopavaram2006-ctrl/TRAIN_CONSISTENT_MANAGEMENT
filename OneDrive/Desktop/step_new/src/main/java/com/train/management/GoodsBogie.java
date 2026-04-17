package com.train.management;

/**
 * GoodsBogie class to represent a goods bogie with type and cargo.
 * Used in UC12, UC15
 */
public class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    /**
     * Safely assigns cargo to the bogie with validation.
     * Uses try-catch-finally for robust error handling.
     * 
     * @param newCargo The cargo to assign
     * @throws CargoSafetyException if the cargo-shape combination is unsafe
     */
    public void assignCargo(String newCargo) {
        try {
            // Validate cargo and shape compatibility
            validateCargoSafety(this.type, newCargo);
            
            // If validation passes, assign the cargo
            this.cargo = newCargo;
            System.out.println("✓ Cargo assignment successful: " + newCargo + " assigned to " + this.type + " bogie");
            
        } catch (CargoSafetyException e) {
            // Handle unsafe cargo assignment
            System.out.println("✗ Cargo assignment failed: " + e.getMessage());
            throw e; // Re-throw to let caller handle it
            
        } finally {
            // Cleanup or logging always happens
            System.out.println("  [INFO] Cargo validation completed for " + this.type + " bogie");
        }
    }

    /**
     * Validates if the cargo and bogie shape combination is safe.
     * 
     * Safety Rule: Petroleum can only be assigned to Cylindrical bogies,
     * not to Rectangular bogies.
     * 
     * @param bogieType The type of bogie (Rectangular or Cylindrical)
     * @param cargo The cargo to be assigned
     * @throws CargoSafetyException if the combination is unsafe
     */
    private void validateCargoSafety(String bogieType, String cargo) {
        if ("Petroleum".equalsIgnoreCase(cargo) && "Rectangular".equalsIgnoreCase(bogieType)) {
            throw new CargoSafetyException(
                "Unsafe cargo assignment! Petroleum cannot be assigned to Rectangular bogies. " +
                "Only Cylindrical bogies can carry Petroleum due to structural constraints."
            );
        }
    }

    @Override
    public String toString() {
        return type + " bogie carrying " + cargo;
    }
}
