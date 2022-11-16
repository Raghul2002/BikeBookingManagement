package bbm.model.account;


import bbm.controller.InstanceGetter;
import bbm.view.AccountView;
import bbm.model.bike.BikeStatus;
import bbm.model.bike.EBikeModel;
import bbm.model.bike.MBikeModel;
import bbm.view.BikeView;

import java.util.List;

public class SalesExecutiveModel extends AccountModel {
    private static int SEId = 1;
    private final int salesExecutiveId = SEId;
    public SalesExecutiveModel(Builder builder) {
        super(builder);
        SEId++;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder extends AccountModel.Builder<Builder> {
        Builder() {}
        @Override
        public SalesExecutiveModel build() {
            return new SalesExecutiveModel(this);
        }
    }
    public int getSalesExecutiveId() {
        return salesExecutiveId;
    }
    public static void addCustomer(){
        AccountView accountView = InstanceGetter.receiveInstance().getAccountView();
        OwnerModel.addCustomer(accountView.getSignUpDetails());
    }
    static BikeView bikeView = InstanceGetter.receiveInstance().getBikeViewInstance();
    public static void compareMBike(int bike1,int bike2){
        List<MBikeModel> mBikeList = OwnerModel.getMBikeList();
        bikeView.mBikeHeader();
        for (MBikeModel i : mBikeList) {
            if (i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE.toString()) && ( i.getBikeId()==bike1 || i.getBikeId()==bike2))
                bikeView.printMBike(i);
        }
        bikeView.mBikeDivider();
    }
    public static void compareEBike(int bike1,int bike2){
        List<EBikeModel> eBikeList = OwnerModel.getEBikeList();
        bikeView.eBikeHeader();
        for (EBikeModel i : eBikeList) {
            if (i.getAvailabilityStatus().equals(BikeStatus.AVAILABLE.toString()) && ( i.getBikeId()==bike1 || i.getBikeId()==bike2))
                bikeView.printEBike(i);
        }
        bikeView.eBikeDivider();
    }

}