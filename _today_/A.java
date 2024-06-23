import java.util.*;
 
/**
 * bfs
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long[] a = new long[(int)n];
        long cnt = 0;

        for (long i = 0; i < a.length; i++) {
            a[(int)i] = sc.nextInt();
        }

        for (long i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (long j = 1; j < n; j++) {
                if (a[(int)i] >= a[(int)j]) {
                    swapped = true;
                    long temp = a[(int)i];
                    a[(int)i] = a[(int)j];
                    a[(int)j] = temp;
                    cnt++;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        System.out.println(cnt);
    }
}