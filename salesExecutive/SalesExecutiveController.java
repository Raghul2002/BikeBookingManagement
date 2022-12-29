package bbm.salesExecutive;

import bbm.enumPackage.EnumBikeTypes;
import bbm.enumPackage.EnumUserDetails;
import bbm.manager.EBikeManagerController;
import bbm.manager.MBikeManagerController;
import bbm.model.DataManager;
import bbm.model.OrderDetails;
import bbm.model.account.Customer;
import bbm.model.account.SalesExecutive;
import bbm.utility.UserView.UtilSalesExecutiveView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SalesExecutiveController {
    DataManager dataManager = new DataManager();
    EBikeManagerController eBikeManagerController = new EBikeManagerController();
    MBikeManagerController mBikeManagerController = new MBikeManagerController();

    public boolean compareBike(List<Integer> bikeDetails) {
        if (bikeDetails.get(1).equals(bikeDetails.get(2)))
            return false;
        switch (bikeDetails.get(0)) {
            case 1:
                mBikeManagerController.compareBike(bikeDetails.get(1), bikeDetails.get(2));
                break;
            case 2:
                eBikeManagerController.compareBike(bikeDetails.get(1), bikeDetails.get(2));
                break;
            default:
                return false;
        }
        return true;
    }

    protected void showPersonalDetails(SalesExecutive salesExecutive) {
        List<SalesExecutive> userList = new ArrayList<>();
        userList.add(salesExecutive);
        UtilSalesExecutiveView.showSalesExecutiveDetails(userList);
    }

    public boolean buyBike(int customerId, int bikeId, EnumBikeTypes bikeType) {
        OrderDetails orderDetails = new OrderDetails(bikeId, customerId);
        if (bikeType.equals(EnumBikeTypes.MECHANICAL_BIKE)) {
            return mBikeManagerController.addOrderDetails(orderDetails);
        }
        return eBikeManagerController.addOrderDetails(orderDetails);
    }

    public void addCustomer(HashMap<EnumUserDetails, Object> details) {
        String firstName = (String) details.get(EnumUserDetails.FIRST_NAME);
        String lastName = (String) details.get(EnumUserDetails.LAST_NAME);
        String userName = (String) details.get(EnumUserDetails.USER_NAME);
        String password = (String) details.get(EnumUserDetails.PASSWORD);
        String emailId = (String) details.get(EnumUserDetails.EMAIL_ID);
        Long phoneNo = (Long) details.get(EnumUserDetails.PHONE_NO);
        Customer customer = new Customer(firstName, lastName, userName, password, emailId, phoneNo);
        dataManager.addUser(customer);
    }
}
