package service;

import java.util.Scanner;

import model.Food;
import model.Order;
import model.Shop;
import model.Order.STATUS;
import view.IShop;

public class ShopImpl implements IShop {

    private OrderListImpl orderListImpl;

    // Constructor: call OrderListImpl
    public ShopImpl() {
        this.orderListImpl = new OrderListImpl();
    }

    @Override
    public void removeFood(Scanner scanner, Shop shop) {
        shop.displayFoodMenu();
        boolean isFound = false;
        while (!isFound) {
            System.out.print("Nhap ID mon can xoa: ");
            int idToRemove = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < shop.getFoodList().size(); ++i) {
                if (shop.getFoodList().get(i).getId() == idToRemove) {
                    shop.getFoodList().remove(shop.getFoodList().get(i));
                    System.out.println("<XOA MON THANH CONG>");
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Khong tim thay ID mon. Vui long kiem tra lai!");
            }
        }
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void editFood(Scanner scanner, Shop shop) {
        shop.displayFoodMenu();
        boolean isFound = false;
        while (!isFound) {
            System.out.print("Nhap ID mon can sua: ");
            int idToEdit = scanner.nextInt();
            scanner.nextLine();
            
            for (int i = 0; i < shop.getFoodList().size(); ++i) {
                if (shop.getFoodList().get(i).getId() == idToEdit) {
                    System.out.print("\tNhap ten moi: ");
                    String name = scanner.nextLine();
                    System.out.print("\tNhap don gia moi (don vi: nghin VND): ");
                    double unitPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("\tNhap so luong ton moi: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Food newFood = new Food(idToEdit, name, unitPrice, quantity);
                    shop.getFoodList().set(i, newFood);
                    System.out.println("<CHINH SUA MON THANH CONG>");
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Khong tim thay ID mon. Vui long kiem tra lai!");
            }
        }
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void addFood(Scanner scanner, Shop shop) {
        boolean isContinue = true;
        while (isContinue == true) {
            System.out.print("\tNhap ten mon: ");
            String name = scanner.nextLine();
            System.out.print("\tNhap don gia (don vi: nghin VND): ");
            double unitPrice = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("\tNhap so luong ton: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            // Generate new food id
            int id = shop.getLastFoodID() + 1;

            Food newFood = new Food(id, name, unitPrice, quantity);
            shop.getFoodList().add(newFood);
            System.out.println("<THEM MON THANH CONG>");
            
            System.out.print("Tiep tuc them (Y/N)? ");
            String checkContinue = scanner.nextLine();
            switch (checkContinue.toLowerCase()) {
                case "y": {
                    break;
                }
                case "n": {
                    isContinue = false;
                    break;
                }
                default: {
                    isContinue = false;
                    break;
                }
            }
        }       
    }

    @Override
    public void confirmOrder(Scanner scanner, Shop shop) {
        System.out.println("\n===== DON HANG CHO XAC NHAN =====");
        orderListImpl.viewMyNewOrders(shop, "Ascending");

        if (orderListImpl.getMyNewOrders(shop).size() != 0) {
            boolean isFound = false;
            while (!isFound) {
                System.out.print("Nhap ID don hang de xac nhan: ");
                int idToConfirm = scanner.nextInt();
                scanner.nextLine();

                for (Order order: orderListImpl.getMyNewOrders(shop)) {
                    if (order.getId() == idToConfirm) {
                        // Change order status to Confirmed
                        order.setStatus(STATUS.Confirmed);
                        
                        System.out.println("<XAC NHAN DON HANG THANH CONG>");
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("Khong ton tai ID nay, hoac khong phai don hang co trang thai Ordered.");
                    System.out.println("Vui long kiem tra lai!");
                }
            }
        }
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void viewRevenue(Shop shop) {
        System.out.println("\n===== XEM DOANH THU =====");
        System.out.println();
        System.out.println("Don hang da hoan thanh:");
        orderListImpl.viewMyCompletedOrders(shop, "Descending");

        double totalRevenue = 0.0;
        for (Order order: orderListImpl.getMyCompletedOrders(shop)) {
            totalRevenue = totalRevenue + order.payShop();
        }
        System.out.println("\nDoanh thu cua ban duoc tinh bang 90% Tong gia mon");
        System.out.println("TONG DOANH THU: " + Math.round(totalRevenue*1000) + " VND");
    } 
}