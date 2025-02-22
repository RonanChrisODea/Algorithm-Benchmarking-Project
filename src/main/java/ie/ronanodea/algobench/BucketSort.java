package ie.ronanodea.algobench;

import java.util.ArrayList;
import java.util.List;

// There seems to be some discourse as to this counting as a non-comparison algo when including insertation sort
// https://stackoverflow.com/questions/66940981/why-is-bucket-sort-considered-to-be-non-comparison-sort
// However the bulk of the sorting is done by array elements being allocated to defined buckets
// These buckets contain elements from predefined ranges. The insertion sort is just an efficient way of sorting the
// final 1 or two element buckets rather than relying on recursion alone.

//Leads to interesting results. Can be slower that merge sort in some scenarios, mainly low array size
// or tightly distributed arrays which are possible with current settings generating in range 0-99 .


// https://www.geeksforgeeks.org/bucket-sort-2/
// https://www.tutorialspoint.com/data_structures_algorithms/bucket_sort_algorithm.htm
// https://www.javatpoint.com/bucket-sort
// https://www.youtube.com/watch?v=vfIoJMsqJ74 - clear description of recursive bucket sort and use of linked lists



public class BucketSort {

    // Function to implement bucket sort
    public static void bucketSort(int[] arr) {
        if (arr.length <= 1) {
            return; // No need to sort if the array has 1 or no elements
        }

        // Find maximum value to determine bucket ranges
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // Number of buckets
        int numberOfBuckets = (int) Math.sqrt(arr.length);
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);

        // Initialize buckets
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = (int) ((double) num / (maxValue + 1) * numberOfBuckets);
            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket using insertion sort
        int index = 0;
        for (List<Integer> bucket : buckets) {
            int[] bucketArray = new int[bucket.size()];
            for (int i = 0; i < bucket.size(); i++) {
                bucketArray[i] = bucket.get(i);
            }

            // Call insertion sort on the bucket
            InsertionSort.insertionSort(bucketArray);

            // Concatenate the sorted buckets
            for (int num : bucketArray) {
                arr[index++] = num;
            }
        }
    }


}
