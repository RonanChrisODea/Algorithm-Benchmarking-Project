package ie.ronanodea.algobench;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        BenchMarker bm = new BenchMarker();
        int reps = 10;
        int[] sizes = {10, 100, 500, 1000, 2000, 3000, 5000, 10000, 12000, 15000 };

        // Print the header
        // Formatting info from :"https://www.javatpoint.com/java-string-format"
        System.out.format("%-15s", "Size");
        for (int size : sizes) {
            System.out.format("%-10d", size);
        }
        System.out.println();

        // Benchmark Bubble Sort
        System.out.format("%-15s", "Bubble Sort");
        for (int size : sizes) {
            if (size > 25000) {
                break; // Break out of the loop if the array size is greater than 5000
            }
            double avgTime = bm.benchmark(reps, size, BubbleSort::bubbleSort);
            System.out.format("%-10.3f", avgTime);
        }
        System.out.println(); // Move to the next line after all sizes


        //  Benchmark Selection Sort
        System.out.format("%-15s", "Selection Sort");
        for (int size : sizes) {
            double avgTime = bm.benchmark(reps, size, SelectionSort::selectionSort);
            System.out.format("%-10.3f", avgTime);
        }
        System.out.println(); // Move to the next line after all sizes

         // Benchmark Insertion Sort
        System.out.format("%-15s", "Insertion Sort");
        for (int size : sizes) {
            double avgTime = bm.benchmark(reps, size, InsertionSort::insertionSort);
            System.out.format("%-10.3f", avgTime);
        }
        System.out.println(); // Move to the next line after all sizes

        // Benchmark Merge Sort
        System.out.format("%-15s", "Merge Sort");
        for (int size : sizes) {
            double avgTime = bm.benchmark(reps, size, MergeSort::mergeSort);
            System.out.format("%-10.3f", avgTime);
        }
        System.out.println(); // Move to the next line after all sizes

        // Benchmark Bucket Sort
        System.out.format("%-15s", "Bucket Sort");
        for (int size : sizes) {
            double avgTime = bm.benchmark(reps, size, BucketSort::bucketSort);
            System.out.format("%-10.3f", avgTime);
        }
        System.out.println(); // Move to the next line after all sizes


        // can probably turn the timer and the above sections into individual methods / classes
        // need to move onto report though so for now this will do. Could be too many layers of abstraction.
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        double elapsedMillis = timeElapsed / 1000000.0;
        System.out.println("\nReal world elapsed time: " + elapsedMillis/1000 +"s");

    }
}
