# Train Consist Management - UC 7-14 Complete Replication Template

## Directory Structure to Replicate

```
YourProject/
├── pom.xml  (if using Maven)
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── train/
│   │               └── management/
│   │                   ├── Bogie.java
│   │                   ├── GoodsBogie.java
│   │                   ├── InvalidCapacityException.java
│   │                   ├── UC7_SortByComparator.java
│   │                   ├── UC8_FilterWithStreams.java
│   │                   ├── UC9_GroupByType.java
│   │                   ├── UC10_CountTotalSeats.java
│   │                   ├── UC11_ValidateRegex.java
│   │                   ├── UC12_SafetyCompliance.java
│   │                   ├── UC13_PerformanceComparison.java
│   │                   └── UC14_CustomException.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── train/
│                   └── management/
│                       └── TrainManagementTest.java
│
└── README.md
```

## Core Classes Template

### 1. Bogie.java
```java
package com.train.management;

/**
 * Bogie class to represent a train bogie with name and capacity.
 * Used in UC7-UC10, UC13-UC14
 */
public class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) throws InvalidCapacityException {
        // UC14: Add validation
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}
```

### 2. GoodsBogie.java
```java
package com.train.management;

/**
 * GoodsBogie class to represent a goods bogie with type and cargo.
 * Used in UC12
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

    @Override
    public String toString() {
        return type + " bogie carrying " + cargo;
    }
}
```

### 3. InvalidCapacityException.java
```java
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
```

## UC-Specific Application Classes

### UC7_SortByComparator.java
```java
package com.train.management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * UC7: Sort Bogies by Capacity (Comparator)
 * Demonstrates use of Comparator for custom sorting
 */
public class UC7_SortByComparator {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC7: Sort Bogies by Capacity (Comparator) ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating passenger bogie objects...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        System.out.println();

        System.out.println("Bogies before sorting (insertion order):");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Sort by capacity using Comparator
        System.out.println("Sorting bogies by seating capacity...");
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("Sorting completed.");
        System.out.println();

        System.out.println("Bogies after sorting by capacity (ascending):");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        System.out.println("Key Benefits of Comparator:");
        System.out.println("✓ Introduces object-based collection handling");
        System.out.println("✓ Enables custom sorting based on business rules");
        System.out.println("✓ Improves train planning and capacity analysis");
        System.out.println("✓ Demonstrates separation of data and logic");
        System.out.println("✓ Prepares for enterprise-level sorting operations");
        System.out.println();
    }
}
```

### UC8_FilterWithStreams.java
```java
package com.train.management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC8: Filter Passenger Bogies Using Streams
 * Demonstrates stream-based filtering with empty state handling
 */
public class UC8_FilterWithStreams {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC8: Filter Passenger Bogies Using Streams ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating passenger bogie objects...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        System.out.println();

        System.out.println("All passenger bogies:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Stream filtering
        System.out.println("Filtering bogies with seating capacity > 60...");
        List<Bogie> filteredBogies = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());
        System.out.println("Filtering completed.");
        System.out.println();

        System.out.println("Filtered bogies (capacity > 60):");
        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the filter criteria.");
        } else {
            for (int i = 0; i < filteredBogies.size(); i++) {
                System.out.println((i + 1) + ". " + filteredBogies.get(i));
            }
        }
        System.out.println();

        System.out.println("Key Benefits of Stream API:");
        System.out.println("✓ Declarative filtering without manual loops");
        System.out.println("✓ Concise and readable business logic");
        System.out.println("✓ Functional programming style");
        System.out.println("✓ Improves code maintainability");
        System.out.println("✓ Prepares for advanced stream operations");
        System.out.println();
    }
}
```

### UC9_GroupByType.java
```java
package com.train.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UC9: Group Bogies by Type (Collectors.groupingBy)
 * Demonstrates grouping collections using stream collectors
 */
public class UC9_GroupByType {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC9: Group Bogies by Type (Collectors.groupingBy) ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating bogie objects with duplicates...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        System.out.println();

        System.out.println("All bogies in the train:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Group by name
        System.out.println("Grouping bogies by type...");
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
            .collect(Collectors.groupingBy(Bogie::getName));
        System.out.println("Grouping completed.");
        System.out.println();

        System.out.println("Grouped bogies by type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            String type = entry.getKey();
            List<Bogie> group = entry.getValue();
            System.out.println("Type: " + type + " (" + group.size() + " bogies)");
            for (int i = 0; i < group.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + group.get(i));
            }
            System.out.println();
        }

        System.out.println("Key Benefits of Collectors.groupingBy:");
        System.out.println("✓ Transforms flat data into categorized structures");
        System.out.println("✓ Enables structured reporting and analysis");
        System.out.println("✓ Introduces advanced stream collectors");
        System.out.println("✓ Improves data organization for dashboards");
        System.out.println("✓ Builds foundation for analytics operations");
        System.out.println();
    }
}
```

