package model;

public class Food {
    private int id;
    private String name;
    private double unitPrice;
    private int quantity;

    public Food(int id, String name, double unitPrice, int quantity) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Getter
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public double getUnitPrice() {
        return this.unitPrice;
    }

    // Check if food name contains the keyword
    public boolean hasKeyword(String keyword) {
        return name.toLowerCase().contains(keyword);
    }

    // Display food info
    public void display() {
        System.out.printf("%-10s", id);
        System.out.printf("%-25s", name);
        System.out.printf("%-15s", Math.round(unitPrice*1000));
        System.out.printf("%-15d", quantity);
    }
}