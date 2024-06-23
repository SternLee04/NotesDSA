import java.util.*;

/**
 * NegativeNumberkSize
 * Problem for given k size window find first negative number occurer in window
 */
public class NegativeNumberkSize {

    public static void main(String[] args) {
        int[] arr = { 23, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        int n = arr.length;

        Queue<Integer> qu = new LinkedList<>();
        int j = 0, i = 0;
        
        while (j < n) {
            if (j - i + 1 < k) {
                if (arr[j] < 0) {
                    qu.add(arr[j]);
                }
                j++;
            } else if (j - i + 1 == k) {
                if (qu.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(qu.peek());
                    if (arr[i] == qu.peek()) {
                        qu.remove();
                    }
                    if (arr[j] < 0) {
                        qu.add(arr[j]);
                    }
                }
                i++;
                j++;
            }
        }
    }
}