package bbm.manager;

import bbm.model.account.Manager;
import bbm.utility.UtilBikeInput;
import bbm.utility.Validation;

import java.util.Scanner;

enum EnumManagerPortal {
    ADD_BIKE,
    REMOVE_BIKE,
    VIEW_BIKE,
    VIEW_PERSONAL_DETAILS,
    LOGOUT,
}
public class ManagerView {


    Scanner sc = new Scanner(System.in);
    BikeManagerController bikeManager = new BikeManagerController();
    EBikeManagerController eBikeManager = new EBikeManagerController();
    MBikeManagerController mBikeManager = new MBikeManagerController();

    public void viewPortal(Manager manager) {
        System.out.println("--------------------Welcome to manager Portal---------------------------");
        whileLoop:
        while (true) {
            String option;
            EnumManagerPortal enumManager ;
            for (int i = 0; i < EnumManagerPortal.values().length; i++) {
                System.out.println(i + 1 + "." + EnumManagerPortal.values()[i]);
            }
            do {
                System.out.println("Enter number :");
                option = sc.nextLine();
            }while(!Validation.validateNumber(option,EnumManagerPortal.values().length));
            enumManager = EnumManagerPortal.values()[Integer.parseInt(option)-1];
            switch (enumManager) {
                case ADD_BIKE:
                    System.out.println("1.Add Mechanical Bike\n2.Add Electronic Bike");
                    switch (sc.nextLine()) {
                        case "1":
                            if (mBikeManager.addBike(UtilBikeInput.getMBikeDetails(), manager))
                                System.out.println("Mechanical bike added Successfully");
                            else System.out.println("Sorry!! Couldn't add Mechanical Bike");
                            break;
                        case "2":
                            if (eBikeManager.addBike(UtilBikeInput.getEBikeDetails(), manager))
                                System.out.println("Electrical bike added Electrical Successfully");
                            else System.out.println("Sorry!! Couldn't add Bike");
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case REMOVE_BIKE:
                    System.out.println("1.Remove Mechanical Bike\n2.Remove Electric Bike");
                    switch (sc.nextLine()) {
                        case "1":
                            System.out.println("Enter Mechanical bike ID to remove :");
                            if (mBikeManager.removeBike(sc.nextInt(), manager))
                                System.out.println("Mechanical Bike successfully removed");
                            else System.out.println("The Mechanical Bike Id you entered does not exist");
                            break;
                        case "2":
                            System.out.println("Enter Electrical bike id to remove :");
                            if (eBikeManager.removeBike(sc.nextInt(), manager))
                                System.out.println("Electric Bike successfully removed");
                            else System.out.println("The Electrical Bike Id you entered does not exist");
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case VIEW_BIKE:
                    bikeManager.viewAvailableBike();
                    break;
                case VIEW_PERSONAL_DETAILS:
                    bikeManager.showPersonalDetails(manager);
                    break;
                case LOGOUT:
                    break whileLoop;
            }
        }
    }
}
