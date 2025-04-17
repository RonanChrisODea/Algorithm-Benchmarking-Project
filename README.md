# AlgoBench

This repository demonstrates a performance benchmarking application for comparing various sorting algorithms across different input sizes and data distributions, built using Java and Gradle.

## Project Structure

The project follows the standard Gradle directory structure:

```
AlgoBench/
├── src/
│   ├── main/
│   │   └── java/ 
│   │       └── ie/
│   │           └── ronanodea/
│   │               └── algobench/
│   │                   ├── BenchmarkConfig.java
│   │                   ├── BenchmarkRunner.java
│   │                   ├── Benchmarker.java
│   │                   ├── BenchmarkResultsPrinter.java
│   │                   ├── BubbleSort.java
│   │                   ├── BucketSort.java
│   │                   ├── CommandLineParser.java
│   │                   ├── CSVExporter.java
│   │                   ├── InsertionSort.java
│   │                   ├── Main.java
│   │                   ├── MergeSort.java
│   │                   └── SelectionSort.java
│   └── test/
│       └── java/  
│           └── ie/
│               └── ronanodea/
│                   └── algobench/
│                       ├── BubbleSortTest.java
│                       ├── BucketSortTest.java
│                       ├── CommandLineParserTest.java
│                       ├── InsertionSortTest.java
│                       ├── MergeSortTest.java
│                       └── SelectionSortTest.java
├── build.gradle 
├── gradlew
├── gradlew.bat
└── gradle/
    └── wrapper/
        ├── gradle-wrapper.jar
        └── gradle-wrapper.properties
```

## Implemented Algorithms

- **Bubble Sort** - Simple comparison-based algorithm with O(n²) average complexity
- **Selection Sort** - In-place comparison sort with O(n²) complexity in all cases
- **Insertion Sort** - Simple sorting algorithm that builds the sorted array one item at a time
- **Merge Sort** - Divide and conquer algorithm with O(n log n) complexity
- **Bucket Sort** - Distribution sort that distributes elements into buckets, then sorts each bucket

## Prerequisites

- Java Development Kit (JDK) 17 or later: This project is set up to use JDK 17+. You can download a JDK from Adoptium or your preferred JDK vendor. Make sure java and javac are on your PATH.
- Git: Used to clone the project.

## Cloning the Repository

To get a copy of this project on your local machine, open a terminal (or Git Bash on Windows) and run:

```bash
git clone https://github.com/RonanChrisODea/Algorithm-Benchmarking-Project.git
cd Algorithm-Benchmarking-Project
```

## Building and Running the Application

This project uses the Gradle Wrapper. You do not need to install Gradle separately. The wrapper will automatically download and use the correct version of Gradle for this project.

### Using the Terminal (Recommended)

1. Navigate to the project root: Open a terminal and use the `cd` command to navigate to the AlgoBench directory (the directory containing gradlew.bat).

2. Build and Run: Execute the following command:

   **Windows:**
   ```
   .\gradlew.bat clean build run
   ```

   **Linux/macOS:**
   ```
   ./gradlew clean build run
   ```

3. To run with specific arguments:

   **Windows:**
   ```
   .\gradlew.bat run --args="-r 5 -min -100 -max 100 -s 100,1000,10000"
   ```

   **Linux/macOS:**
   ```
   ./gradlew run --args="-r 5 -min -100 -max 100 -s 100,1000,10000"
   ```

### Command Line Arguments

```
Options:
  -r, --repetitions <num>  Number of repetitions for each benchmark (default: 10)
  -min, --min-value <num>  Minimum value for random arrays (default: 0)
  -max, --max-value <num>  Maximum value for random arrays (default: 100)
  -s, --sizes <s1,s2,...>  Comma-separated list of array sizes to benchmark
  -h, --help               Display this help message
```

## Running Tests

Run all tests using the Gradle test task:

**Windows:**
```
.\gradlew.bat test
```

**Linux/macOS:**
```
./gradlew test
```

