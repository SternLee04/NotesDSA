import java.util.*;

import javax.swing.text.html.MinimalHTMLWriter;
public class DeepShallow_copyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        // marks set for s1.
        s1.marks[0] = 100;
        s1.marks[1] = 10;
        s1.marks[2] = 20;
        System.out.println("before the s2 declare in memory");
        for (int i = 0; i < s1.marks.length; i++) {
            if (i<1) {
                System.out.println("name : " + s1.name);
                System.out.println("roll : " + s1.roll);
                System.out.println("password : " + s1.getPassword());
            }
            System.out.println(s1.marks[i]);
        }

        Student s2 = new Student(s1);
        Student s3 = new Student(s1 , "Deep copy");

        s1.marks[1] = s1.marks[1] + 40;// change in marks of s1.
        s1.roll = 22;

        System.out.println("after the s2 declare in memory and with changed marks");
        for (int i = 0; i < s2.marks.length; i++) {
            if (i<1) {
                System.out.println("name : " + s2.name);
                System.out.println("roll : " + s2.roll);
                System.out.println("password : " + s2.getPassword());
            }
            System.out.println(s2.marks[i]);
        }
        System.out.println("after the s3 declare in memory and with changed marks");
        for (int i = 0; i < s3.marks.length; i++) {
            if (i<1) {
                System.out.println("name : " + s3.name);
                System.out.println("roll : " + s3.roll);
                System.out.println("password : " + s3.getPassword());
            }
            System.out.println(s3.marks[i]);
        }
    }
}
class Student {
    String name;
    int roll;
    private String password;
    int marks[];
    
    // shallow copy consturctor
    Student(Student s) {
        marks = new int[3];
        this.name = s.name;
        this.roll = s.roll; 
        this.marks = s.marks;
    }
    // Deep copy consturctor
    Student (Student s, String type)
    {
        marks = new int[3];
        this.name = s.name;
        this.roll = s.roll;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s.marks[i];
        }
    }
    // general consturctor
    Student()
    {
        marks = new int[3];
        this.name = "NULL";
        this.roll = 0;
        this.password = "00000000";
    }
    // getter ans setter for password
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}