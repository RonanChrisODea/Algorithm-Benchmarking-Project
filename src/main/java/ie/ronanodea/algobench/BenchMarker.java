package ie.ronanodea.algobench;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class BenchMarker {

//     This method of random number generation is encouraged by Dr. John Healy.
//     Researching this leads me to believe this is a safer method to implement for multithreading.
//     https://stackoverflow.com/questions/23396033/random-over-threadlocalrandom
//     it also allows me to specify a lower/ upper bound easily.
    private static int[] randomArray(int size, int min, int max) {
        int[] randArr = new int[size];
        for (int i = 0; i < randArr.length; i++) {
            int boundedRandomValue = ThreadLocalRandom.current().nextInt(min, max);
            randArr[i] = boundedRandomValue;
        }
        return randArr;
    }

    // method taken from class materials
    private int[] copyArr(int[] src) {
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }


    // Here I had the idea to allow the benchmark method to accept an int
    // to define the size of the random array, and the sorting method to be used.
    // In order to pass a method from another class I implemented the Consumer function.

    public double benchmark(int reps, int size, Consumer<int[]> sortingMethod) {
        double total = 0;
        int[] arr = randomArray(size, 0, 100);
        // useful for checking if arrays are indeed sorting correctly
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            long startTime = System.nanoTime();
            sortingMethod.accept(cloned);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            double elapsedMillis = timeElapsed / 1000000.0;
            total += elapsedMillis;
            // useful for checking if arrays are indeed sorting correctly
            //System.out.println(Arrays.toString(cloned));

        }
        return total / reps;
        //System.out.println("Average time: " + averageTime + " ms");
    }
}


// I'd like to measure CPU time but am low on time to implement the JMH
// https://stackoverflow.com/questions/7467245/cpu-execution-time-in-java
// https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java