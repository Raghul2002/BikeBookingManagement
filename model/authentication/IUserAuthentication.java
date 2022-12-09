package bbm.model.authentication;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.User;

public interface IUserAuthentication {
    IDatabase db = Database.getInstance();
    User authenticate(User Account);
}