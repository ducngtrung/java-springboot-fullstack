package Day10_ArrayList.Quan_Ly_San_Pham;

public class Product {
    private String id;
    private String name;
    private int quantity;
    private long unitPrice;
    private String unit;

    // Constructor
    public Product(String id, String name, int quantity, int i, String unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = i;
        this.unit = unit;
    }

    // Getter and Setter
    public long getUnitPrice() {
        return this.unitPrice;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display product info
    public void display() {
        System.out.printf("\tid: %-7s name: %-15s quantity: %-5d unit: %-10s unit price: VND %-10d \n", 
                            id, name, quantity, unit, unitPrice);
    }

    // Search product based on product name
    public boolean hasKeywordName (String keyword) {
        return this.name.toLowerCase().contains(keyword);
    }

    // Search product based on product id
    public boolean hasKeywordID (String idToSearch) {
        return this.id.toLowerCase().contains(idToSearch);
    }
}