import java.util.*;
public class Hybrid_Inheritance {
    public static void main(String[] args) {
    Humans h1 = new Humans();
    h1.blood();
    h1.eat();
    h1.thinking();        
    }
}
class Animals {
    private String species;
    void eat() {
        System.out.println("yes they eat.");
    }
    void breath() {
        System.out.println("Yes they breath.");
    }
}
class Fishs extends Animals {
    void swiming() {
        System.out.println("Yes they swim");
    }
}
class Birds extends Animals{
    void fly() {
        System.out.println("Yes they fly");
    }
} 
class Mamals extends Animals{
    void blood() {
        System.out.println("Warm blooded.");
    }
}
class Shark extends Fishs {
    void gill_slits() {
        System.out.println("yes they have multiple gill slits.");
    }
}
class Dog extends Mamals {
    void loyal() {
        System.out.println("yes they are loyal.");
    }
}
class Humans extends Mamals {
    void thinking() {
        System.out.println("yes they have vary complex thinging.");
    }
}