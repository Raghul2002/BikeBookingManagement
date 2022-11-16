package bbm.controller.account;

import bbm.controller.InstanceGetter;
import bbm.model.account.*;
import bbm.model.account.OwnerModel;
import bbm.view.*;

import java.util.Scanner;

public class CustomerController {
    InstanceGetter instanceGetter = InstanceGetter.receiveInstance();
    Scanner sc = instanceGetter.getScannerInstance();
    BikeView bikeView = instanceGetter.getBikeViewInstance();
    AccountView accountView = instanceGetter.getAccountView();
    SalesExecutiveController salesExecutiveController = instanceGetter.getSalesExecutiveController();
    CustomerView customerView = instanceGetter.getCustomerView();

    public void customerPortal() {
        System.out.println("1.Sign Up\n2.Sign In");
        switch (sc.nextLine()) {
            case "1":
                SalesExecutiveModel.addCustomer();
                break;
            case "2":
                AccountModel account = AccountAuthentication.authenticateCustomer(accountView.getSignInDetails(), OwnerModel.getCustomerList());
                if (account instanceof CustomerModel) {
                    CustomerModel customer = (CustomerModel)account;
                    System.out.println("--------------------Welcome to customer Portal---------------------------");
                    whileLoop:
                    while (true) {
                        System.out.println("1.View Bike\n2.Compare Bike\n3.Buy Bike\n4.View Personal Details\n5.Logout");
                        switch (sc.nextLine()) {
                            case "1":
                                bikeView.showBikeDetails();
                                break;
                            case "2":
                                salesExecutiveController.compareBike();
                                break;
                            case "3":
                                salesExecutiveController.buyBike(customer.getCustomerId());
                                break;
                            case "4":
                                customerView.showPersonalDetail(customer);
                                break;
                            case "5":
                                break whileLoop;
                            default:
                                System.out.println("Enter Valid Number");
                        }
                    }
                } else {
                    System.out.println("Invalid Credentials !!!");
                }
            default:
                System.out.println("Enter valid number!!");
        }
    }
}
