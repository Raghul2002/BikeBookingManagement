package bbm.controller.account;

import bbm.controller.InstanceGetter;
import bbm.view.BikeInputView;
import bbm.model.account.AccountAuthentication;
import bbm.model.account.AccountModel;
import bbm.model.account.ManagerModel;
import bbm.model.account.OwnerModel;
import bbm.view.AccountView;
import bbm.view.BikeView;
import bbm.view.ManagerView;

import java.util.Scanner;

public class ManagerController {
    InstanceGetter instanceGetter = InstanceGetter.receiveInstance();
    Scanner sc = instanceGetter.getScannerInstance();
    BikeInputView bikeInputView = instanceGetter.getBikeInputView();
    AccountView accountView = instanceGetter.getAccountView();
    BikeView bikeView = instanceGetter.getBikeViewInstance();
    ManagerView managerView = instanceGetter.getManagerView();
    public void managerPortal() {
        AccountModel account = AccountAuthentication.authenticateManager(accountView.getSignInDetails(), OwnerModel.getManagerList());
        if (account instanceof ManagerModel) {
            System.out.println("--------------------Welcome to manager Portal---------------------------");
            whileLoop:
            while (true) {
                System.out.println("1.Add Bike\n2.Remove Bike\n3.View Bike\n4.View Personal Details\n5.Logout");
                ManagerModel manager = (ManagerModel) account;
                switch (sc.nextLine()) {
                    case "1":
                        System.out.println("1.Add Mechanical Bike\n2.Add Electronic Bike");
                        switch (sc.nextLine()) {
                            case "1":
                                manager.addMBike(bikeInputView.getMBikeDetails(), manager);
                                System.out.println("Mechanical bike Removed Successfully");
                                break;
                            case "2":
                                manager.addEBike(bikeInputView.getEBikeDetails(), manager);
                                System.out.println("Electrical bike Removed Successfully");
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
                                if (manager.removeMBike(sc.nextInt(), manager))
                                    System.out.println("Mechanical Bike successfully removed");
                                else System.out.println("The Mechanical Bike Id you entered does not exist");
                                break;
                            case "2":
                                System.out.println("Enter Electrical bike id to remove :");
                                if (manager.removeEBike(sc.nextInt(), manager))
                                    System.out.println("Mechanical Bike successfully removed");
                                else System.out.println("The Electrical Bike Id you entered does not exist");
                                break;
                            default:
                                System.out.println("Enter Valid Input");
                                break;
                        }
                        break;
                    case "3":
                        bikeView.showBikeDetails();
                        break;
                    case "4":
                        managerView.showPersonalDetail(manager);
                        break;
                    case "5":
                        break whileLoop;
                    default:
                        System.out.println("Enter Valid Number");
                }
            }
        } else {
            System.out.println("Wrong Credentials !!!");
        }
    }
}
