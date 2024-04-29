import java.util.*;

/**
 * SlidingWindowMax hard
 * 
 * ans in form of array that contains max value for perticular window.
 * 
 * 1,3,-1,-3,5,3,6,7 k = 3
 * ans = 3,3,5,5,6,7
 */
public class SlidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {// O(n)
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) q.pollFirst();
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
            q.offer(i);
            if (i >= k - 1) ans[j++] = nums[q.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {// O(n * k)
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        ArrayList<Integer> maxWindow = new ArrayList<>();
        for (int i = 0; i + k <= arr.length; i++) {
            int value = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                value = Math.max(value, arr[j]);
            }
            maxWindow.add(value);
        }

        for (Integer itr : maxWindow) {
            System.out.print(itr + " ");
        }
        System.out.println();
        for (Integer itr : maxSlidingWindow(arr,k)) {
            System.out.print(itr +  " ");
        }
    }
}