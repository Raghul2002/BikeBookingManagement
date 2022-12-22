package bbm.model.account;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.interfaces.IPersonalAdministrator;
import bbm.model.interfaces.IUserAdministrator;

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
        db.addSalesExecutive(salesExecutive);
    }

    @Override
    public void removeUser(Manager manager) {
        db.removeManager(manager);
    }

    @Override
    public void removeUser(SalesExecutive salesExecutive) {
        db.removeSalesExecutive(salesExecutive);
    }

}