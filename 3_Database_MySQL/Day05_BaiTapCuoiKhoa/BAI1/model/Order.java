package Day05_BaiTapCuoiKhoa.BAI1.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private int customer_id;
    private int item_id;
    private int quantity;
    private LocalDate order_date;
    private double total;

    // Constructor
    public Order(int id, int customer_id, int item_id, int quantity, LocalDate order_date) {
        this.id = id;
        this.customer_id = customer_id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.order_date = order_date;
    }

    // Getter and Setter
    public int getId() {
        return this.id;
    }
    public int getCustomer_id() {
        return this.customer_id;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public double getTotal() {
        return this.total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public LocalDate getOrder_date() {
        return this.order_date;
    }
}