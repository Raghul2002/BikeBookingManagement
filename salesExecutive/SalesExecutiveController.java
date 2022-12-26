package bbm.salesExecutive;

import bbm.model.DataManager;
import bbm.model.SoldDetails;
import bbm.model.bike.BikeStatus;

import java.util.List;

public class SalesExecutiveController {
    DataManager dataManager = new DataManager();
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
}
