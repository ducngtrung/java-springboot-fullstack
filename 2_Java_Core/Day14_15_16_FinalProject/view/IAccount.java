package view;

import java.util.Scanner;

import model.Account;

public interface IAccount {
    String createNewUsername(Scanner scanner);
    String createNewEmail(Scanner scanner);
    String createNewPhone(Scanner scanner);
    String createNewPassword(Scanner scanner);
    void changePhone(Scanner scanner, Account account);
    void changeAddress(Scanner scanner, Account account);
    void changePassword(Scanner scanner, Account account);
    void forgetPassword(Scanner scanner, Account account);
}