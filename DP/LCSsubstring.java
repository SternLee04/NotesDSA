import java.util.*;
/*
 * longest common substring where two strings are given.
 * return the size of substring.
 * 
 * tabluation is simpler that memo 
 * 
 * if the subs set window get break then assign 0 else 
 */
public class LCSsubstring {
    static int tabulation(String x , String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n+ 1][m + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String x = "abcde";
        String y = "abfce";
        System.out.println(tabulation(x, y));

        int m = x.length();
        int n = y.length();

        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int[] maxLength = {0}; // To store the maximum length

        longestCommonSubstring(x, y, m, n, memo, maxLength);
        System.out.println("Length of Longest Common Substring: " + maxLength[0]);
    }
    static int longestCommonSubstring(String x, String y, int m, int n, int[][] memo, int[] maxLength) {
        // Base case: if we've reached the end of either string
        if (m == 0 || n == 0) {
            return 0;
        }

        // Check if we've already computed this subproblem
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        // If characters match, increment length and continue
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            memo[m][n] = 1 + longestCommonSubstring(x, y, m - 1, n - 1, memo, maxLength);
            maxLength[0] = Math.max(maxLength[0], memo[m][n]);
        } else {
            // If characters don't match, reset length to 0
            memo[m][n] = 0;
        }

        // Explore other possibilities
        longestCommonSubstring(x, y, m - 1, n, memo, maxLength);
        longestCommonSubstring(x, y, m, n - 1, memo, maxLength);

        return memo[m][n];
    }
    
}