import java.util.*;
/**
 * dp is nothing but a simple way to remember work that already done.
 * and not doing again rather using memory to achive better time complexity.
 */
public class Introduction {

    static int fibonacci_recursion(int n) {// O(2^n)
        if (n == 1 || n == 0) 
            return n;
        
        return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
    }

    static int fibonacci_dynamic_programming(int n, int[] dp) {// O(n+1)
        if (n == 1 || n == 0) {
            return n;
        }

        if (dp[n] != 0) {// i already worked for n number then i have to return through memory.
            return dp[n];
        }

        // i haven't worked for n number i have to work and store in memory.
        dp[n] = fibonacci_dynamic_programming(n - 1, dp) + fibonacci_dynamic_programming(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(fibonacci_recursion(n));

        int[] dp = new int[n+1];// we store workdone result from 0 to n.
        System.out.println(fibonacci_dynamic_programming(n, dp));
    }
}
