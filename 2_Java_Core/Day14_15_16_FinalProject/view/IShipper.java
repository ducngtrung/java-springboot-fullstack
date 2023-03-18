package view;

import java.util.Scanner;

import model.Shipper;

public interface IShipper {
    void startDeliveringOrder(Scanner scanner, Shipper shipper);
    void viewIncome(Shipper shipper);
}