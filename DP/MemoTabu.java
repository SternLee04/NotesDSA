import java.util.*;

/**
 * way to implement DP is through :
 * 
 * Memoization.
 * Tabulation.
 * 
 * Memo = recursion + choice + store.
 * tabu = table + loop + store.
 */
public class MemoTabu {

    static int memoization_dp(int n, int[] dp) {// top to down : biggest + bigger + big + small + ... + smallest = big
        if (n == 1 || n == 0) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = memoization_dp(n - 1, dp) + memoization_dp(n - 2, dp);
        return dp[n];
    }

    static int tabulation_dp(int n) {// bottom to up : sub + sub + ... + sub = big
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;

        int[] dp = new int[n + 1];
        System.out.println(memoization_dp(n, dp));

        System.out.println(tabulation_dp(n));
    }
}