import java.util.*;

public class B {
    static long maxProfit(int n, int a, int b) {
        int left = 0, right = Math.min(n, b);
        long maxProfit = Long.MIN_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long profitMid = calculateProfit(n, a, b, mid);
            long profitMidPlusOne = calculateProfit(n, a, b, mid + 1);

            maxProfit = Math.max(maxProfit, profitMid);

            if (profitMid < profitMidPlusOne) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxProfit;
    }

    static long calculateProfit(int n, int a, int b, int k) {
        // Calculate profit for first k buns sold at decreasing prices
        long profit = (long) k * (b + (b - k + 1)) / 2;

        // Calculate profit for remaining (n - k) buns sold at price a
        profit += (long)(n - k) * a;

        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            // Calculate and print the maximum profit for the current test case
            System.out.println(maxProfit(n, a, b));
        }

        sc.close();
    }
}
