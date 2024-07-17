import java.util.*;
public class CopyConstructor {
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

        System.out.println();
        System.out.println("after changing the marks in s1 that change(add 40 marks to 2nd element) also reflecting s2, ideally it should not be there. ");
        System.out.println("s2 password is null represent the there no property assosiated.");
        System.out.println("the change is not reflects in roll number as it is also change to 22 after the s2 declaration.");
        System.out.println();
    }
}
class Student {
    String name;
    int roll;
    private String password;
    int marks[];
    
    // copy consturctor
    Student(Student s) {
        marks = new int[3];
        this.name = s.name;
        this.roll = s.roll; // s.roll is not the reference it is copy.
        this.marks = s.marks; // s.marks is reference not copy. 
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
// in java the any data sturcture and objects and class is pass as refrence not copy.
// the primitive data type variable(int, char, float, boolean) is pass as copy. 