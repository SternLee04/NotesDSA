import java.util.*;

public class Inheritance {
    public static void main(String[] args) {
        Humans p1 = new Humans();
        System.out.println(p1.getSpecies());
        p1.eat();
        p1.breath();
        String test = p1.getSpecies();
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
class Humans extends Dinosaurs {
    Humans() {
        setSpecies("Homo Sapien");
    }
}
// Type : single level inreritance