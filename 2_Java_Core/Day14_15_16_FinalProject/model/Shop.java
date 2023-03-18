package model;

import java.util.List;

public class Shop extends Account {
    private List<Food> foodList;

    // Constructor
    public Shop(int id, ROLE role, String username, String password, String email, 
                String name, String phone, String address, ShopeePay wallet, List<Food> foodList) {
        super(id, role, username, password, email, name, phone, address, wallet);
        this.foodList = foodList;
    }

    // Getter
    public List<Food> getFoodList() {
        return this.foodList;
    }

    // Get food by ID
    public Food getFood(int id) {
        Food result = null;
        for (Food food: foodList) {
            if (food.getId() == id) {
                result = food;
                break;
            }
        }
        return result;
    }

    // Get the last ID (the biggest ID) in the foodList
    public int getLastFoodID() {
        int result = 0;
        for (Food food: foodList) {
            if (food.getId() > result) {
                result = food.getId();
            }
        }
        return result;
    }

    // Display shop info
    public void displayShopInfo() {
        System.out.printf("\n%-5s", "ID");
        System.out.printf("%-20s", "Ten shop");
        System.out.printf("%-15s", "SDT");
        System.out.printf("%-30s", "Dia chi");
        System.out.println();
        System.out.printf("%-5s", super.getId());
        System.out.printf("%-20s", super.getName());
        System.out.printf("%-15s", super.getPhone());
        System.out.printf("%-30s", super.getAddress());
        System.out.println();
    }

    // Display food menu
    public void displayFoodMenu() {
        System.out.printf("%-10s", "ID");
        System.out.printf("%-25s", "Ten mon");
        System.out.printf("%-15s", "Don gia (VND)");
        System.out.printf("%-15s", "So luong ton");
        System.out.println();
        if (foodList == null || foodList.size() == 0) {
            System.out.println("(Khong co mon nao)");
        } else {    
            for (Food food: foodList) {
                if (food != null) {
                    food.display();
                    System.out.println();
                }
            }
        }
    }

    // Display shop and food menu
    public void displayShopAndFood() {
        displayShopInfo();
        System.out.println("\n=== MENU ===");
        displayFoodMenu();
    }
}