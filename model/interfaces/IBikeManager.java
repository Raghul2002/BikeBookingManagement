package bbm.model.interfaces;

import bbm.model.account.Manager;
import bbm.model.bike.Bike;
import bbm.model.bike.BikeStatus;

public interface IBikeManager {
    boolean addBike(Bike bike, Manager manager);
    boolean removeBike(int bikeId,Manager manager);
    void viewBike(String bikeStatus);
}
