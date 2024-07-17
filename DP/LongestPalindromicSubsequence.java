import java.util.*;
/**
 * LongestPalindromicSusequence
 * 
 * Problem :
 * you given a string that is non palindrom or may be its self palindrom.
 * you have make the palindrom string that is largest form the string.
 * 
 * also way to ask question may differ make string by doing minimum operation on string to make palindrom.
 * 
 * but issue is in identifying the pattern of LCS. and ya this is itself pattern.
 * and pattern of LCS.
 * 
 * in LCS : 
 * 2 string some common elements and ouput is int.
 * but here is 1 stirng and ask for int.
 * 
 * key idea :
 * palindrom string is common elements from front and back 
 * abbcbba idx 0 & n-1, 1 & n-2 is common like that.
 * otherwise reversing string is resulting same as it was.
 */
public class LongestPalindromicSubsequence {

    static int lcs (String s, String rev) {
        int m = s.length();
        int n = rev.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == rev.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "agbcba"; // what if g is removed then?
        String reverse = "abcbga"; // if you apply LCS on s and reverse then 'g' will eleminate !

        int lcs = lcs(s, reverse); // by the way lcs is palindrom and that is also LPS (lognest common subsequence)

        if (lcs == "abcba".length()) {
            System.out.println("yes");
            System.out.println("minimum deletion : " + (s.length()-lcs));
        }
    }
}