# AlgoBench - Java Sorting Algorithm Benchmarking Tool

A performance benchmarking application for comparing various sorting algorithms across different input sizes and data distributions.

![Java](https://img.shields.io/badge/Java-17-orange)
![Gradle](https://img.shields.io/badge/Gradle-7.4+-blue)
![JUnit](https://img.shields.io/badge/JUnit-5.8.1-green)

## Overview

AlgoBench provides a framework for evaluating the performance characteristics of different sorting algorithms. It supports multiple array sizes, customizable data distributions, and exports results to CSV for further analysis.

### Implemented Algorithms

- **Bubble Sort** - Simple comparison-based algorithm with O(n²) average complexity
- **Selection Sort** - In-place comparison sort with O(n²) complexity in all cases
- **Insertion Sort** - Simple sorting algorithm that builds the sorted array one item at a time
- **Merge Sort** - Divide and conquer algorithm with O(n log n) complexity
- **Bucket Sort** - Distribution sort that distributes elements into buckets, then sorts each bucket

## Features

- **Configurable Benchmarks** - Customize array sizes, number of repetitions, and value ranges
- **Multithreaded Execution** - Parallel benchmarking for faster results
- **Statistical Analysis** - Averages over multiple runs for reliable measurements
- **CSV Export** - Exports results to CSV files for further analysis or visualization
- **Command-Line Interface** - Run benchmarks with custom parameters via CLI

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

## Usage

### Command Line Arguments

```
./gradlew run --args="[options]"

Options:
  -r, --repetitions <num>  Number of repetitions for each benchmark (default: 10)
  -min, --min-value <num>  Minimum value for random arrays (default: 0)
  -max, --max-value <num>  Maximum value for random arrays (default: 100)
  -s, --sizes <s1,s2,...>  Comma-separated list of array sizes to benchmark
  -h, --help               Display this help message

Example:
  ./gradlew run --args="-r 5 -min -100 -max 100 -s 100,1000,10000"
```

### Using in Code

```java
// Create a custom configuration
BenchmarkConfig config = new BenchmarkConfig.Builder()
    .arraySizes(new int[]{100, 1000, 10000})
    .repetitions(5)
    .randomRange(-100, 100)
    .build();

// Run benchmarks
BenchmarkRunner runner = new BenchmarkRunner(config);
runner.runAllBenchmarks();
```

## Project Structure

- `ie.ronanodea.algobench` - Main package
  - Sorting algorithm implementations: `BubbleSort`, `SelectionSort`, `InsertionSort`, `MergeSort`, `BucketSort`
  - Benchmarking: `Benchmarker`, `BenchmarkRunner`, `BenchmarkConfig`
  - Results: `BenchmarkResultsPrinter`, `CSVExporter`
  - Command line: `CommandLineParser`, `Main`

## Performance Characteristics

| Algorithm     | Best Case    | Average Case | Worst Case   | Space Complexity | Stable |
|---------------|--------------|--------------|--------------|------------------|--------|
| Bubble Sort   | O(n)         | O(n²)        | O(n²)        | O(1)             | Yes    |
| Selection Sort| O(n²)        | O(n²)        | O(n²)        | O(1)             | No     |
| Insertion Sort| O(n)         | O(n²)        | O(n²)        | O(1)             | Yes    |
| Merge Sort    | O(n log n)   | O(n log n)   | O(n log n)   | O(n)             | Yes    |
| Bucket Sort   | O(n+k)       | O(n+k)       | O(n²)        | O(n+k)           | Yes    |

## Build and Run

### Prerequisites

- Java 11 or higher
- Gradle 7.4+

### Building and Running

```bash
# Clone the repository
git clone https://github.com/yourusername/algobench.git

# Navigate to project directory
cd algobench

# Build and run with Gradle
./gradlew clean build run
```

If you want to run specific arguments:

```bash
./gradlew run --args="-r 5 -min -100 -max 100 -s 100,1000,10000"
```

## Testing

The project includes comprehensive JUnit 5 tests for all sorting algorithms. Run tests with:

```bash
gradle test
```

## Future Improvements

- Add more sorting algorithms (QuickSort, HeapSort, RadixSort, etc.)
- Implement visualization of sorting algorithms and benchmark results
- Add memory usage measurements
- Improve statistical analysis with standard deviation and confidence intervals
- Support for different data distributions (already sorted, reversed, nearly sorted)

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Algorithm visualizations and explanations cited in code comments
- JUnit 5 for testing framework

## Author

Ronan O'Dea - Higher Diploma in Software Design