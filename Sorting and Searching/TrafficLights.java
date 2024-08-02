import java.util.*;
/**
 * TrafficLights
 */
public class TrafficLights {
    
    void solve(int[] lights, int n , int m) {
        Integer max = null;
        ArrayList<ArrayList<Integer>> maxTrack = new ArrayList<>();
        ArrayList<Integer> street = new ArrayList<>();
        street.add(0);
        street.add(n);
        for (int i = 0; i < m; i++) {
            street.add(lights[i]);
            int greaterIdx = upperbound(street, lights[i]);
            int lowerIdx = greaterIdx-2;
            int newRecord = Math.max(lights[i] - street.get(lowerIdx), street.get(greaterIdx) - lights[i]);
            if (max == null || max < newRecord) {
                for (int j = 0 ; j < street.size()-1; j++) {
                    if (street.get(j+1) - street.get(j) == max) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(street.get(j));
                        list.add(street.get(j+1));
                        maxTrack.add(list);
                    }
                }
            } else {
                for (ArrayList<Integer> pair : maxTrack) {
                    
                }
            }
        }
    }
    public static int upperbound(ArrayList<Integer> arr, int x) {
        int low = 0, high = arr.size() - 1;
        int ans = arr.size();

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] lights = new int[m];
        for (int i = 0; i < lights.length; i++) {
            lights[i] = sc.nextInt();
        }
        solve(lights, n, m)
    }
}