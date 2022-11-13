package model;

public class ShopeePay {
    private int id;
    private double balance;

    // Constructor
    public ShopeePay(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    // Getter and Setter
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
}