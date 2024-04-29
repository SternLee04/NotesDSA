import java.util.*;
/**
 * SlidingWindowMax
 * 
 * ans in form of array that contains max value for perticular window.
 * 
 * 1,3,-1,-3,5,3,6,7 k = 3
 * ans = 3,3,5,5,6,7
 */
public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        PriorityQueue<Integer> maxWindow = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i + k < arr.length ; i++) {
            int value = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                value = Math.max(value,arr[j]);
            }
            maxWindow.add(value);
        }

        while (!maxWindow.isEmpty()) {
            System.out.print(maxWindow.remove() + " ");
        }
    }
}