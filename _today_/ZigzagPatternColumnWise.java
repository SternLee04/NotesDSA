public class ZigzagPatternColumnWise {
    public static void printWavePatternColumnWise(int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                num++;
            }
        }
        // Generate and print the pattern column-wise
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < i; j++) {
                    System.out.print(num-- + " ");
                }
            } else {
                int temp = num - i + 1;
                for (int j = 0; j < i; j++) {
                    System.out.print(temp++ + " ");
                }
                num = num - i;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 1; // Change the value of n as needed
        printWavePatternColumnWise(n);
    }
}