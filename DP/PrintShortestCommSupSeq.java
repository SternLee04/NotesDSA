import java.util.*;
/**
 * PrintShortestCommSupSeq
 * print shortest common super sequence.
 * 
 * shortest common super sequence => a.length() + b.length() - lcs.length()
 * now this time we have print 
 * similar code video solution in printLCS.java
 */
public class PrintShortestCommSupSeq {

    static String printSCSS(String a, String b, int[][] dp) {

        int i = a.length(), j = b.length();
        String SCSS = "";

        while (i > 0 && j > 0) {
            if (a.charAt(i-1) == b.charAt(j-1)) {
                SCSS = a.charAt(i-1) + SCSS;
                i--;
                j--;  
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    SCSS = a.charAt(i-1) + SCSS;
                    i--;
                } else {
                    SCSS = b.charAt(j-1) + SCSS;
                    j--;
                }
            }
        }
        // if a = "xyz" and b = "" then common is xyz + empty
        while (i > 0) {
            SCSS = a.charAt(i-1) + SCSS;
            i--;
        } 
        while (j > 0) {
            SCSS = b.charAt(j-1) + SCSS;
            j--;
        }

        return SCSS;
    }

    static int[][] dp(String a, String b, int m, int n) {

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m+1; i++) {
            dp[0][i] = 0;
        }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String a = "acbcf";
        String b = "abcdaf";// output : acbcdaf
        int n = a.length();
        int m = b.length();

        int[][] dp = dp(a,b,m,n);
        System.out.println("Shortest Common Supersequence: " + printSCSS(a, b, dp));
    }
}