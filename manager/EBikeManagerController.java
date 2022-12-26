package bbm.manager;

import bbm.model.DataManager;
import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.EBike;
import bbm.model.interfaces.IBikeManager;
import bbm.model.interfaces.IDataManager;
import bbm.utility.UtilBikeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EBikeManagerController implements IBikeManager {
    IDataManager dataManager = new DataManager();
    UtilBikeView bikeView = new UtilBikeView();
    @Override
    public boolean addBike(Bike bike, Manager manager) {
        if(bike instanceof EBike) {
            dataManager.addBike((EBike) bike, manager);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean removeBike(int bikeId,Manager manager) {
        for (EBike i : dataManager.getEBikeList()) {
            if( i.getBikeId() == bikeId){
                dataManager.removeBike(i,manager);
                return true;
            }
        }
        return false;
    }
    public void viewBike(String bikeStatus){
        List <EBike> eBikeList = dataManager.getEBikeList();
        List<EBike> eBikes = new ArrayList<>();
        for(EBike bike:eBikeList){
            if(bike.getAvailabilityStatus().equals(bikeStatus))
                eBikes.add(bike);
        }
        bikeView.printEBikeList(eBikes);
    }
}