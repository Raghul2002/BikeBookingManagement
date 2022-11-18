package bbm.controller;

import bbm.controller.account.CustomerController;
import bbm.controller.account.ManagerController;
import bbm.controller.account.OwnerController;
import bbm.controller.account.SalesExecutiveController;
import bbm.view.*;

import java.util.Scanner;

public class InstanceGetter {
    //demo
    private static InstanceGetter single_instance = null;
    private final Scanner sc = new Scanner(System.in);

    private InstanceGetter() {
    }

    public static InstanceGetter receiveInstance() {
        if (single_instance == null) {
            single_instance = new InstanceGetter();
        }
        return single_instance;
    }

    public Scanner getScannerInstance() {
        return sc;
    }

    public BikeView getBikeViewInstance() {
        return new BikeView();
    }

    public OwnerController getOwnerController() {

        return new OwnerController();
    }

    public CustomerController getCustomerController() {
        return new CustomerController();
    }

    public ManagerController getManagerController() {

        return new ManagerController();
    }

    public SalesExecutiveController getSalesExecutiveController() {
        return new SalesExecutiveController();
    }

    public AccountView getAccountView() {
        return new AccountView();
    }

    public BikeInputView getBikeInputView() {
        return new BikeInputView();
    }

    public SalesExecutiveView getSalesExecutiveView() {
        return new SalesExecutiveView();
    }

    public CustomerView getCustomerView() {
        return new CustomerView();
    }

    public ManagerView getManagerView() {
        return new ManagerView();
    }
    public OwnerView getOwnerView(){
        return new OwnerView();
    }
    public SoldDetailsView getSoldDetailsView(){
        return new SoldDetailsView();
    }
}
