package bbm.manager;

import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.BikeStatus;

public class BikeManagerController {
    EBikeManagerController eBikeManager = new EBikeManagerController();
    MBikeManagerController mBikeManager = new MBikeManagerController();
    public void viewAvailableBike(){
        BikeStatus bikeStatus = BikeStatus.AVAILABLE;
        eBikeManager.viewBike(bikeStatus.toString());
        mBikeManager.viewBike(bikeStatus.toString());

    }
    public void viewSoldBike(Owner owner){
        BikeStatus bikeStatus = BikeStatus.SOLD;
        eBikeManager.viewBike(bikeStatus.toString());
        mBikeManager.viewBike(bikeStatus.toString());
    }
    public void viewReservedBike(SalesExecutive salesExecutive){
        BikeStatus bikeStatus = BikeStatus.RESERVED;
        eBikeManager.viewBike(bikeStatus.toString());
        mBikeManager.viewBike(bikeStatus.toString());
    }

}
