package bbm.owner;

import bbm.database.Database;
import bbm.database.IDatabase;
import bbm.model.account.Customer;
import bbm.model.account.Manager;
import bbm.model.account.Owner;
import bbm.model.account.SalesExecutive;

import java.util.HashMap;
import java.util.List;

public class OwnerController {
    IDatabase db = Database.getInstance();
    protected void addManager(Owner owner, HashMap<String, Object> details) {
        String firstName = (String) details.get("firstName");
        String lastName = (String) details.get("lastName");
        String userName = (String) details.get("useName");
        String password = (String) details.get("password");
        String emailId = (String) details.get("emailId");
        Long phoneNo = (Long) details.get("phoneNo");
        Manager manager = new Manager(firstName, lastName, userName, password, emailId, phoneNo);
        owner.addUser(manager);
    }
    protected void addSalesExecutive(Owner owner,HashMap<String, Object> details) {
        String firstName = (String) details.get("firstName");
        String lastName = (String) details.get("lastName");
        String userName = (String) details.get("useName");
        String password = (String) details.get("password");
        String emailId = (String) details.get("emailId");
        Long phoneNo = (Long) details.get("phoneNo");
        SalesExecutive salesExecutive = new SalesExecutive(firstName, lastName, userName, password, emailId, phoneNo);
        owner.addUser(salesExecutive);
    }

    protected boolean removeManger(Owner owner,int id) {
        List <Manager> managerList = db.getManagerList();
        for (Manager i : managerList) {
            if( i.getManagerId() == id){
                owner.removeUser(i);
                return true;
            }
        }
        return false;
    }
    protected boolean removeSalesExecutive(Owner owner,int id) {
        List <SalesExecutive> salesExecutiveList = db.getSalesExecutiveList();
        for (SalesExecutive i : salesExecutiveList) {
            if( i.getSalesExecutiveId() == id){
                owner.removeUser(i);
                return true;
            }
        }
        return false;
    }

    protected List<Manager> getManagerList() {
        return db.getManagerList();
    }
    protected List<SalesExecutive> getSalesExecutiveList() {
        return db.getSalesExecutiveList();
    }
    protected List<Customer> getCustomerList() {
        return db.getCustomerList();
    }
}