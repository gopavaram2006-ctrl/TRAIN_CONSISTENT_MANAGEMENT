# Train Consist Management - UC 7-14 Detailed Analysis

## Project Overview

**Repository**: `https://github.com/asishvemparala11/Train-Consist-Management-`

**Project Structure**:
```
Train-Consist-Management-/
├── Desktop/
│   └── RA2411026010349/
│       └── src/
│           ├── main/java/
│           │   └── TrainConsistManagementApp.java
│           └── test/java/
│               └── TrainConsistManagementAppTest.java
├── src/  (Legacy)
│   └── TrainConsistManagementApp.java
```

**Branch Organization**: Each UC 7-14 is developed in separate feature branches:
- `feature/UC7`
- `feature/UC8`
- `feature/UC9`
- `feature/UC10`
- `feature/UC11`
- `feature/UC12`
- `feature/UC13`
- `feature/UC14`

---

## UC 7: Sort Bogies by Capacity (Comparator)

### Branch Info
- **Branch**: `feature/UC7`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
Desktop/RA2411026010349/src/test/java/TrainConsistManagementAppTest.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `Bogie` - Domain model class
  - `TrainConsistManagementApp` - Main application class

### Class Structure

#### Bogie Class
```java
class Bogie {
    private String name;
    private int capacity;
    
    public Bogie(String name, int capacity)
    public String getName()
    public int getCapacity()
    @Override public String toString()
}
```

#### TrainConsistManagementApp Class
- **Main Method**: Demonstrates sorting functionality
- **Key Methods**:
  - `Comparator.comparingInt(Bogie::getCapacity)` - Comparator for sorting
  - `List.sort()` - Built-in sorting using comparator

### Functionality
- Creates ArrayList of Bogie objects
- Sorts by seating capacity (ascending order)
- Displays before and after sorting
- Uses method reference for cleaner code

### Key Concepts
- Comparator interface usage
- Method references (`Bogie::getCapacity`)
- Stream-compatible sorting

---

## UC 8: Filter Passenger Bogies Using Streams

### Branch Info
- **Branch**: `feature/UC8`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `Bogie` - Domain model (same as UC7)
  - `TrainConsistManagementApp` - Main application

### Functionality
- Filters bogies with capacity > 60 using Stream API
- Uses `stream().filter().collect()`
- Handles empty result state with `isEmpty()` check
- Displays filtered and non-matching results

### Key Methods
```java
List<Bogie> filteredBogies = bogies.stream()
    .filter(b -> b.getCapacity() > 60)
    .collect(Collectors.toList());
```

### Key Concepts
- Stream API for functional filtering
- Collectors.toList()
- Lambda expressions
- Empty state handling

---

## UC 9: Group Bogies by Type (Collectors.groupingBy)

### Branch Info
- **Branch**: `feature/UC9`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `Bogie` - Domain model
  - `TrainConsistManagementApp` - Main application

### Functionality
- Groups bogies by name/type
- Creates Map<String, List<Bogie>> structure
- Handles duplicate bogies
- Iterates over grouped results

### Key Methods
```java
Map<String, List<Bogie>> groupedBogies = bogies.stream()
    .collect(Collectors.groupingBy(Bogie::getName));
```

### Key Concepts
- Collectors.groupingBy() for grouping
- Map entries iteration
- Method references for key extraction
- Collections organization

---

## UC 10: Count Total Seats in Train (reduce)

### Branch Info
- **Branch**: `feature/UC10`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `Bogie` - Domain model
  - `TrainConsistManagementApp` - Main application

### Functionality
- Calculates total seating capacity across all bogies
- Uses mapToInt() and sum() for aggregation
- Provides quantitative metrics for planning

### Key Methods
```java
int totalSeats = bogies.stream()
    .mapToInt(Bogie::getCapacity)
    .sum();
```

### Key Concepts
- IntStream for primitive operations
- Stream aggregation (mapToInt + sum)
- Terminal operations (sum())
- Performance optimized integer handling

