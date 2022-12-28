package bbm.salesExecutive;

import bbm.manager.BikeManagerController;
import bbm.model.account.SalesExecutive;

import java.util.Scanner;

public class SalesExecutiveView {
    enum EnumSalesExecutivePortal {
        VIEW_BIKE,
        VIEW_BIKE_ORDERS,
        ADD_BOOKING,
        VIEW_PERSONAL_DETAILS,
        LOGOUT,
        DEFAULT;
    }

    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    SalesExecutiveController salesExecutiveController = new SalesExecutiveController();

    public void viewPortal(SalesExecutive salesExecutive) {
        salesExecutiveWhile:
        while (true) {
            int option;
            EnumSalesExecutivePortal enumSalesExecutive = EnumSalesExecutivePortal.DEFAULT;
            for (int i = 0; i < EnumSalesExecutivePortal.values().length - 1; i++) {
                System.out.println(i + 1 + "." + EnumSalesExecutivePortal.values()[i]);
            }
            System.out.println("Enter number :");
            option = Integer.parseInt(sc.nextLine());
            for (EnumSalesExecutivePortal type : EnumSalesExecutivePortal.values()) {
                if (type.ordinal() == option - 1) {
                    enumSalesExecutive = type;
                }
            }
            switch (enumSalesExecutive) {
                case VIEW_BIKE:
                    bikeManager.viewAvailableBike();
                    break;
                case VIEW_BIKE_ORDERS:
                    bikeManager.viewReservedBike(salesExecutive);
                    break;
                case ADD_BOOKING:
                    //salesExecutiveController.confirmBooking();
                    break;
                case VIEW_PERSONAL_DETAILS:
                    salesExecutiveController.showPersonalDetails(salesExecutive);
                    break;
                case LOGOUT:
                    break salesExecutiveWhile;
                case DEFAULT:
                    System.err.println("Enter Valid Number");
            }
        }
    }
}
