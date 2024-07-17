import java.util.*;
/**
 * PrintLCS
 * 
 * Problem :
 * in this they ask for to print that logest common subsequence not the length.
 * 
 * i think storing string as dp is not efficient 
 * 
 * alternative solution : as per video.
 * 
 * find lcs
 * and put loop on dp table from n,m --> 0,0
 * if n == m (character) then add to empty string.
 * else 
 * if n,m-1 > n-1,m 
 *  j--
 * else i-- // this nothing reversed logic applied in order find answer what we want as applied on LCS. 
 */
public class PrintLCS {

    static String asPerVideo (String x, String y) {
        int n = x.length();
        int m = y.length();

        // LCS code
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // generating solution base on dp table.
        String solution = "";
        int i = n, j = m;
        while (j > 0 && i > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                solution = x.charAt(i-1) + solution;
                i--;
                j--;  
            } else {
                if (dp[i][j-1] > dp[i-1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        return solution;
    }

    static String memo (String x, String y, int n, int m, String[][] dp) {

        if (n == 0 || m == 0) {
            return "";
        }

        if (dp[n][m] != "") {
            return dp[n][m];
        }

        if (x.charAt(n-1) == y.charAt(m-1)) {
            dp[n][m] = memo(x, y, n-1, m-1, dp) + x.charAt(n-1);
        } else {
            String s1 = memo(x, y, n-1, m, dp);
            String s2 = memo(x, y, n, m-1, dp);

            if (s1.length() > s2.length()) {
                dp[n][m] = s1;     
            } else {
                dp[n][m] = s2;
            }
        }

        return dp[n][m];
    }
    
    static void tabulation (String x, String y) {

        int n = x.length();
        int m = y.length();

        String[][] dp = new String[n+1][m+1];

        // initialize
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = "";
            }
        }
        
        for (int i = 1; i < n +1; i++) {
            for (int j = 1; j < m +1; j++) { 
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + x.charAt(i-1);
                } else {
                    String s1 = dp[i-1][j];
                    String s2 = dp[i][j-1];

                    if (s1.length() > s2.length()) {
                        dp[i][j] = s1;
                    } else {
                        dp[i][j] = s2;
                    }
                }
            }
        }

        System.out.println(dp[n][m]);
    }
    public static void main(String[] args) {

        String x = "acbcf";
        String y = "abcdaf";

        tabulation(x,y);

        // initialize
        String[][] dp = new String[x.length()+1][y.length()+1];
        for (int i = 0; i < x.length()+1; i++) {
            for (int j = 0; j < y.length()+1; j++) {
                dp[i][j] = "";
            }
        }
    
        String ans = memo(x, y, x.length(), y.length(), dp);
        System.out.println(ans);
        System.out.println(asPerVideo(x,y));
    }
}