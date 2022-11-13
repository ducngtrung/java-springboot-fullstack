package Day09_Interface.Account_Management;

import java.util.Scanner;

public class AccountManagement {
    public static void main(String[] args) {
        Account account = new Account();
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap thong tin tai khoan:");
        System.out.print("\t Nhap ten chu tai khoan: ");
        account.setName(input.nextLine());
        
        System.out.print("\t Nhap so tai khoan: ");
        account.setAccountNumber(input.nextLine());

        System.out.print("\t Nhap email: ");
        account.setEmail(input.nextLine());

        System.out.print("\t Nhap so du: ");
        account.setAccountBalance(input.nextDouble());
        input.nextLine();

        System.out.println("Nap them tien vao tai khoan");
        System.out.print("\t Nhap so tien nap them: ");
        double rechargeAmount = input.nextDouble();
        input.nextLine();
        account.recharge(rechargeAmount);

        System.out.println("Chinh sua email");
        System.out.print("\t Nhap email moi: ");
        String newEmail = input.nextLine();
        account.changeEmail(newEmail);

        System.out.println("\nThong tin tai khoan:");
        account.displayInfo();

        input.close();
    }
}