---

## UC 11: Validate Train ID & Cargo Codes (Regex)

### Branch Info
- **Branch**: `feature/UC11`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `TrainConsistManagementApp` - Main application

### Functionality
- Validates Train ID format: `TRN-1234`
- Validates Cargo Code format: `PET-AB`
- User input via Scanner
- Pattern matching using regex

### Key Methods & Patterns
```java
Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
boolean isTrainIdValid = trainIdMatcher.matches();

Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");
Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);
boolean isCargoCodeValid = cargoCodeMatcher.matches();
```

### Regex Patterns
- Train ID: `TRN-\d{4}` (TRN- followed by exactly 4 digits)
- Cargo Code: `PET-[A-Z]{2}` (PET- followed by exactly 2 uppercase letters)

### Key Concepts
- Pattern.compile() for regex compilation
- Matcher.matches() for full string validation
- Format validation
- Input sanitization

---

## UC 12: Safety Compliance Check for Goods Bogies

### Branch Info
- **Branch**: `feature/UC12`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `GoodsBogie` - Domain model for goods wagons
  - `TrainConsistManagementApp` - Main application

### Class Structure

#### GoodsBogie Class
```java
class GoodsBogie {
    private String type;      // e.g., "Cylindrical", "Rectangular", "Open"
    private String cargo;      // e.g., "Petroleum", "Coal", "Grain"
    
    public GoodsBogie(String type, String cargo)
    public String getType()
    public String getCargo()
    @Override public String toString()
}
```

### Functionality
- Validates safety compliance rules
- Rule: Cylindrical bogies must carry Petroleum only
- Uses stream().allMatch() for validation
- Reports compliance status

### Key Methods
```java
boolean isSafe = goodsBogies.stream()
    .allMatch(b -> !"Cylindrical".equals(b.getType()) || 
                   "Petroleum".equals(b.getCargo()));
```

### Business Rules
- Cylindrical bogies have specific cargo restrictions
- All bogies must comply or entire train is unsafe
- Safety violations are flagged

### Key Concepts
- Stream.allMatch() for universal validation
- Business rule enforcement
- Lambda predicates for complex conditions
- Safety compliance checking

---

## UC 13: Performance Comparison (Loops vs Streams)

### Branch Info
- **Branch**: `feature/UC13`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `Bogie` - Domain model
  - `TrainConsistManagementApp` - Main application

### Functionality
- Creates 10,000 bogie objects for testing
- Measures loop-based filtering performance
- Measures stream-based filtering performance
- Compares execution times in nanoseconds
- Analyzes which approach performed better

### Performance Measurement Code
```java
// Loop-based filtering
long startTime = System.nanoTime();
List<Bogie> loopFiltered = new ArrayList<>();
for (Bogie bogie : bogies) {
    if (bogie.getCapacity() > 60) {
        loopFiltered.add(bogie);
    }
}
long loopTime = System.nanoTime() - startTime;

// Stream-based filtering
startTime = System.nanoTime();
List<Bogie> streamFiltered = bogies.stream()
    .filter(b -> b.getCapacity() > 60)
    .collect(Collectors.toList());
long streamTime = System.nanoTime() - startTime;
```

### Key Concepts
- System.nanoTime() for precision timing
- Imperative vs declarative styles
- Performance benchmarking
- Avoids premature optimization assumptions
- Evidence-based development decisions

---

## UC 14: Handle Invalid Bogie Capacity (Custom Exception)

### Branch Info
- **Branch**: `feature/UC14`
- **Status**: Merged to main

### Files & Location
```
Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
```

### Package Structure
- **Package**: No explicit package (default package)
- **Classes**:
  - `InvalidCapacityException` - Custom exception
  - `Bogie` - Domain model with validation
  - `TrainConsistManagementApp` - Main application

### Class Structure

#### InvalidCapacityException
```java
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}
```

