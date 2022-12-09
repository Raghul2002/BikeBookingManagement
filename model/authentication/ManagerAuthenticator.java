package bbm.model.authentication;

import bbm.model.account.Manager;
import bbm.model.account.User;

import java.util.List;

public class ManagerAuthenticator implements IUserAuthentication {
    List<Manager> managerList = db.getManagerList();
    @Override
    public User authenticate(User account) {
        for (Manager i : managerList)
            if (i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
}
