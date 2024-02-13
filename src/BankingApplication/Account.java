package BankingApplication;



public class Account {
    private int accountId;
    private String accountType;
    private double balance;
    private int customerId;
    private  String accountName;

    public Account(int accountId, String accountType, double balance, String accountName) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
        this.accountName = accountName;
    }
    public int getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", customerId=" + customerId +
                '}';
    }


}
