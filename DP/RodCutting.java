import java.util.*;
/**
 * RodCutting
 * 
 * you given price where price is assoicated with length or rod.
 * N size road is given.
 * you have to maximize the profit by cutting the rod.
 * 
 * variation : 
 * if they given allowed length array, price array and N length rod.
 * idx(price) <-> idx(length).
 * 
 * else not given this means u can cut 0 to n length.
 * here it mendatory price.size() == N.
 */
public class RodCutting {

    static int profit(int[] length, int[] price, int N, int n, int[][] dp) {
        if (n == 0 || N == 0) {
            return 0;
        }

        if (dp[n][N] != 0) {
            return dp[n][N];
        }

        if (length[n-1] <= N) {
            int include = price[n-1]+ profit(length, price, N-length[n-1], n, dp);
            int exclude = profit(length, price, N, n-1, dp);
            
            dp[n][N] =  Math.max(include, exclude);
        } else {
            int exclude = profit(length, price, N, n-1, dp);
            dp[n][N] = exclude;
        }
        return dp[n][N];
    }

    public static void main(String[] args) {
        int[] length = {1, 3, 4, 5};
        int[] price = {10, 40, 50, 70};
        int N = 8;
        int n = price.length;

        int[][] dp = new int[n+1][N+1];

        int profit = profit(length, price, N, n, dp);
        System.out.println(profit);
    }
}