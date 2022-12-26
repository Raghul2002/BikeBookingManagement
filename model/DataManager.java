package bbm.model;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;
import bbm.model.interfaces.IDataManager;

import java.util.List;

public class DataManager implements IDataManager {
    IDatabase db = Database.getInstance();


    @Override
    public void addUser(Manager manager) {
        db.addUser(manager);
    }

    @Override
    public void addUser(SalesExecutive salesExecutive) {
        db.addUser(salesExecutive);
    }
    public void addUser(Owner owner) {
        db.addUser(owner);
    }

    public void addUser(Customer customer) {
        db.addUser(customer);
    }

    @Override
    public void addBike(EBike eBike, Manager manager) {
         db.addBike(eBike);
    }

    @Override
    public void addBike(MBike mBike, Manager manager) {
        System.out.println("HIII");
        db.addBike(mBike);
    }

    @Override
    public void removeUser(SalesExecutive salesExecutive) {
        db.removeUser(salesExecutive);
    }

    @Override
    public void removeUser(Owner owner) {
        db.removeUser(owner);
    }

    @Override
    public void removeUser(Customer customer) {
        db.removeUser(customer);
    }

    @Override
    public void removeUser(Manager manager) {
        db.removeUser(manager);
    }

    @Override
    public void removeBike(EBike eBike, Manager manager) {
        db.removeBike(eBike);
    }

    @Override
    public void removeBike(MBike mBike, Manager manager) {
        db.removeBike(mBike);
    }

    @Override
    public List<Customer> getCustomerList() {
        return db.getCustomerList();
    }

    @Override
    public List<SalesExecutive> getSalesExecutiveList() {
        return db.getSalesExecutiveList();
    }

    @Override
    public List<Manager> getManagerList() {
        return db.getManagerList();
    }

    @Override
    public List<Owner> getOwnerList() {
        return db.getOwnerList();
    }

    @Override
    public List<EBike> getEBikeList() {
        return db.getEBikeList();
    }

    @Override
    public List<MBike> getMBikeList() {
        return db.getMBikeList();
    }

    @Override
    public void addOrderDetails(SoldDetails soldDetails) {

    }

    @Override
    public List<SoldDetails> getSoldDetailsList() {
        return null;
    }

    @Override
    public void setBooking(SoldDetails soldDetails, int indexNo) {

    }


}