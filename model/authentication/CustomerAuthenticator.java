package bbm.model.authentication;

import bbm.model.account.Customer;
import bbm.model.account.User;

import java.util.List;

public class CustomerAuthenticator implements IUserAuthentication{
    List<Customer> customerList = db.getCustomerList();
    @Override
    public User authenticate(User account){
        for (Customer i : customerList)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
}
