package bbm.view;

import bbm.model.account.CustomerModel;

import java.util.List;

public class CustomerView {
    private void customerHeader() {
        divider();
        System.out.printf("|%11s |%15s |%15s |%15s |%20s |%15s |\n", "Customer Id", "First Name", "Last Name", "User Name", "Email Id", "Phone No");
        divider();
    }

    private void printCustomer(CustomerModel i) {
        System.out.format("|%11s |%15s |%15s |%15s |%20s |%15s |\n", i.getCustomerId(), i.getFirstName(), i.getLastName(), i.getUserName(), i.getEmailId(), i.getPhoneNo());
    }

    public void showCustomerDetails(List<CustomerModel> customerList) {
        if (!customerList.isEmpty()) {
            System.out.println("Customer Details :");
            customerHeader();
            for (CustomerModel i : customerList) {
                printCustomer(i);
            }
            divider();
        } else System.out.println("Sorry !!\nCurrently no customers registered");
    }

    public void showPersonalDetail(CustomerModel account) {
        customerHeader();
        printCustomer(account);
        divider();
    }

    private void divider() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}
