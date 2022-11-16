package bbm.view;

import bbm.model.account.OwnerModel;

public class OwnerView {
    private static void ownerHeader(){
        divider();
        System.out.printf("|%15s |%15s |%15s |%20s |%15s |\n","First Name","Last Name","User Name","Email Id","Phone No");
        divider();
    }
    static private void printOwner(OwnerModel i){
        System.out.format("|%15s |%15s |%15s |%20s |%15s |\n",i.getFirstName(),i.getLastName(),i.getUserName(),i.getEmailId(),i.getPhoneNo());
    }
    public void showPersonalDetail(OwnerModel account){
        ownerHeader();
        printOwner(account);
        divider();
    }
    private static void divider(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }

}
