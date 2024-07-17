import java.util.*;
/**
 * Hierachinal_Inheritance
 */
public class Hierachinal_Inheritance {
    public static void main(String[] args) {
        Fishs gold_fish = new Fishs();
        gold_fish.eat();
        gold_fish.migration();
        Animals elephant = new Animals();
        elephant.breath();
        elephant.migration();
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
class Animals extends Dinosaurs {
    void migration() {
        System.out.println("by walking");
    }
}
class Fishs extends Dinosaurs {
    void migration() {
        System.out.println("by swiming");
    }
}