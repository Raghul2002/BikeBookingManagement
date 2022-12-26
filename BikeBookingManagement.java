package bbm;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.manager.ManagerView;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.User;
import bbm.model.authentication.IUserAuthentication;
import bbm.model.authentication.ManagerAuthenticator;
import bbm.model.authentication.OwnerAuthenticator;
import bbm.model.interfaces.IPortal;
import bbm.owner.OwnerView;
import bbm.utility.UtilUserInput;

import java.util.List;
import java.util.Scanner;


public class BikeBookingManagement {
    static {
        IDatabase db = Database.getInstance();
        db.addUser(new Manager("m","m","m","m","@gmail",3456234234l));
        db.addUser(new Owner("m","m","o","t","@gmail",3456234234l));
    }
    private void mainLoop() {
        try {
            User user;
            UtilUserInput utilUserInput = new UtilUserInput();
            IUserAuthentication authentication;
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Owner\n2.Manager\n3.Sales Executive\n4.Customer\n5.Exit Console");
            System.out.println("Enter number :");
            switch (sc.nextLine()) {
                case "1":
                    List<String> loginCredentials = utilUserInput.getSignInDetails();
                    authentication = new OwnerAuthenticator();
                    user = authentication.authenticate(loginCredentials);
                    if(user !=null) {
                        IPortal ownerView = new OwnerView();
                        ownerView.viewPortal(user);
                    }
                    break;
                case "2":
                    loginCredentials = utilUserInput.getSignInDetails();
                    authentication = new ManagerAuthenticator();
                    user = authentication.authenticate(loginCredentials);
                    if(user instanceof Manager) {
                        ManagerView managerView = new ManagerView();
                        managerView.viewPortal((Manager)user);
                    }
                    break;
                case "3":
                    //instanceGetter.getSalesExecutiveController().salesExecutivePortal();
                    break;
                case "4":
                    //instanceGetter.getCustomerController().customerPortal();
                    break;
                case "5":
                    System.out.println("Console Closing !!!");
                    return;
                default:
                    System.out.println("Enter valid Number");
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        mainLoop();
    }
    public static void main(String[] args){
        BikeBookingManagement bikeBookingManagement = new BikeBookingManagement();
            bikeBookingManagement.mainLoop();
    }
}
