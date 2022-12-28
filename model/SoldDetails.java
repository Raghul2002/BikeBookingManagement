package bbm.model;

public class SoldDetails {
    private int bikeId, customerId, salesExecutiveId;

    public SoldDetails(int bikeId, int customerId, int salesExecutiveId) {
        this.bikeId = bikeId;
        this.customerId = customerId;
        this.salesExecutiveId = salesExecutiveId;
    }
    public int getBikeId() {
        return bikeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getSalesExecutiveId() {
        return salesExecutiveId;
    }
}