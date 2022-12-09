package bbm.model.authentication;

import bbm.model.account.Owner;
import bbm.model.account.User;

import java.util.List;

public class OwnerAuthenticator implements IUserAuthentication{
    List<Owner> ownerList = db.getOwnerList();
    public User authenticate(User account){
        for (User i : ownerList)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
}
