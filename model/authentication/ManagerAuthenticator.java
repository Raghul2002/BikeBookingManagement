package bbm.model.authentication;

import bbm.model.account.Manager;
import bbm.model.account.User;

import java.util.List;

public class ManagerAuthenticator implements IUserAuthentication {
    List<Manager> managerList = db.getManagerList();
    @Override
    public User authenticate(List<String> loginCredentials) {
        for (Manager i : managerList)
            if (i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
