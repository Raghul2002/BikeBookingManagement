package bbm.salesExecutive;

import bbm.model.account.SalesExecutive;

import java.util.Scanner;

public class SalesExecutiveView {
    Scanner sc = new Scanner(System.in);
    public void viewPortal(SalesExecutive salesExecutive) {
        System.out.println("--------------------Welcome to Sales Executive Portal---------------------------");
        salesExecutiveWhile:
        while (true) {
            System.out.println("1.View Bike\n2.View bike Orders\n3.Add Booking\n4.View Personal Details\n5.Logout");
//            switch (sc.nextLine()) {
//                case "1":
//                    bikeView.showBikeDetails();
//                    break;
//                case "2":
//                    bikeView.showReservedBikeDetails(account);
//                    break;
//                case "3":
//                    ownerController.confirmBooking(salesExecutive);
//                    break;
//                case "4":
//                    salesExecutiveView.showPersonalDetail(salesExecutive);
//                    break;
//                case "5":
//                    break salesExecutiveWhile;
//                default:
//                    System.out.println("Enter Valid Number");
//            }
        }
    }
}
