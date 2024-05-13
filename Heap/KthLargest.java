import java.util.*;
/**
 * KthLargest
 * return the kth largest element from array.
 * eg. 1,2,3,5,6 and k = 2
 * ans = 2.
 */
public class KthLargest {

    static int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> largest = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < nums.length; i++) {
          largest.add(nums[i]);
        }
        Integer ans = null;
        for(int i = 0; ! largest.isEmpty() && i < k ; i++) {
          ans = largest.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}