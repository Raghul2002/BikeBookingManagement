package bbm;

import bbm.model.IEncryption;
import bbm.model.account.User;
import bbm.model.encryption.Encryption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registrar {
    Scanner sc = new Scanner(System.in);
    private String firstName,lastName, userName, password,emailId;
    private static long phoneNo;

    private String getUserNameDetails() {
        System.out.println("Enter User Name \t:");
        userName = sc.next();
        return  userName;
    }
    private String getPasswordDetails(){
        IEncryption encryption = new Encryption();
        System.out.println("Enter Password \t:");
        password = sc.next();
        password = encryption.encryptPassword(password);
        return password;
    }
    private String getFirstNameDetails(){
        System.out.println("Enter First Name \t:");
        firstName = sc.next();
        return firstName;
    }
    private String getLastNameDetails(){
        System.out.println("Enter Last Name \t:");
        lastName = sc.next();
        return lastName;
    }
    private String getEmailIdDetails(){
        System.out.println("Enter Email \t:");
        emailId = sc.next();
        return emailId;
    }
    private long getPhoneNoDetails(){
        System.out.println("Enter Phone number \t:");
        phoneNo = sc.nextLong();
        return phoneNo;
    }
    public List<String> getSignInDetails() {
        getUserNameDetails();
        getPasswordDetails();
        List<String > details = new ArrayList<>();
        details.add(userName);
        details.add(password);
        return details;
    }
    public String getSignUpDetails() {
        getFirstNameDetails();
        getLastNameDetails();
        getSignInDetails();
        getEmailIdDetails();
        getPhoneNoDetails();
        return firstName+"$"+lastName+"$"+userName+"$"+password+"$"+emailId+"$"+phoneNo;
    }
}