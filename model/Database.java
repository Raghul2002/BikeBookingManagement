package bbm.model;

import bbm.model.account.CustomerModel;
import bbm.model.account.OwnerModel;
import bbm.model.account.SalesExecutiveModel;
import bbm.model.account.ManagerModel;
import bbm.model.bike.EBikeModel;
import bbm.model.bike.MBikeModel;

import java.util.ArrayList;
import java.util.List;
public class Database {
    private static Database database;
    private Database(){}
    public static Database getInstance(){
        if (database == null)
            database = new Database();
        return database;
    }
    final private static List<OwnerModel> ownerList = new ArrayList<>();
    final private static List<ManagerModel> managerList = new ArrayList<>();
    final private static List<SalesExecutiveModel> salesExecutiveList = new ArrayList<>();
    final private static List<CustomerModel> customerList = new ArrayList<>();
    final private static List<EBikeModel> eBikeList = new ArrayList<>();
    final private static List<MBikeModel> mBikeList = new ArrayList<>();
    final private static List<SoldDetails> soldDetailsList = new ArrayList<>();
    public void addOwner(OwnerModel owner){
        ownerList.add(owner);
    }
    public void addCustomer(CustomerModel customer){
        customerList.add(customer);
    }
    public void addSalesExecutive(SalesExecutiveModel salesExecutive){
        salesExecutiveList.add(salesExecutive);
    }
    public void addManager(ManagerModel manager){
        managerList.add(manager);
    }
    public void addEBike(EBikeModel eBike,ManagerModel manager){
        eBikeList.add(eBike);
    }
    public void addMBike(MBikeModel mBike,ManagerModel manager){
        mBikeList.add(mBike);
    }
    public boolean removeSalesExecutive(int id){
        for (SalesExecutiveModel i : salesExecutiveList) {
            if( i.getSalesExecutiveId() == id){
                salesExecutiveList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean removeManager(int id){
        for (ManagerModel i : managerList) {
            if( i.getManagerId() == id){
                managerList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean removeMBike(int mBikeId,ManagerModel manager){
        for (MBikeModel i : mBikeList) {
            if( i.getBikeId() == mBikeId){
                mBikeList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean removeEBike(int eBikeId,ManagerModel manager){
        for (EBikeModel i : eBikeList) {
            if( i.getBikeId() == eBikeId){
                eBikeList.remove(i);
                return true;
            }
        }
        return false;
    }
    public List<CustomerModel> getCustomerList(){
        return customerList;
    }
    public List<SalesExecutiveModel> getSalesExecutiveList(){
        return salesExecutiveList;
    }
    public List<ManagerModel> getManagerList(){
        return managerList;
    }
    public List<OwnerModel> getOwnerList(){
        return ownerList;
    }
    public List<EBikeModel> getEBikeList(){
        return eBikeList;
    }
    public List<MBikeModel> getMBikeList(){
        return mBikeList;
    }
    public void addOrderDetails(SoldDetails soldDetails){
        soldDetailsList.add(soldDetails);
    }
    public List<SoldDetails> getSoldDetailsList(){
        return soldDetailsList;
    }
    public boolean setBikeAvailabilityStatus(int bikeId, String status){
        boolean flag = false;
        for (MBikeModel i : mBikeList) {
            if (i.getBikeId() == bikeId ){
                i.setAvailabilityStatus(status);
                flag = true;
            }
        }
        for (EBikeModel i : eBikeList) {
            if (i.getBikeId() == bikeId ){
                i.setAvailabilityStatus(status);
                flag = true;
            }
        }
        return flag;
    }
    public void setBooking(SoldDetails soldDetails,int indexNo){
        soldDetailsList.set(indexNo,soldDetails);
    }

}