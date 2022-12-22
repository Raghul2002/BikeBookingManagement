package bbm.model.interfaces;

import bbm.model.account.Manager;
import bbm.model.account.SalesExecutive;

public interface IUserAdministrator {
    void addUser(Manager manager);
    void addUser(SalesExecutive salesExecutive);
    void removeUser(Manager manager);
    void removeUser(SalesExecutive salesExecutive);
}
