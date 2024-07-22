import java.util.*;

public class Towers {

    static long solve(long N, ArrayList<Long> cubes) {// O(n^2)
        for (int i = 0; i < N; i++) {
            Long current = cubes.get(i);
            if (current != -1) {
                int j = i;
                while (j < N ) {
                    if (cubes.get(j) != -1 && current > cubes.get(j)) {
                        current = cubes.get(j);
                        cubes.set(j, -1l);
                    }
                    j++;
                }
            }
        }

        int ans = 0;

        for (Long itr : cubes) {
            if (itr != -1) 
                ans++;
        }

        return ans;
    }

    static long gfg(long N, ArrayList<Long> cubes) {
        // Variable to store the number of towers
        long ans = 0;

        // Multiset to store the size of top most cubes of all towers
        TreeSet<Long> topElements = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            // Find the smallest cube which is larger than cubes[i]
            Long it = topElements.higher(cubes.get(i));
            // If no cube has size > cubes[i], then we need another tower for this block
            if (it == null) {
                ans++;
                topElements.add(cubes.get(i));
            }
            // If there is a cube which has size > cubes[i], place cubes[i] on top of it.
            else {
                topElements.remove(it);
                topElements.add(cubes.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        ArrayList<Long> cubes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cubes.add(sc.nextLong());
        }

        System.out.println(gfg(N, cubes));
    }
}