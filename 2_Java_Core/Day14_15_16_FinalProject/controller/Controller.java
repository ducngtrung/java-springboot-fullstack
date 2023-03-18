package controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import model.Account;
import model.Customer;
import model.Shipper;
import model.Shop;
import model.ShopeePay;
import model.Account.ROLE;
import repository.Repository;
import service.AccountImpl;
import service.CustomerImpl;
import service.FoodImpl;
import service.ShipperImpl;
import service.ShopImpl;
import service.WalletImpl;

public class Controller {

    private Repository repository;
    private AccountImpl accountImpl;
    private CustomerImpl customerImpl;
    private ShopImpl shopImpl;
    private ShipperImpl shipperImpl;
    private WalletImpl walletImpl;
    private FoodImpl foodImpl;

    // Constructor: call Repository and all services
    public Controller() {
        this.repository = new Repository();
        this.accountImpl = new AccountImpl();
        this.customerImpl = new CustomerImpl();
        this.shopImpl = new ShopImpl();
        this.shipperImpl = new ShipperImpl();
        this.walletImpl = new WalletImpl();
        this.foodImpl = new FoodImpl();
    }

    private List<Account> getAccountList() {
        return Repository.accountList;
    }

    private List<ShopeePay> getWalletList() {
        return Repository.walletList;
    }
   
    public void signUp(Scanner scanner) {
        repository.displayAccountList();
        System.out.println();
        System.out.println("[1] Customer");
        System.out.println("[2] Shop");
        System.out.println("[3] Shipper");
        System.out.print("Chon doi tuong dang ky: ");
        int selectedMenu = scanner.nextInt();
        scanner.nextLine();

        // Generate new account id
        int id = getAccountList().size() + 1;

        // Create new username, email, password, phone number
        String username = accountImpl.createNewUsername(scanner);
        String email = accountImpl.createNewEmail(scanner);
        String password = accountImpl.createNewPassword(scanner);
        String phone = accountImpl.createNewPhone(scanner);
       
        // Create new display name
        System.out.print("Nhap ten hien thi:\n\t");
        String name = scanner.nextLine();
        
        // Create new address
        System.out.print("Nhap dia chi:\n\t");
        String address = scanner.nextLine();
        
        // Create new wallet
        int walletId = getWalletList().size() + 1;
        System.out.println("Tai khoan moi dang ky se duoc tang 100,000 VND vao vi ShopeePay.");
        double walletBalance = 100.0;
        ShopeePay wallet = new ShopeePay(walletId, walletBalance);

        switch (selectedMenu) {
            case 1:{ // Customer
                Customer newCustomer = new Customer(id, ROLE.Customer, username, password, email, name, phone, address, wallet, false, LocalDateTime.now());
                getAccountList().add(newCustomer);
                System.out.println("\n<DANG KY THANH CONG>");
                getAccountList().get(getAccountList().size()-1).displayAccountInfo();
                break;
            }
            case 2: { // Shop
                Shop newShop = new Shop(id, ROLE.Shop, username, password, email, name, phone, address, wallet, null);
                getAccountList().add(newShop);
                System.out.println("<DANG KY THANH CONG>");
                getAccountList().get(getAccountList().size()-1).displayAccountInfo();
                break;
            }
            case 3:{ // Shipper
                Shipper newShipper = new Shipper(id, ROLE.Shipper, username, password, email, name, phone, address, wallet);
                getAccountList().add(newShipper);
                System.out.println("<DANG KY THANH CONG>");
                getAccountList().get(getAccountList().size()-1).displayAccountInfo();
                break;
            }
        }

        System.out.println();
        System.out.print("Enter de tiep tuc");
        scanner.nextLine();
        clearConsoleScreen();
    }

