import java.util.*;
/**
 * JosephusProblem1
 */
public class JosephusProblem2 {
 
    static ArrayList<Integer> solve(Queue<Integer> nums, int n, int k) {// O(n^2)
        ArrayList<Integer> order = new ArrayList<>();
        
        while (!nums.isEmpty()) {
            for (int i = 0; i < k % nums.size() ; i++) {
                nums.add(nums.poll());
            }
            order.add(nums.poll());
        }
 
 
        return order;
    }

    static ArrayList<Integer> bestway(int n, int k) {// O(n log n)
        TreeSet<Integer> children = new TreeSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        // Inserting elements into the TreeSet
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }

        int startPosition = 0;

        while (!children.isEmpty()) {
            // Calculate position to remove
            startPosition = (startPosition + k) % children.size();

            // Convert TreeSet to a list for easy index access
            Integer positionToRemove = new ArrayList<>(children).get(startPosition);

            // Print and remove the selected position
            ans.add(positionToRemove);
            children.remove(positionToRemove);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> numsQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            numsQ.add(i+1);
        }

        Set<Integer> nums = new HashSet<>();
        for (Integer itr : numsQ) {
            nums.add(itr);
        }
 
        ArrayList<Integer> ans = bestway(n, k);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
