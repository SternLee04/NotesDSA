
// Optimal way GCD of 2 numbers.
import java.util.*;

class EuclideanAlgo {
    // extended Euclidean Algorithm
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    // Driver code
    public static void main(String[] args)
    {
        int a = 10, b = 15, g;
      
          // Function call
        g = gcd(a, b);
        System.out.println("GCD(" + a + " , " + b
                           + ") = " + g);

        a = 35;
        b = 10;
        g = gcd(a, b);
        System.out.println("GCD(" + a + " , " + b
                           + ") = " + g);

        a = 31;
        b = 2;
        g = gcd(a, b);
        System.out.println("GCD(" + a + " , " + b
                           + ") = " + g);
    }
}
// Time Complexity: O(Log min(a, b))
// Auxiliary Space: O(Log (min(a,b))
