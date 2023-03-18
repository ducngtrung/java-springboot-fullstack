package service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.Customer;
import model.Order;
import model.Shipper;
import model.Shop;
import model.Order.STATUS;
import repository.Repository;
import util.DateTimeConverter;
import view.IOrderList;

public class OrderListImpl implements IOrderList {

    public List<Order> getOrderList() {
        return Repository.orderList;
    }

    @Override
    public List<Order> getMyOrders(Account account) {
        List<Order> myOrders = new ArrayList<>();
        switch (account.getRole()) {
            case Customer: {
                for (Order order: getOrderList()) {
                    if (order.getCustomer().equals((Customer)account)) {
                        myOrders.add(order);
                    }
                }
                break;
            }
            case Shop: {
                for (Order order: getOrderList()) {
                    if (order.getShop().equals((Shop)account)) {
                        myOrders.add(order);
                    }
                }
                break;
            }
            case Shipper: {
                for (Order order: getOrderList()) {
                    if (order.getShipper().equals((Shipper)account)) {
                        myOrders.add(order);
                    }
                }
                break;
            }
        }
        return myOrders;
    }

    @Override
    public List<Order> getMyNewOrders(Account account) {
        List<Order> myNewOrders = new ArrayList<>();
        for (Order order: getMyOrders(account)) {
            if (order.getStatus() == STATUS.Ordered) {
                myNewOrders.add(order);
            }
        }
        return myNewOrders;
    }

    @Override
    public List<Order> getMyConfirmedOrders(Account account) {
        List<Order> myConfirmedOrders = new ArrayList<>();
        for (Order order: getMyOrders(account)) {
            if (order.getStatus() == STATUS.Confirmed) {
                myConfirmedOrders.add(order);
            }
        }
        return myConfirmedOrders;
    }

    @Override
    public List<Order> getAllConfirmedOrders() {
        List<Order> allConfirmedOrders = new ArrayList<>();
        for (Order order: getOrderList()) {
            if (order.getStatus() == STATUS.Confirmed) {
                allConfirmedOrders.add(order);
            }
        }
        return allConfirmedOrders;
    }

    @Override
    public List<Order> getMyDeliveringOrders(Account account) {
        List<Order> myDeliveringOrders = new ArrayList<>();
        for (Order order: getMyOrders(account)) {
            if (order.getStatus() == STATUS.Delivering) {
                myDeliveringOrders.add(order);
            }
        }
        return myDeliveringOrders;
    }

    @Override
    public List<Order> getMyCompletedOrders(Account account) {
        List<Order> myCompletedOrders = new ArrayList<>();
        for (Order order: getMyOrders(account)) {
            if (order.getStatus() == STATUS.Completed) {
                myCompletedOrders.add(order);
            }
        }
        return myCompletedOrders;
    }

    @Override
    public List<Order> getMyCanceledOrders(Account account) {
        List<Order> myCanceledOrders = new ArrayList<>();
        for (Order order: getMyOrders(account)) {
            if (order.getStatus() == STATUS.Canceled) {
                myCanceledOrders.add(order);
            }
        }
        return myCanceledOrders;
    }

    private List<Order> sortOrderByTime(List<Order> orderList, String sortMethod) {
        Order temp;
        int length = orderList.size();
        if (sortMethod.equals("Ascending")) {
            for (int i = 0; i < (length - 1); ++i) {
                for (int j = 0; j < (length - i - 1); ++j) {
                    if (orderList.get(j).getTimeOrd().compareTo(orderList.get(j+1).getTimeOrd()) > 0) {
                        temp = orderList.get(j);
                        orderList.set(j, orderList.get(j+1));
                        orderList.set(j+1, temp);
                    }
                }
            }
        } else if (sortMethod.equals("Descending")) {
            for (int i = 0; i < (length - 1); ++i) {
                for (int j = 0; j < (length - i - 1); ++j) {
                    if (orderList.get(j).getTimeOrd().compareTo(orderList.get(j+1).getTimeOrd()) < 0) {
                        temp = orderList.get(j);
                        orderList.set(j, orderList.get(j+1));
                        orderList.set(j+1, temp);
                    }
                }
            }
        }
        return orderList;
    }

    public void viewMyNewOrders(Account account, String sortByTime) {
        if (getMyNewOrders(account).size() != 0) {
            for (Order order: sortOrderByTime(getMyNewOrders(account), sortByTime)) {
                order.displayAllInfo();
            }
        } else {
            System.out.println("\t(Khong co)");
        }
    }

    public void viewMyConfirmedOrders(Account account, String sortByTime) {
        if (getMyConfirmedOrders(account).size() != 0) {
            for (Order order: sortOrderByTime(getMyConfirmedOrders(account), sortByTime)) {
                order.displayAllInfo();
            }
        } else {
            System.out.println("\t(Khong co)");
        }       
    }

    public void viewAllConfirmedOrders(String sortByTime) {
        if (getAllConfirmedOrders().size() != 0) {
            for (Order order: sortOrderByTime(getAllConfirmedOrders(), sortByTime)) {
                order.displayAllInfo();
            }
        } else {
            System.out.println("\t(Khong co)");
        }       
    }

    public void viewMyDeliveringOrders(Account account, String sortByTime) {
        if (getMyDeliveringOrders(account).size() != 0) {
            for (Order order: sortOrderByTime(getMyDeliveringOrders(account), sortByTime)) {
                order.displayAllInfo();
            }
        } else {
            System.out.println("\t(Khong co)");
        }        
    }

    public void viewMyCompletedOrders(Account account, String sortByTime) {
        if (getMyCompletedOrders(account).size() != 0) {
            for (Order order: sortOrderByTime(getMyCompletedOrders(account), sortByTime)) {
                order.displayAllInfo();
            }
        } else {
            System.out.println("\t(Khong co)");
        }        
    }

    public void viewMyCanceledOrders(Account account, String sortByTime) {
        if (getMyCanceledOrders(account).size() != 0) {
            for (Order order: sortOrderByTime(getMyCanceledOrders(account), sortByTime)) {
                order.displayAllInfo();
            }
        } else {
            System.out.println("\t(Khong co)");
        }        
    }

    // Count the number of recently canceled orders of a customer:
    // - If duration from the last activation < 24 hours then count from the last activation to now
    // - If duration from the last activation >= 24 hours then count within 24 hours back from now
    @Override
    public int countRecentCanceledOrders(Customer customer) {
        int count = 0;
        LocalDateTime currentTime = LocalDateTime.now();
        Duration durationFromLastActivation = Duration.between(customer.getActivationTime(), currentTime);
        for (Order order: getMyCanceledOrders(customer)) {
            LocalDateTime orderedTime = DateTimeConverter.stringToDateTime(order.getTimeOrd());
            Duration durationfromOrderedTime = Duration.between(orderedTime, currentTime);
            if (durationFromLastActivation.toHours() < 24) {
                if (durationfromOrderedTime.toMinutes() <= durationFromLastActivation.toMinutes()) {
                    ++count;
                }
            } else {
                if (durationfromOrderedTime.toHours() <= 24) {
                    ++count;
                }
            }
        }
        return count;  
    }
}