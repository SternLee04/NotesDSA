import java.util.*;
/**
 * count ways to reach the nth stair. person can either take 1 stair or 2 stairs at time.
 * 
 * identify : 
 * 2 choices 1 or 2.
 * how many ways.
 * 
 * let person on 3rd stair way to reach on 5th is either take 1,1 or 2.
 * let person on 4th stairs to reach on 5th 1 is only way.
 * 
 * total ways :
 * 
 * 4th -> 5th step by making choice of 1 -> 4+1.
 * 1,1,1,1,_1_
 * 1,1,2,_1_
 * 1,2,1,_1_
 * 2,1,1,_1_
 * 2,2,_1_
 * 
 * 3rd -> 5th step by making choice of 1 or 2 -> 3+1+1 or 3+2.
 * but here 3+1+1 = 4+1 that is repeating in both. so only do 3+2.
 * 
 * 3rd -> 5th step by making choice of 2.
 * 1,1,1,
 * 1,2,_2_
 * 2,1,_2_
 * 
 */
public class ClimbingStaris {

    static int ways_memoiztion(int n, int[] dp) {
        if (n == 1 || n == 2) {
            dp[n] = n;
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int previous = ways_memoiztion(n-1, dp);
        int previous_to_previous = ways_memoiztion(n-2, dp);
        dp[n] = previous + previous_to_previous;

        return dp[n];
    }

    static int ways_tabulation(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        System.out.println(ways_memoiztion(n, new int[n+1]));
        System.out.println(ways_tabulation(n));
    }
}