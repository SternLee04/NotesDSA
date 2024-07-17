
import java.util.*;

/**
 * Cses2Apartments
 */
public class Cses2Apartments {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        int[] A = new int[n];
        int[] B = new int[m];       

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n && j < m) {
            if (Math.abs(A[i]-B[j]) <= k ) {
                count++;
                i++;
                j++;
            } else if (A[i] < B[j])  {// room is over large (room > x+k)
                i++;
            } else {// room is not sufficiently (room < x-k)
                j++;
            }
        }

        System.out.println(count);
    }
}