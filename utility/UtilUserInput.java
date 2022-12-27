package bbm.utility;

import bbm.model.interfaces.IEncryption;
import bbm.model.encryption.Encryption;
import bbm.enumUserDetails;

import java.util.*;

public class UtilUserInput {
    static Scanner sc = new Scanner(System.in);
    private static String firstName,lastName, userName, password,emailId;
    private static long phoneNo;
    private UtilUserInput(){}

    private static String getUserNameDetails() {
        System.out.println("Enter User Name \t:");
        userName = sc.next();
        return  userName;
    }
    private static String getPasswordDetails(){
        IEncryption encryption = new Encryption();
        System.out.println("Enter Password \t:");
        password = sc.next();
        password = encryption.encryptPassword(password);
        return password;
    }
    private static String getFirstNameDetails(){
        System.out.println("Enter First Name \t:");
        firstName = sc.next();
        return firstName;
    }
    private static String getLastNameDetails(){
        System.out.println("Enter Last Name \t:");
        lastName = sc.next();
        return lastName;
    }
    private static String getEmailIdDetails(){
        System.out.println("Enter Email \t:");
        emailId = sc.next();
        return emailId;
    }
    private static long getPhoneNoDetails(){
        System.out.println("Enter Phone number \t:");
        phoneNo = sc.nextLong();
        return phoneNo;
    }
    public static List<String> getSignInDetails() {
        getUserNameDetails();
        getPasswordDetails();
        List<String> details = new ArrayList<>();
        details.add(userName);
        details.add(password);
        return details;
    }
    public static HashMap<enumUserDetails,Object> getSignUpDetails() {
        HashMap<enumUserDetails,Object> details=new HashMap<>();
        getFirstNameDetails();
        getLastNameDetails();
        getSignInDetails();
        getEmailIdDetails();
        getPhoneNoDetails();
        details.put(enumUserDetails.FIRST_NAME,firstName);
        details.put(enumUserDetails.LAST_NAME,lastName);
        details.put(enumUserDetails.USER_NAME,userName);
        details.put(enumUserDetails.PASSWORD,password);
        details.put(enumUserDetails.EMAIL_ID,emailId);
        details.put(enumUserDetails.PHONE_NO,phoneNo);
        return details;
    }
}