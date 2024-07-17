import java.util.*;

/**
 * PrintLCSsubString
 * this time you have to print the lcs sub string.
 * 
 * change the longestsequence string when the max hits this is only change.
 * 
 * Blunders : 
 * String s ; // this mean s haveing null value on printing this will give null.
 * s += 'c'; // ont printing s value will result nullc.
 * 
 * String s = "": // this mean s has empty value or string literal this will print nothing.
 * s += 'c'; // this will print c.
 */
public class PrintLCSsubString {

    static void tabulation(String x, String y) {
        int n = x.length();
        int m = y.length();

        String[][] dp = new String[n + 1][m + 1];
        int max = 0;
        String longestSequence = "";

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = "";
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + x.charAt(i-1);
                    if (dp[i][j].length() > max) {
                        max = dp[i][j].length();
                        longestSequence = dp[i][j];
                    }
                } else {
                    dp[i][j] = "";
                }
            }
        }

        System.out.println(longestSequence);
    }

    public static void main(String[] args) {
        String x = "abcde";
        String y = "abfce";

        tabulation(x,y);
    }
}