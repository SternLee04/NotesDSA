import java.util.*;;
/**
 * countSubSetSum this time we don't have return true or false we have to return count of subset.
 * {}
 */
public class countSubSetSum {

    static Integer dp[][];

    static int countSubSet(int[] nums, int sum, int n) {
        if (sum == 0) 
            return 1;
        if (n == 0) 
            return 0;

        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        if (nums[n-1] <= sum) {
            dp[n][sum] = countSubSet(nums, sum-nums[n-1], n-1) + countSubSet(nums, sum, n-1);
        } else {
            dp[n][sum] = countSubSet(nums, sum, n-1);
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,6,8,10};
        int sum = 10;

        dp = new Integer[nums.length+1][sum+1];

        int ans = countSubSet(nums, sum, nums.length);// {2,8}, {5,2,3}, {10} = 3
        System.out.println(ans);
    }
}