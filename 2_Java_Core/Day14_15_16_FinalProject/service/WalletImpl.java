package service;

import java.time.LocalDateTime;
import java.util.Scanner;

import model.Account;
import model.Customer;
import view.IWallet;

public class WalletImpl implements IWallet {

    @Override
    public void increaseBalance(Account account, double amount) {
        double newBalance = account.getWallet().getBalance() + amount;
        account.getWallet().setBalance(newBalance);        
    }

    @Override
    public void deductBalance(Account account, double amount) {
        double newBalance = account.getWallet().getBalance() - amount;
        account.getWallet().setBalance(newBalance);        
    }

    @Override
    public void payPenalty(Scanner scanner, Customer customer) {        
        System.out.println("So du hien tai: " + Math.round((customer.getWallet().getBalance())*1000) + " VND");
        
        double penaltyAmount = 100.0;
        while (penaltyAmount > customer.getWallet().getBalance()) {
            System.out.println("So du hien tai khong du de nop phat. Vui long nap them tien!");
            recharge(scanner, customer);
        }
        
        deductBalance(customer, penaltyAmount);
        System.out.println("\n<NOP PHAT THANH CONG>");
        System.out.println("So du hien tai: " + Math.round((customer.getWallet().getBalance())*1000) + " VND");

        // Reactivate the account and reset activation time
        customer.setIsSuspend(false);
        customer.setActivationTime(LocalDateTime.now());

        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void recharge(Scanner scanner, Customer customer) {
        System.out.print("Nhap so tien nap them (don vi: nghin VND): ");
        double amountRecharge = scanner.nextDouble();
        scanner.nextLine();

        increaseBalance(customer, amountRecharge);
        System.out.println("\n<NAP TIEN THANH CONG>");
        System.out.println("So du hien tai: " + Math.round((customer.getWallet().getBalance())*1000) + " VND");
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void withdraw(Scanner scanner, Account account) {
        double amountWithdraw;
        boolean isContinue = false;
        do {
            System.out.print("Nhap so tien can rut (don vi: nghin VND): ");
            amountWithdraw = scanner.nextDouble();
            scanner.nextLine();
            if (amountWithdraw > account.getWallet().getBalance()) {
                System.out.println("So du hien tai khong du de rut tien. Vui long nhap lai!");
                isContinue = true;
            } else {
                isContinue = false;
            }
        } while (isContinue == true);
        
        deductBalance(account, amountWithdraw);
        System.out.println("\n<RUT TIEN THANH CONG>");
        System.out.println("So du hien tai: " + Math.round((account.getWallet().getBalance())*1000) + " VND");
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    public void manageShopeePay(Scanner scanner, Account account) {
        System.out.println("So du hien tai: " + Math.round((account.getWallet().getBalance())*1000) + " VND");
        System.out.println();
        if (account instanceof Customer) {
            System.out.println("[1] Nap tien vao ShopeePay");
            System.out.println("[2] Thoat");
            System.out.print("Chon tac vu: ");
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 1: { // Nap tien
                    recharge(scanner, (Customer)account);
                    ClearConsoleScreen();
                    break;
                }
                case 2: { // Thoat
                    ClearConsoleScreen();
                    break;
                }
                default: {
                    ClearConsoleScreen();
                    break;
                }
            }
        } else {
            System.out.println("[1] Rut tien tu ShopeePay");
            System.out.println("[2] Thoat");
            System.out.print("Chon tac vu: ");
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 1: { // Rut tien
                    withdraw(scanner, account);
                    ClearConsoleScreen();
                    break;
                }
                case 2: { // Thoat
                    ClearConsoleScreen();
                    break;
                }
                default: {
                    ClearConsoleScreen();
                    break;
                }
            }
        }
    }

    private void ClearConsoleScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}