#### Bogie Class (Modified)
```java
class Bogie {
    private String name;
    private int capacity;
    
    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException(
                "Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }
    // ... getters and toString
}
```

### Functionality
- Custom exception for domain constraint validation
- Validates capacity at object creation time
- Prevents invalid state from being created
- Tests multiple invalid scenarios:
  - Negative capacity
  - Zero capacity
- Catches and handles exceptions appropriately

### Exception Handling Pattern
```java
try {
    Bogie sleeper = new Bogie("Sleeper", 72);
    validBogies.add(sleeper);
    System.out.println("✓ Created valid bogie: " + sleeper);
} catch (InvalidCapacityException e) {
    System.out.println("✗ Caught invalid capacity: " + e.getMessage());
}
```

### Key Concepts
- Custom exceptions for domain-specific errors
- Fail-fast validation
- Object creation-time validation
- Exception handling with try-catch
- Business logic enforcement
- System reliability

---

## Common Utilities & Shared Code

### Shared Class: Bogie (Used in UC7-UC10, UC13-UC14)
```java
class Bogie {
    private String name;        // Type: Sleeper, AC Chair, First Class
    private int capacity;       // Seating capacity
    
    // Constructor validates capacity in UC14
    public Bogie(String name, int capacity) throws InvalidCapacityException
    
    public String getName()     // Returns bogie type/name
    public int getCapacity()    // Returns seating capacity
    public String toString()    // Returns formatted string
}
```

### Shared Class: GoodsBogie (Used in UC12)
```java
class GoodsBogie {
    private String type;       // Cylindrical, Rectangular, Open
    private String cargo;      // Petroleum, Coal, Grain
    
    public GoodsBogie(String type, String cargo)
    public String getType()
    public String getCargo()
    public String toString()
}
```

### Shared Utilities
- **ArrayList<T>**: Collection initialization
- **Scanner**: User input (UC11)
- **System.out.println()**: Console output
- **System.nanoTime()**: Performance measurement (UC13)

---

## Naming Conventions

### Package Structure
- **Default Package**: All classes in the default package (no package declaration)
- Used for educational purposes in this Train Consist Management project

### Class Naming
- `TrainConsistManagementApp` - PascalCase for main application class
- `Bogie` - PascalCase for domain models
- `GoodsBogie` - PascalCase with descriptive suffix
- `InvalidCapacityException` - PascalCase with "Exception" suffix

### Variable Naming
- `bogies`, `validBogies`, `filteredBogies` - camelCase plurals for collections
- `groupedBogies`, `streamFiltered` - camelCase for descriptive variables
- `trainId`, `cargoCode` - camelCase for strings
- `totalSeats`, `loopTime`, `streamTime` - camelCase for primitives
- `isTrainIdValid`, `isSafe` - camelCase with boolean prefix (is/has)

### Method Naming
- `getName()`, `getCapacity()` - Getter prefix
- `toString()` - Standard Java override
- `main(String[] args)` - Entry point convention

### Lambda / Functional Style
- `b -> b.getCapacity() > 60` - Single parameter lambda
- `Bogie::getName` - Method reference syntax
- `Collectors.groupingBy()` - Functional collector

---

## Project Directory Structure

```
TRAIN_CONSISTENT_MANAGEMENT/
└── src/
    └── TrainConsistManagementApp.java (Legacy - UC6)

train-consist-management-repo/
├── Desktop/
│   └── RA2411026010349/
│       └── src/
│           ├── main/
│           │   └── java/
│           │       ├── Bogie.java (implied in single file)
│           │       ├── GoodsBogie.java (implied in single file)
│           │       ├── InvalidCapacityException.java (implied)
│           │       └── TrainConsistManagementApp.java
│           │
│           └── test/
│               └── java/
│                   └── TrainConsistManagementAppTest.java
│
└── .git/ (Git repository)
```

---

## Key Technologies & Concepts Used Across UC 7-14

