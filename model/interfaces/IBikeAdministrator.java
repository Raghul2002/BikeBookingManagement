package bbm.model.interfaces;

import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

public interface IBikeAdministrator {
    void addBike(MBike Bike);
    void addBike(EBike Bike);
    void removeBike(MBike bike);
    void removeBike(EBike bike);
}
