
/**
 * How to Identify the problems :
 * 
 * - array or string given 
 * - metion in some form subarray or substring
 * - ask for condition like max sum or maxi yield or min sum...
 * - window size given or sometimes not given.
 * 
 * type :
 * - fixed size 
 * - variable size
 * 
 * general pattern :
 * - either window mention you have find condition.
 * - or condition given they as for array.
 * 
 * Problem :
 * you are given you have return maximum sum generated on k size window.
 */
public class MaxSumkSize {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int k = 3; // fixed size

        long max = Integer.MIN_VALUE;
        long sum = 0;
        int i = 0, j = 0;
        while (j < arr.length) {
            if (j - i + 1 < k) {
                while (j - i + 1 <= k) {
                    sum += arr[j];
                    j++;
                }
                System.out.println(sum);
            } else {
                sum += arr[j];
                
                sum -= arr[i];
                System.out.println(sum);
                i++;
                j++;
            }
            max = Math.max(max, sum);
        }

        System.out.println("-----");
        System.out.println(max);
        System.out.println("-----");
    }
}
