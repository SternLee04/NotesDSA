import java.util.*;

public class CollectingNumbers {

    static int solve(int[] nums, int n) {
        // Create a map to store the original indices of elements
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(nums[i], i);
        }

        // Sort the array
        Arrays.sort(nums);

        int count = 1; // At least one round is required
        for (int i = 1; i < n; i++) {
            // If the current number's original index is less than the previous number's original index
            // it means a new round is required
            if (indexMap.get(nums[i]) < indexMap.get(nums[i - 1])) {
                count++;
            }
        }

        return count;
    }
    static long solve(long[] arr, int N)
    {
        // Variable to store the final answer
        long ans = 1;

        // Array to store the index of numbers from 1 to N
        long[] indices = new long[N + 1];

        // Store the index of all elements of arr[]
        for (int i = 0; i < N; i++) {
            indices[(int)arr[i]] = i;
        }

        // If num occurs after (num + 1), increment ans by 1
        for (int num = 1; num < N; num++) {
            if (indices[num + 1] < indices[num])
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long ans = solve(arr, n);
        System.out.println(ans);
    }
}
