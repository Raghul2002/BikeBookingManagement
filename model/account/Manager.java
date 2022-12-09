package bbm.model.account;

import bbm.model.IBikeAdministrator;
import bbm.model.IPersonalAdministrator;
import bbm.model.account.User;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

public class Manager extends User implements IPersonalAdministrator, IBikeAdministrator {
    private static int mId = 1;
    private final int managerId = mId;

    public Manager(String firstName, String lastName, String userName, String password, String emailId, long phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        mId++;
    }
    public int getManagerId() {
        return managerId;
    }

    @Override
    public void editDetails() {
        System.out.println("Edit");
    }
    @Override
    public void printDetails() {
        System.out.println("print");
    }

    @Override
    public void addBike(MBike Bike) {
        System.out.println("BIke Added");
    }

    @Override
    public void addBike(EBike Bike) {

    }

    @Override
    public void removeBike(MBike bike) {

    }

    @Override
    public void removeBike(EBike bike) {

    }
}