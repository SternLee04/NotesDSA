import java.util.*;
public class getter_setter{
    public static void main(String[] args) {
        MailAccount prsn1 = new MailAccount();

        // getter methods output
        System.out.println(prsn1.getMail_Id());
        System.out.println(prsn1.getPassword());
        // setter method input
        prsn1.setPassword("F0@k_00f");
        System.out.println(prsn1.getPassword());
    }
}
class MailAccount {
    String mail_id = "jayvadalia02@gmail.com";
    private String password = "J5000#v";

    String getMail_Id()
    {
        return this.mail_id;
    }
    String getPassword()
    {
        return this.password;
    }
    void setPassword(String password) {
        this.password = password;
    }
}