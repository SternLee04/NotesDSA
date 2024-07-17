import java.util.*;

public class Abstraction {
    public static void main(String[] args) {
        Horse h1 = new Horse();
        Chicken c1 = new Chicken();
        // Animals xyz = new Animals();
        h1.eat();
        h1.migrate();
        System.out.println(h1.color);
        c1.eat();
        c1.migrate();
    }
}
abstract class Animals {
    String color;

    Animals() { // constructor
        color = "red";
        System.out.println("animal constructor is called.");
    }
    void eat() { // non abstract method
        System.out.println("Yes they eat.");
    }
    abstract  void migrate();// abstract method
}
class Horse extends Animals {
    Horse() {
        System.out.println("horse constorctor is called.");
    }
    void setColor(){
        color = "dark brown";
    }
    void migrate() {
        System.out.println("By walking on 4 legs.");
    }
}
class Chicken extends Animals {
    void migrate() {
        System.out.println("By walking on 2 legs.");
    }
}