package bbm;

import bbm.customer.CustomerView;
import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.manager.ManagerView;
import bbm.model.account.*;
import bbm.model.authentication.*;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.model.interfaces.IPortal;
import bbm.owner.OwnerView;
import bbm.salesExecutive.SalesExecutiveView;
import bbm.utility.UtilUserInput;

import java.util.List;
import java.util.Scanner;

public class BikeBookingManagement {
    static {
        IDatabase db = Database.getInstance();
        db.addUser(new Manager("m","m","m","r","@gmail",3456234234L));
        db.addUser(new Owner("m","m","o","t","@gmail", 3456234234L));
        db.addBike(new MBike(1,2,3,4,5,"1","2","3","4",5,1,"2","3","4","5","3"));
        db.addBike(new MBike(1,2,3,4,5,"1","2","3","4",5,1,"2","3","4","5","3"));
        db.addBike(new EBike(5,4,3,2,1,"5","4", "3","2",1,5,4,3,2));
        db.addBike(new EBike(5,4,3,2,1,"5","4", "3","2",1,5,4,3,2));
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
                    loginCredentials = utilUserInput.getSignInDetails();
                    authentication = new SalesExecutiveAuthenticator();
                    user = authentication.authenticate(loginCredentials);
                    if(user instanceof SalesExecutive) {
                        SalesExecutiveView salesExecutiveView = new SalesExecutiveView();
                        salesExecutiveView.viewPortal((SalesExecutive)user);
                    }
                    break;
                case "4":
                    System.out.println("1.Sign Up\n2.Sign In");
                    switch (sc.nextLine()) {
                        case "1":
                            utilUserInput.getSignUpDetails();
                        case "2":
                            loginCredentials = utilUserInput.getSignInDetails();
                            authentication = new CustomerAuthenticator();
                            user = authentication.authenticate(loginCredentials);
                            if(user instanceof Customer) {
                                CustomerView customerView = new CustomerView();
                                customerView.viewPortal((Customer)user);
                            }
                        default:
                            System.out.println("Enter valid number!!");
                    }
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
