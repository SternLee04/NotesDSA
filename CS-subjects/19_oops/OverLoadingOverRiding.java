// Class to demonstrate Method Overloading based on Number of Parameters, Type of Parameters, and Using Annotations
class Calculator {

    // Overloading by Number of Parameters (2 parameters)
    int add(int a, int b) {
        return a + b;
    }

    // Overloading by Number of Parameters (3 parameters)
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloading by Type of Parameters (int and float)
    float add(int a, float b) {
        return a + b;
    }

    // Overloading by Type of Parameters (float and int)
    float add(float a, int b) {
        return a + b;
    }

    // Method Overriding and Overloading with the @Override annotation
    // Superclass Method (Overridden in subclass)
    void showResult() {
        System.out.println("Result from Calculator class.");
    }
}

// Derived class (Subclass) that overrides the showResult() method
class AdvancedCalculator extends Calculator {

    // Overriding the showResult() method using @Override annotation
    @Override
    void showResult() {
        System.out.println("Result from Advanced Calculator class.");
    }

    // Additional method that uses method overloading with different number of parameters
    void showResult(int result) {
        System.out.println("Advanced Calculator result: " + result);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create objects of Calculator and AdvancedCalculator
        Calculator calc = new Calculator();
        AdvancedCalculator advCalc = new AdvancedCalculator();

        // Demonstrating Overloading by Number of Parameters
        System.out.println("Sum of 2 numbers: " + calc.add(5, 10)); // Calls add(int, int)
        System.out.println("Sum of 3 numbers: " + calc.add(5, 10, 15)); // Calls add(int, int, int)

        // Demonstrating Overloading by Type of Parameters
        System.out.println("Sum of int and float: " + calc.add(5, 10.5f)); // Calls add(int, float)
        System.out.println("Sum of float and int: " + calc.add(10.5f, 5)); // Calls add(float, int)

        // Demonstrating Method Overriding with the @Override annotation
        calc.showResult(); // Calls showResult() in Calculator class
        advCalc.showResult(); // Calls overridden showResult() in AdvancedCalculator class

        // Using method overloading in AdvancedCalculator
        advCalc.showResult(100); // Calls overloaded showResult(int) in AdvancedCalculator class
    }
}
