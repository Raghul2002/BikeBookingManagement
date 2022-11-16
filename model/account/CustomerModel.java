package bbm.model.account;


public class CustomerModel extends AccountModel {
    private static int cId = 1;
    private final int customerId = cId;
    public CustomerModel(Builder builder) {
        super(builder);
        cId++;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AccountModel.Builder<Builder> {
        Builder() {}
        @Override
        public CustomerModel build() {
            return new CustomerModel(this);
        }
    }

    public int getCustomerId() {
        return customerId;
    }
}
 