    public void logIn(Scanner scanner) {
        repository.displayAccountList();
        System.out.println();
        boolean isContinue = true;
        while (isContinue == true) {
            System.out.print("Nhap username:\n\t");
            String username = scanner.nextLine();
            if (accountImpl.checkExistingUsername(username) != null) {
                isContinue = false;
                Account currentAccount = accountImpl.checkExistingUsername(username);
                System.out.print("Nhap password:\n\t");
                String passwordToCheck = scanner.nextLine();
                if (currentAccount.isCorrectPassword(passwordToCheck)) {
                    clearConsoleScreen();
                    switch (currentAccount.getRole()) {
                        case Customer: {
                            if ( ((Customer)currentAccount).isSuspend() ) {
                                suspendedCustomerFunctions(scanner, currentAccount);
                            } else {
                                customerFunctions(scanner, currentAccount);
                            }
                            break;
                        }
                        case Shop: {
                            shopFunctions(scanner, currentAccount);
                            break;
                        }
                        case Shipper: {
                            shipperFunctions(scanner, currentAccount);
                            break;
                        }
                    }
                } else {
                    System.out.println("Sai mat khau!");
                    System.out.println();
                    System.out.println("[1] Dang nhap lai");
                    System.out.println("[2] Quen mat khau");
                    System.out.print("Vui long chon: ");
                    int selectedMenu = scanner.nextInt();
                    scanner.nextLine();
                    switch (selectedMenu) {
                        case 1:{ // Dang nhap lai
                            isContinue = true;
                            break;
                        }
                        case 2: { 
                            System.out.println("\n===== QUEN MAT KHAU =====");
                            System.out.println();
                            accountImpl.forgetPassword(scanner, currentAccount);
                            isContinue = false;
                            clearConsoleScreen();
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Username khong ton tai. Vui long nhap lai!");
            }
        }
    }

    private void suspendedCustomerFunctions(Scanner scanner, Account account) {
        System.out.println("\n*** WELCOME " + account.getRole() + ": " + account.getName() + " ***");
        System.out.println();
        System.out.println("Tai khoan bi khoa vi da huy don hang 3 lan trong vong 24h.");
        System.out.println("Can thanh toan tien phat 100,000 VND de mo khoa tai khoan.");
        boolean isContinue = true;
        do {
            System.out.println();
            System.out.println("[1] Nop tien phat");
            System.out.println("[2] Dang xuat");
            System.out.print("Chon tac vu: ");
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 1: { 
                    System.out.println("\n===== NOP TIEN PHAT =====");
                    System.out.println();
                    walletImpl.payPenalty(scanner, (Customer)account);
                    isContinue = false;
                    clearConsoleScreen();
                    break;
                }
                case 2: { // Dang xuat
                    isContinue = false;
                    clearConsoleScreen();
                    break;
                }
                default: {
                    clearConsoleScreen();
                    break;
                }
            }
        } while (isContinue == true);
    }

    private void customerFunctions(Scanner scanner, Account account) {
        boolean isContinue = true;
        do {
            if ( ((Customer)account).isSuspend() ) {
                suspendedCustomerFunctions(scanner, account);
                isContinue = false;
            } else {
                System.out.println("\n*** WELCOME " + account.getRole() + ": " + account.getName() + " ***");
                System.out.println();
                System.out.println("[1] Quan ly tai khoan");
                System.out.println("[2] Tim kiem mon an");
                System.out.println("[3] Don hang cua toi");
                System.out.println("[4] Dat hang");
                System.out.println("[5] Dang xuat");
                System.out.print("Chon tac vu: ");
                int selectedMenu = scanner.nextInt();
                scanner.nextLine();
                switch (selectedMenu) {
                    case 1: { // QUAN LY TAI KHOAN
                        clearConsoleScreen();
                        manageAccount(scanner, account);
                        break;
                    }
                    case 2: { // TIM KIEM MON AN
                        clearConsoleScreen();
                        foodImpl.searchFood(scanner);
                        clearConsoleScreen();
                        break;
                    }
                    case 3: { // DON HANG CUA TOI
                        clearConsoleScreen();
                        manageCustomerOrders(scanner, (Customer)account);
                        break;
                    }
                    case 4: { // DAT HANG
                        clearConsoleScreen();
                        customerImpl.createOrder(scanner, (Customer)account);
                        clearConsoleScreen();
                        break;
                    }
                    case 5: { // Dang xuat
                        isContinue = false;
                        clearConsoleScreen();
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

    private void shopFunctions(Scanner scanner, Account account) {
        boolean isContinue = true;
        do {
            System.out.println("\n*** WELCOME " + account.getRole() + ": " + account.getName() + " ***");
            System.out.println();
            System.out.println("[1] Quan ly tai khoan");
            System.out.println("[2] Chinh sua danh sach mon");
            System.out.println("[3] Don hang cho xac nhan");
            System.out.println("[4] Xem doanh thu");
            System.out.println("[5] Dang xuat");
            System.out.print("Chon tac vu: ");
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 1: { // QUAN LY TAI KHOAN
                    clearConsoleScreen();
                    manageAccount(scanner, account);
                    break;
                }
                case 2: { // CHINH SUA DANH SACH MON
                    clearConsoleScreen();
                    editShopMenu(scanner, (Shop)account);
                    break;
                }
                case 3: { // DON HANG CHO XAC NHAN
                    clearConsoleScreen();
                    shopImpl.confirmOrder(scanner, (Shop)account);
                    clearConsoleScreen();
                    break;
                }
                case 4: { // XEM DOANH THU
                    clearConsoleScreen();
                    shopImpl.viewRevenue((Shop)account);
                    System.out.print("Enter de tiep tuc...");
                    scanner.nextLine();
                    clearConsoleScreen();
                    break;
                }
                case 5: { // Dang xuat
                    isContinue = false;
                    clearConsoleScreen();
                    break;
                }
                default: {
                    clearConsoleScreen();
                    break;
                }
            }
        } while (isContinue == true);
    }

    private void shipperFunctions(Scanner scanner, Account account) {
        boolean isContinue = true;
        do {
            System.out.println("\n*** WELCOME " + account.getRole() + ": " + account.getName() + " ***");
            System.out.println();
            System.out.println("[1] Quan ly tai khoan");
            System.out.println("[2] Don hang cho van chuyen");
            System.out.println("[3] Xem thu nhap");
            System.out.println("[4] Dang xuat");
            System.out.print("Chon tac vu: ");
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 1: { // QUAN LY TAI KHOAN
                    clearConsoleScreen();
                    manageAccount(scanner, account);
                    break;
                }
                case 2: { // DON HANG CHO VAN CHUYEN
                    clearConsoleScreen();
                    shipperImpl.startDeliveringOrder(scanner, (Shipper)account);
                    clearConsoleScreen();
                    break;
                }
                case 3: { // XEM THU NHAP
                    clearConsoleScreen();
                    shipperImpl.viewIncome((Shipper)account);
                    System.out.print("Enter de tiep tuc...");
                    scanner.nextLine();
                    clearConsoleScreen();
                    break;
                }
                case 4: { // Dang xuat
                    isContinue = false;
                    clearConsoleScreen();
                    break;
                }
                default: {
                    clearConsoleScreen();
                    break;
                }
            }
        } while (isContinue == true);
    }

    private void manageAccount(Scanner scanner, Account account) {
        boolean isContinue = true;
        do {
            System.out.println("\n===== QUAN LY TAI KHOAN =====");
            account.displayAccountInfo();
            System.out.println();
            System.out.println("[1] Cap nhat mat khau");
            System.out.println("[2] Cap nhat so dien thoai");
            System.out.println("[3] Cap nhat dia chi");
            System.out.println("[4] Quan ly vi ShopeePay");
            System.out.println("[5] Thoat");
            System.out.print("Chon tac vu: ");
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 1: { 
                    clearConsoleScreen();
                    System.out.println("\n=== CAP NHAT MAT KHAU ===");
                    accountImpl.changePassword(scanner, account);
                    clearConsoleScreen();
                    break;
                }
                case 2: { 
                    clearConsoleScreen();
                    System.out.println("\n=== CAP NHAT SO DIEN THOAI ===");
                    accountImpl.changePhone(scanner, account);
                    clearConsoleScreen();
                    break;
                }
                case 3: { 
                    clearConsoleScreen();
                    System.out.println("\n=== CAP NHAT DIA CHI ===");
                    accountImpl.changeAddress(scanner, account);
                    clearConsoleScreen();
                    break;
                }
                case 4: { 
                    clearConsoleScreen();
                    System.out.println("\n=== QUAN LY VI SHOPEEPAY ===");
                    walletImpl.manageShopeePay(scanner, account);
                    clearConsoleScreen();
                    break;
                }
                case 5: { // Thoat
                    isContinue = false;
                    clearConsoleScreen();
                    break;
                }
                default: {
                    clearConsoleScreen();
                    break;
                }
            }
        } while (isContinue == true);
    }

    private void manageCustomerOrders(Scanner scanner, Customer customer) {
        boolean isContinue = true;
        do {
            if (customer.isSuspend()) {
                suspendedCustomerFunctions(scanner, customer);
                isContinue = false;
            } else {
                System.out.println("\n===== DON HANG CUA TOI =====");
                System.out.println();
                System.out.println("[1] Xem don hang moi va huy don");
                System.out.println("[2] Lich su dat hang");
                System.out.println("[3] Hoan thanh don hang");
                System.out.println("[4] Thoat");
                System.out.print("Chon tac vu: ");
                int selectedMenu = scanner.nextInt();
                scanner.nextLine();
                switch (selectedMenu) {
                    case 1: { // XEM DON HANG MOI VA HUY DON
                        clearConsoleScreen();
                        customerImpl.activeOrdersAndCancelOption(scanner, customer);
                        clearConsoleScreen();
                        break;
                    }
                    case 2: { // LICH SU DAT HANG
                        clearConsoleScreen();
                        customerImpl.viewOrderHistory(customer);
                        System.out.print("Enter de tiep tuc...");
                        scanner.nextLine();
                        clearConsoleScreen();
                        break;
                    }
                    case 3: { // HOAN THANH DON HANG
                        clearConsoleScreen();
                        customerImpl.completeOrder(scanner, customer);
                        clearConsoleScreen();
                        break;
                    }
                    case 4: { // Thoat
                        isContinue = false;
                        clearConsoleScreen();
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

    private void editShopMenu(Scanner scanner, Shop shop) {
        boolean isContinue = true;
        do {
            System.out.println("\n===== CHINH SUA DANH SACH MON =====");
            System.out.println();
            System.out.println("[1] Xem danh sach mon");
            System.out.println("[2] Xoa mon");
            System.out.println("[3] Chinh sua mon");
            System.out.println("[4] Them mon");
            System.out.println("[5] Thoat");
            System.out.print("Chon tac vu: ");
            int selectedMenu = scanner.nextInt();
            scanner.nextLine();
            switch (selectedMenu) {
                case 1: { 
                    clearConsoleScreen();
                    System.out.println("\n=== XEM DANH SACH MON ===");
                    shop.displayFoodMenu();
                    System.out.print("Enter de tiep tuc...");
                    scanner.nextLine();
                    clearConsoleScreen();
                    break;
                }
                case 2: { 
                    clearConsoleScreen();
                    System.out.println("\n=== XOA MON ===");
                    shopImpl.removeFood(scanner, shop);
                    clearConsoleScreen();
                    break;
                }
                case 3: { 
                    clearConsoleScreen();
                    System.out.println("\n=== CHINH SUA MON ===");
                    shopImpl.editFood(scanner, shop);
                    clearConsoleScreen();
                    break;
                }
                case 4: { 
                    clearConsoleScreen();
                    System.out.println("\n=== THEM MON ===");
                    shopImpl.addFood(scanner, shop);
                    clearConsoleScreen();
                    break;
                }
                case 5: { // Thoat
                    isContinue = false;
                    clearConsoleScreen();
                    break;
                }
                default: {
                    clearConsoleScreen();
                    break;
                }
            }
        } while (isContinue == true);
    }

    private void clearConsoleScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}