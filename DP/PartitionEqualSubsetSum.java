/**
 * a variation of sub set sum just check sum is even then find for sum/2 because x/2 + x/2 = x.
 */
public class PartitionEqualSubsetSum {

    static Boolean[][] dp;
    static boolean subSetSum(int[] nums, int sum, int n) {
        if (sum == 0) 
            return true;
        if (n == 0) 
            return false;

        if (dp[n-1][sum] != null) 
            return true;

        if (nums[n-1] <= sum) {
            dp[n][sum] = subSetSum(nums, sum - nums[n-1], n-1) || subSetSum(nums, sum, n-1);
        } else {
            dp[n][sum] = subSetSum(nums, sum, n-1);
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};// output : 5+1+5 , 11 = 11 + 11 = 22 -> 22 is even. so we can make partitions equally.

        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        if (sum % 2 != 0) {
            System.out.println("not possible.");
        } else {
            dp = new  Boolean[nums.length+1][sum+1];
            boolean subsetsum = subSetSum(nums, sum/2, nums.length);
            if (subsetsum) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
