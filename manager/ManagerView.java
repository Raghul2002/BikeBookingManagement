package bbm.manager;

import bbm.model.account.Manager;
import bbm.utility.UtilBikeInput;
import java.util.Scanner;

public class ManagerView {
    Scanner sc = new Scanner(System.in);
    UtilBikeInput bikeInput = new UtilBikeInput();
    BikeManagerController bikeManager = new BikeManagerController();
    EBikeManagerController mBikeManager = new EBikeManagerController();
    MBikeManagerController eBikeManager = new MBikeManagerController();
    public void viewPortal(Manager manager) {
        System.out.println("--------------------Welcome to manager Portal---------------------------");
        whileLoop:
        while (true) {
            System.out.println("1.Add Bike\n2.Remove Bike\n3.View Bike\n4.View Personal Details\n5.Logout");
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("1.Add Mechanical Bike\n2.Add Electronic Bike");
                    switch (sc.nextLine()) {
                        case "1":
                            if (mBikeManager.addBike(bikeInput.getMBikeDetails(), manager))
                                System.out.println("Mechanical bike added Successfully");
                            else System.out.println("Sorry!! Couldn't add Mechanical Bike");
                            break;
                        case "2":
                            if (eBikeManager.addBike(bikeInput.getEBikeDetails(), manager))
                                System.out.println("Electrical bike added Electrical Successfully");
                            else System.out.println("Sorry!! Couldn't add Bike");
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case "2":
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
                                System.out.println("Mechanical Bike successfully removed");
                            else System.out.println("The Electrical Bike Id you entered does not exist");
                            break;
                        default:
                            System.out.println("Enter Valid Input");
                            break;
                    }
                    break;
                case "3":
                    bikeManager.viewAvailableBike();
                    break;
                case "4":
                    //managerView.showPersonalDetail(manager);
                    break;
                case "5":
                    break whileLoop;
                default:
                    System.out.println("Enter Valid Number");
            }
        }
    }

}
