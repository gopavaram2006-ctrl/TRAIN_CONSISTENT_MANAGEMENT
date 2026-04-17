# Train Consist Management - UC 7-15

Complete implementation of Use Cases 7-15 for Train Consist Management System.

## Project Structure

```
train-consist-management/
├── src/
│   ├── main/java/
│   │   └── com/train/management/
│   │       ├── Bogie.java
│   │       ├── GoodsBogie.java
│   │       ├── InvalidCapacityException.java
│   │       ├── CargoSafetyException.java (NEW - UC15)
│   │       ├── UC7_SortByComparator.java
│   │       ├── UC8_FilterWithStreams.java
│   │       ├── UC9_GroupByType.java
│   │       ├── UC10_CountTotalSeats.java
│   │       ├── UC11_ValidateRegex.java
│   │       ├── UC12_SafetyCompliance.java
│   │       ├── UC13_PerformanceComparison.java
│   │       ├── UC14_CustomException.java
│   │       └── UC15_CargoSafetyAssignment.java (NEW)
│   └── test/java/
│       └── com/train/management/
│           └── UC15_CargoSafetyAssignmentTest.java (NEW)
├── pom.xml
└── README.md
```

## Use Cases Overview

### UC7: Sort Bogies by Capacity (Comparator)
- Demonstrates use of Comparator for custom sorting
- Sorts passenger bogies by seating capacity
- Uses method references for cleaner code

### UC8: Filter Passenger Bogies Using Streams
- Demonstrates stream-based filtering
- Filters bogies by capacity threshold
- Handles empty result sets

### UC9: Group Bogies by Type
- Groups bogies using Collectors.groupingBy
- Creates categorized data structures
- Enables structured reporting

### UC10: Count Total Seats in Train
- Aggregates bogie capacities
- Uses stream reduce operations
- Provides quantitative metrics

### UC11: Validate Train ID & Cargo Codes
- Regex pattern validation
- Train ID format: TRN-1234
- Cargo Code format: PET-AB
- Interactive user input

### UC12: Safety Compliance Check
- Validates goods bogie configurations
- Business rule: Cylindrical bogies carry Petroleum only
- Uses stream allMatch() validation

### UC13: Performance Comparison
- Benchmarks loop vs stream approaches
- Uses System.nanoTime() for measurements
- Compares execution times

### UC14: Handle Invalid Bogie Capacity
- Custom exception handling
- Fail-fast validation
- Business rule enforcement

## Prerequisites

- Java 11 or higher
- Maven 3.6+

## Running the Use Cases

### Option 1: Command Line (No Maven)
```bash
# Compile all files
javac -d bin src/main/java/com/train/management/*.java

# Run specific UC
java -cp bin com.train.management.UC7_SortByComparator
java -cp bin com.train.management.UC8_FilterWithStreams
java -cp bin com.train.management.UC9_GroupByType
java -cp bin com.train.management.UC10_CountTotalSeats
java -cp bin com.train.management.UC11_ValidateRegex
java -cp bin com.train.management.UC12_SafetyCompliance
java -cp bin com.train.management.UC13_PerformanceComparison
java -cp bin com.train.management.UC14_CustomException
```

### Option 2: Maven
```bash
# Compile
mvn clean compile

# Run specific UC
mvn exec:java -Dexec.mainClass="com.train.management.UC7_SortByComparator"
mvn exec:java -Dexec.mainClass="com.train.management.UC8_FilterWithStreams"
mvn exec:java -Dexec.mainClass="com.train.management.UC9_GroupByType"
mvn exec:java -Dexec.mainClass="com.train.management.UC10_CountTotalSeats"
mvn exec:java -Dexec.mainClass="com.train.management.UC11_ValidateRegex"
mvn exec:java -Dexec.mainClass="com.train.management.UC12_SafetyCompliance"
mvn exec:java -Dexec.mainClass="com.train.management.UC13_PerformanceComparison"
mvn exec:java -Dexec.mainClass="com.train.management.UC14_CustomException"
```

## Key Learning Outcomes

1. **Collections & Comparators**: Custom sorting with Comparator
2. **Stream API**: Filtering, mapping, and collecting
3. **Collectors**: GroupingBy for data aggregation
4. **Functional Programming**: Lambda expressions and method references
5. **Validation**: Pattern matching with Regex
6. **Business Rules**: Domain-driven validation
7. **Performance**: Benchmarking and optimization
8. **Exception Handling**: Custom exceptions and fail-fast validation

## Design Patterns

- **Domain Objects**: Bogie, GoodsBogie classes
- **Custom Exceptions**: InvalidCapacityException
- **Functional Processing**: Stream operations
- **Validation at Entry Points**: Constructor validation

## License

Educational material
