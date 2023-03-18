package model;

public class Account {
    public enum ROLE {Customer, Shop, Shipper}
    private int id;
    private ROLE role;
    private String username;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String address;
    private ShopeePay wallet;

    // Constructor
    public Account(int id, ROLE role, String username, String password, String email, String name, String phone, String address, ShopeePay wallet) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.wallet = wallet;
    }

    // Getter and Setter
    public int getId() {
        return this.id;
    }
    public ROLE getRole() {
        return this.role;
    }
    public String getUsername() {
        return this.username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public ShopeePay getWallet() {
        return this.wallet;
    }

    // Check if passwordToCheck is this account's password
    public boolean isCorrectPassword(String passwordToCheck) {
        if (password.equals(passwordToCheck)) {
            return true;
        }
        return false;
    }

    // Check if emailToCheck is this account's email
    public boolean isCorrectEmail(String emailToCheck) {
        if (email.equals(emailToCheck)) {
            return true;
        }
        return false;
    }

    // Display account info
    public void displayAccountInfo() {
        System.out.printf("%-15s", "Username");
        System.out.printf("%-25s", "Email");
        System.out.printf("%-15s", "Password");
        System.out.printf("%-15s", "SDT");
        System.out.printf("%-30s", "Dia chi");
        System.out.printf("%-10s", "So du vi");
        System.out.println();
        System.out.printf("%-15s", username);
        System.out.printf("%-25s", email);
        System.out.printf("%-15s", password);
        System.out.printf("%-15s", phone);
        System.out.printf("%-30s", address);
        System.out.println("VND " + Math.round(wallet.getBalance()*1000));
    }
}