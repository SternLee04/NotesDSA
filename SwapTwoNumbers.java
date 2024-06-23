import java.util.*;
/**
 * SwapTwoNumbers
 */
public class SwapTwoNumbers {

    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        System.out.println(x + " " + y);
        
        int temp = x;
        x = y;
        y = temp;

        System.out.println(x + " " + y);

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println(x + " " + y);
    }
}