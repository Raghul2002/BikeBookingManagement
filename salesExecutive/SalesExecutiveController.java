package bbm.salesExecutive;

import bbm.manager.BikeManagerController;
import bbm.manager.EBikeManagerController;
import bbm.manager.MBikeManagerController;
import bbm.model.DataManager;
import bbm.model.SoldDetails;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.BikeStatus;
import bbm.utility.UserView.UtilOwnerView;
import bbm.utility.UserView.UtilSalesExecutiveView;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesExecutiveController {
    BikeManagerController bikeManager = new BikeManagerController();
    EBikeManagerController eBikeManagerController = new EBikeManagerController();
    MBikeManagerController mBikeManagerController = new MBikeManagerController();
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

    public void compareBike(List<Integer> bikeDetails) {

        if (bikeDetails.get(1) == bikeDetails.get(2))
            System.out.println("Enter valid comparison!! You are comparing same bike ");
        else
            switch (bikeDetails.get(0)) {
                case 1:
                    System.out.println("Mechanical Bikes  :");
                    mBikeManagerController.compareBike(bikeDetails.get(1),bikeDetails.get(2));
                    break;
                case 2:
                    System.out.println("Electrical Bikes  :");
                    eBikeManagerController.compareBike(bikeDetails.get(1),bikeDetails.get(2));
                    break;
                default:
                    System.out.println("Enter valid input!!!");
            }
    }
    protected void showPersonalDetails(SalesExecutive salesExecutive){
        List<SalesExecutive> userList = new ArrayList<>();
        userList.add(salesExecutive);
        UtilSalesExecutiveView.showSalesExecutiveDetails(userList);
    }
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
