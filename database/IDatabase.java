package bbm.database;

import bbm.model.SoldDetails;
import bbm.customer.Customer;
import bbm.manager.Manager;
import bbm.owner.Owner;
import bbm.salesExecutive.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.List;

interface IDatabase {

    void addOwner(Owner owner);
    void addCustomer(Customer customer);
    void addSalesExecutive(SalesExecutive salesExecutive);
    void addManager(Manager manager);
    void addEBike(EBike eBike, Manager manager);
    void addMBike(MBike mBike, Manager manager);
    void removeSalesExecutive(SalesExecutive salesExecutive);
    void removeManager(Manager manager);
    void removeMBike(EBike eBike);
    void removeEBike(MBike mBike);
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
