package bbm.backend;

import bbm.customer.Customer;
import bbm.manager.Manager;
import bbm.model.account.User;
import bbm.owner.Owner;
import bbm.salesExecutive.SalesExecutive;

import java.util.List;

public class AccountAuthentication {
    IDatabase db = Database.getInstance();
    List<Owner> ownerList = db.getOwnerList();
    List<Manager> managerList = db.getManagerList();
    List<SalesExecutive> salesExecutiveList = db.getSalesExecutiveList();
    List<Customer> customerList = db.getCustomerList();
    public User authenticateOwner(User account){
        for (User i : ownerList)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public User authenticateManager(User account){
        for (Manager i : managerList)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public User authenticateSalesExecutive(User account){
        for (SalesExecutive i : salesExecutiveList)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public User authenticateCustomer(User account){
        for (Customer i : customerList)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
}