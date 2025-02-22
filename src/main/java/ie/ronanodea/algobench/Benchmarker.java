package ie.ronanodea.algobench;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class Benchmarker {
    private static final int WARM_UP_ITERATIONS = 5;
    private final ThreadMXBean threadMXBean;

    public Benchmarker() {
        this.threadMXBean = ManagementFactory.getThreadMXBean();
    }

    private static int[] randomArray(int size, int min, int max) {
        int[] randArr = new int[size];
        for (int i = 0; i < randArr.length; i++) {
            int boundedRandomValue = ThreadLocalRandom.current().nextInt(min, max);
            randArr[i] = boundedRandomValue;
        }
        return randArr;
    }

    private int[] copyArr(int[] src) {
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }

    private void performWarmup(int size, Consumer<int[]> sortingMethod, int minValue, int maxValue) {
        int[] warmupArray = randomArray(size, minValue, maxValue);
        for (int i = 0; i < WARM_UP_ITERATIONS; i++) {
            int[] cloned = copyArr(warmupArray);
            sortingMethod.accept(cloned);
        }
    }

    public double benchmarkWallTime(int reps, int size, Consumer<int[]> sortingMethod, int minValue, int maxValue) {
        performWarmup(size, sortingMethod, minValue, maxValue);
        
        double totalWallTime = 0;
        int[] arr = randomArray(size, minValue, maxValue);
        
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            
            long startWallTime = System.nanoTime();
            sortingMethod.accept(cloned);
            long endWallTime = System.nanoTime();
            
            double wallTimeMs = (endWallTime - startWallTime) / 1_000_000.0;
            totalWallTime += wallTimeMs;
        }
        
        return totalWallTime / reps;
    }

    public double benchmarkCpuTime(int reps, int size, Consumer<int[]> sortingMethod, int minValue, int maxValue) {
        performWarmup(size, sortingMethod, minValue, maxValue);
        
        double totalCpuTime = 0;
        int[] arr = randomArray(size, minValue, maxValue);
        
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            
            long startCpuTime = threadMXBean.getCurrentThreadCpuTime();
            sortingMethod.accept(cloned);
            long endCpuTime = threadMXBean.getCurrentThreadCpuTime();
            
            double cpuTimeMs = (endCpuTime - startCpuTime) / 1_000_000.0;
            totalCpuTime += cpuTimeMs;
        }
        
        return totalCpuTime / reps;
    }
}