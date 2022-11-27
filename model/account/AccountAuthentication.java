package bbm.model.account;

import bbm.customer.Customer;
import bbm.manager.Manager;
import bbm.owner.Owner;
import bbm.salesExecutive.SalesExecutive;

import java.util.List;

public class AccountAuthentication {
    public static User authenticateOwner(User account, List<Owner> list){
        for (User i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public static User authenticateManager(User account, List<Manager> list){
        for (Manager i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public static User authenticateSalesExecutive(User account, List<SalesExecutive> list){
        for (SalesExecutive i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public static User authenticateCustomer(User account, List<Customer> list){
        for (Customer i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
}