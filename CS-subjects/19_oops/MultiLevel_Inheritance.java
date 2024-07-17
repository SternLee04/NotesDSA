import java.util.*;

public class MultiLevel_Inheritance {
    public static void main(String[] args) {
        Tiger paper_Tiger = new Tiger();
        
        paper_Tiger.eat();// property of dinosaurs.
        System.out.println(paper_Tiger.getLegs());// property of Cat.
        paper_Tiger.wild();// property of tiger
    }
}
class Dinosaurs {
    private String species;
    
    void eat() {
        System.out.println("Yes they eats");
    }
    void breath() {
        System.out.println("Yes they breath oxygen");
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
}
class Cat extends Dinosaurs {
    private int legs = 4;

    public int getLegs() {
        return legs;
    }
}
class Tiger extends Cat {
    void wild() {
        System.out.println("Highly wild");
    }
}