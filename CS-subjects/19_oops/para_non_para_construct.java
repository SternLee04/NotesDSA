import java.util.*;
import java.util.jar.Attributes.Name;
public class para_non_para_construct {
    public static void main(String[] args) {
        Student s1 = new Student();// this resolves as non paramitarize constructure not default so it give error.
        // default consturcture only kick in when there no defination of consturctor in class.

        Car c1 = new Car(); // this is default consturctor.
    }
}
class Student {
    public String name;
    public long ph_no;

    Student() {
         this.name = "null"; 
    }
    Student(String name) {
        this.name = name;
    }
    Student(long ph_no) {
        this.ph_no = ph_no;
    }
}
class Car {
    public String name = "Honda";
}