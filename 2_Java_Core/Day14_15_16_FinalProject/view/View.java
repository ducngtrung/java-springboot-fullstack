package view;

import java.util.Scanner;

import controller.Controller;

public class View {
    
    private Scanner scanner;    
    private Controller appController;

    // Constructor: initialize Scanner, call Controller
    public View() {
        this.scanner = new Scanner(System.in);
        this.appController = new Controller();
    }
    
    // Display UI
    public void showHomeScreen() {
        boolean isQuit = false;
        while (true) {
            System.out.println();
            System.out.println("======= ShopeeFood =======");
            System.out.println("[1] Dang nhap");
            System.out.println("[2] Dang ky");
            System.out.println("[3] Thoat");
            
            boolean isContinue = false;
            do {
                System.out.print("Chon tac vu: ");
                int selectedMenu = scanner.nextInt();
                scanner.nextLine();
                switch (selectedMenu) {
                    case 1: {
                        System.out.println("\n===== DANG NHAP =====");
                        appController.logIn(scanner);
                        isContinue = false;
                        break;
                    }
                    case 2: {
                        System.out.println("\n===== DANG KY =====");
                        appController.signUp(scanner);
                        isContinue = false;
                        break;
                    }
                    case 3: { // Thoat
                        isQuit = true;
                        isContinue = false;
                        break;
                    }
                    default: {
                        System.out.println("Vui long chon lai!");
                        isContinue = true;
                        break;
                    }
                }
            } while (isContinue == true);
            
            if (isQuit) {
                quit();
                break;
            }
        }
    }

    private void quit() {
        System.out.println("\nHEN GAP LAI !!!");
        scanner.close();
    }
}