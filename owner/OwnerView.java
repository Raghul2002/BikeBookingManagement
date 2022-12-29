package bbm.owner;

import bbm.manager.BikeManagerController;
import bbm.utility.UtilUserInput;

import bbm.model.account.*;
import bbm.utility.Validation;

import java.util.List;
import java.util.Scanner;

public class OwnerView {
    enum EnumOwnerPortal {
        ADD_MANAGER,
        ADD_SALES_EXECUTIVE,
        REMOVE_MANAGER,
        REMOVE_SALES_EXECUTIVE,
        VIEW_MANAGER_DETAILS,
        VIEW_SALES_EXECUTIVE_DETAILS,
        VIEW_CUSTOMER_DETAILS,
        VIEW_BIKE_DETAILS,
        VIEW_SOLD_DETAILS,
        VIEW_PERSONAL_DETAILS,
        VIEW_SOLD_BIKE_DETAIL,
        LOGOUT,
    }

    OwnerController ownerController = new OwnerController();
    BikeManagerController bikeManager = new BikeManagerController();
    Scanner sc = new Scanner(System.in);

    public void viewPortal(Owner owner) {

        System.out.println("--------------------Welcome to Owner Portal---------------------------");
        whileLoop:
        while (true) {
            String option;
            EnumOwnerPortal enumOwner;
            for (int i = 0; i < EnumOwnerPortal.values().length ; i++) {
                System.out.println(i + 1 + "." + EnumOwnerPortal.values()[i]);
            }
            do{
                System.out.println("Enter number :");
                option = sc.next();
            }while(!Validation.validateNumber(option,EnumOwnerPortal.values().length));
            enumOwner = EnumOwnerPortal.values()[Integer.parseInt(option)];
            switch (enumOwner) {
                case ADD_MANAGER:
                    System.out.println("Enter Manager Details :");
                    ownerController.addManager(owner, UtilUserInput.getSignUpDetails());
                    break;
                case ADD_SALES_EXECUTIVE:
                    System.out.println("Enter Sales Executive Details :");
                    ownerController.addSalesExecutive(owner, UtilUserInput.getSignUpDetails());
                    break;
                case REMOVE_MANAGER:
                    System.out.println("Enter manager id you want to remove :");
                    if (ownerController.removeManger(owner, sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case REMOVE_SALES_EXECUTIVE:
                    System.out.println("Enter Sales Executive id you want to remove :");
                    if (ownerController.removeSalesExecutive(owner, sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case VIEW_MANAGER_DETAILS:
                    List<Manager> managerList = ownerController.getManagerList();
                    if (!managerList.isEmpty()) {
                        System.out.println("Manager Details :");
                        for (Manager i : managerList) {
                            System.out.println(i);
                        }
                    } else System.out.println("Sorry !!\nCurrently no managers registered");
                    break;
                case VIEW_SALES_EXECUTIVE_DETAILS:
                    List<SalesExecutive> salesExecutiveList = ownerController.getSalesExecutiveList();
                    if (!salesExecutiveList.isEmpty()) {
                        System.out.println("Manager Details :");
                        for (SalesExecutive i : salesExecutiveList) {
                            System.out.println(i);
                        }
                    } else System.out.println("Sorry !!\nCurrently no sales executive registered");
                    break;
                case VIEW_CUSTOMER_DETAILS:
                    List<Customer> customerList = ownerController.getCustomerList();
                    if (!customerList.isEmpty()) {
                        System.out.println("Manager Details :");
                        for (Customer i : customerList) {
                            System.out.println(i);
                        }
                    } else System.out.println("Sorry !!\nCurrently no customer registered");
                    break;
                case VIEW_BIKE_DETAILS:
                    bikeManager.viewAvailableBike();
                    break;
                case VIEW_SOLD_DETAILS:
                    bikeManager.viewSoldDetails(owner);
                    break;
                case VIEW_PERSONAL_DETAILS:
                    ownerController.showPersonalDetails(owner);
                    break;
                case VIEW_SOLD_BIKE_DETAIL:
                    bikeManager.viewSoldBike(owner);
                    break;
                case LOGOUT:
                    break whileLoop;
            }
        }
    }
}
