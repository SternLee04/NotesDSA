
/**
 * CoinChange1 : count subset sum in unbounded form
 * 
 * Problem :
 * you have return number of possible way to make the Sum of money to pay vandor.
 * coin[] is given that kind of coin you have
 * you can choose same coin again.(unbound knapsack)
 */
public class CoinChange1 {

    static int coinchange(int[] coins, int payment, int n, int[][] dp) {
        if (payment == 0) 
            return 1;
        if (n == 0) 
            return 0;

        if (dp[n][payment] != 0) 
            return dp[n][payment];
        
        if (coins[n-1] <= payment) {
            int inclucdeWays = coinchange(coins, payment-coins[n-1], n, dp);
            int excludeWays = coinchange(coins, payment, n-1, dp);
            dp[n][payment] = inclucdeWays + excludeWays;
        } else {
            int excludeWays = coinchange(coins, payment, n-1, dp);
            dp[n][payment] = excludeWays;
        }

        return dp[n][payment];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int payment = 5;

        int n = coins.length;
        int[][] dp = new int[n+1][payment+1];

        int ways = coinchange(coins, payment, n, dp);
        System.out.println(ways);
    }
}