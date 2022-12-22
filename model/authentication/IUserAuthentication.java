package bbm.model.authentication;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.User;

import java.util.List;

public interface IUserAuthentication {
    IDatabase db = Database.getInstance();
    User authenticate(List<String> loginCredentials);
}