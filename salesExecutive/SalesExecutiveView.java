package bbm.salesExecutive;

import bbm.manager.BikeManagerController;
import bbm.model.account.SalesExecutive;
import bbm.utility.Validation;

import java.util.Scanner;

public class SalesExecutiveView {
    enum EnumSalesExecutivePortal {
        VIEW_BIKE,
        VIEW_BIKE_ORDERS,
        CONFIRM_BOOKING,
        VIEW_PERSONAL_DETAILS,
        LOGOUT,
    }

    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    SalesExecutiveController salesExecutiveController = new SalesExecutiveController();

    public void viewPortal(SalesExecutive salesExecutive) {
        salesExecutiveWhile:
        while (true) {
            String option;
            EnumSalesExecutivePortal enumSalesExecutive;
            for (int i = 0; i < EnumSalesExecutivePortal.values().length; i++) {
                System.out.println(i + 1 + "." + EnumSalesExecutivePortal.values()[i]);
            }
            do {
                System.out.println("Enter number :");
                option = sc.nextLine();
            } while (!Validation.validateNumber(option, EnumSalesExecutivePortal.values().length));
            enumSalesExecutive = EnumSalesExecutivePortal.values()[Integer.parseInt(option)];
            switch (enumSalesExecutive) {
                case VIEW_BIKE:
                    bikeManager.viewAvailableBike();
                    break;
                case VIEW_BIKE_ORDERS:
                    bikeManager.viewReservedBike(salesExecutive);
                    break;
                case CONFIRM_BOOKING:
                    bikeManager.confirmBikeBooking(salesExecutive);
                    break;
                case VIEW_PERSONAL_DETAILS:
                    salesExecutiveController.showPersonalDetails(salesExecutive);
                    break;
                case LOGOUT:
                    break salesExecutiveWhile;
            }
        }
    }
}
