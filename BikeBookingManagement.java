package bbm;

import bbm.owner.OwnerView;

import java.util.Scanner;

public class BikeBookingManagement {
    private void mainLoop() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Owner\n2.Manager\n3.Sales Executive\n4.Customer\n5.Exit Console");
            System.out.println("Enter number :");
            switch (sc.nextLine()) {
                case "1":
                    OwnerView ownerView = new OwnerView();
                    ownerView.set();
                    //instanceGetter.getOwnerController().ownerPortal();
                    break;
                case "2":
                    //instanceGetter.getManagerController().managerPortal();
                    break;
                case "3":
                    //instanceGetter.getSalesExecutiveController().salesExecutivePortal();
                    break;
                case "4":
                    //instanceGetter.getCustomerController().customerPortal();
                    break;
                case "5":
                    System.out.println("Console Closing !!!");
                    return;
                default:
                    System.out.println("Enter valid Number");
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        mainLoop();
    }
    public static void main(){
        BikeBookingManagement bikeBookingManagement = new BikeBookingManagement();
        try {
            bikeBookingManagement.mainLoop();
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}
