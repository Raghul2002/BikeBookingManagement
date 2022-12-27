package bbm.owner;

import bbm.model.DataManager;
import bbm.model.account.*;
import bbm.model.interfaces.IDataManager;
import bbm.utility.UserView.UtilOwnerView;
import bbm.enumUserDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnerController {
    IDataManager dataManager = new DataManager();
    protected void addManager(Owner owner, HashMap<enumUserDetails, Object> details) {
        String firstName = (String) details.get(enumUserDetails.FIRST_NAME);
        String lastName = (String) details.get(enumUserDetails.LAST_NAME);
        String userName = (String) details.get(enumUserDetails.USER_NAME);
        String password = (String) details.get(enumUserDetails.PASSWORD);
        String emailId = (String) details.get(enumUserDetails.EMAIL_ID);
        Long phoneNo = (Long) details.get(enumUserDetails.PHONE_NO);
        Manager manager = new Manager(firstName, lastName, userName, password, emailId, phoneNo);
        dataManager.addUser(manager);
    }
    protected void addSalesExecutive(Owner owner,HashMap<enumUserDetails, Object> details) {
        String firstName = (String) details.get(enumUserDetails.FIRST_NAME);
        String lastName = (String) details.get(enumUserDetails.LAST_NAME);
        String userName = (String) details.get(enumUserDetails.USER_NAME);
        String password = (String) details.get(enumUserDetails.PASSWORD);
        String emailId = (String) details.get(enumUserDetails.EMAIL_ID);
        Long phoneNo = (Long) details.get(enumUserDetails.PHONE_NO);
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
    protected void showPersonalDetails(Owner owner){
        List<Owner> userList = new ArrayList<>();
        userList.add(owner);
        UtilOwnerView.showOwnerDetail(userList);
    }
}