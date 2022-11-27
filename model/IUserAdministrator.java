package bbm.model;

import bbm.manager.Manager;
import bbm.salesExecutive.SalesExecutive;

public interface IUserAdministrator {
    void addUser(Manager manager);
    void addUser(SalesExecutive salesExecutive);
    void removeUser(Manager manager);
    void removeUser(SalesExecutive salesExecutive);
}
