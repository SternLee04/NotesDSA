import java.util.*;
/**
 * MinInsertionDeletionAtoB
 * 
 * by doing minimum operations of insertion and deletion
 * you have to make string a to b.
 * 
 * so key idea is by untoched common elements we can do that
 * this common thing is present in both means LCS.
 * 
 * for maximum no brainer thing
 * by removing all elements and then pushing all elements.
 * in O( a.length() b.length() ) time complexity.
 */
public class MinInsertionDeletionAtoB {

    static int lcs (String a, String b, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        if (a.charAt(n-1) == b.charAt(m-1)) {
            dp[n][m] = lcs(a, b, n-1, m-1, dp) + 1;
        } else {
            int s1 = lcs(a, b, n-1, m, dp);
            int s2 = lcs(a, b, n, m-1, dp);
            dp[n][m] = Math.max(s1, s2);
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String a = "heap"; // h ea p --> h & p is deleted.
        String b = "pea"; // p ea --> p is added.

        int intertion, deletion;
        int lcs = lcs(a,b, a.length(), b.length(), new int[a.length()+1][b.length()+1]);

        intertion = b.length() - lcs;
        deletion = a.length() - lcs;
        int minimum = intertion + deletion;

        System.out.println("insertion : " + intertion);
        System.out.println("Deletion : " + deletion);
        System.out.println("Minimum total operation : " + minimum);

    }
}