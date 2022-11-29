package bbm.backend;

import bbm.model.SoldDetails;
import bbm.customer.Customer;
import bbm.owner.Owner;
import bbm.salesExecutive.SalesExecutive;
import bbm.manager.Manager;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

import java.util.ArrayList;
import java.util.List;

public class Database implements IDatabase {
    private static Database database;

    private Database() {
    }

    public static Database getInstance() {
        if (database == null) database = new Database();
        return database;
    }

    final private List<Owner> ownerList = new ArrayList<>();
    final private List<Manager> managerList = new ArrayList<>();
    final private List<SalesExecutive> salesExecutiveList = new ArrayList<>();
    final private List<Customer> customerList = new ArrayList<>();
    final private List<EBike> eBikeList = new ArrayList<>();
    final private List<MBike> mBikeList = new ArrayList<>();
    final private List<SoldDetails> soldDetailsList = new ArrayList<>();

    public void addOwner(Owner owner) {
        ownerList.add(owner);
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void addSalesExecutive(SalesExecutive salesExecutive) {
        salesExecutiveList.add(salesExecutive);
    }

    public void addManager(Manager manager) {
        managerList.add(manager);
    }

    public void addBike(EBike eBike, Manager manager) {
        eBikeList.add(eBike);
    }

    public void addBike(MBike mBike, Manager manager) {
        mBikeList.add(mBike);
    }

    public void removeSalesExecutive(SalesExecutive salesExecutive) {
        salesExecutiveList.remove(salesExecutive);
    }

    public void removeManager(Manager manager) {

        managerList.remove(manager);
    }

    @Override
    public void removeBike(EBike eBike, Manager manager) {
        eBikeList.remove(eBike);

    }

    @Override
    public void removeBike(MBike mBike, Manager manager) {
        mBikeList.remove(mBike);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<SalesExecutive> getSalesExecutiveList() {
        return salesExecutiveList;
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public List<EBike> getEBikeList() {
        return eBikeList;
    }

    public List<MBike> getMBikeList() {
        return mBikeList;
    }

    public void addOrderDetails(SoldDetails soldDetails) {
        soldDetailsList.add(soldDetails);
    }

    public List<SoldDetails> getSoldDetailsList() {
        return soldDetailsList;
    }

    @Override
    public void setBooking(SoldDetails soldDetails, int indexNo) {

    }


}