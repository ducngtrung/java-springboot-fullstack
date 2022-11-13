package repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Customer;
import model.Food;
import model.Order;
import model.Shipper;
import model.Shop;
import model.ShopeePay;
import model.Account.ROLE;

public class Repository {

    public static List<Account> accountList = new ArrayList<>();
    public static List<ShopeePay> walletList = new ArrayList<>();
    public static List<Shop> shopList = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();

    // Constructor
    public Repository() {
        
        // Initialize 2 shops
        List<Food> foodListShop1 = new ArrayList<>();
        foodListShop1.add(new Food(1, "Beef Steak", 250.5, 12));
        foodListShop1.add(new Food(2, "Creamy Chicken Soup", 175, 20));
        foodListShop1.add(new Food(3, "Carbonara Pasta", 109, 25));
        ShopeePay walletShop1 = new ShopeePay(1, 550);
        Shop shop1 = new Shop(1, ROLE.Shop, "LeMondeSteak", "leMonde@123", "LeMonde.Steak@gmail.com", "Le Monde Steak", "1900633640", "84 Trung Hoa, Cau Giay", walletShop1, foodListShop1);

        List<Food> foodListShop2 = new ArrayList<>();
        foodListShop2.add(new Food(1, "Boneless Chicken", 180, 50));
        foodListShop2.add(new Food(2, "Grilled Chicken", 170, 33));
        foodListShop2.add(new Food(3, "Dakgalbi Chicken", 280, 15));
        ShopeePay walletShop2 = new ShopeePay(2, 1070);
        Shop shop2 = new Shop(2, ROLE.Shop, "BBQChicken", "Chicken@123", "bbq.chicken@gmail.com", "BBQ Chicken", "02437588935", "62 Ba Trieu, Hai Ba Trung", walletShop2, foodListShop2);
    
        // Initialize 1 customer
        ShopeePay walletCustomer1 = new ShopeePay(3, 120);
        Customer customer1 = new Customer(3, ROLE.Customer, "ducnt", "Hanoi@123", "ducnguyen.bme@gmail.com", "Nguyen Trung Duc", "0373331381", "Nghia Do, Cau Giay", walletCustomer1, false, LocalDateTime.now());

        // Initialize 1 shipper
        ShopeePay walletShipper1 = new ShopeePay(4, 75);
        Shipper shipper1 = new Shipper(4, ROLE.Shipper, "huyenvk", "Sonla@123", "khanhhuyen712@yahoo.com", "Vuong Khanh Huyen", "0393892377", "Vinh Phuc, Ba Dinh", walletShipper1);

        // Initialize account list
        accountList.add(shop1);
        accountList.add(shop2);
        accountList.add(customer1);
        accountList.add(shipper1);

        // Initialize wallet list
        walletList.add(walletShop1);
        walletList.add(walletShop2);
        walletList.add(walletCustomer1);
        walletList.add(walletShipper1);

        // Initialize shop list
        shopList.add(shop1);
        shopList.add(shop2);
    }

    public void displayAccountList() {
        System.out.printf("%-15s", "Doi tuong");
        System.out.printf("%-15s", "Username");
        System.out.printf("%-15s", "Password");
        System.out.printf("%-30s", "Email");
        System.out.printf("%-10s", "So du vi");
        System.out.println();
        for (Account account: accountList) {
            System.out.printf("%-15s", account.getRole());
            System.out.printf("%-15s", account.getUsername());
            System.out.printf("%-15s", account.getPassword());
            System.out.printf("%-30s", account.getEmail());
            System.out.println("VND " + Math.round(account.getWallet().getBalance()*1000));
        }
    }
}