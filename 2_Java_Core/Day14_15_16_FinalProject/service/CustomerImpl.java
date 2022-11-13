package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Customer;
import model.Food;
import model.Order;
import model.Order.STATUS;
import model.Shop;
import repository.Repository;
import util.DateTimeConverter;
import view.ICustomer;

public class CustomerImpl implements ICustomer {

    private WalletImpl walletImpl;
    private OrderListImpl orderListImpl;

    // Constructor: call OrderListImpl and WalletImpl
    public CustomerImpl() {
        this.walletImpl = new WalletImpl();
        this.orderListImpl = new OrderListImpl();
    }

    public List<Order> getOrderList() {
        return Repository.orderList;
    }

    public List<Shop> getShopList() {
        return Repository.shopList;
    }

    // Create a map to store ordered food and corresponding quantity
    public Map<Food, Integer> selectFoodAndQuantity(Scanner scanner, Shop shop) {
        Map<Food, Integer> foodOrd = new HashMap<>();
        System.out.println("Xin moi chon mon:");

        boolean isContinue = true;
        while (isContinue == true) {
            System.out.print("\tNhap ID mon: ");
            int foodID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\tNhap so luong: ");
            int foodQuantity = scanner.nextInt();
            scanner.nextLine();
            
            foodOrd.put(shop.getFood(foodID), foodQuantity);

            System.out.print("Tiep tuc chon (Y/N)? ");
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
        return foodOrd;
    }

    // Ask customer to recharge wallet if the balance is not enough to place order
    private void checkBalance(Scanner scanner, Order order, Customer customer) {
        while ( customer.getWallet().getBalance() < order.calculateTotal() ) {
            System.out.println("Khong du so du ShopeePay de dat hang!");
            System.out.println("So du hien tai: " + Math.round((customer.getWallet().getBalance())*1000) + " VND");
            System.out.println("Vui long nap them tien de dat hang.");
            System.out.println();
            walletImpl.recharge(scanner, customer);
        }
    }

    // Deduct the total bill amount from customer's wallet, then add the order to orderList
    private void placeOrder(Scanner scanner, Order order, Customer customer) {
        // Customer pays the bill
        walletImpl.deductBalance(customer, order.calculateTotal());
        System.out.println("<THANH TOAN THANH CONG>");

        // Add the new order to orderList
        getOrderList().add(order);
        System.out.println("\n<DAT HANG THANH CONG>");

        System.out.println("\tThong tin don hang:");
        order.displayAllInfo();
    }

    @Override
    public void createOrder(Scanner scanner, Customer customer) {
        System.out.println("\n===== DAT HANG =====");
        System.out.println();
        boolean isFound = false;
        while (!isFound) {
            System.out.print("Nhap ID shop hoac ten shop: ");
            String shopIdentifier = scanner.nextLine();
            for (Shop shop: getShopList()) {
                if ( shop.getName().equalsIgnoreCase(shopIdentifier) 
                    || (String.valueOf(shop.getId()).equals(shopIdentifier)) ) {
                        // Show shop info and it's menu
                        shop.displayShopAndFood();
                        // Create a map to store ordered food and corresponding quantity
                        Map<Food, Integer> foodOrd = selectFoodAndQuantity(scanner, shop);
                        // Generate new order id
                        int newOrderID = getOrderList().size() + 1;
                        // Set order time
                        String timeOrder = DateTimeConverter.dateTimeToString(LocalDateTime.now());
                        // Create new order
                        Order newOrder = new Order(newOrderID, customer, shop, foodOrd, 
                                                    timeOrder, null, STATUS.Ordered);
                        System.out.println("\nTong gia tri don hang: " + Math.round((newOrder.calculateTotal())*1000) + " VND");
                        // Ask customer to recharge wallet if the balance is not enough to place order
                        checkBalance(scanner, newOrder, customer);
                        // Deduct the total bill amount from customer's wallet, then add the order to orderList
                        placeOrder(scanner, newOrder, customer);

                        System.out.print("Enter de tiep tuc...");
                        scanner.nextLine();
                        isFound = true;
                        break;
                } else {
                    isFound = false;
                }
            }
            if (!isFound) {
                System.out.println("Khong tim thay shop. Moi nhap lai!");
            }
        }
    }

    @Override
    public void viewOrderHistory(Customer customer) {
        System.out.println("\n=== LICH SU DAT HANG ===");
        System.out.println();        
        System.out.println("Don hang da hoan thanh:");
        orderListImpl.viewMyCompletedOrders(customer, "Descending");
        System.out.println("Don hang da huy:");
        orderListImpl.viewMyCanceledOrders(customer, "Descending");
    }

    @Override
    public void activeOrdersAndCancelOption(Scanner scanner, Customer customer) {
        boolean isContinue = true;
        do {
            if (customer.isSuspend()) {
                isContinue = false;
            } else {
                System.out.println("\n=== XEM DON HANG MOI VA HUY DON ===");
                System.out.println();
                System.out.println("Don hang cho xac nhan:");
                orderListImpl.viewMyNewOrders(customer, "Ascending");
                System.out.println("Don hang da xac nhan:");
                orderListImpl.viewMyConfirmedOrders(customer, "Ascending");
                
                System.out.println("[1] Huy don hang");
                System.out.println("[2] Thoat");
                System.out.print("Chon tac vu: ");
                int selectedMenu = scanner.nextInt();
                scanner.nextLine();
                switch (selectedMenu) {
                    case 1: { 
                        System.out.println("\n=== HUY DON HANG ===");
                        if ((orderListImpl.getMyNewOrders(customer).size() == 0) 
                            && (orderListImpl.getMyConfirmedOrders(customer).size() == 0)) {
                                System.out.println("(Khong co don hang moi nao)");
                        } else {
                            cancelOrder(scanner, customer);
                        }
                        System.out.print("Enter de tiep tuc...");
                        scanner.nextLine();
                        clearConsoleScreen();
                        break;
                    }
                    case 2: { // Thoat
                        isContinue = false;
                        break;
                    }
                    default: {
                        clearConsoleScreen();
                        break;
                    }
                }
            }
        } while (isContinue == true);
    }
    
    private void cancelOrder(Scanner scanner, Customer customer) {        
        boolean isFound = false;
        System.out.print("Nhap ID don hang can huy: ");
        int idToCancel = scanner.nextInt();
        scanner.nextLine();
        for (Order order: orderListImpl.getMyOrders(customer)) {
            if ((order.getId() == idToCancel) && 
                ((order.getStatus() == STATUS.Ordered) || (order.getStatus() == STATUS.Confirmed))) {
                // Change order status to Canceled
                order.setStatus(STATUS.Canceled);
                System.out.println("<HUY DON HANG THANH CONG>");

                // Customer gets refunded
                walletImpl.increaseBalance(order.getCustomer(), order.calculateTotal());
                System.out.println("<DA HOAN TIEN VAO VI SHOPEEPAY>");
                
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Khong ton tai ID nay, hoac khong phai don hang co trang thai Ordered hoac Confirmed.");
        } else {
            // Check the number of canceled orders of this customer within 1 day:
            // If result >= 3 then suspend the account
            if (orderListImpl.countRecentCanceledOrders(customer) >= 3) {
                customer.setIsSuspend(true);
            }
        }
    }

    @Override
    public void completeOrder(Scanner scanner, Customer customer) {
        System.out.println("\n=== HOAN THANH DON HANG ===");
        System.out.println();        
        System.out.println("Don hang dang van chuyen:");
        orderListImpl.viewMyDeliveringOrders(customer, "Ascending");

        if (orderListImpl.getMyDeliveringOrders(customer).size() != 0) {
            boolean isFound = false;
            while (!isFound) {
                System.out.print("Nhap ID don hang de xac nhan hoan thanh: ");
                int idToComplete = scanner.nextInt();
                scanner.nextLine();

                for (Order order: orderListImpl.getMyDeliveringOrders(customer)) {
                    if (order.getId() == idToComplete) {
                        // Change order status to Completed
                        order.setStatus(STATUS.Completed);

                        // Shipper and Shop get paid
                        walletImpl.increaseBalance(order.getShipper(), order.payShipper());
                        walletImpl.increaseBalance(order.getShop(), order.payShop());

                        System.out.println("<DON HANG DA HOAN THANH>");
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("Khong ton tai ID nay, hoac khong phai don hang co trang thai Delivering.");
                    System.out.println("Vui long kiem tra lai!");
                }
            }
        }
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    private void clearConsoleScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}