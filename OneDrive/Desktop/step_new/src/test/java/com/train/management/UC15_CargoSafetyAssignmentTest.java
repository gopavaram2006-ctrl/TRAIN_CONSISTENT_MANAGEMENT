package com.train.management;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * UC15: Test Cases for Safe Cargo Assignment Using try-catch-finally
 * 
 * Test coverage includes:
 * - Safe cargo assignments execute without exceptions
 * - Unsafe cargo assignments trigger CargoSafetyException
 * - Exception handling prevents application crashes
 * - Program continues after exceptions
 * - Finally blocks execute regardless of success/failure
 */
public class UC15_CargoSafetyAssignmentTest {
    
    private GoodsBogie rectangularBogie;
    private GoodsBogie cylindricalBogie;
    
    @Before
    public void setUp() {
        // Initialize test bogies
        rectangularBogie = new GoodsBogie("Rectangular", "Initial");
        cylindricalBogie = new GoodsBogie("Cylindrical", "Initial");
    }

    /**
     * Test Case 1: Safe Cargo Assignment
     * 
     * Verifies that safe cargo assignments are processed successfully.
     * - Cylindrical bogie can be assigned Petroleum without exception
     * - Cargo is successfully updated
     */
    @Test
    public void testCargo_SafeAssignment() {
        System.out.println("\n[TEST] testCargo_SafeAssignment");
        System.out.println("Assigning Petroleum to Cylindrical bogie...");
        
        try {
            cylindricalBogie.assignCargo("Petroleum");
            
            // Verify cargo was assigned
            assertEquals("Petroleum", cylindricalBogie.getCargo());
            System.out.println("✓ Test PASSED: Cargo assigned successfully");
            
        } catch (CargoSafetyException e) {
            fail("Safe assignment should not throw exception: " + e.getMessage());
        }
    }

    /**
     * Test Case 2: Unsafe Cargo Assignment Detection
     * 
     * Verifies that assigning petroleum to a rectangular bogie triggers
     * CargoSafetyException as expected.
     * - Exception is raised for unsafe combination
     * - Exception message is meaningful
     */
    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        System.out.println("\n[TEST] testCargo_UnsafeAssignmentHandled");
        System.out.println("Assigning Petroleum to Rectangular bogie...");
        
        CargoSafetyException thrown = null;
        try {
            rectangularBogie.assignCargo("Petroleum");
            fail("Should throw CargoSafetyException for unsafe assignment");
            
        } catch (CargoSafetyException e) {
            thrown = e;
            System.out.println("✓ Test PASSED: CargoSafetyException caught as expected");
            System.out.println("  Exception message: " + e.getMessage());
        }
        
