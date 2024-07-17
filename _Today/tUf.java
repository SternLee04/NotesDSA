
import java.util.*;

public class tUf {

    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1; // Base case.

        // Perform the steps:
        int mid = (low + high) / 2;
        if (nums[mid] == target)
            return mid;
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        return binarySearch(nums, low, mid - 1, target);
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 9, 9, 15, 19 };
        int n = 6, x = 5;
        int search = search(arr, x);
        int upp = upperBound(arr, x, n);
        int loww = lowerBound(arr, n, x);
        System.out.println("Binary Search index: " + search);
        System.out.println("Lower Bound index: " + loww);
        System.out.println("Upper Bound index: " + upp);
    }
}
// 3, 5, 8, 9, 15, 19
// 0, 1, 2, 3, 4, 5