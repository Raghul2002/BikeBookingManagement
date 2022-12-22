package bbm.owner;

import bbm.Registrar;

import bbm.model.account.Owner;
import bbm.model.account.User;
import bbm.model.interfaces.IPortal;

import java.util.Scanner;

public class OwnerView implements IPortal {
    OwnerController ownerController = new OwnerController();

    public void viewPortal(User user) {
        Registrar registrar = new Registrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------Welcome to Owner Portal---------------------------");
        Owner owner = (Owner) user;
        whileLoop:
        while (true) {
            System.out.println("1.Add Manager\n2.Add Sales Executive\n3.Remove Manager\n4.Remove Sales Executive\n5.View Manager Details\n6.View Sales Man Details\n7.View Customer Details\n8.View Bike Details\n9.View Sold Details\n10.View Personal Details\n11.View Sold Bike Details\n12.Logout");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Enter Manager Details :");
                    ownerController.addManager(owner, registrar.getSignUpDetails());
                    break;
                case "2":
                    System.out.println("Enter Sales Executive Details :");
                    ownerController.addSalesExecutive(owner,registrar.getSignUpDetails());
                    break;
                case "3":
                    System.out.println("Enter manager id you want to remove :");
                    if (ownerController.removeManger(owner,sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                case "4":
                    System.out.println("Enter Sales Executive id you want to remove :");
                    if (ownerController.removeSalesExecutive(owner,sc.nextInt()))
                        System.out.println("Successfully Removed");
                    else
                        System.out.println("Failed, Enter valid Manager Id !");
                    break;
                    case "5":
                        ownerController.showManagerDetails(owner);
                        break;
//                    case "6":
//                        salesExecutiveView.showSalesExecutiveDetails(OwnerModel.getSalesExecutiveList());
//                        break;
//                    case "7":
//                        customerView.showCustomerDetails(OwnerModel.getCustomerList());
//                        break;
//                    case "8":
//                        bikeView.showBikeDetails();
//                        break;
//                    case "9":
//                        soldDetailsView.viewSoldOrders();
//                        break;
//                    case "10":
//                        ownerView.showPersonalDetail(owner);
//                        break;
//                    case "11":
//                        bikeView.showSoldBikeDetails(owner);
//                        break;
                case "12":
                    break whileLoop;
                default:
                    System.out.println("Enter Valid Number");
            }
        }
    }
}
