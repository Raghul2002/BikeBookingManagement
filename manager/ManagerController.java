package bbm.manager;

import bbm.model.DataManager;
import bbm.model.account.Manager;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

public class ManagerController {
    DataManager dataManager = new DataManager();
    public void addMBike(MBike mBike, Manager manager) {
        dataManager.addBike(mBike,manager);
    }
    public void addEBike(EBike eBike, Manager manager) {
        dataManager.addBike(eBike, manager);
    }

    public boolean removeMBike(int mBikeId, Manager manager) {
        for (MBike i : dataManager.getMBikeList()) {
            if( i.getBikeId() == mBikeId){
                dataManager.removeBike(i,manager);
                return true;
            }
        }
        return false;
    }
    public boolean removeEBike(int eBikeId, Manager manager) {
        for (EBike i : dataManager.getEBikeList()) {
            if( i.getBikeId() == eBikeId){
                dataManager.removeBike(i,manager);
                return true;
            }
        }
        return false;
    }
}
