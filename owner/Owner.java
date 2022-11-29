package bbm.owner;

import bbm.backend.Database;
import bbm.backend.IDatabase;
import bbm.manager.Manager;
import bbm.model.IPersonalAdministrator;
import bbm.model.IUserAdministrator;
import bbm.model.account.User;
import bbm.salesExecutive.SalesExecutive;

public class Owner extends User implements IUserAdministrator, IPersonalAdministrator{
    public Owner(String firstName, String lastName, String userName, String password, String emailId, long phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
    }
    IDatabase db = Database.getInstance();
    @Override
    public void editDetails() {

    }

    @Override
    public void printDetails() {

    }

    @Override
    public void addUser(Manager manager) {
        db.addManager(manager);
    }

    @Override
    public void addUser(SalesExecutive salesExecutive) {

    }

    @Override
    public void removeUser(Manager manager) {

    }

    @Override
    public void removeUser(SalesExecutive salesExecutive) {

    }
}