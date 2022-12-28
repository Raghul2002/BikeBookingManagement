package bbm.salesExecutive;

import bbm.enumPackage.EnumBikeTypes;
import bbm.enumPackage.EnumUserDetails;
import bbm.manager.EBikeManagerController;
import bbm.manager.MBikeManagerController;
import bbm.model.DataManager;
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
    public void confirmBooking() {
//        for (SoldDetails i : dataManager.getSoldDetailsList()) {
//            if(i.getSalesExecutiveId() == 0) {
//                List<SoldDetails> soldDetailsList = dataManager.getSoldDetailsList();
//                int indexNo = soldDetailsList.indexOf(i);
//                SoldDetails soldDetails = SoldDetails.builder().setSalesExecutiveId(salesExecutiveId).setBikeId(i.getBikeId()).setCustomerId(i.getCustomerId()).build();
//                setBikeStatus(i.getBikeId(), BikeStatus.SOLD.toString());
//                dataManager.setBooking(soldDetails,indexNo);
//            }
//        }
    }

    public void compareBike(List<Integer> bikeDetails) {
        if (bikeDetails.get(1).equals(bikeDetails.get(2)))
            System.out.println("Enter valid comparison!! You are comparing same bike ");
        else
            switch (bikeDetails.get(0)) {
                case 1:
                    System.out.println("Mechanical Bikes  :");
                    mBikeManagerController.compareBike(bikeDetails.get(1),bikeDetails.get(2));
                    break;
                case 2:
                    System.out.println("Electrical Bikes  :");
                    eBikeManagerController.compareBike(bikeDetails.get(1),bikeDetails.get(2));
                    break;
                default:
                    System.out.println("Enter valid input!!!");
            }
    }
    protected void showPersonalDetails(SalesExecutive salesExecutive){
        List<SalesExecutive> userList = new ArrayList<>();
        userList.add(salesExecutive);
        UtilSalesExecutiveView.showSalesExecutiveDetails(userList);
    }
    public void buyBike(int customerId, EnumBikeTypes bikeType,int bikeId) {
//        if (OwnerModel.buyBike(bikeId)) {
//            //SoldDetails.addBookingDetails(bikeId, customerId);
//            System.out.println("Thank you for Booking ! \nYour Bike will be delivered");
//        } else
//            System.out.println("The Bike ID you entered does not exist !!! Try Again");
    }
    public void addCustomer(HashMap<EnumUserDetails, Object> details){
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
