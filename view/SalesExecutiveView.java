package bbm.view;

import bbm.model.account.SalesExecutiveModel;

import java.util.List;

public class SalesExecutiveView {
    private void salesExecutiveHeader() {
        divider();
        System.out.printf("|%18s |%15s |%15s |%15s |%20s |%15s |\n", "SalesExecutive Id", "First Name", "Last Name", "User Name", "Email Id", "Phone No");
        divider();
    }

    private void printSalesExecutive(SalesExecutiveModel i) {
        System.out.format("|%18s |%15s |%15s |%15s |%20s |%15s |\n", i.getSalesExecutiveId(), i.getFirstName(), i.getLastName(), i.getUserName(), i.getEmailId(), i.getPhoneNo());
    }

    public void showSalesExecutiveDetails(List<SalesExecutiveModel> salesExecutiveList) {
        if (!salesExecutiveList.isEmpty()) {
            System.out.println("Sales Executive Details :");
            salesExecutiveHeader();
            for (SalesExecutiveModel i : salesExecutiveList) {
                printSalesExecutive(i);
            }
            divider();
        } else System.out.println("Sorry !!\nCurrently no sales executives registered");
    }

    public void showPersonalDetail(SalesExecutiveModel account) {
        salesExecutiveHeader();
        printSalesExecutive(account);
        divider();
    }

    private void divider() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}
