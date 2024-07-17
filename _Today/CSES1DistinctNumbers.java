import java.util.*;

/**
 * CSES_1_DistinctNumbers
 */
public class CSES1DistinctNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            set.add(x);
        }
        System.out.println(set.size());
    }
}