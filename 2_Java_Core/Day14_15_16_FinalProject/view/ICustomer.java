package view;

import java.util.Scanner;

import model.Customer;

public interface ICustomer {
    void createOrder(Scanner scanner, Customer customer);
    void viewOrderHistory(Customer customer);
    void activeOrdersAndCancelOption(Scanner scanner, Customer customer);
    void completeOrder(Scanner scanner, Customer customer);
}