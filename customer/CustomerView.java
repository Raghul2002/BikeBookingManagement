package bbm.customer;

import bbm.manager.BikeManagerController;
import bbm.model.account.Customer;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.utility.UtilBikeInput;
import bbm.utility.UtilBikeView;

import java.util.Scanner;

public class CustomerView {
    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    SalesExecutiveController salesExecutiveController = new SalesExecutiveController();
    CustomerController customerController = new CustomerController();
    public void viewPortal(Customer customer) {
        System.out.println("--------------------Welcome to customer Portal---------------------------");
        whileLoop:
        while (true) {
            System.out.println("1.View Bike\n2.Compare Bike\n3.Buy Bike\n4.View Personal Details\n5.Logout");
            switch (sc.nextLine()) {
                case "1":
                    bikeManager.viewAvailableBike();
                    break;
                case "2":
                    salesExecutiveController.compareBike(UtilBikeInput.getBikesIdToCompare());
                    break;
                case "3":
                   // salesExecutiveController.buyBike(customer.getCustomerId());
                    break;
                case "4":
                    customerController.showPersonalDetails(customer);
                    break;
                case "5":
                    break whileLoop;
                default:
                    System.out.println("Enter Valid Number");
            }
        }
    }
}
