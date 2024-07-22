import java.util.*;
/**
 * MissingCoinSum
 */
public class MissingCoinSum {

      // Function to find the maximum sum which we cannot
    // construct using given coins
    static long solve(long[] arr, int N) {
        // Variable to store the maximum value of the next coin
        long X = 1;
 
        // Sort the coins in ascending order of their values
        Arrays.sort(arr);
 
        for (int i = 0; i < N; i++) {
            // If the current coin's value is greater than X,
            // then X is the answer
            if (arr[i] > X) {
                return X;
            }
            // If current coin's value is less than or equal to
            // X, then we can update X as X + arr[i]
            X += arr[i];
        }
        return X;
    }
 
    public static void main(String[] args) {
        // Sample Input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
 
        System.out.println(solve(arr, N));
    }
}