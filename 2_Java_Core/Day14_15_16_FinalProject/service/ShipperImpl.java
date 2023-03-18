package service;

import java.util.Scanner;

import model.Order;
import model.Shipper;
import model.Order.STATUS;
import view.IShipper;

public class ShipperImpl implements IShipper {
    
    private OrderListImpl orderListImpl;

    // Constructor: call OrderListImpl
    public ShipperImpl() {
        this.orderListImpl = new OrderListImpl();
    }

    @Override
    public void startDeliveringOrder(Scanner scanner, Shipper shipper) {
        System.out.println("\n===== DON HANG CHO VAN CHUYEN =====");
        orderListImpl.viewAllConfirmedOrders("Ascending");

        if (orderListImpl.getAllConfirmedOrders().size() != 0) {
            boolean isFound = false;
            while (!isFound) {
                System.out.print("Nhap ID don hang de bat dau van chuyen: ");
                int idToDeliver = scanner.nextInt();
                scanner.nextLine();

                for (Order order: orderListImpl.getAllConfirmedOrders()) {
                    if (order.getId() == idToDeliver) {
                        // Change order status to Delivering
                        order.setStatus(STATUS.Delivering);
                        // Set the current account as the shipper of this order
                        order.setShipper(shipper);
                        
                        System.out.println("<BAT DAU VAN CHUYEN>");
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println("Khong ton tai ID nay, hoac khong phai don hang co trang thai Confirmed.");
                    System.out.println("Vui long kiem tra lai!");
                }
            }
        }
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void viewIncome(Shipper shipper) {
        System.out.println("\n===== XEM THU NHAP =====");
        System.out.println();        
        System.out.println("Don hang da hoan thanh:");
        orderListImpl.viewMyCompletedOrders(shipper, "Descending");

        double totalIncome = 0.0;
        for (Order order: orderListImpl.getMyCompletedOrders(shipper)) {
            totalIncome = totalIncome + order.payShipper();
        }
        System.out.println("\nDoanh thu cua ban duoc tinh bang Phi van chuyen");
        System.out.println("TONG THU NHAP: " + Math.round(totalIncome*1000) + " VND");
    }
}