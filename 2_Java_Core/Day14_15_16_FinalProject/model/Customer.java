package model;

import java.time.LocalDateTime;

public class Customer extends Account {
    private boolean isSuspend;
    private LocalDateTime activationTime;

    // Constructor
    public Customer(int id, ROLE role, String username, String password, 
                    String email, String name, String phone, String address, 
                    ShopeePay wallet, boolean isSuspend, LocalDateTime activationTime) {
        super(id, role, username, password, email, name, phone, address, wallet);
        this.isSuspend = isSuspend;
        this.activationTime = activationTime;
    }

    // Getter and Setter
    public boolean isSuspend() {
        return this.isSuspend;
    }
    public void setIsSuspend(boolean isSuspend) {
        this.isSuspend = isSuspend;
    }
    public LocalDateTime getActivationTime() {
        return this.activationTime;
    }
    public void setActivationTime(LocalDateTime activationTime) {
        this.activationTime = activationTime;
    }
}