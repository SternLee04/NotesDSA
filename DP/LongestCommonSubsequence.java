

/**
 * LongestCommonSubsequence : most variation pattern in dp.
 * 
 * Problem what will be the length of the common sequence string is left
 * when we remove the uncommon characters from both.
 * 
 * Solution : 
 *  if characters are same then do then increse count and find for n-1 and m-1(mean other characters)
 * 
 *  else check character in first string by doing n-1 
 *  and also check character in second string by doing m-1
 * 
 *  one of two finds then ok 
 *  what if both calback return same value then by default we consider first string character as contribution.(convection)
 *  else max from both.
 * 
 * dp[3][4] show the ans when length first string 3 and second string 4.
 */
public class LongestCommonSubsequence {

    static String LCS_Recursive(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return "";
        }

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return LCS_Recursive(x, y, n - 1, m - 1) + x.charAt(n - 1);
        } else {
            String s1 = LCS_Recursive(x, y, n - 1, m);
            String s2 = LCS_Recursive(x, y, n, m - 1);

            return (s2.length() > s1.length()) ? s2 : s1;
        }
    }

    static int LCS_Memo(String x, String y, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != 0)
            return dp[n][m];

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            dp[n][m] = LCS_Memo(x, y, n - 1, m - 1, dp) + 1;
        } else {
            int exclude_in_1 = LCS_Memo(x, y, n - 1, m, dp);
            int exclude_in_2 = LCS_Memo(x, y, n, m - 1, dp);

            dp[n][m] = Math.max(exclude_in_1, exclude_in_2);
        }

        return dp[n][m];
    }

    static int LCS_Tabulation(String x, String y) {
        int m = x.length();
        int n = y.length();

        // Create a 2D DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right cell contains the length of the LCS
        return dp[m][n];
    }

    public static void main(String[] args) {
        String x = "ajy";
        String y = "jaay";

        int n = x.length();
        int m = y.length();
        int[][] dp = new int[n + 1][m + 1];

        System.out.println(LCS_Recursive(x, y, n, m));
        System.out.println(LCS_Recursive(x, y, n, m).length());
        System.out.println(LCS_Memo(x,y,n,m,dp));
        System.out.println(LCS_Tabulation(x, y));
        
    }
}