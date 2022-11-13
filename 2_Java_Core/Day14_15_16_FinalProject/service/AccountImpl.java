package service;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Account;
import repository.Repository;
import view.IAccount;

public class AccountImpl implements IAccount {

    public List<Account> getAccountList() {
        return Repository.accountList;
    }

    public Account checkExistingUsername(String username) {
        for (Account account: getAccountList()) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    private Account checkExistingEmail(String email) {
        for (Account account: getAccountList()) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }

    private Account checkExistingPhone(String phone) {
        for (Account account: getAccountList()) {
            if (account.getPhone().equals(phone)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String createNewUsername(Scanner scanner) {
        String newUsername = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap username moi:\n\t");
            newUsername = scanner.nextLine();
            if (checkExistingUsername(newUsername) == null) {
                isContinue = false;
            } else {
                System.out.println("Username da ton tai!");
            }
        }
        return newUsername;
    }

    @Override
    public String createNewEmail(Scanner scanner) {
        String newEmail = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap email moi:\n\t");
            newEmail = scanner.nextLine();
            String EMAIL_PATTERN = "^[a-zA-Z].+@([\\w]+[-]*[\\w]+\\.[\\w]{2,}|[\\w]+[-]*[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
            // Validate email
            if (checkExistingEmail(newEmail) == null) {
                if (Pattern.matches(EMAIL_PATTERN, newEmail)) {
                    isContinue = false;
                } else {
                    System.out.println("Email khong hop le!");
                }
            } else {
                System.out.println("Email nay da duoc su dung!");
            }
        }
        return newEmail;
    }

    @Override
    public String createNewPhone(Scanner scanner) {
        String newPhone = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap so dien thoai moi:\n\t");
            newPhone = scanner.nextLine();
            if (checkExistingPhone(newPhone) == null) {
                isContinue = false;
            } else {
                System.out.println("So dien thoai nay da duoc su dung!");
            }
        }
        return newPhone;
    }

    @Override
    public String createNewPassword(Scanner scanner) {
        String newPassword = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap password moi:\n\t");
            newPassword = scanner.nextLine();
            String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$";
            // Validate password
            if (newPassword.matches(PASSWORD_PATTERN)) {
                isContinue = false;
            } else {
                System.out.println("Password tu 8 den 15 ky tu, khong chua dau cach, phai chua: chu cai in thuong, chu cai in hoa, chu so, ky tu dac biet");
            }
        }
        return newPassword;
    }

    private void updatePhone(Account obj, List<Account> objs) {
        for (int i = 0; i < objs.size(); ++i) {
            if (objs.get(i).getId() == obj.getId()) {
                objs.set(i, obj);
                System.out.println("<PHONE UPDATED>");
            }
        } 
    }

    private void updateAddress(Account obj, List<Account> objs) {
        for (int i = 0; i < objs.size(); ++i) {
            if (objs.get(i).getId() == obj.getId()) {
                objs.set(i, obj);
                System.out.println("<ADDRESS UPDATED>");
            }
        }
    }

    private void updatePassword(Account obj, List<Account> objs) {
        for (int i = 0; i < objs.size(); ++i) {
            if (objs.get(i).getId() == obj.getId()) {
                objs.set(i, obj);
                System.out.println("<PASSWORD UPDATED>");
            }
        }
    }

    @Override
    public void changePhone(Scanner scanner, Account account) {
        String newPhone = createNewPhone(scanner);
        account.setPhone(newPhone);
        updatePhone(account, getAccountList());
        System.out.println();
        account.displayAccountInfo();
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void changeAddress(Scanner scanner, Account account) {
        System.out.print("Nhap ten moi:\n\t");
        String newAddress = scanner.nextLine();
        account.setAddress(newAddress);
        updateAddress(account, getAccountList());
        System.out.println();
        account.displayAccountInfo();
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void changePassword(Scanner scanner, Account account) {
        String newPassword = createNewPassword(scanner);
        while (newPassword.equals(account.getPassword())) {
            System.out.println("Khong duoc su dung password cu. Vui long nhap lai!");
            newPassword = createNewPassword(scanner);
        }
        account.setPassword(newPassword);
        updatePassword(account, getAccountList());
        System.out.println();
        account.displayAccountInfo();
        System.out.print("Enter de tiep tuc...");
        scanner.nextLine();
    }

    @Override
    public void forgetPassword(Scanner scanner, Account account) {
        System.out.print("Nhap email de xac thuc:\n\t");
        String emailToCheck = scanner.nextLine();
        if (account.isCorrectEmail(emailToCheck)) {
            changePassword(scanner, account);
        } else {
            System.out.println("Xac thuc that bai!");
            System.out.print("Enter de tiep tuc...");
            scanner.nextLine();
        }
    }
}