package bbm.utility;

import bbm.model.OrderDetails;

import java.util.List;

public class UtilOrderDetailsView {
    private UtilOrderDetailsView(){}
    public static void viewOrderDetails(List<OrderDetails> orderDetails){
            if (!orderDetails.isEmpty()) {
                System.out.println("Ordered Bike Details :");
                for (OrderDetails i : orderDetails) {
                    System.out.println("Customer Id : " + i.getCustomerId() + "\tBike Id : " + i.getBikeId() + "\tDealer Id : " + i.getSalesExecutiveId());
                }
            }
            else{
                System.out.println("Sorry Currently no bike sold");
            }
        
    }
}
