package bbm.model.account;

import bbm.model.SoldDetails;
import bbm.model.Database;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.EBikeModel;
import bbm.model.bike.MBikeModel;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

public class OwnerModel extends AccountModel {
    public OwnerModel(Builder builder) {
        super(builder);
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder extends AccountModel.Builder<Builder> {
        Builder() {}
        public OwnerModel build() {
            return new OwnerModel(this);
        }
    }


    static Database db = Database.getInstance();
    public static void addOwner(AccountModel account) {
        db.addOwner(OwnerModel.builder()
                .setUserName(account.getUserName())
                .setLastName(account.getLastName())
                .setUserName(account.getUserName())
                .setPassword(account.getPassword())
                .setEmailId(account.getEmailId())
                .setPhoneNo(account.getPhoneNo())
                .build());
    }
    public void addManager(AccountModel account) {
        db.addManager(ManagerModel.builder()
                .setUserName(account.getUserName())
                .setLastName(account.getLastName())
                .setUserName(account.getUserName())
                .setPassword(account.getPassword())
                .setEmailId(account.getEmailId())
                .setPhoneNo(account.getPhoneNo())
                .build());
    }
    public void addSalesExecutive(AccountModel account) {
        db.addSalesExecutive(SalesExecutiveModel.builder()
                .setUserName(account.getUserName())
                .setLastName(account.getLastName())
                .setUserName(account.getUserName())
                .setPassword(account.getPassword())
                .setEmailId(account.getEmailId())
                .setPhoneNo(account.getPhoneNo())
                .build());
    }
    public static void addCustomer(AccountModel account) {
        db.addCustomer(CustomerModel.builder()
                .setUserName(account.getUserName())
                .setLastName(account.getLastName())
                .setUserName(account.getUserName())
                .setPassword(account.getPassword())
                .setEmailId(account.getEmailId())
                .setPhoneNo(account.getPhoneNo())
                .build());
    }
    public static List<OwnerModel> getOwnerList(){
        return new ArrayList<>(db.getOwnerList());
    }
    public static List<ManagerModel> getManagerList(){
        return new ArrayList<>(db.getManagerList());
    }
    public static List<SalesExecutiveModel> getSalesExecutiveList(){
        return new ArrayList<>(db.getSalesExecutiveList());
    }
    public static List<CustomerModel> getCustomerList(){
        return new ArrayList<>(db.getCustomerList());
    }
    public static List<MBikeModel> getMBikeList(){
        return new ArrayList<>(db.getMBikeList());
    }
    public static List<EBikeModel> getEBikeList(){
        return new ArrayList<>(db.getEBikeList());
    }
    public boolean removeManger(int id){
        return db.removeManager(id);
    }
    public boolean removeSalesExecutive(int id){
        return db.removeSalesExecutive(id);
    }

    public static boolean setBikeStatus(int id,String str){
        return db.setBikeAvailabilityStatus(id,str);
    }
    public static void setOrderDetails(SoldDetails soldDetails){
        db.addOrderDetails(soldDetails);
    }
    public static List<SoldDetails> getSoldDetails(){
        return db.getSoldDetailsList();
    }
    public static void confirmBooking(int salesExecutiveId){
        for (SoldDetails i : db.getSoldDetailsList()) {
            if(i.getSalesExecutiveId() == 0) {
                List<SoldDetails> soldDetailsList = db.getSoldDetailsList();
                int indexNo = soldDetailsList.indexOf(i);
                SoldDetails soldDetails = SoldDetails.builder().setSalesExecutiveId(salesExecutiveId).setBikeId(i.getBikeId()).setCustomerId(i.getCustomerId()).build();
                setBikeStatus(i.getBikeId(), BikeStatus.SOLD.toString());
                db.setBooking(soldDetails,indexNo);
            }
        }
    }
    public static boolean buyBike(int bikeId){
        for (MBikeModel i : db.getMBikeList()) {
            if (i.getBikeId() == bikeId ){
                if(i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE.toString()))
                    return setBikeStatus(bikeId,BikeStatus.RESERVED.toString());
            }
        }
        for (EBikeModel i : db.getEBikeList()) {
            if (i.getBikeId() == bikeId ){
                if(i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE.toString()))
                    return setBikeStatus(bikeId,BikeStatus.RESERVED.toString());
            }
        }
        return  false;
    }
}