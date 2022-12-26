package bbm.model.interfaces;

import bbm.model.SoldDetails;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface IDataManager {
    void addUser(Owner owner);
    void addUser(Customer customer);

    void addUser(Manager manager);
    void addUser(SalesExecutive salesExecutive);

    void removeUser(Manager manager);
    void removeUser(SalesExecutive salesExecutive);
    void removeUser(Owner owner);
    void removeUser(Customer customer);
    void addBike(EBike eBike, Manager manager);
    void addBike(MBike mBike, Manager manager);
    void removeBike(EBike eBike,Manager manager);
    void removeBike(MBike mBike,Manager manager);
    List<Customer> getCustomerList();
    List<SalesExecutive> getSalesExecutiveList();
    List<Manager> getManagerList();
    List<Owner> getOwnerList();
    List<EBike> getEBikeList();
    List<MBike> getMBikeList();
    void addOrderDetails(SoldDetails soldDetails);
    List<SoldDetails> getSoldDetailsList();
    void setBooking(SoldDetails soldDetails,int indexNo);
}
