package bbm.model.account;

public class AccountModel {
    private String firstName,lastName, userName, password,emailId;
    private long phoneNo;
    AccountModel(Builder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.userName = builder.userName;
        this.password = builder.password;
        this.emailId = builder.emailId;
        this.phoneNo = builder.phoneNo;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder<build extends Builder> {
        private String firstName,lastName, userName, password,emailId;
        private long phoneNo;
        Builder() {}

        public build setFirstName(String firstName) {
            this.firstName = firstName;
            return (build) this;
        }

        public build setLastName(String lastName) {
            this.lastName = lastName;
            return (build) this;
        }

        public build setUserName(String userName) {
            this.userName = userName;
            return (build) this;
        }

        public build setPassword(String password) {
            this.password = password;
            return (build) this;
        }

        public build setEmailId(String emailId) {
            this.emailId = emailId;
            return (build) this;
        }

        public build setPhoneNo(long phoneNo) {
            this.phoneNo = phoneNo;
            return (build) this;
        }
        public AccountModel build(){
            return new AccountModel(this);
        }
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getEmailId() {
        return emailId;
    }
    public long getPhoneNo() {
        return phoneNo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
}