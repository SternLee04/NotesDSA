import java.util.*;

/**
 * gfg_code
 */

public class gfg_code {

    boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    ArrayList<Integer> getprime(int firstprime) {
        ArrayList<Integer> list = new ArrayList<>();
        int x = 2;
        while (x < firstprime) {
            if (isPrime(x)) {
                list.add(x);
            }
            x++;
        }
        return list;
    }

    int gfg_fun(int n, int m) {
        if (n <= 1)
            return -1;
        ArrayList<Integer> list = getprime(m);
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size()-1));
            list.set(list.size()-1, temp);
        }
        int sum = 0;
        int cnt = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            if (sum + list.get(i) < n) {
                sum += list.get(i);
                cnt++;
            } else {
                return sum;
            }
        }
    }

    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        gfg_code s = new gfg_code();

        n = sc.nextInt();
        m = sc.nextInt();

        System.out.println(s.gfg_fun(n, m));
    }
}
n = 13
m = 2;

2 2 2 2 2 3
3 3 3 2 2