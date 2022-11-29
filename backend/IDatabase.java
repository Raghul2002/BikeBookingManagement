package bbm.backend;

import bbm.model.SoldDetails;
import bbm.customer.Customer;
import bbm.manager.Manager;
import bbm.owner.Owner;
import bbm.salesExecutive.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

public interface IDatabase {

    void addOwner(Owner owner);
    void addCustomer(Customer customer);
    void addSalesExecutive(SalesExecutive salesExecutive);
    void addManager(Manager manager);
    void addBike(EBike eBike, Manager manager);
    void addBike(MBike mBike, Manager manager);
    void removeSalesExecutive(SalesExecutive salesExecutive);
    void removeManager(Manager manager);
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