This will compile the code, run all the unit tests, and generate a test report.

View the Test Report: After the tests run, open the HTML test report in your browser, found at the following directories:

- Windows: `.\build\reports\tests\test\index.html`
- Linux/macOS: `build/reports/tests/test/index.html`

<!-- Removed Javadoc section as it hasn't been implemented yet -->

## Using an IDE (IntelliJ IDEA, Eclipse, etc.)

### Import the Project:

- **IntelliJ IDEA**: Choose "Open" and select the build.gradle file or the project's root directory. IntelliJ IDEA will automatically detect the Gradle project.
- **Eclipse**: Choose "File" -> "Import..." -> "Gradle" -> "Existing Gradle Project". Select the project's root directory.
- **Other IDEs**: Use their appropriate "Import Project" feature for Gradle projects.

### Run the Application:

- **IntelliJ IDEA**: Right-click on the Main.java file and select "Run 'Main.main()'".
- **Eclipse**: Right-click on the Main.java file, go to "Run As" -> "Java Application".

### Run Tests:

- **IntelliJ IDEA**: Right-click on the src/test directory in the Project tool window and choose "Run 'All Tests'". You can also right-click on individual test classes or methods and run them.
- **Eclipse**: Right-click on the project, go to "Run As" -> "JUnit Test". You can also configure run configurations for specific tests.

## Example Output

```
Starting benchmarks with multithreading...

Array Size:   10           100          500          1000         2000         5000         10000        20000        
Bubble:       0.003940     0.039781     0.955040     3.771350     15.062731    93.688522    374.619005   1496.287141
Selection:    0.002193     0.022174     0.537114     1.825235     7.522413     46.926317    187.712514   750.840124
Insertion:    0.001846     0.018670     0.453048     1.731123     6.638221     41.489542    166.017842   664.035219
Merge:        0.003081     0.028914     0.172844     0.390219     0.872182     2.391001     5.103912     11.242184
Bucket:       0.006721     0.041522     0.204717     0.421093     0.902381     2.481824     5.302183     11.592918

Algorithm completion times:
Merge: 3.71 seconds
Bucket: 3.83 seconds
Insertion: 54.61 seconds
Selection: 62.81 seconds
Bubble: 105.33 seconds

Real world elapsed time: 105.33s

Results exported to: benchmark_results_20250417_120145.csv
```

## Performance Characteristics

| Algorithm     | Best Case    | Average Case | Worst Case   | Space Complexity | Stable |
|---------------|--------------|--------------|--------------|------------------|--------|
| Bubble Sort   | O(n)         | O(n²)        | O(n²)        | O(1)             | Yes    |
| Selection Sort| O(n²)        | O(n²)        | O(n²)        | O(1)             | No     |
| Insertion Sort| O(n)         | O(n²)        | O(n²)        | O(1)             | Yes    |
| Merge Sort    | O(n log n)   | O(n log n)   | O(n log n)   | O(n)             | Yes    |
| Bucket Sort   | O(n+k)       | O(n+k)       | O(n²)        | O(n+k)           | Yes    |

## Features

- **Configurable Benchmarks** - Customize array sizes, number of repetitions, and value ranges
- **Multithreaded Execution** - Parallel benchmarking for faster results
- **Statistical Analysis** - Averages over multiple runs for reliable measurements
- **CSV Export** - Exports results to CSV files for further analysis or visualization
- **Command-Line Interface** - Run benchmarks with custom parameters via CLI

## Cleaning the Build

To remove all generated files (compiled classes, test reports, etc.), run:

**Windows:**
```
.\gradlew.bat clean
```

**Linux/macOS:**
```
./gradlew clean
```

## Future Improvements

- Add more sorting algorithms (QuickSort, HeapSort, RadixSort, etc.)
- Implement visualization of sorting algorithms and benchmark results
- Add memory usage measurements
- Improve statistical analysis with standard deviation and confidence intervals
- Support for different data distributions (already sorted, reversed, nearly sorted)

## Author

Ronan O'Dea