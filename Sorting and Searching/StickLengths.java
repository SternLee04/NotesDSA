import java.util.*;
/**
 * StickLengths
 */
public class StickLengths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        long median = arr[n/2]; // we decreasing from n side increasing on 0 side
        long operation = 0;

        for (int i = 0; i < n; i++) {
            operation += Math.abs(median - arr[i]);// doesn't matter increasing or dercreating.
        }
        System.out.println(operation);
    }
}