### Core Java Features
- **Collections**: ArrayList, List, Map
- **Streams API**: stream(), filter(), collect()
- **Comparators**: Custom sorting logic
- **Exceptions**: Custom exception classes, try-catch blocks

### Functional Programming
- **Lambda Expressions**: Inline function implementations
- **Method References**: `Class::method` syntax
- **Collectors**: groupingBy, toList
- **Terminal Operations**: forEach, collect, sum, allMatch

### Input/Output
- **Scanner**: Console input (UC11)
- **System.out**: Console output across all UCs

### Pattern Matching & Validation
- **Regex (Pattern/Matcher)**: String format validation
- **Business Rules**: Programmatic constraint enforcement

### Performance Analysis
- **System.nanoTime()**: Microsecond-precision timing
- **Benchmarking**: Comparing algorithm approaches

---

## Replication Guide

### To Replicate UC 7-14:

1. **Create Maven/Gradle Project Structure**:
   ```
   src/
   ├── main/java/
   │   └── [PackageName]/
   │       ├── Bogie.java
   │       ├── GoodsBogie.java
   │       ├── InvalidCapacityException.java
   │       └── TrainConsistManagementApp.java
   └── test/java/
       └── [PackageName]/
           └── TrainConsistManagementAppTest.java
   ```

2. **Add Package Declarations** (if using packages):
   ```java
   package com.train.consist.management;
   ```

3. **Import Required Classes**:
   - `java.util.ArrayList`
   - `java.util.List`
   - `java.util.Map`
   - `java.util.stream.Collectors`
   - `java.util.Scanner`
   - `java.util.regex.Pattern`
   - `java.util.regex.Matcher`

4. **Follow Naming Conventions**:
   - Use PascalCase for classes
   - Use camelCase for variables/methods
   - Use descriptive names

5. **Implement UC-Specific Code**:
   - Copy class definitions from respective branches
   - Maintain the same method signatures
   - Keep the println statements for demonstration

---

## Testing Notes

- **Test Files**: `TrainConsistManagementAppTest.java` placeholder exists
- **Current Status**: Placeholder only, no specific tests implemented
- **Manual Testing**: Each UC demonstrates functionality with console output

---

## Common Features Across All UCs

1. **Welcome Banner**: Prints "=== Train Consist Management App ===" and section header
2. **Data Setup**: Creates sample Bogie/GoodsBogie objects
3. **Display Before**: Shows original data
4. **Processing**: Applies UC-specific logic
5. **Display After**: Shows results
6. **Benefits Summary**: Lists key benefits of the approach
7. **Closing**: "Program continues..." statement

---

## Use Case Summary Table

| UC  | Feature | Key Class | Key Method | Pattern |
|-----|---------|-----------|-----------|---------|
| 7   | Sort by Capacity | Bogie | Comparator.comparingInt() | Comparator |
| 8   | Filter with Streams | Bogie | stream().filter() | Functional |
| 9   | Group by Type | Bogie | Collectors.groupingBy() | Grouping |
| 10  | Count Total Seats | Bogie | mapToInt().sum() | Aggregation |
| 11  | Validate Codes | TrainConsistManagementApp | Pattern.matches() | Regex |
| 12  | Safety Compliance | GoodsBogie | allMatch() | Validation |
| 13  | Performance Compare | Bogie | System.nanoTime() | Benchmarking |
| 14  | Exception Handling | InvalidCapacityException | throw/catch | Exception |

---

## File Sizes (Approximate)

- UC7: ~3014 bytes
- UC8: ~2825 bytes
- UC9: ~3125 bytes
- UC10: ~2341 bytes
- UC11: ~2527 bytes (includes Scanner)
- UC12: ~2833 bytes
- UC13: ~3551 bytes
- UC14: ~3567 bytes

---

**Last Updated**: 2026-04-08  
**Repository**: https://github.com/asishvemparala11/Train-Consist-Management-  
**Default Branch**: main
