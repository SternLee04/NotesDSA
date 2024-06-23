import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * MaxSubArrayWindow
 * 
 * Problem : 
 * In given array you have find maximum number occurences in k size window.
 * 
 * Note : 3 2 1 0 normally we max = max(arr[j], max); but it not work in decreasing monolitic.
 */
public class MaxSubArrayWindow {

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7,3,2,1,0};
        int n = 12;
        int k = 3;

        int i = 0, j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        while (j < n) {
            if (j - i + 1 < k) {
                pq.add(arr[j]);
                j++;
            } else if (j - i + 1 == k) {
                pq.add(arr[j]);
                System.out.println(pq.peek());
                pq.remove(arr[i]);
                i++;
                j++;
            }
        }

    }
}