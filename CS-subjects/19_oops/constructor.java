import java.util.*;
public class constructor {
    public static void main(String[] args) {
        pen p1 = new pen();
        student s1 = new student(20);
        
        System.out.println(s1.getRoll_no() + " this data is allocted and intalized for s1");
    }
}
class pen {
    pen()
    {
        System.out.println("that the call of me");
    }
}
class student {
    protected int roll_no;
    student(int roll_no)
    {
        this.roll_no = roll_no;
    }
    int getRoll_no()
    {
        return this.roll_no;
    }
}