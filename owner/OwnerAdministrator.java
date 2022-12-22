package bbm.owner;

import bbm.model.account.Owner;

public class OwnerAdministrator {
    private static void ownerHeader(){
        divider();
        System.out.printf("|%15s |%15s |%15s |%20s |%15s |\n","First Name","Last Name","User Name","Email Id","Phone No");
        divider();
    }
    private void printOwner(Owner i){
        System.out.format("|%15s |%15s |%15s |%20s |%15s |\n",i.getFirstName(),i.getLastName(),i.getUserName(),i.getEmailId(),i.getPhoneNo());
    }
    private static void divider(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }
    protected void showPersonalDetail(Owner account){
        ownerHeader();
        printOwner(account);
        divider();
    }
}
