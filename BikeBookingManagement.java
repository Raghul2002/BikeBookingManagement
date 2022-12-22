package bbm;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.User;
import bbm.model.authentication.IUserAuthentication;
import bbm.model.authentication.OwnerAuthenticator;
import bbm.model.interfaces.IPortal;
import bbm.owner.OwnerView;

import java.util.List;
import java.util.Scanner;


public class BikeBookingManagement {
    static {
        IDatabase db = Database.getInstance();
        db.addManager(new Manager("m","m","m","m","@gmail",3456234234l));
        db.addOwner(new Owner("m","m","o","t","@gmail",3456234234l));
    }
    private void mainLoop() {
        try {
            User user;
            Registrar registrar = new Registrar();
            IUserAuthentication authentication;
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Owner\n2.Manager\n3.Sales Executive\n4.Customer\n5.Exit Console");
            System.out.println("Enter number :");
            switch (sc.nextLine()) {
                case "1":
                    List<String> loginCredentials = registrar.getSignInDetails();
                    authentication = new OwnerAuthenticator();
                    user = authentication.authenticate(loginCredentials);
                    if(user !=null) {
                        IPortal ownerView = new OwnerView();
                        ownerView.viewPortal(user);
                    }
                    break;
                case "2":
                    //instanceGetter.getManagerController().managerPortal();
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
