import java.util.*;
/**
 * aka Kadane Algo
 */
public class MaxSubarraySum {
    // Function to find the maximum subarray sum
    static long maxSubarraySum(long[] arr, int N) {
        // Variables to store the running sum and the maximum sum
        long sum = 0, max_sum = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            max_sum = Math.max(max_sum, sum);
            // If we encounter a subarray with negative sum,
            // remove the subarray from the current sum
            if (sum < 0)
                sum = 0;
        }
        return max_sum;
    }

    public static void main(String[] args) {
        // Sample Input
        int N = 8;
        long[] arr = { -1, 3, -2, 5, 3, -5, 2, 2 };

        System.out.println(maxSubarraySum(arr, N));
    }
}

// This code is contributed by akshitaguprzj3
