import java.util.*;
/**
 * minimum Subset Sum Difference : variation of equal partition.
 * 
 * NOTE : absolute difference is to find so s1 - s2 or s2 - s1 is same thing.
 * 
 * Problem is we have to find subset sum this is minimum in number : s1 - s2 or s2 - s1 should be minimum.
 * 
 * what is maximum sum for subset ? {1,6,11,5} , {0} = 23 , 0
 * 
 * it is obviously we make 2 partions (subset) is always lying between 0 to sum or elements in array.
 * because s1 + s2 = sum of elements.
 * 
 * Math :
 * let range = sum of elements in array;
 * 
 * s1 + s2 = range
 * s2 = range - s1 // by this if we able to find one subset sum then automatically s2 achived. : subset sum problem.
 * s2 - s1 = minimum // real problem. a
 * minimum = (range - s1) - s1 
 * minimum = range - 2 * s1
 * 
 * how find s1 ?
 * s1 is noting but a subset within 0 to range.
 * each block of dp[n][sum] will tell when size of array is n we can get sum or not.
 * dp[1][10] this say there is only one element in array whose sum is 10 -> 
 * also means if sum exist then element is non other its 10 itself.
 * 
 * same way dp[3][sum] were nums size is 3 this row of dp tell all possible sum we can generate using array.
 * which is consider as s1.
 * 
 * filter using two pointer : let range is 10 array is any.
 * s1 - s2
 * 0 - 10 = 10 maximum subset sum
 * 1 - 9 = 8
 * 2 - 8 = 6
 * 3 - 7 = 4
 * 4 - 6 = 2
 * 5 - 5 = 0 // mid of range
 * 6 - 4 = 2
 * 
 * s1 s2 must be other side of mid point to get answer
 * 
 * check for every s1 possible and calculate s2 by range - 2s1 and minimum of that is answer.
 */
public class minimumSubsetSumDifference {

    static int tabulation(int[] nums, int range, int n) {
        boolean[][] dp = new boolean[n+1][range+1];

        // Initialize dp array
        for (int i = 1; i <= range; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill dp array
        for (int item = 1; item <= n; item++) {
            for (int sum = 1; sum <= range; sum++) {
                int value = nums[item - 1];

                if (value <= sum) {
                    dp[item][sum] = dp[item - 1][sum - value] || dp[item - 1][sum];
                } else {
                    dp[item][sum] = dp[item - 1][sum];
                }
            }
        }// in bottom up there no need to find possible s1 we are done that is last row : i items can we make j sum ?

        // Find the minimum difference
        int minimize = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= range / 2; s1++) {
            if (dp[n][s1]) {
                int difference = range - 2 * s1;
                minimize = Math.min(minimize, difference);
            }
        }

        return minimize;
    }

    static boolean subsetSum(int[] nums, int sum, int n, boolean[][] dp) {
        if (sum == 0) 
            return true;
        if (n == 0) 
            return false;

        if (dp[n][sum]) {
            return dp[n][sum];
        }

        if (nums[n-1] <= sum) {
            dp[n][sum] = subsetSum(nums, sum-nums[n-1], n-1, dp) || subsetSum(nums, sum, n-1, dp);
        } else {
            dp[n][sum] = subsetSum(nums, sum, n-1, dp);
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7};// output : 1 -> {1,6,5} {11} -> 12 - 11 == 1
        int n = nums.length;

        int range = 0;
        for (int i = 0; i < nums.length; i++) {
            range += nums[i];
        }

        boolean[][] dp = new boolean[nums.length+1][range+1];
        // base case 
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }

        boolean[] possibleS1 = new boolean[range+1];
        for (int i = 0; i <= range/2; i++) {// we need to find s1 for each nth row.
            possibleS1[i] = subsetSum(nums, i, n, dp);
        }

        int minimize = Integer.MAX_VALUE;
        for (int i = 0; i <= range/2; i++) {
            if (possibleS1[i]) {
                minimize = Math.min(minimize, range - 2 * i);
            }
        }


        System.out.println(minimize);
        System.err.println(tabulation(nums, range, n));
    }
}

// NOTE: It is _NOT_ always same _DP TABLE_ generation by using both approaches.