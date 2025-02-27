package ie.ronanodea.algobench;

public class Main {
    public static void main(String[] args) {
        try {
            // Check for help flag first
            if (args.length > 0 && (args[0].equals("-h") || args[0].equals("--help"))) {
                CommandLineParser.printHelp();
                return;
            }
            
            // Parse command line arguments
            BenchmarkConfig config;
            if (args.length > 0) {
                config = CommandLineParser.parseArgs(args);
                if (config == null) {
                    return; // Help was displayed
                }
                CommandLineParser.printConfiguration(config);
            } else {
                // Use default configuration if no arguments provided
                config = BenchmarkConfig.getDefault();
                System.out.println("Using default configuration:");
                CommandLineParser.printConfiguration(config);
            }
            
            // Run benchmarks with the configured settings
            BenchmarkRunner runner = new BenchmarkRunner(config);
            runner.runAllBenchmarks();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            CommandLineParser.printHelp();
        }
    }
}