### UC10_CountTotalSeats.java
```java
package com.train.management;

import java.util.ArrayList;
import java.util.List;

/**
 * UC10: Count Total Seats in Train (reduce)
 * Demonstrates stream aggregation for quantitative metrics
 */
public class UC10_CountTotalSeats {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC10: Count Total Seats in Train (reduce) ---");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating bogie objects...");
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        System.out.println();

        System.out.println("Bogies in the train:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Key line: Aggregate using mapToInt and sum
        System.out.println("Calculating total seating capacity...");
        int totalSeats = bogies.stream()
            .mapToInt(Bogie::getCapacity)
            .sum();
        System.out.println("Total seating capacity: " + totalSeats + " seats");
        System.out.println();

        System.out.println("Key Benefits of Stream reduce:");
        System.out.println("✓ Enables functional aggregation of data");
        System.out.println("✓ Provides quantitative metrics for planning");
        System.out.println("✓ Replaces manual summation loops");
        System.out.println("✓ Improves code readability and safety");
        System.out.println("✓ Builds foundation for advanced analytics");
        System.out.println();
    }
}
```

### UC11_ValidateRegex.java
```java
package com.train.management;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UC11: Validate Train ID & Cargo Codes (Regex)
 * Demonstrates pattern matching for input validation
 * Train ID format: TRN-1234
 * Cargo Code format: PET-AB
 */
public class UC11_ValidateRegex {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC11: Validate Train ID & Cargo Codes (Regex) ---");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Key lines: Pattern compilation and matching
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        boolean isTrainIdValid = trainIdMatcher.matches();

        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        System.out.println();
        System.out.println("Validation Results:");
        System.out.println("Train ID '" + trainId + "': " + 
            (isTrainIdValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code '" + cargoCode + "': " + 
            (isCargoCodeValid ? "Valid" : "Invalid"));

        if (isTrainIdValid && isCargoCodeValid) {
            System.out.println("✓ All inputs are valid. Proceeding with train operations.");
        } else {
            System.out.println("✗ Invalid input detected. Please correct and try again.");
        }
        System.out.println();

        System.out.println("Key Benefits of Regex Validation:");
        System.out.println("✓ Ensures data integrity and format correctness");
        System.out.println("✓ Prevents invalid data from entering the system");
        System.out.println("✓ Introduces pattern-based validation techniques");
        System.out.println("✓ Improves robustness of input handling");
        System.out.println("✓ Builds foundation for enterprise validation rules");
        System.out.println();

        scanner.close();
    }
}
```

### UC12_SafetyCompliance.java
```java
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
```

### UC13_PerformanceComparison.java
```java
package com.train.management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UC13: Performance Comparison (Loops vs Streams)
 * Demonstrates benchmarking to compare imperative vs declarative styles
 */
public class UC13_PerformanceComparison {
    public static void main(String[] args) throws InvalidCapacityException {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC13: Performance Comparison (Loops vs Streams) ---");
        System.out.println();

        // Create a large list of bogies for testing
        List<Bogie> bogies = new ArrayList<>();
        System.out.println("Creating 10,000 bogies for performance testing...");
        for (int i = 0; i < 10000; i++) {
            String name = (i % 3 == 0) ? "Sleeper" : 
                         (i % 3 == 1) ? "AC Chair" : "First Class";
            int capacity = 30 + (i % 100);
            bogies.add(new Bogie(name, capacity));
        }
        System.out.println("Created " + bogies.size() + " bogies for performance testing.");
        System.out.println();

        // Measure loop-based filtering
        long startTime = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopFiltered.add(bogie);
            }
        }
        long loopTime = System.nanoTime() - startTime;

        // Measure stream-based filtering
        startTime = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
            .filter(b -> b.getCapacity() > 60)
            .collect(Collectors.toList());
        long streamTime = System.nanoTime() - startTime;

        System.out.println("Performance Comparison Results:");
        System.out.println("Loop-based filtering: " + loopFiltered.size() + 
            " bogies, Time: " + loopTime + " ns");
        System.out.println("Stream-based filtering: " + streamFiltered.size() + 
            " bogies, Time: " + streamTime + " ns");
        System.out.println();

        if (loopTime < streamTime) {
            System.out.println("✓ Loop-based approach was faster in this test.");
        } else if (streamTime < loopTime) {
            System.out.println("✓ Stream-based approach was faster in this test.");
        } else {
            System.out.println("✓ Both approaches had similar performance in this test.");
        }
        System.out.println();

        System.out.println("Key Benefits of Performance Benchmarking:");
        System.out.println("✓ Introduces measurement-driven optimization");
        System.out.println("✓ Compares imperative vs declarative styles");
        System.out.println("✓ Avoids premature performance assumptions");
        System.out.println("✓ Builds awareness of execution costs");
        System.out.println("✓ Encourages evidence-based development decisions");
        System.out.println();
    }
}
```

