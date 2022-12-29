package bbm.customer;

import bbm.enumPackage.EnumBikeTypes;
import bbm.manager.BikeManagerController;
import bbm.model.account.Customer;
import bbm.salesExecutive.SalesExecutiveController;
import bbm.utility.UtilBikeInput;

import java.util.Scanner;

enum EnumCustomerPortal {
    VIEW_BIKE,
    COMPARE_BIKE,
    BUY_BIKE,
    VIEW_PERSONAL_DETAILS,
    LOGOUT,
    DEFAULT
}
public class CustomerView {

    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    SalesExecutiveController salesExecutive = new SalesExecutiveController();
    CustomerController customerController = new CustomerController();

    public void viewPortal(Customer customer) {
        System.out.println("--------------------Welcome to customer Portal---------------------------");
        whileLoop:
        while (true) {
            int option;
            EnumCustomerPortal enumCustomer = EnumCustomerPortal.DEFAULT;
            for (int i = 0; i < EnumCustomerPortal.values().length - 1; i++) {
                System.out.println(i + 1 + "." + EnumCustomerPortal.values()[i]);
            }
            System.out.println("Enter number :");
            option = Integer.parseInt(sc.nextLine());
            for (EnumCustomerPortal type : EnumCustomerPortal.values()) {
                if (type.ordinal() == option - 1) {
                    enumCustomer = type;
                }
            }
            switch (enumCustomer) {
                case VIEW_BIKE:
                    bikeManager.viewAvailableBike();
                    break;
                case COMPARE_BIKE:
                    salesExecutive.compareBike(UtilBikeInput.getBikesIdToCompare());
                    break;
                case BUY_BIKE:
                    EnumBikeTypes bikeType = bikeManager.getBikeType();
                    if(salesExecutive.buyBike(customer.getCustomerId(), bikeManager.getBikeId(bikeType),bikeType))       //TO check bike in data
                        System.out.println("Bike is registered to your name");
                    else
                        System.out.println("Enter valid Bike Id");
                    break;
                case VIEW_PERSONAL_DETAILS:
                    customerController.showPersonalDetails(customer);
                    break;
                case LOGOUT:
                    break whileLoop;
                case DEFAULT:
                    System.err.println("Enter Valid Number");
            }
        }
    }
}
