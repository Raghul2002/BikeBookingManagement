package bbm.model.authentication;

import bbm.model.account.SalesExecutive;
import bbm.model.account.User;

import java.util.List;

public class SalesExecutiveAuthenticator implements IUserAuthentication{
    List<SalesExecutive> salesExecutiveList = db.getSalesExecutiveList();
    @Override
    public User authenticate(List<String> loginCredentials) {
        for (SalesExecutive i : salesExecutiveList)
            if( i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
