package bbm.owner;

import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;

public class OwnerController  {
    protected void addUser(Manager manager, Owner owner){
        owner.addUser(manager);
    }
    protected void addUser(SalesExecutive salesExecutive,Owner owner){
        owner.addUser(salesExecutive);
    }


}
