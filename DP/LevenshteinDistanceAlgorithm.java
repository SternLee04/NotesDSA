/**
 * LevenshteinDistanceAlgorithm (edit distance)
 * 
 * there are 3 operation to perform in order to convert str1 to str2.
 * insertion, deletion and replace.
 */
public class LevenshteinDistanceAlgorithm {

    class Solution {
        public int minDistance(String x, String y) {
            int n = x.length();
            int m = y.length();

            // dp[i][j] will hold the edit distance between x[0..i-1] and y[0..j-1]
            int[][] dp = new int[n + 1][m + 1];

            // Initialize the dp array
            for (int i = 0; i <= n; i++) {
                dp[i][0] = i; // Deletion of all characters from x to match empty y
            }
            for (int j = 0; j <= m; j++) {
                dp[0][j] = j; // Insertion of all characters from y to match empty x
            }

            // Compute the dp values
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1]; // No operation needed
                    } else {
                        int insert = dp[i][j - 1] + 1;
                        int delete = dp[i - 1][j] + 1;
                        int replace = dp[i - 1][j - 1] + 1;
                        dp[i][j] = Math.min(insert, Math.min(delete, replace));
                    }
                }
            }

            return dp[n][m];
        }
    }
    
}