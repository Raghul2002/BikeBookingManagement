package bbm.model.account;

import java.util.List;

public class AccountAuthentication {
    public static AccountModel authenticateOwner(AccountModel account, List<OwnerModel> list){
        for (AccountModel i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public static AccountModel authenticateManager(AccountModel account, List<ManagerModel> list){
        for (ManagerModel i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public static AccountModel authenticateSalesExecutive(AccountModel account, List<SalesExecutiveModel> list){
        for (SalesExecutiveModel i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
    public static AccountModel authenticateCustomer(AccountModel account, List<CustomerModel> list){
        for (CustomerModel i : list)
            if( i.getUserName().equals(account.getUserName()) && i.getPassword().equals(account.getPassword()))
                return i;
        return account;
    }
}