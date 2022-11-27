package bbm.owner;

import bbm.manager.Manager;
import bbm.model.IUserAdministrator;

public class OwnerView {
    IUserAdministrator ownerController = new OwnerController();
    public void set(){
        Manager manager = new Manager("2","2","2","2","2",2);
        ownerController.addUser(manager);
    }
}