        // Verify exception was thrown
        assertNotNull("Exception should be thrown", thrown);
        assertTrue("Exception message should mention Petroleum", 
                   thrown.getMessage().contains("Petroleum"));
        assertTrue("Exception message should mention Rectangular", 
                   thrown.getMessage().contains("Rectangular"));
    }

    /**
     * Test Case 3: Cargo Not Assigned After Failure
     * 
     * Verifies that when an unsafe cargo assignment occurs, the cargo field
     * is not updated and remains unchanged.
     * - Cargo remains as initial value after failed assignment
     * - No partial assignment occurs
     */
    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        System.out.println("\n[TEST] testCargo_CargoNotAssignedAfterFailure");
        System.out.println("Initial cargo: " + rectangularBogie.getCargo());
        
        String initialCargo = rectangularBogie.getCargo();
        
        try {
            rectangularBogie.assignCargo("Petroleum");
            fail("Should throw CargoSafetyException");
            
        } catch (CargoSafetyException e) {
            System.out.println("✓ Exception caught, verifying cargo unchanged...");
        }
        
        // Verify cargo was NOT changed
        assertEquals("Cargo should not be updated after failed assignment", 
                     initialCargo, rectangularBogie.getCargo());
        System.out.println("✓ Test PASSED: Cargo unchanged after failed assignment");
    }

    /**
     * Test Case 4: Program Continues After Exception
     * 
     * Verifies that the application continues execution after exception handling.
     * Multiple cargo assignments proceed without terminating the program.
     * - Program executes all assignments
     * - No fatal crash occurs
     * - Both successful and failed assignments are processed
     */
    @Test
    public void testCargo_ProgramContinuesAfterException() {
        System.out.println("\n[TEST] testCargo_ProgramContinuesAfterException");
        System.out.println("Processing multiple assignments...");
        
        int processedCount = 0;
        
        // Assignment 1: Safe
        try {
            cylindricalBogie.assignCargo("Petroleum");
            processedCount++;
            System.out.println("✓ Assignment 1 succeeded");
        } catch (CargoSafetyException e) {
            System.out.println("✗ Assignment 1 failed (unexpected)");
        }
        
        // Assignment 2: Unsafe (should fail but program continues)
        try {
            rectangularBogie.assignCargo("Petroleum");
            System.out.println("✗ Assignment 2 should have failed");
        } catch (CargoSafetyException e) {
            processedCount++;
            System.out.println("✓ Assignment 2 caught exception (expected)");
        }
        
        // Assignment 3: Safe (after exception)
        try {
            rectangularBogie.assignCargo("Coal");
            processedCount++;
            System.out.println("✓ Assignment 3 succeeded");
        } catch (CargoSafetyException e) {
            System.out.println("✗ Assignment 3 failed (unexpected)");
        }
        
        // Verify all 3 assignments were processed
        assertEquals("All assignments should be processed even with exceptions", 
                     3, processedCount);
        System.out.println("✓ Test PASSED: Program continued after exception");
    }

    /**
     * Test Case 5: Finally Block Execution
     * 
     * Verifies that the finally block executes regardless of whether the
     * cargo assignment was successful or failed.
     * - Finally block executes on success
     * - Finally block executes on exception
     * - Cleanup/logging always happens
     */
    @Test
    public void testCargo_FinallyBlockExecution() {
        System.out.println("\n[TEST] testCargo_FinallyBlockExecution");
        
        int finallyExecutionCount = 0;
        
        // Test Case 5a: Finally block on SUCCESS
        System.out.println("Test 5a: Finally block on successful assignment...");
        try {
            cylindricalBogie.assignCargo("Fuel");
            finallyExecutionCount++;
        } catch (CargoSafetyException e) {
            System.out.println("✗ Unexpected exception");
        } finally {
            finallyExecutionCount++;
            System.out.println("✓ Finally block executed on success");
        }
        
        assertEquals("Finally should execute after success", 2, finallyExecutionCount);
        finallyExecutionCount = 0;
        
        // Test Case 5b: Finally block on EXCEPTION
        System.out.println("Test 5b: Finally block on exception...");
        try {
            rectangularBogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            finallyExecutionCount++;
        } finally {
            finallyExecutionCount++;
            System.out.println("✓ Finally block executed after exception");
        }
        
        assertEquals("Finally should execute even after exception", 2, finallyExecutionCount);
        System.out.println("✓ Test PASSED: Finally block executes regardless of outcome");
    }

    /**
     * Test Case 6: Exception Message Validity
     * 
     * Verifies that the exception message provides meaningful information
     * about the safety violation.
     */
    @Test
    public void testCargo_ExceptionMessageValidity() {
        System.out.println("\n[TEST] testCargo_ExceptionMessageValidity");
        
        try {
            rectangularBogie.assignCargo("Petroleum");
            fail("Should throw CargoSafetyException");
        } catch (CargoSafetyException e) {
            String message = e.getMessage();
            assertTrue("Message should explain the problem", 
                       message.contains("Unsafe") || message.contains("unsafe"));
            assertTrue("Message should mention Petroleum", 
                       message.contains("Petroleum"));
            assertTrue("Message should describe the constraint", 
                       message.length() > 20);
            System.out.println("✓ Test PASSED: Exception message is descriptive");
        }
    }

    /**
     * Test Case 7: Different Safe Assignments
     * 
     * Verifies that multiple different safe cargo assignments work correctly.
     */
    @Test
    public void testCargo_MultipleSafeAssignments() {
        System.out.println("\n[TEST] testCargo_MultipleSafeAssignments");
        
        String[] safeCargos = {"Coal", "Iron", "Stone", "Chemicals"};
        
        for (String cargo : safeCargos) {
            try {
                GoodsBogie testBogie = new GoodsBogie("Rectangular", "Initial");
                testBogie.assignCargo(cargo);
                assertEquals(cargo, testBogie.getCargo());
                System.out.println("✓ Successfully assigned " + cargo + " to Rectangular bogie");
            } catch (CargoSafetyException e) {
                fail("Safe cargo assignment failed: " + cargo);
            }
        }
        
        System.out.println("✓ Test PASSED: All safe assignments succeeded");
    }

    /**
     * Test Case 8: Cylindrical Bogie Safety
     * 
     * Verifies that Cylindrical bogies can safely carry all cargo types
     * including Petroleum.
     */
    @Test
    public void testCargo_CylindricalBogieSafety() {
        System.out.println("\n[TEST] testCargo_CylindricalBogieSafety");
        
        String[] allCargos = {"Petroleum", "Coal", "Fuel", "Oil", "Chemicals"};
        
        for (String cargo : allCargos) {
            try {
                GoodsBogie testBogie = new GoodsBogie("Cylindrical", "Initial");
                testBogie.assignCargo(cargo);
                assertEquals(cargo, testBogie.getCargo());
                System.out.println("✓ Successfully assigned " + cargo + " to Cylindrical bogie");
            } catch (CargoSafetyException e) {
                fail("Cylindrical bogie should safely carry all cargo types: " + cargo);
            }
        }
        
        System.out.println("✓ Test PASSED: Cylindrical bogies can carry all cargo safely");
    }
}
