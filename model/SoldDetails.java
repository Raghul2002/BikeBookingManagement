package bbm.model;

public class SoldDetails {
    private int bikeId,customerId,salesExecutiveId;
    SoldDetails(Builder builder){
        this.bikeId = builder.bikeId;
        this.customerId = builder.customerId;
        this.salesExecutiveId = builder.salesExecutiveId;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder{
        Builder(){}
        private int bikeId,customerId,salesExecutiveId;

        public Builder setBikeId(int bikeId) {
            this.bikeId = bikeId;
            return this;
        }

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setSalesExecutiveId(int salesExecutiveId) {
            this.salesExecutiveId = salesExecutiveId;
            return this;
        }
        public SoldDetails build(){
            return new SoldDetails(this);
        }
    }
    //Getters
    public int getBikeId() {
        return bikeId;
    }
    public int getCustomerId() {
        return customerId;
    }

    public int getSalesExecutiveId() {
        return salesExecutiveId;
    }
    //    public int getSalesExecutiveId() {
//        return salesExecutiveId;
//    }

//    //Database db = new Database();
//    public static void addBookingDetails(int bikeId,int customerId){
//        SoldDetails soldDetails = SoldDetails.builder().setCustomerId(customerId).setBikeId(bikeId).setSalesExecutiveId(0).build();
//        Owner.setOrderDetails(soldDetails);
//    }
}