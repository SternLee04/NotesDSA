public class Subsetsum {
    // Memoization table

    static boolean subset(int[] nums, int target, int n,boolean dp[][]) {// O(n*target)
        // Base Cases
        if (target == 0){
            return true; // A subset with sum 0 is always possible: the empty subset
        }
        if (n == 0) {
            return false; // If there are no numbers left and target is not 0, no subset exists
        }

        // Check if the subproblem has already been solved
        if (dp[n][target]) {
            return dp[n][target];
        }

        if (nums[n - 1] > target) {
            // Check if last element is greater than the sum
            dp[n][target] = subset(nums, target, n - 1, dp);
        } else {
            // Check if the sum can be obtained by either including or excluding the last
            // element
            boolean taken = subset(nums, target - nums[n - 1], n - 1, dp);
            boolean notTaken = subset(nums, target, n - 1, dp);
            dp[n][target] = taken || notTaken;
        }

        return dp[n][target];
    }

    static void print(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean subset_tabulation(int[] nums, int target, int n) {
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base cases initialization
        for (int i = 1; i <= target; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Filling the DP table
        for (int item = 1; item <= n; item++) {
            for (int sum = 1; sum <= target; sum++) {
                int value = nums[item - 1];

                if (value <= sum && dp[item - 1][sum - value]) {
                    dp[item][sum] = true;
                } else {
                    dp[item][sum] = dp[item - 1][sum];
                }
            }
        }

        // Printing the DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] ? "y " : "n ");
            }
            System.out.println();
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 7, 1, 3 };
        int target = 10;

        // Initialize the memoization table
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // if (subset_tabulation(nums, 10, nums.length)) {
        //     System.out.println("yes");
        // } else {
        //     System.out.println("no");
        // }
        subset(nums, target, nums.length, dp);
        print(dp);
    }
}
