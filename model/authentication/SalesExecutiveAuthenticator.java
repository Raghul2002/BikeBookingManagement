package bbm.model.authentication;

import bbm.model.account.SalesExecutive;
import bbm.model.account.User;

import java.util.List;

public class SalesExecutiveAuthenticator implements IUserAuthentication{
    List<SalesExecutive> salesExecutiveList = db.getSalesExecutiveList();
    @Override
    public User authenticate(User account) {
        for (SalesExecutive i : salesExecutiveList)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
}
