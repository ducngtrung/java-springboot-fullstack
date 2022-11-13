package model;

import java.util.Map;
import java.util.Set;

public class Order {
    public enum STATUS {Ordered, Confirmed, Delivering, Completed, Canceled}
    private int id;
    private Customer customer;
    private Shop shop;
    private Map<Food, Integer> foodOrd;
    private String timeOrd;
    private Shipper shipper;
    private STATUS status;

    // Constructor
    public Order(int id, Customer customer, Shop shop, Map<Food,Integer> foodOrd, String timeOrd, Shipper shipper, STATUS status) {
        this.id = id;
        this.customer = customer;
        this.shop = shop;
        this.foodOrd = foodOrd;
        this.timeOrd = timeOrd;
        this.shipper = shipper;
        this.status = status;
    }

    // Getter and Setter
    public int getId() {
        return this.id;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public Shop getShop() {
        return this.shop;
    }
    public String getTimeOrd() {
        return this.timeOrd;
    }
    public Shipper getShipper() {
        return this.shipper;
    }
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }
    public STATUS getStatus() {
        return this.status;
    }
    public void setStatus(STATUS status) {
        this.status = status;
    }

    // Calculate the total price of all ordered items
    public double calculatePrice() {
        double total = 0;
        for (Map.Entry<Food, Integer> orderItem : foodOrd.entrySet()) {
            int quantity = orderItem.getValue();
            double unitPrice = orderItem.getKey().getUnitPrice();
            total = total + (quantity * unitPrice);
        }
        return total;
    }

    // Calculate the money to pay shop: 90% of calculatePrice (the remaining 10% is taken by Shopee)
    public double payShop() {
        return (calculatePrice()*0.9);
    }

    // Calculate shipping fee: 3% of calculatePrice (minimum 15,000 VND)
    public double payShipper() {
        if ( (calculatePrice()*0.03) > 15.0 ) {
            return (calculatePrice()*0.03);
        } else {
            return 15.0;
        }
    }

    // Calculate the total bill amount: total price of all ordered items + shipping fee
    public double calculateTotal() {
        return (calculatePrice() + payShipper());
    }

    // Display ordered items
    public void displayOrderedFood() {
        Set<Food> foodSet = foodOrd.keySet();
        if (foodSet == null || foodSet.size() == 0) {
            System.out.println("\t\t(Khong co mon nao)");
        } else {
            System.out.printf("\t\t%-25s", "Ten mon");
            System.out.printf("%-15s", "So luong");
            System.out.printf("%-15s", "Don gia (VND)");
            System.out.println();
            for (Food food: foodSet) {
                System.out.printf("\t\t%-25s", food.getName());
                System.out.printf("%-15d", foodOrd.get(food));
                System.out.printf("%-15s", Math.round((food.getUnitPrice())*1000));
                System.out.println();
            }
        }
    }

    // Display all order details
    public void displayAllInfo() {
        System.out.println("\t---------------------");
        System.out.printf("\t%-5s", "ID");
        System.out.printf("%-20s", "Khach hang");
        System.out.printf("%-20s", "Shop");
        System.out.printf("%-25s", "Thoi gian dat hang");
        System.out.printf("%-25s", "Shipper");
        System.out.printf("%-10s", "Trang thai");
        System.out.println();
        System.out.printf("\t%-5s", id);
        System.out.printf("%-20s", customer.getUsername());
        System.out.printf("%-20s", shop.getName());
        System.out.printf("%-25s", timeOrd);
        if (shipper == null) {
            System.out.printf("%-25s", "(Dang tim kiem)");
        } else {
            System.out.printf("%-25s", shipper.getName());
        }
        System.out.printf("%-10s", status);
        System.out.println();

        System.out.println("\tCHI TIET MON:");
        displayOrderedFood();

        System.out.println("\tTHANH TOAN:");
        System.out.printf("\t%-20s", "Tong gia mon");
        System.out.printf("%-20s", "Phi van chuyen");
        System.out.printf("%-20s", "TONG CONG");
        System.out.println();
        System.out.printf("\t%-20s", Math.round(calculatePrice()*1000) + " VND");
        System.out.printf("%-20s", Math.round(payShipper()*1000) + " VND");
        System.out.printf("%-20s", Math.round(calculateTotal()*1000) + " VND");
        System.out.println();
    }
}