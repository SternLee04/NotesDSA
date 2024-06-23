import java.util.Arrays;
/**
 * same as 01 Kapsack just there is change in inclusion condition if included we moving to next item 
 * here we can include same item again.
 * the exlude condition is same.
 */
public class UnboundedKnapsack {

    // Function to solve the unbounded knapsack problem using memoization
    static int knapsackMemo(int[] weights, int[] values, int capacity, int n, int[][] dp) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if (weights[n - 1] <= capacity) {
            // We can either include the item multiple times or exclude it
            int include = values[n - 1] + knapsackMemo(weights, values, capacity - weights[n - 1], n, dp);
            int exclude = knapsackMemo(weights, values, capacity, n - 1, dp);
            dp[n][capacity] = Math.max(include, exclude);
        } else {
            dp[n][capacity] = knapsackMemo(weights, values, capacity, n - 1, dp);
        }

        return dp[n][capacity];
    }

    static int knapsackTab(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[][] dp = new int[n+1][capacity+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < capacity+1; j++) {
                int value = values[i-1];
                int weight = weights[i-1];

                if (weight <= j) {
                    int incProfit = value + dp[i][j-weight];
                    int excProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {10, 40, 50, 70};
        int capacity = 8;
        int n = weights.length;

        int[][] dp = new int[n + 1][capacity + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int maxProfitM = knapsackMemo(weights, values, capacity, n, dp);
        int maxProfitT = knapsackTab(weights, values, capacity);

        System.out.println("Maximum Profit (Memoization): " + maxProfitM);
        System.out.println("Maximum Profit (Tabulation): " + maxProfitT);
    }
}
