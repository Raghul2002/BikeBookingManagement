package bbm.controller.account;

import bbm.controller.InstanceGetter;
import bbm.model.SoldDetails;
import bbm.model.account.AccountAuthentication;
import bbm.model.account.AccountModel;
import bbm.model.account.OwnerModel;
import bbm.model.account.SalesExecutiveModel;
import bbm.view.AccountView;
import bbm.view.BikeView;
import bbm.view.SalesExecutiveView;

import java.util.Scanner;

public class SalesExecutiveController {
    InstanceGetter instanceGetter = InstanceGetter.receiveInstance();
    Scanner sc = instanceGetter.getScannerInstance();
    BikeView bikeView = instanceGetter.getBikeViewInstance();
    OwnerController ownerController = instanceGetter.getOwnerController();
    SalesExecutiveView salesExecutiveView = instanceGetter.getSalesExecutiveView();
    AccountView accountView = new AccountView();
    public void salesExecutivePortal() {

        AccountModel account = AccountAuthentication.authenticateSalesExecutive(accountView.getSignInDetails(), OwnerModel.getSalesExecutiveList());
        if (account instanceof SalesExecutiveModel) {
            SalesExecutiveModel salesExecutive = (SalesExecutiveModel) account;
            System.out.println("--------------------Welcome to Sales Executive Portal---------------------------");
            salesWhile:
            while (true) {
                System.out.println("1.View Bike\n2.View bike Orders\n3.Add Booking\n4.View Personal Details\n5.Logout");
                switch (sc.nextLine()) {
                    case "1":
                        bikeView.showBikeDetails();
                        break;
                    case "2":
                        bikeView.showReservedBikeDetails(account);
                        break;
                    case "3":
                        ownerController.confirmBooking(salesExecutive);
                        break;
                    case "4":
                        salesExecutiveView.showPersonalDetail(salesExecutive);
                        break;
                    case "5":
                        break salesWhile;
                    default:
                        System.out.println("Enter Valid Number");
                }
            }
        } else {
            System.out.println("Wrong Credentials! ");
        }
    }

    protected void compareBike() {
        Scanner sc = new Scanner(System.in);
        int bike1, bike2, bikeChoice;
        bikeView.showBikeDetails();
        System.out.println("You want to compare\n1.Mechanical Bikes\n2.Electric Bikes");
        bikeChoice = sc.nextInt();
        System.out.println("---------------Compare Bikes---------------");
        System.out.println("Enter Bike 1 ID:");
        bike1 = sc.nextInt();
        System.out.println("Enter Bike 2 ID:");
        bike2 = sc.nextInt();
        if (bike1 == bike2) System.out.println("Enter valid comparison!! You are comparing same bike ");
        else
            switch (bikeChoice) {
                case 1:
                    System.out.println("Mechanical Bikes  :");
                    SalesExecutiveModel.compareMBike(bike1, bike2);
                    break;
                case 2:
                    System.out.println("Electrical Bikes  :");
                    SalesExecutiveModel.compareEBike(bike1, bike2);
                    break;
                default:
                    System.out.println("Enter valid input!!!");
            }
    }

    public void buyBike(int customerId) {
        bikeView.showBikeDetails();
        Scanner sc = new Scanner(System.in);
        int bikeId;
        System.out.println("Enter the bike id you want to book:");
        bikeId = sc.nextInt();
        if (OwnerModel.buyBike(bikeId)) {
            SoldDetails.addBookingDetails(bikeId, customerId);
            System.out.println("Thank you for Booking ! \nYour Bike will be delivered");
        } else
            System.out.println("The Bike ID you entered does not exist !!! Try Again");

    }
}