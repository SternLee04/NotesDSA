import java.util.*;
/**
 * JosephusProblem1
 */
public class JosephusProblem2 {
 
    static ArrayList<Integer> solve(Queue<Integer> nums, int n, int k) {
        ArrayList<Integer> order = new ArrayList<>();
        
        while (!nums.isEmpty()) {
            for (int i = 0; i < k % nums.size() ; i++) {
                nums.add(nums.poll());
            }
            order.add(nums.poll());
        }
 
 
        return order;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
 
        ArrayList<Integer> ans = solve(nums, n, k);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
