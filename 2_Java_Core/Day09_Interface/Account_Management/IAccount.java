package Day09_Interface.Account_Management;

public interface IAccount {
    void recharge(double amount);
    void changeEmail(String email);
    
    default void displayInfo() {
        System.out.println("Thong tin tai khoan");
    };
}