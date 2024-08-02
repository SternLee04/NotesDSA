import java.util.*;
/**
 * BinarySearch
 */
public class Step1 {

    static boolean binarySearch(int[] nums, int n, int target) {
        int left = -1;
        int right = n;

        while (left+1 < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) left = mid;
            else right = mid;
        }
        return false;
    }

    static int closestLeft(int[] nums, int n, int target) {// also works when number not exist in range.
        int left = -1;// will point to a[l] <= x
        int right = n;// will point to a[r] > x
        while (left+1 < right) {
            int mid = left+(right - left)/2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left+1;
    }

    static int closestRight(int[] nums, int n, int target) {
        int left = -1;// a[l] < x
        int right = n;// a[r] >= x
        while (left+1 < right) {
            int mid = left+(right - left)/2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right+1;
    }

    static int fastSearch(int nums[], int fromQuery, int toQuery) {
        int cLeft = closestRight(nums, nums.length, fromQuery);
        int cRight = closestLeft(nums, nums.length, toQuery);
        return cRight-cLeft+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int q = sc.nextInt();
        System.out.println(binarySearch(nums, n, q) ? "yes" : "no");
    }
}