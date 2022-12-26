package bbm.salesExecutive;

import bbm.manager.BikeManagerController;
import bbm.model.account.SalesExecutive;

import java.util.Scanner;

public class SalesExecutiveView {
    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    SalesExecutiveController salesExecutiveController = new SalesExecutiveController();
    public void viewPortal(SalesExecutive salesExecutive) {
        System.out.println("--------------------Welcome to Sales Executive Portal---------------------------");
        salesExecutiveWhile:
        while (true) {
            System.out.println("1.View Bike\n2.View bike Orders\n3.Add Booking\n4.View Personal Details\n5.Logout");
            switch (sc.nextLine()) {
                case "1":
                    bikeManager.viewAvailableBike();
                    break;
                case "2":
                    bikeManager.viewReservedBike(salesExecutive);
                    break;
                case "3":
                    salesExecutiveController.confirmBooking();
                    break;
                case "4":
                    //salesExecutiveView.showPersonalDetail(salesExecutive);
                    break;
                case "5":
                    break salesExecutiveWhile;
                default:
                    System.out.println("Enter Valid Number");
            }
        }
    }
}
