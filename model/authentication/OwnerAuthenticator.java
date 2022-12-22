package bbm.model.authentication;

import bbm.model.account.Owner;
import bbm.model.account.User;

import java.util.List;

public class OwnerAuthenticator implements IUserAuthentication{
    List<Owner> ownerList = db.getOwnerList();
    public User authenticate(List<String> loginCredentials){
        for (Owner i : ownerList)
            if( i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
