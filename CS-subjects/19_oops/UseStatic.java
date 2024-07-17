import java.util.*;
/**
 * UseStatic
 */
public class UseStatic {
    private static void hello() { // inside memory once and use in UseStatic class not in Student class.
        System.out.println("hello world");
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.school_name = "dumber";
        System.out.println(s1.school_name);
        Student s2 = new Student();
        System.out.println(s2.school_name);// here no need to initalize saprately as already set by s1.
        Student s3 = new Student();
        s3.school_name = "bits"; // s3 change for all.
        System.out.println(s1.school_name);
        System.out.println(s2.school_name);
        System.out.println(s3.school_name);
        hello();
        hello();
        s1.hello();
        s3.hello();
    }
}
class Student {
    String name; 
    int roll;
    static String school_name;
    static void hello() {
        System.out.println("hi world");
    }
}