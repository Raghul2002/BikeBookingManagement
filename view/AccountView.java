package bbm.view;

import bbm.controller.InstanceGetter;
import bbm.model.encryption.Encryption;
import bbm.model.IEncryption;
import bbm.model.account.AccountModel;

import java.util.Scanner;

public class AccountView {
    Scanner sc = InstanceGetter.receiveInstance().getScannerInstance();
    private String firstName,lastName, userName, password,emailId;
    private static long phoneNo;

    public String getUserNameDetails() {
        System.out.println("Enter User Name \t:");
        userName = sc.next();
        return  userName;
    }
    public String getPasswordDetails(){
        IEncryption encryption = new Encryption();
        System.out.println("Enter Password \t:");
        password = sc.next();
        password = encryption.encryptPassword(password);
        return password;
    }
    public String getFirstNameDetails(){
        System.out.println("Enter First Name \t:");
        firstName = sc.next();
        return firstName;
    }
    public String getLastNameDetails(){
        System.out.println("Enter Last Name \t:");
        lastName = sc.next();
        return lastName;
    }
    public String getEmailIdDetails(){
        System.out.println("Enter Email \t:");
        emailId = sc.next();
        return emailId;
    }
    public long getPhoneNoDetails(){
        System.out.println("Enter Phone number \t:");
        phoneNo = sc.nextLong();
        return phoneNo;
    }
    public AccountModel getSignInDetails() {
        getUserNameDetails();
        getPasswordDetails();
        return AccountModel.builder().setUserName(userName).setPassword(password).build();
    }
    public AccountModel getSignUpDetails() {
        getFirstNameDetails();
        getLastNameDetails();
        getSignInDetails();
        getEmailIdDetails();
        getPhoneNoDetails();
        return AccountModel.builder()
                .setUserName(firstName)
                .setLastName(lastName)
                .setUserName(userName)
                .setPassword(password)
                .setEmailId(emailId)
                .setPhoneNo(phoneNo)
                .build();
    }
}