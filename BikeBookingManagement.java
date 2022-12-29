package bbm;

import bbm.customer.CustomerView;
import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.manager.ManagerView;
import bbm.model.account.*;
import bbm.model.authentication.*;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.owner.OwnerView;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.salesExecutive.SalesExecutiveView;
import bbm.utility.UtilUserInput;

import java.util.List;
import java.util.Scanner;

enum EnumUserTypes {
    OWNER, MANAGER, SALES_EXECUTIVE, CUSTOMER, EXIT, DEFAULT
}

public class BikeBookingManagement {

    static {
        IDatabase db = Database.getInstance();
        db.addUser(new Manager("m", "m", "m", "r", "@gmail", 3456234234L));
        db.addUser(new Owner("m", "m", "o", "t", "@gmail", 3456234234L));
        db.addUser(new Customer("m", "m", "c", "h", "@gmail", 3456234234L));
        db.addUser(new SalesExecutive("m", "m", "s", "x", "@gmail", 3456234234L));
        db.addBike(new MBike(1, 2, 3, 4, 5, "1", "2", "3", "4", 5, 1, "2", "3", "4", "5", "3"));
        db.addBike(new MBike(1, 2, 3, 4, 5, "1", "2", "3", "4", 5, 1, "2", "3", "4", "5", "3"));
        db.addBike(new EBike(5, 4, 3, 2, 1, "5", "4", "3", "2", 1, 5, 4, 3, 2));
        db.addBike(new EBike(5, 4, 3, 2, 1, "5", "4", "3", "2", 1, 5, 4, 3, 2));
    }

    private void mainLoop() {
        User user;
        int num;
        EnumUserTypes userType = EnumUserTypes.DEFAULT;
        IUserAuthentication authentication;
        SalesExecutiveController salesExecutive = new SalesExecutiveController();
        Scanner sc = new Scanner(System.in);
        try {
            for (int i = 0; i < EnumUserTypes.values().length - 1; i++) {
                System.out.println(i + 1 + "." + EnumUserTypes.values()[i]);
            }
            System.out.println("Enter number :");
            num = Integer.parseInt(sc.nextLine());
            for (EnumUserTypes type : EnumUserTypes.values()) {
                if (type.ordinal() == num - 1) {
                    userType = type;
                }
            }
            switch (userType) {
                case OWNER:
                    List<String> loginCredentials = UtilUserInput.getSignInDetails();
                    authentication = new OwnerAuthenticator();
                    user = authentication.authenticate(loginCredentials);
                    if (user != null) {
                        OwnerView ownerView = new OwnerView();
                        ownerView.viewPortal((Owner) user);
                    }
                    break;
                case MANAGER:
                    loginCredentials = UtilUserInput.getSignInDetails();
                    authentication = new ManagerAuthenticator();
                    user = authentication.authenticate(loginCredentials);
                    if (user instanceof Manager) {
                        ManagerView managerView = new ManagerView();
                        managerView.viewPortal((Manager) user);
                    }
                    break;
                case SALES_EXECUTIVE:
                    loginCredentials = UtilUserInput.getSignInDetails();
                    authentication = new SalesExecutiveAuthenticator();
                    user = authentication.authenticate(loginCredentials);
                    if (user instanceof SalesExecutive) {
                        SalesExecutiveView salesExecutiveView = new SalesExecutiveView();
                        salesExecutiveView.viewPortal((SalesExecutive) user);
                    }
                    break;
                case CUSTOMER:
                    System.out.println("1.Sign Up\n2.Sign In");
                    switch (sc.nextLine()) {
                        case "1":
                            salesExecutive.addCustomer(UtilUserInput.getSignUpDetails());
                            System.out.println("Customer added successfully");
                        case "2":
                            loginCredentials = UtilUserInput.getSignInDetails();
                            authentication = new CustomerAuthenticator();
                            user = authentication.authenticate(loginCredentials);
                            if (user instanceof Customer) {
                                CustomerView customerView = new CustomerView();
                                customerView.viewPortal((Customer) user);
                            }
                        default:
                            System.out.println("Enter valid number!!");
                    }
                    break;
                case EXIT:
                    System.out.println("Console Closing !!!");
                    return;
                case DEFAULT:
                    System.err.println("Enter valid Number");
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        mainLoop();
    }

    public static void main(String[] args) {
        BikeBookingManagement bikeBookingManagement = new BikeBookingManagement();
        bikeBookingManagement.mainLoop();
    }
}