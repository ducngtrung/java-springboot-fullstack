package model;

public class Shipper extends Account {

    // Constructor
    public Shipper(int id, ROLE role, String username, String password, String email, 
                    String name, String phone, String address, ShopeePay wallet) {
        super(id, role, username, password, email, name, phone, address, wallet);
    }
}