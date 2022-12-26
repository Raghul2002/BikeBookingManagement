package bbm.model.authentication;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.Manager;
import bbm.model.account.User;

import java.util.List;

public class ManagerAuthenticator implements IUserAuthentication {
    @Override
    public User authenticate(List<String> loginCredentials) {
        IDatabase db = Database.getInstance();
        List<Manager> managerList = db.getManagerList();
        for (Manager i : managerList)
            if (i.getUserName().equals(loginCredentials.get(0)) && i.getPassword().equals(loginCredentials.get(1)))
                return i;
        return null;
    }
}
