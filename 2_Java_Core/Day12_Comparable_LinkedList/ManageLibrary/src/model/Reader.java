package model;

public class Reader {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    // Reader
    public Reader(int id, String address, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getter
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Reader {" +
            "id='" + id + "'" +
            ", name='" + name + "'" +
            ", address='" + address + "'" +
            ", phoneNumber='" + phoneNumber + "'" +
            "}";
    }
}