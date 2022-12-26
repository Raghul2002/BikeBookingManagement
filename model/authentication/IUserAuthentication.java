package bbm.model.authentication;
import bbm.model.account.User;

import java.util.List;

public interface IUserAuthentication {
    User authenticate(List<String> loginCredentials);
}