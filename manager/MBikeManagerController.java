package bbm.manager;

import bbm.model.DataManager;
import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.MBike;
import bbm.model.interfaces.IBikeManager;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MBikeManagerController implements IBikeManager {
    DataManager dataManager = new DataManager();
    UtilBikeView bikeView = new UtilBikeView();
    @Override
    public boolean addBike(Bike bike, Manager manager) {
        if(bike instanceof MBike) {
            System.out.println("HII");
            dataManager.addBike((MBike) bike, manager);
            return true;
        }
        else
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

    public void viewBike(String bikeStatus){
        List<MBike> mBikeList = dataManager.getMBikeList();
        List<MBike> mBikes = new ArrayList<>();
        for(MBike bike:mBikeList){
            if(bike.getAvailabilityStatus().equals( bikeStatus))
                mBikes.add(bike);
        }
        bikeView.printMBikeList(mBikes);
    }
}
