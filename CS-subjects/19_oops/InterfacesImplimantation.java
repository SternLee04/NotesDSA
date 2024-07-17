import java.util.*;

public class InterfacesImplimantation {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
        Dog fluffy = new Dog();
        fluffy.eat();
    }
}
// moves() is abstrated 100% as this behaviour defines differently by Queen & Rook.
// nobody knows what is move its just an idea where the meaning is vary from classes to classes.
interface ChessCharactor {
    void moves();
}
class Queen implements ChessCharactor {
    public void moves() {
        System.out.println("Left, Right, Up, Down, Right Diagonal, Left Diagonal");
    }
}
class Rook implements ChessCharactor {
    public void moves(){
        System.out.println("Left, Right, Up, Down,");
    }
}
// 5th inheritacne : multiple inheritance
interface Herbivore {
    void eat();
}
interface Carnivore {
    void eat();
}
class Dog implements Herbivore, Carnivore {
    public void eat() {
        System.out.println("Yes the eat both meat and herbs.");
    }
}
