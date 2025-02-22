package ie.ronanodea.algobench;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BenchMarker bm = new BenchMarker();
        int reps = 10;
        int[] sizes = {10, 100, 500, 1000, 2000, 3000, 5000, 10000, 12000, 15000};

        // Print the header
        System.out.format("%-15s", "Size");
        for (int size : sizes) {
            System.out.format("%-10d", size);
        }
        System.out.println();

        // Benchmark each sorting algorithm
        benchmarkAlgorithm("Bubble", bm, sizes, reps, BubbleSort::bubbleSort);
        benchmarkAlgorithm("Selection", bm, sizes, reps, SelectionSort::selectionSort);
        benchmarkAlgorithm("Insertion", bm, sizes, reps, InsertionSort::insertionSort);
        benchmarkAlgorithm("Merge", bm, sizes, reps, MergeSort::mergeSort);
        benchmarkAlgorithm("Bucket", bm, sizes, reps, BucketSort::bucketSort);

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        double elapsedMillis = timeElapsed / 1000000.0;
        System.out.println("\nReal world elapsed time: " + elapsedMillis/1000 + "s");
    }

    private static void benchmarkAlgorithm(String name, BenchMarker bm, int[] sizes, int reps,
            Consumer<int[]> algorithm) {
        // Print wall time row
        System.out.format("%-15s", name + "(W)");
        for (int size : sizes) {
            double wallTime = bm.benchmarkWallTime(reps, size, algorithm);
            System.out.format("%-10.3f", wallTime);
        }
        System.out.println();

        // Print CPU time row
        System.out.format("%-15s", name + "(C)");
        for (int size : sizes) {
            double cpuTime = bm.benchmarkCpuTime(reps, size, algorithm);
            System.out.format("%-10.3f", cpuTime);
        }
        System.out.println();
        System.out.println(); // Extra line between algorithms
    }
}