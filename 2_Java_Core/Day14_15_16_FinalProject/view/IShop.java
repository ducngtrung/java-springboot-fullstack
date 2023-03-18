package view;

import java.util.Scanner;

import model.Shop;

public interface IShop {
    void removeFood(Scanner scanner, Shop shop);
    void editFood(Scanner scanner, Shop shop);
    void addFood(Scanner scanner, Shop shop);
    void confirmOrder(Scanner scanner, Shop shop);
    void viewRevenue(Shop shop);
}