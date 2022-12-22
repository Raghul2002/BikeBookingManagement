package bbm.model.account;


import bbm.model.interfaces.IPersonalAdministrator;

public class Customer extends User implements IPersonalAdministrator {
    private static int cId = 1;
    private final int customerId = cId;

    public Customer(String firstName, String lastName, String userName, String password, String emailId, long phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        cId++;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public void editDetails() {

    }

    @Override
    public void printDetails() {

    }
}
 