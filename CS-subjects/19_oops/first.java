import java.util.*;
public class first {

    public static void main(String[] args) {
        Pen p1 = new Pen();// p1 object is created with one string and int.

        p1.color = "Red";// assigin red properties as it not initalized before.
        p1.tip_size = 5;
        System.out.println(p1.color + " before.");
        System.out.println(p1.tip_size + " is tip size.");
        // properties is set.
        p1.setColor("Blue");
        p1.setTipSize(7);
        System.out.println(p1.color + " after the function call to change the properties");
        System.out.println(p1.tip_size + " the tip size now.");
        // function access demonstration.
    } 
}

class Pen {
    String color;
     int tip_size;
    
    void setColor(String new_color)
    { 
        color = new_color;
    }
    void setTipSize(int new_tip_size)
    {
        tip_size = new_tip_size;
    }
}