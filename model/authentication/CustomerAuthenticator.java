package bbm.model.authentication;

import bbm.model.account.Customer;
import bbm.model.account.User;

import java.util.List;

public class CustomerAuthenticator implements IUserAuthentication{
    List<Customer> customerList = db.getCustomerList();
    @Override
    public User authenticate(List<String> loginCredentials){
        for (Customer i : customerList)
            if( i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
