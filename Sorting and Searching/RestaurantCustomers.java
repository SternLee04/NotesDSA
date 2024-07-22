import java.util.*;
/**
 * RestaurantCustomers
 * 
 * You are given the arrival and leaving times of n customers in a restaurant.
 * What was the maximum number of customers in the restaurant at any time?
 * Input
 * The first input line has an integer n: the number of customers.
 * After this, there are n lines that describe the customers. Each line has two integers a and b: the arrival and leaving times of a customer.
 * You may assume that all arrival and leaving times are distinct.
 * Output
 * Print one integer: the maximum number of customers.
 */
public class RestaurantCustomers {
    static int solve(int[][] customers, int N)
    {
        // Store the arrival and departure time in two
        // different arrays
        int[] arr = new int[N];
        int[] dep = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = customers[i][0];
            dep[i] = customers[i][1];
        }

        // Sort the arrival and departure time in ascending
        // order
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        // Variables to store the number of customers in the
        // shop and the maximum customers so far
        int currentCustomers = 0, maxCustomers = 0;
        while (i < N && j < N) {
            // If the arrival time is less than or equal to
            // the departure time
            if (arr[i] <= dep[j]) {
                currentCustomers++;
                maxCustomers = Math.max(maxCustomers,
                                        currentCustomers);
                i++;
            }
            else {
                j++;
                currentCustomers--;
            }
        }
        return maxCustomers;
    }

    public static void main(String[] args)
    {
        // Sample Input
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] customers = new int[N][2];
        for (int i = 0; i < customers.length; i++) {
            customers[i][0] = scanner.nextInt();
            customers[i][1] = scanner.nextInt();
        }
        // Call the solve method and print the result
        System.out.println(solve(customers, N));
    }
}