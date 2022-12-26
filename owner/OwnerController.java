package bbm.owner;

import bbm.model.DataManager;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;
import bbm.model.interfaces.IDataManager;

import java.util.HashMap;
import java.util.List;

public class OwnerController {
    IDataManager dataManager = new DataManager();
    protected void addManager(Owner owner, HashMap<String, Object> details) {
        String firstName = (String) details.get("firstName");
        String lastName = (String) details.get("lastName");
        String userName = (String) details.get("useName");
        String password = (String) details.get("password");
        String emailId = (String) details.get("emailId");
        Long phoneNo = (Long) details.get("phoneNo");
        Manager manager = new Manager(firstName, lastName, userName, password, emailId, phoneNo);
        dataManager.addUser(manager);
    }
    protected void addSalesExecutive(Owner owner,HashMap<String, Object> details) {
        String firstName = (String) details.get("firstName");
        String lastName = (String) details.get("lastName");
        String userName = (String) details.get("useName");
        String password = (String) details.get("password");
        String emailId = (String) details.get("emailId");
        Long phoneNo = (Long) details.get("phoneNo");
        SalesExecutive salesExecutive = new SalesExecutive(firstName, lastName, userName, password, emailId, phoneNo);
        dataManager.addUser(salesExecutive);
    }

    protected boolean removeManger(Owner owner,int id) {
        List <Manager> managerList = dataManager.getManagerList();
        for (Manager i : managerList) {
            if( i.getManagerId() == id){
                dataManager.removeUser(i);
                return true;
            }
        }
        return false;
    }
    protected boolean removeSalesExecutive(Owner owner,int id) {
        List <SalesExecutive> salesExecutiveList = dataManager.getSalesExecutiveList();
        for (SalesExecutive i : salesExecutiveList) {
            if( i.getSalesExecutiveId() == id){
                dataManager.removeUser(i);
                return true;
            }
        }
        return false;
    }

    protected List<Manager> getManagerList() {
        return dataManager.getManagerList();
    }
    protected List<SalesExecutive> getSalesExecutiveList() {
        return dataManager.getSalesExecutiveList();
    }
    protected List<Customer> getCustomerList() {
        return dataManager.getCustomerList();
    }
}