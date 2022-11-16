package bbm.view;

import bbm.model.SoldDetails;
import bbm.model.account.OwnerModel;

import java.util.List;

public class SoldDetailsView {
    public void viewSoldOrders(){
        List<SoldDetails> soldDetailsList = OwnerModel.getSoldDetails();
        if (!soldDetailsList.isEmpty()) {
            System.out.println("Ordered Bike Details :");
            for (SoldDetails i : soldDetailsList) {
                System.out.println("Customer Id : " + i.getCustomerId() + "\tBike Id : " + i.getBikeId() + "\tDealer Id : " + i.getSalesExecutiveId());
            }
        }
        else{
            System.out.println("Sorry Currently no bike sold");
        }
    }
}
