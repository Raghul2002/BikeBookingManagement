package bbm.owner;

import bbm.manager.BikeManagerController;
import bbm.utility.UtilUserInput;

import bbm.model.account.*;
import bbm.model.interfaces.IPortal;

import java.util.List;
import java.util.Scanner;

public class OwnerView implements IPortal {
    OwnerController ownerController = new OwnerController();
    BikeManagerController bikeManager = new BikeManagerController();
    Scanner sc = new Scanner(System.in);

    public void viewPortal(User user) {

        System.out.println("--------------------Welcome to Owner Portal---------------------------");
        Owner owner = (Owner) user;
        whileLoop:
        while (true) {
            System.out.println("1.Add Manager\n2.Add Sales Executive\n3.Remove Manager\n4.Remove Sales Executive\n5.View Manager Details\n6.View Sales Man Details\n7.View Customer Details\n8.View Bike Details\n9.View Sold Details\n10.View Personal Details\n11.View Sold Bike Details\n12.Logout");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Enter Manager Details :");
                    ownerController.addManager(owner, UtilUserInput.getSignUpDetails());
                    break;
                case "2":
                    System.out.println("Enter Sales Executive Details :");
                    ownerController.addSalesExecutive(owner, UtilUserInput.getSignUpDetails());
                    break;
                case "3":
                    System.out.println("Enter manager id you want to remove :");
                    if (ownerController.removeManger(owner, sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case "4":
                    System.out.println("Enter Sales Executive id you want to remove :");
                    if (ownerController.removeSalesExecutive(owner, sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case "5":
                    List<Manager> managerList = ownerController.getManagerList();
                    if (!managerList.isEmpty()) {
                        System.out.println("Manager Details :");
                        for (Manager i : managerList) {
                            System.out.println(i);
                        }
                    } else System.out.println("Sorry !!\nCurrently no managers registered");
                    break;
                case "6":
                    List<SalesExecutive> salesExecutiveList = ownerController.getSalesExecutiveList();
                    if (!salesExecutiveList.isEmpty()) {
                        System.out.println("Manager Details :");
                        for (SalesExecutive i : salesExecutiveList) {
                            System.out.println(i);
                        }
                    } else System.out.println("Sorry !!\nCurrently no sales executive registered");
                    break;
                case "7":
                    List<Customer> customerList = ownerController.getCustomerList();
                    if (!customerList.isEmpty()) {
                        System.out.println("Manager Details :");
                        for (Customer i : customerList) {
                            System.out.println(i);
                        }
                    } else System.out.println("Sorry !!\nCurrently no customer registered");
                    break;
                case "8":
                    bikeManager.viewAvailableBike();
                    break;
                case "9":
                    //bikeManager.viewSoldBike(owner);
                    break;
                case "10":
                    ownerController.showPersonalDetails(owner);
                    break;
                case "11":
                    bikeManager.viewSoldBike(owner);
                    break;
                case "12":
                    break whileLoop;
                default:
                    System.out.println("Enter Valid Number");
            }
        }
    }
}