### UC14_CustomException.java
```java
package com.train.management;

import java.util.ArrayList;
import java.util.List;

/**
 * UC14: Handle Invalid Bogie Capacity (Custom Exception)
 * Demonstrates fail-fast validation and custom exception handling
 */
public class UC14_CustomException {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println();
        System.out.println("--- UC14: Handle Invalid Bogie Capacity (Custom Exception) ---");
        System.out.println();

        List<Bogie> validBogies = new ArrayList<>();

        // Test valid bogie creation
        try {
            Bogie sleeper = new Bogie("Sleeper", 72);
            validBogies.add(sleeper);
            System.out.println("✓ Created valid bogie: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
        }

        // Test invalid bogie creation (negative capacity)
        try {
            Bogie invalidBogie = new Bogie("Invalid", -10);
            System.out.println("✗ This should not print: " + invalidBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("✓ Caught invalid capacity: " + e.getMessage());
        }

        // Test invalid bogie creation (zero capacity)
        try {
            Bogie zeroBogie = new Bogie("Zero", 0);
            System.out.println("✗ This should not print: " + zeroBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("✓ Caught invalid capacity: " + e.getMessage());
        }

        // Test another valid bogie
        try {
            Bogie acChair = new Bogie("AC Chair", 96);
            validBogies.add(acChair);
            System.out.println("✓ Created valid bogie: " + acChair);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Valid bogies created: " + validBogies.size());
        for (Bogie b : validBogies) {
            System.out.println("- " + b);
        }
        System.out.println();

        System.out.println("Key Benefits of Custom Exceptions:");
        System.out.println("✓ Enforces business rules at object creation");
        System.out.println("✓ Prevents invalid data from entering the system");
        System.out.println("✓ Provides clear error messages");
        System.out.println("✓ Encourages fail-fast validation");
        System.out.println("✓ Improves system reliability");
        System.out.println();
    }
}
```

## Maven pom.xml Template

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.train</groupId>
    <artifactId>train-consist-management</artifactId>
    <version>1.0.0</version>

    <name>Train Consist Management</name>
    <description>Educational project demonstrating Java streams, collections, and advanced features</description>

    <properties>
        <maven.compiler.version>11</maven.compiler.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- No external dependencies needed for UC 7-14 -->
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

## Key Patterns to Replicate

### 1. Comparator Pattern (UC7)
```java
List<Bogie> bogies = /* ... */;
bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
```

### 2. Stream Filter Pattern (UC8)
```java
List<Bogie> filtered = bogies.stream()
    .filter(b -> b.getCapacity() > 60)
    .collect(Collectors.toList());
```

### 3. Stream GroupingBy Pattern (UC9)
```java
Map<String, List<Bogie>> grouped = bogies.stream()
    .collect(Collectors.groupingBy(Bogie::getName));
```

### 4. Stream Aggregation Pattern (UC10)
```java
int total = bogies.stream()
    .mapToInt(Bogie::getCapacity)
    .sum();
```

### 5. Regex Validation Pattern (UC11)
```java
Pattern pattern = Pattern.compile("TRN-\\d{4}");
Matcher matcher = pattern.matcher(input);
boolean valid = matcher.matches();
```

### 6. Stream Validation Pattern (UC12)
```java
boolean valid = goodsBogies.stream()
    .allMatch(b -> !"Cylindrical".equals(b.getType()) || 
                   "Petroleum".equals(b.getCargo()));
```

### 7. Performance Benchmarking Pattern (UC13)
```java
long startTime = System.nanoTime();
// operation
long duration = System.nanoTime() - startTime;
```

### 8. Custom Exception Pattern (UC14)
```java
public Bogie(String name, int capacity) throws InvalidCapacityException {
    if (capacity <= 0) {
        throw new InvalidCapacityException("Capacity must be > 0");
    }
    // ...
}
```

## Testing Template

```java
package com.train.management;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainManagementTest {
    
    @Test
    public void testBogieCreation() throws InvalidCapacityException {
        Bogie bogie = new Bogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.getName());
        assertEquals(72, bogie.getCapacity());
    }
    
    @Test
    public void testInvalidCapacity() {
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Invalid", 0);
        });
    }
}
```

## Running Each UC

```bash
# Compile
javac -d bin src/main/java/com/train/management/*.java

# Run UC7
java -cp bin com.train.management.UC7_SortByComparator

# Run UC11 (requires input)
java -cp bin com.train.management.UC11_ValidateRegex
# Input: TRN-1234
#        PET-AB

# Run others similarly
java -cp bin com.train.management.UC8_FilterWithStreams
java -cp bin com.train.management.UC9_GroupByType
java -cp bin com.train.management.UC10_CountTotalSeats
java -cp bin com.train.management.UC12_SafetyCompliance
java -cp bin com.train.management.UC13_PerformanceComparison
java -cp bin com.train.management.UC14_CustomException
```

Or with Maven:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.train.management.UC7_SortByComparator"
```

---

This template provides a complete replicable structure for UC 7-14.
