import java.util.*;
/**
 * SumOfTwoValues
 */
public class SumOfTwoValues {

    static int[] solve (int[] nums, int n, int sum) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++) {
          int val = sum - nums[i];
          if(hm.containsKey(nums[i])) {
            ans[0] = hm.get(nums[i]) + 1;
            ans[1] = i +1;
            return ans;
          }
          hm.put(val,i);
        }
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] ans = solve(arr, n, sum);
        if (ans[0] == -1 && ans[1] == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}