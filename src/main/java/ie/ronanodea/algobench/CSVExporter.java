package ie.ronanodea.algobench;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVExporter {
    private final List<BenchmarkResult> results;
    private final int[] sizes;

    private static class BenchmarkResult {
        final String algorithmName;
        final double[] wallTimes;

        BenchmarkResult(String algorithmName, double[] wallTimes) {
            this.algorithmName = algorithmName;
            this.wallTimes = wallTimes.clone();
        }
    }

    public CSVExporter(int[] sizes) {
        this.sizes = sizes.clone();
        this.results = new ArrayList<>();
    }

    public void addResult(String algorithmName, double[] wallTimes) {
        results.add(new BenchmarkResult(algorithmName, wallTimes));
    }

    public void exportToFile() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "benchmark_results_" + timestamp + ".csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write header
            writer.print("Algorithm,");
            for (int size : sizes) {
                writer.print(size + ",");
            }
            writer.println();

            // Write wall times for each algorithm
            for (BenchmarkResult result : results) {
                writer.print(result.algorithmName + ",");
                for (double time : result.wallTimes) {
                    writer.print(time + ",");
                }
                writer.println();
            }

            System.out.println("\nResults exported to: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}