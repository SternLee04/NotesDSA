import java.util.*;
/**
 * SuperKeyword
 */
public class SuperKeyword {
    public static void main(String[] args) {
        Humans p1 = new Humans();
        System.out.println(p1.color);
    }
}
class Animal {
    String color = "red";
    Animal() {
        System.out.println("constructor of animal");
    }
    public String getColor() {
        return color;
    }
}
class Humans extends Animal{
    Humans(){
        color = "brown";
        System.out.println("constructor of humans");
    }
}