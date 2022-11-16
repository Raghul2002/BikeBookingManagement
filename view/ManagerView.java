package bbm.view;

import bbm.model.account.ManagerModel;

import java.util.List;

public class ManagerView {
    private void managerHeader(){
        divider();
        System.out.printf("|%11s |%15s |%15s |%15s |%20s |%15s |\n","Manager Id","First Name","Last Name","User Name","Email Id","Phone No");
        divider();
    }
    private void printManager(ManagerModel i){
        System.out.format("|%11s |%15s |%15s |%15s |%20s |%15s |\n",i.getManagerId(),i.getFirstName(),i.getLastName(),i.getUserName(),i.getEmailId(),i.getPhoneNo());
    }
    public void showManagerDetails(List<ManagerModel> managerList){
        if (!managerList.isEmpty()) {
            System.out.println("Manager Details :");
            managerHeader();
            for (ManagerModel i : managerList) {
                printManager(i);
            }
            divider();
        }
        else System.out.println("Sorry !!\nCurrently no managers registered");
    }
    public void showPersonalDetail(ManagerModel account){
        managerHeader();
        printManager(account);
        divider();
    }
    private void divider(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}