package Day09_Interface.Account_Management;

public class Account implements IAccount {
    private String name;
    private String accountNumber;
    private String email;
    private double accountBalance;

    // Getter and Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Nap them tien vao account
    @Override
    public void recharge(double amount) {
        this.accountBalance = this.accountBalance + amount;        
    }

    @Override
    public void changeEmail(String email) {
        this.setEmail(email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name + " - Account Number: " + accountNumber 
                            + " - Email: " + email + " - Account Balance: " + Math.round(accountBalance));  
    }
}