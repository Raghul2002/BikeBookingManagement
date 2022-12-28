package bbm.manager;

import bbm.enumPackage.EnumBikeTypes;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.BikeStatus;
import bbm.utility.UserView.UtilManagerView;
import bbm.utility.UtilBikeInput;

import java.util.ArrayList;
import java.util.List;

public class BikeManagerController {
    EBikeManagerController eBikeManager = new EBikeManagerController();
    MBikeManagerController mBikeManager = new MBikeManagerController();
    private void viewAvailableEBike(){
        BikeStatus bikeStatus = BikeStatus.AVAILABLE;
        eBikeManager.viewBike(bikeStatus.toString());
    }
    private void viewAvailableMBike(){
        BikeStatus bikeStatus = BikeStatus.AVAILABLE;
        mBikeManager.viewBike(bikeStatus.toString());
    }
    public void viewAvailableBike(){
        viewAvailableMBike();
        viewAvailableEBike();
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
    protected void showPersonalDetails(Manager manager){
        List<Manager> userList = new ArrayList<>();
        userList.add(manager);
        UtilManagerView.showManagerDetails(userList);
    }

    public int getBikeId(EnumBikeTypes bikeType) {
        if(EnumBikeTypes.MECHANICAL_BIKE.equals(bikeType))
            viewAvailableMBike();
        else viewAvailableEBike();
        return UtilBikeInput.getBikeId();
    }

    public EnumBikeTypes getBikeType() {
        return UtilBikeInput.getBikeType();
    }
}
