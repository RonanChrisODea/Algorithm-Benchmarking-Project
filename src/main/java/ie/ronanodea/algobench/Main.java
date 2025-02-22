package ie.ronanodea.algobench;

public class Main {
    public static void main(String[] args) {
        // Use default configuration
        BenchmarkConfig defaultConfig = BenchmarkConfig.getDefault();
        BenchmarkRunner runner = new BenchmarkRunner(defaultConfig);
        runner.runAllBenchmarks();

        // Example of custom configuration
        /*
        BenchmarkConfig customConfig = new BenchmarkConfig.Builder()
            .randomRange(-1000, 1000)
            .repetitions(20)
            .build();
        BenchmarkRunner customRunner = new BenchmarkRunner(customConfig);
        customRunner.runAllBenchmarks();
        */
    }
}