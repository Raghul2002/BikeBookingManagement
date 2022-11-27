package bbm.owner;

import bbm.manager.Manager;
import bbm.model.IPersonalAdministrator;
import bbm.model.IUserAdministrator;
import bbm.model.account.User;
import bbm.salesExecutive.SalesExecutive;

public class Owner extends User  {
    public Owner(String firstName, String lastName, String userName, String password, String emailId, long phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
    }
}