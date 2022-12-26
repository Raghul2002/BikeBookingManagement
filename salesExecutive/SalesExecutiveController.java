package bbm.salesExecutive;

import bbm.manager.BikeManagerController;
import bbm.model.DataManager;
import bbm.model.SoldDetails;
import bbm.model.bike.BikeStatus;

import java.util.List;
import java.util.Scanner;

public class SalesExecutiveController {
    DataManager dataManager = new DataManager();
    BikeManagerController bikeManager = new BikeManagerController();
    Scanner sc = new Scanner(System.in);
    public void confirmBooking() {
//        for (SoldDetails i : dataManager.getSoldDetailsList()) {
//            if(i.getSalesExecutiveId() == 0) {
//                List<SoldDetails> soldDetailsList = dataManager.getSoldDetailsList();
//                int indexNo = soldDetailsList.indexOf(i);
//                SoldDetails soldDetails = SoldDetails.builder().setSalesExecutiveId(salesExecutiveId).setBikeId(i.getBikeId()).setCustomerId(i.getCustomerId()).build();
//                setBikeStatus(i.getBikeId(), BikeStatus.SOLD.toString());
//                dataManager.setBooking(soldDetails,indexNo);
//            }
//        }
    }
//    protected void compareBike() {
//        Scanner sc = new Scanner(System.in);
//        int bike1, bike2, bikeChoice;
//        bikeManager.viewAvailableBike();
//        System.out.println("You want to compare\n1.Mechanical Bikes\n2.Electric Bikes");
//        bikeChoice = sc.nextInt();
//        System.out.println("---------------Compare Bikes---------------");
//        System.out.println("Enter Bike 1 ID:");
//        bike1 = sc.nextInt();
//        System.out.println("Enter Bike 2 ID:");
//        bike2 = sc.nextInt();
//        if (bike1 == bike2) System.out.println("Enter valid comparison!! You are comparing same bike ");
//        else
//            switch (bikeChoice) {
//                case 1:
//                    System.out.println("Mechanical Bikes  :");
//                    SalesExecutiveModel.compareMBike(bike1, bike2);
//                    break;
//                case 2:
//                    System.out.println("Electrical Bikes  :");
//                    SalesExecutiveModel.compareEBike(bike1, bike2);
//                    break;
//                default:
//                    System.out.println("Enter valid input!!!");
//            }
//    }
    public void buyBike(int customerId) {
        bikeManager.viewAvailableBike();
        int bikeId;
        System.out.println("Enter the bike id you want to book:");
        bikeId = sc.nextInt();
//        if (OwnerModel.buyBike(bikeId)) {
//            //SoldDetails.addBookingDetails(bikeId, customerId);
//            System.out.println("Thank you for Booking ! \nYour Bike will be delivered");
//        } else
//            System.out.println("The Bike ID you entered does not exist !!! Try Again");
    }
}
