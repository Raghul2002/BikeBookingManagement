package bbm.manager;

import bbm.model.DataManager;
import bbm.model.OrderDetails;
import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.MBike;
import bbm.model.interfaces.IBikeManager;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;


public class MBikeManagerController implements IBikeManager {
    DataManager dataManager = new DataManager();
    @Override
    public boolean addBike(Bike bike, Manager manager) {
        if(bike instanceof MBike) {
            dataManager.addBike((MBike) bike, manager);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeBike(int bikeId, Manager manager) {
        for (MBike i : dataManager.getMBikeList()) {
            if( i.getBikeId() == bikeId){
                dataManager.removeBike(i,manager);
                return true;
            }
        }
        return false;
    }

    public void viewBike(BikeStatus bikeStatus){
        List<MBike> mBikeList = dataManager.getMBikeList();
        List<MBike> mBikes = new ArrayList<>();
        for(MBike bike:mBikeList){
            if(bike.getAvailabilityStatus().equals( bikeStatus))
                mBikes.add(bike);
        }
        UtilBikeView.printMBikeList(mBikes);
    }


    @Override
    public void compareBike(int bikeId1, int bikeId2) {
        List<MBike> mBikeList = dataManager.getMBikeList();
        List<MBike> mBikes = new ArrayList<>();
        for (MBike i : mBikeList) {
            if (i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE.toString()) && (i.getBikeId() == bikeId1 || i.getBikeId() == bikeId2))
                mBikes.add(i);
        }
        UtilBikeView.printMBikeList(mBikes);
    }
    public boolean addOrderDetails(OrderDetails orderDetails){
        for (Bike bike : dataManager.getMBikeList())
            if (orderDetails.getBikeId() == bike.getBikeId()) {
                dataManager.addOrderDetails(orderDetails);
                setBikeStatus(bike,BikeStatus.RESERVED);
                return true;
            }
        return false;
    }
    public void setBikeStatus(Bike bike, BikeStatus bikeStatus){
        bike.setAvailabilityStatus(bikeStatus);
    }

}
