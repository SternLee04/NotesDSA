import java.util.*;
/**
 * CSES5
 */
public class CSES5 {

    /**
     * P
     */
    public class P implements Comparable<P> {
    
        int start;
        int end;

        public P(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(P o) {
            return (int) (this.end - o.end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        for (int[] is : a) {
            System.out.println(is[0] + " " + is[1]);
        }

        int max = 0;
        PriorityQueue<P> queue = new PriorityQueue<>();
    }
}