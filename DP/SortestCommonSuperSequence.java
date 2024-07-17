import java.util.*;
/**
 * SortestCommonSuperSequence
 * 
 * Problem :
 * for the given 2 strings where you have to build the smallest possible string.
 * such that string must intact both strings sequences and that string must be shortest.
 * 
 * like aggtab , gxtxayb --> aggxtxayb
 * 
 * it is not necessary that substring is generated of either it may may not.
 * 
 * key idea is to eliminate the common characters from both stirngs which comes from LCS.
 * 
 * s1.length() + s2.length() - lcs.length()
 */
public class SortestCommonSuperSequence {

    static int lcs (String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxayb";

        int lcs = lcs(s1, s2);

        System.out.println(s1.length() + s2.length() - lcs);
    }
}