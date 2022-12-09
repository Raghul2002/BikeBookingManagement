package bbm.model.account;

import bbm.model.IPersonalAdministrator;
import bbm.model.account.User;

public class SalesExecutive extends User implements IPersonalAdministrator {
    private static int SEId = 1;
    private final int salesExecutiveId = SEId;

    public SalesExecutive(String firstName, String lastName, String userName, String password, String emailId, long phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        SEId++;
    }
    public int getSalesExecutiveId() {
        return salesExecutiveId;
    }

    @Override
    public void editDetails() {

    }

    @Override
    public void printDetails() {

    }
}