package bbm.owner;

import bbm.model.IPortal;

public class OwnerView implements IPortal {
    OwnerController ownerController = new OwnerController();
    public void viewPortal() {
        System.out.println("--------------------Welcome to Owner Portal---------------------------");
        System.out.println("Sign In  ");
       // AccountModel account = AccountAuthentication.authenticateOwner(accountView.getSignInDetails(), OwnerModel.getOwnerList());
//        if (account instanceof OwnerModel) {
//            OwnerModel owner = (OwnerModel)account;
//            whileLoop:
//            while (true) {
//                System.out.println("1.Add Manager\n2.Add Sales Executive\n3.Remove Manager\n4.Remove Sales Executive\n5.View Manager Details\n6.View Sales Man Details\n7.View Customer Details\n8.View Bike Details\n9.View Sold Details\n10.View Personal Details\n11.View Sold Bike Details\n12.Logout");
//                switch (sc.nextLine()) {
//                    case "1":
//                        System.out.println("Enter Manager Details :");
//                        owner.addManager(accountView.getSignUpDetails());
//                        break;
//                    case "2":
//                        System.out.println("Enter Sales Executive Details :");
//                        owner.addSalesExecutive(accountView.getSignUpDetails());
//                        break;
//                    case "3":
//                        System.out.println("Enter manager id you want to remove :");
//                        if (owner.removeManger(sc.nextInt()))
//                            System.out.println("Successfully Removed");
//                        else
//                            System.out.println("Failed, Enter valid Manager Id !");
//                        break;
//                    case "4":
//                        System.out.println("Enter Sales Executive id you want to remove :");
//                        if (owner.removeSalesExecutive(sc.nextInt()))
//                            System.out.println("Successfully Removed");
//                        else
//                            System.out.println("Failed, Enter valid Manager Id !");
//                        break;
//                    case "5":
//                        managerView.showManagerDetails(OwnerModel.getManagerList());
//                        break;
//                    case "6":
//                        salesExecutiveView.showSalesExecutiveDetails(OwnerModel.getSalesExecutiveList());
//                        break;
//                    case "7":
//                        customerView.showCustomerDetails(OwnerModel.getCustomerList());
//                        break;
//                    case "8":
//                        bikeView.showBikeDetails();
//                        break;
//                    case "9":
//                        soldDetailsView.viewSoldOrders();
//                        break;
//                    case "10":
//                        ownerView.showPersonalDetail(owner);
//                        break;
//                    case "11":
//                        bikeView.showSoldBikeDetails(owner);
//                        break;
//                    case "12":
//                        break whileLoop;
//                    default:
//                        System.out.println("Enter Valid Number");
//                }
//            }
//        } else System.out.println("Invalid Credentials");
    }
}