package bbm.model.account;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.interfaces.IPersonalAdministrator;
import bbm.model.interfaces.IUserAdministrator;

public class Owner extends User implements  IPersonalAdministrator{
    public Owner(String firstName, String lastName, String userName, String password, String emailId, long phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
    }
    @Override
    public void editDetails() {

    }

    @Override
    public void printDetails() {

    }

}