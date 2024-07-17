import java.util.*;
// package program for abc bank;
public class AccessModifiers{
    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount();

        myAcc.username = "jay";// access of public
        System.out.println(myAcc.password + " before accessing the password");
        myAcc.setpassword("w13e4");
        System.out.println(myAcc.password + " after the accessing the password");
    }
    static class  BankAccount {
        public String username;// all can access abc & xyz packages.
        private String  password = "12344";// we can access this in BankAccout class only not in main even.
        protected String ifc_code; // access by bank class of BankAddminstration program of  xyz Bank package.
         void setpassword(String pwd)// default method it can be use with in package. 
        {
            password = pwd;
        }
    }
}