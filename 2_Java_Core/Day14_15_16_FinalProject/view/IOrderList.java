package view;

import java.util.List;

import model.Account;
import model.Customer;
import model.Order;

public interface IOrderList {
    List<Order> getMyOrders(Account account);
    List<Order> getMyNewOrders(Account account);
    List<Order> getMyConfirmedOrders(Account account);
    List<Order> getAllConfirmedOrders();
    List<Order> getMyDeliveringOrders(Account account);
    List<Order> getMyCompletedOrders(Account account);
    List<Order> getMyCanceledOrders(Account account);
    int countRecentCanceledOrders(Customer customer);
}