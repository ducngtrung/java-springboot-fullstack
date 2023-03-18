package Day05_BaiTapCuoiKhoa.BAI1.model;

public class Item {
    private int id;
    private String name;
    private double price;
    private String description;

    // Constructor
    public Item(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter and Setter
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }

    // Display item info
    public void display() {
        System.out.printf("%-10s", id);
        System.out.printf("%-25s", name);
        System.out.printf("%-15s", Math.round(price*1000));
        System.out.printf("%-30s", description);
    }
}