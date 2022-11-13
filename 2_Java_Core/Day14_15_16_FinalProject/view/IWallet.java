package view;

import java.util.Scanner;

import model.Account;
import model.Customer;

public interface IWallet {
    void increaseBalance(Account account, double amount);
    void deductBalance(Account account, double amount);
    void payPenalty(Scanner scanner, Customer customer);
    void recharge(Scanner scanner, Customer customer);
    void withdraw(Scanner scanner, Account account);
}