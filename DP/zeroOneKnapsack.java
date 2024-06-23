import java.util.*;
/** 
 * problem : 
 * there is item and associated value we can add to bag but in whole amount(not like fractional knapsake problem)
 * and ya once we can add not infinite amount addition to bag(not like unbound knapsake problem)
 * 
 * value -> weight and maximum capacity of bag W. solution must be maximum profit by filling bag.
 * 
 * Solution :
 * so there is 2 choice either put or remove item from bag.
 * and we find for all items inorder to find all possiblies. n to 0.
 * 
 * if bag is has sapce to accomodate item .
 * then put it and also check what if we skip and add another item.
 * 
 * another case is item cann't accomodate in bag. its obvious that we have skip the item.
 * 
 * when travers completly
 * i.e. n == 0 return 0 so profit = value of item + 0; i.e.
 * 
 * 
 * so how to determine dp[] is what is changing each level. it's W and n.
 * 
 * for choice tree there migth possible that we gone through 
 * same workdone for n,w instead use dp[] to memoize it.
 * 
 */
public class zeroOneKnapsack {

    static int recursive_0_1_knapsack(int[] val, int[] wt, int W, int n) {// O(n^2)
        if (n == 0 || W == 0)
            return 0;
        
        if (wt[n-1] <= W) {// weight of item can fit in bag. then add it.
            // inclucde items
            int profit_with = val[n-1] + recursive_0_1_knapsack(val, wt, W-wt[n-1], n-1);
            // exclude items
            int profit_without = recursive_0_1_knapsack(val, wt, W, n-1);

            return Math.max(profit_with, profit_without);
        }

        return recursive_0_1_knapsack(val, wt, W, n-1);// weight is more so cann't fit in bag.
    }

    static int memoization_0_1_knapsack(int[] val, int[] wt, int W, int n, int[][] dp){// O(n*W)
        if (n == 0 || W == 0)
            return 0;
        
        if (dp[n][W] != -1) 
            return dp[n][W];

        if (wt[n-1] <= W) {
            // inclucde items
            int profit_with = val[n-1] + memoization_0_1_knapsack(val, wt, W-wt[n-1], n-1, dp);
            // exclude items
            int profit_without = memoization_0_1_knapsack(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(profit_with, profit_without);

            return dp[n][W];
        } else {
            dp[n][W] = memoization_0_1_knapsack(val, wt, W, n-1, dp);
            
            return dp[n][W];
        }
    }

    static int tabulation_0_1_knapsack(int[] val, int[] wt, int W, int n) {
        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int value = val[i-1];
                int weight = wt[i-1];

                if (weight <= j) {
                    int incProfit = value + dp[i-1][j-weight];
                    int excProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print_dp(dp);
        return dp[n][W];
    }

    static void print_dp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int n = val.length;
        int W = 7;

        int ans = recursive_0_1_knapsack(val, wt, W, n);
        System.out.println(ans);

        int[][] dp = new int[n+1][W +1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(memoization_0_1_knapsack(val, wt, W, n, dp));
        System.out.println(tabulation_0_1_knapsack(val, wt, W, n));
    }
}
