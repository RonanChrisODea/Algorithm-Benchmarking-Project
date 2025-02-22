package ie.ronanodea.algobench;

import java.util.function.Consumer;

public class BenchmarkRunner {
    private final Benchmarker benchmarker;
    private final BenchmarkConfig config;
    private final BenchmarkResultsPrinter printer;

    public BenchmarkRunner(BenchmarkConfig config) {
        this.benchmarker = new Benchmarker();
        this.config = config;
        this.printer = new BenchmarkResultsPrinter();
    }

    public void runAllBenchmarks() {
        System.out.println("Starting sorting algorithm benchmarks...\n");
        long startTime = System.nanoTime();
        
        printer.printHeader(config.getArraySizes());

        runSortingBenchmark("Bubble", BubbleSort::bubbleSort);
        runSortingBenchmark("Selection", SelectionSort::selectionSort);
        runSortingBenchmark("Insertion", InsertionSort::insertionSort);
        runSortingBenchmark("Merge", MergeSort::mergeSort);
        runSortingBenchmark("Bucket", BucketSort::bucketSort);

        long endTime = System.nanoTime();
        double totalTimeSeconds = (endTime - startTime) / 1_000_000_000.0;
        printer.printTotalTime(totalTimeSeconds);
        System.out.println("\nBenchmarking complete.");
    }

    private void runSortingBenchmark(String algorithmName, Consumer<int[]> sortingAlgorithm) {
        int[] sizes = config.getArraySizes();
        int reps = config.getRepetitions();
        int minValue = config.getMinValue();
        int maxValue = config.getMaxValue();
        
        double[] wallTimes = new double[sizes.length];
        double[] cpuTimes = new double[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            wallTimes[i] = benchmarker.benchmarkWallTime(reps, sizes[i], sortingAlgorithm, minValue, maxValue);
            cpuTimes[i] = benchmarker.benchmarkCpuTime(reps, sizes[i], sortingAlgorithm, minValue, maxValue);
        }

        printer.printAlgorithmResults(algorithmName, wallTimes, cpuTimes);
    }
}