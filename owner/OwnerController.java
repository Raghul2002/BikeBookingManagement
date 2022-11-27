package bbm.owner;

import bbm.manager.Manager;
import bbm.model.IPersonalAdministrator;
import bbm.model.IUserAdministrator;
import bbm.salesExecutive.SalesExecutive;

public class OwnerController implements IUserAdministrator, IPersonalAdministrator {
    @Override
    public void addUser(Manager manager) {
        System.out.println("HI");
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

    @Override
    public void editDetails() {

    }

    @Override
    public void printDetails() {

    }
}
