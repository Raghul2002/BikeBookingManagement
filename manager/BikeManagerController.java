package bbm.manager;

import bbm.enumPackage.EnumBikeTypes;
import bbm.model.DataManager;
import bbm.model.OrderDetails;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;
import bbm.utility.UserView.UtilManagerView;
import bbm.utility.UtilBikeInput;
import bbm.utility.UtilOrderDetailsView;

import java.util.ArrayList;
import java.util.List;

public class BikeManagerController {
    EBikeManagerController eBikeManager = new EBikeManagerController();
    MBikeManagerController mBikeManager = new MBikeManagerController();
    DataManager dataManager = new DataManager();

    private void viewAvailableEBike() {
        BikeStatus bikeStatus = BikeStatus.AVAILABLE;
        eBikeManager.viewBike(bikeStatus);
    }

    private void viewAvailableMBike() {
        BikeStatus bikeStatus = BikeStatus.AVAILABLE;
        mBikeManager.viewBike(bikeStatus);
    }

    public void viewAvailableBike() {
        viewAvailableMBike();
        viewAvailableEBike();
    }

    public void viewSoldBike(Owner owner) {
        BikeStatus bikeStatus = BikeStatus.SOLD;
        eBikeManager.viewBike(bikeStatus);
        mBikeManager.viewBike(bikeStatus);
    }

    public void viewReservedBike(SalesExecutive salesExecutive) {
        BikeStatus bikeStatus = BikeStatus.RESERVED;
        eBikeManager.viewBike(bikeStatus);
        mBikeManager.viewBike(bikeStatus);
    }

    protected void showPersonalDetails(Manager manager) {
        List<Manager> userList = new ArrayList<>();
        userList.add(manager);
        UtilManagerView.showManagerDetails(userList);
    }

    public int getBikeId(EnumBikeTypes bikeType) {
        if (EnumBikeTypes.MECHANICAL_BIKE.equals(bikeType))
            viewAvailableMBike();
        else viewAvailableEBike();
        return UtilBikeInput.getBikeId();
    }


    public EnumBikeTypes getBikeType() {
        return UtilBikeInput.getBikeType();
    }


    public Bike getBike(int bikeId) {
        for (Bike bike : dataManager.getEBikeList()) {
            if (bike.getBikeId() == bikeId) {
                return bike;
            }
        }
        for (Bike bike : dataManager.getMBikeList()) {
            if (bike.getBikeId() == bikeId) {
                return bike;
            }
        }
        return null;
    }

    public void confirmBikeBooking(SalesExecutive salesExecutive) {
        int bikeId;
        Bike bike = getBike(0);
        for (OrderDetails orderDetails : dataManager.getOrderDetailsList()) {
            if (orderDetails.getSalesExecutiveId() == 0) {
                orderDetails.setSalesExecutiveId(salesExecutive.getSalesExecutiveId());
                bikeId = orderDetails.getBikeId();
                bike = getBike(bikeId);
            }
        }
        mBikeManager.setBikeStatus(bike, BikeStatus.SOLD);
    }

    public void viewSoldDetails(Owner owner) {
        List<OrderDetails> orderDetails = dataManager.getOrderDetailsList();
        UtilOrderDetailsView.viewOrderDetails(orderDetails);
    }
}
