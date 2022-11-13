package Day05_BaiTapCuoiKhoa.BAI1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Day05_BaiTapCuoiKhoa.BAI1.model.Item;
import Day05_BaiTapCuoiKhoa.BAI1.model.Order;

public class Main {
    public static List<Item> itemList = new ArrayList<>();
    public static void main(String[] args) {
        // Create a list of items
        itemList.add(new Item(1, "thuoc ngu", 120, "thuoc ngu vi cafe"));
        itemList.add(new Item(2, "ban chai", 250, "ban chai dien"));
        itemList.add(new Item(3, "kinh mat", 200, "kinh cho nguoi mu"));
        itemList.add(new Item(4, "ao ca sa", 300, "ao ca sa mau huong"));
        displayAllItems();

        // Input order info
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===Tao don hang moi===");

        System.out.print("\tNhap ma khach hang: ");
        int customer_id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\tNhap ma san pham: ");
        int item_id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\tNhap so luong: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        scanner.close();

        // Calculate total price
        double total = 0.0;
        for (Item item : itemList) {
            if (item.getId() == item_id) {
                total = item.getPrice() * quantity;
                break;
            }
        }

        // Get current date
        LocalDate order_date = LocalDate.now();

        // Create new order
        Order newOrder = new Order(1, customer_id, item_id, quantity, order_date);
        newOrder.setTotal(total);

        // Get item name
        String item_name = "";
        for (Item item : itemList) {
            if (item.getId() == item_id) {
                item_name = item.getName();
                break;
            }
        }

        // Display order info
        System.out.println("\n===Thong tin don hang===");
        System.out.println("\tID don hang: " + newOrder.getId());
        System.out.println("\tMa khach hang: " + newOrder.getCustomer_id());
        System.out.println("\tTen san pham: " + item_name);
        System.out.println("\tSo luong: " + newOrder.getQuantity());
        System.out.println("\tThanh tien: " + Math.round(newOrder.getTotal()*1000) + " VND");
        System.out.println("\tNgay dat hang: " + newOrder.getOrder_date());
    }

    static void displayAllItems() {
        System.out.printf("%-10s", "ID");
        System.out.printf("%-25s", "Ten san pham");
        System.out.printf("%-15s", "Don gia (VND)");
        System.out.printf("%-30s", "Mo ta");
        System.out.println();    
        for (Item item : itemList) {
            item.display();
            System.out.println();
        }
    }
}