package bbm.model.account;

import bbm.model.interfaces.IBikeAdministrator;
import bbm.model.interfaces.IPersonalAdministrator;
import bbm.model.bike.EBike;
import bbm.model.bike.MBike;

public class Manager extends User  {
    private static int mId = 1;
    private final int managerId ;

    public Manager(String firstName, String lastName, String userName, String password, String emailId, long phoneNo) {
        super(firstName, lastName, userName, password, emailId, phoneNo);
        this.managerId = mId;
        mId++;
    }
    public int getManagerId() {
        return managerId;
    }

}