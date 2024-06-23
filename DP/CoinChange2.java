import java.util.*;
/**
 * CoinChange2
 * 
 * this only problem that hase twist ! in initialization.
 * 
 * Problem :
 * same as coin change 1 you given coin[] and Payment
 * you have to find the minimum coin to make payments.
 */
public class CoinChange2 {
    static int ways(int[] coins, int payment, int n, int[][] dp) {
        if (n == 0 || payment == 0)  
            return dp[n][payment];

        if (dp[n][payment] != 0) {
            return dp[n][payment];
        }

        if (coins[n-1] <= payment) {
            int include = 1 + ways(coins, payment-coins[n-1], n, dp);
            int exclude = ways(coins, payment, n-1, dp);

            dp[n][payment] = Math.min(include, exclude);
        } else {
            dp[n][payment] = ways(coins, payment, n-1, dp);
        }

        return dp[n][payment];
    }


    public static void main(String[] args) {
        int[] coins = {1,2,3};// output : 2 -> 3+2 = 5
        int payment = 5;
        int n = coins.length;

        int ways_tabulation = ways_tabulation(coins, payment, n);
        System.out.println(ways_tabulation);

        int[][] dp = new int[n+1][payment+1];
        // Initialize
        for (int i = 1; i < payment+1; i++) {// we have to pay but we don't have coins.
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for (int i = 0; i < n+1; i++) {// when there is nothing to pay.
            dp[i][0] = 0;
        }
        for (int i = 1; i < payment+1 ; i++) {// can we payment using first coin ?
            dp[1][i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE-1;
        }

        int ways_memoization = ways(coins, payment, n, dp);
        System.out.println(ways_memoization);
    }

    static int ways_tabulation(int[] coins, int payment, int n) {

        int[][] dp = new int[n+1][payment+1];
        // Initialize
        for (int i = 1; i < payment+1; i++) {// we have to pay but we don't have coins.
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for (int i = 0; i < n+1; i++) {// when there is nothing to pay.
            dp[i][0] = 0;
        }
        for (int i = 1; i < payment+1 ; i++) {// can we payment using first coin ?
            dp[1][i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE-1;
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < payment+1; j++) {
                if (coins[i-1] <= j) {
                    int include = 1 + dp[i][j-coins[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.min(include, exclude);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][payment];
    }
}

// chat gpt 
/*
import java.util.*;

public class CoinChange2 {


 */