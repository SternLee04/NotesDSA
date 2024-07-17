import java.util.*;

/**
 * CSES3
 */
public class CSES3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxWeight = sc.nextInt();
        int[] values = new int[n];

        for (int i = 0; i < values.length; i++) {
            values [i] = sc.nextInt();
        }
        Arrays.sort(values);
        
        int i = 0;
        int j = n-1;
        int count = 0;
        while (i <= j) {
            if (values[j] + values[i] <= maxWeight) {
                count++;
                i++;
                j--;
            } else if (values[j] + values[i] > maxWeight) {
                count++;
                j--;
            }
        }
        System.out.println(count);
    }
}