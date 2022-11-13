import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main13 {
    static Scanner scanner = new Scanner(System.in);
    static UserModel userModel = new UserModel();
    static boolean isQuit = false;
    public static void main(String[] args) {
        // Initialize users
        User user1 = new User("ducngtrung", "ducnguyen.bme@gmail.com", "Hanoi@123");
        User user2 = new User("khanhhuyen712", "khanhhuyen712@gmail.com", "Sonla@123");
        User user3 = new User("daotran", "trandao1970@gmail.com", "ThaiBinh@123");

        // Initialize userList
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        displayUserList(userList);

        while (true) {
            showHomeMenu(userList);
            if (isQuit) {
                quit();
                break;
            }
        }
    }

    static void displayUserList(List<User> userList) {
        System.out.println();
        System.out.println("Danh sach user:");
        for (User user: userList) {
            user.display();
        }
    }

    static void showHomeMenu(List<User> userList) {
        System.out.println();
        System.out.println("=======MENU=======");
        System.out.println("[1] Dang nhap");
        System.out.println("[2] Dang ky");
        System.out.print("Moi ban chon menu: ");
        int selectedMenu = scanner.nextInt();
        scanner.nextLine();
        switch (selectedMenu) {
            case 1:{ // Dang nhap
                logIn(scanner, userList);
                break;
            }
            case 2: { // Dang ky
                signUp(scanner, userList);
                break;
            }
        }
    }

    static User checkExistingUsername(List<User> userList, String username) {
        for (User user: userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    static User checkExistingEmail(List<User> userList, String email) {
        for (User user: userList) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    static String createNewUsername(Scanner scanner, List<User> userList) {
        String newUsername = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap username moi:\n\t");
            newUsername = scanner.nextLine();
            // Validate username
            if (checkExistingUsername(userList, newUsername) == null) {
                isContinue = false;
            } else {
                System.out.println("Username da ton tai!");
            }
        }
        return newUsername;
    }

    static String createNewEmail(Scanner scanner, List<User> userList) {
        String newEmail = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap email moi:\n\t");
            newEmail = scanner.nextLine();
            String EMAIL_PATTERN = "^[a-zA-Z].+@([\\w]+[-]*[\\w]+\\.[\\w]{2,}|[\\w]+[-]*[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
            // Validate email
            if (checkExistingEmail(userList, newEmail) == null) {
                if (Pattern.matches(EMAIL_PATTERN, newEmail)) {
                    isContinue = false;
                } else {
                    System.out.println("Email khong hop le!");
                }
            } else {
                System.out.println("Email da ton tai!");
            }
        }
        return newEmail;
    }

    static String createNewPassword(Scanner scanner) {
        String newPassword = "";
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap password moi:\n\t");
            newPassword = scanner.nextLine();
            String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,10}$";
            // Validate password
            // Tham khao: https://helpex.vn/question/regexp-java-de-xac-thuc-mat-khau-609efc1ba941cd7a68b8a9e7
            if (newPassword.matches(PASSWORD_PATTERN)) {
                isContinue = false;
            } else {
                System.out.println("Password tu 8 den 10 ky tu, khong chua dau cach, phai chua: chu cai in thuong, chu cai in hoa, chu so, ky tu dac biet");
            }
        }
        return newPassword;
    }

    static void changeUserName(Scanner scanner, User user, List<User> userList) {
        String newUsername = createNewUsername(scanner, userList);
        user.setUsername(newUsername);
        userModel.updateUsername(user, userList);
    }

    static void changeEmail(Scanner scanner, User user, List<User> userList) {
        String newEmail = createNewEmail(scanner, userList);
        user.setEmail(newEmail);
        userModel.updateEmail(user, userList);
    }

    static void changePassword(Scanner scanner, User user, List<User> userList) {
        String newPassword = createNewPassword(scanner);
        user.setPassword(newPassword);
        userModel.updatePassword(user, userList);
    }

    static void forgetPassword(Scanner scanner, User user, List<User> userList) {
        System.out.print("Nhap email de xac thuc:\n\t");
        String emailToCheck = scanner.nextLine();
        if (user.isCorrectEmail(emailToCheck)) {
            changePassword(scanner, user, userList);
            displayUserList(userList);
        } else {
            System.out.println("Tai khoan khong ton tai!");
        }
    }

    static void logIn(Scanner scanner, List<User> userList) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.print("Nhap username:\n\t");
            String username = scanner.nextLine();
            if (checkExistingUsername(userList, username) != null) {
                isContinue = false;
                User user = checkExistingUsername(userList, username);
                System.out.print("Nhap password:\n\t");
                String passwordToCheck = scanner.nextLine();
                if (user.isCorrectPassword(passwordToCheck)) {
                    System.out.println("*** CHAO MUNG " + username + " ***");
                    System.out.println("Ban co the thuc hien cac tac vu sau:");
                    System.out.println("[1] Thay doi username");
                    System.out.println("[2] Thay doi email");
                    System.out.println("[3] Thay doi password");
                    System.out.println("[4] Dang xuat");
                    System.out.println("[5] Exit");
                    System.out.print("Moi ban chon menu: ");
                    int selectedMenu = scanner.nextInt();
                    scanner.nextLine();
                    switch (selectedMenu) {
                        case 1: { // Thay doi username
                            changeUserName(scanner, user, userList);
                            displayUserList(userList);
                            break;
                        }
                        case 2: { // Thay doi email
                            changeEmail(scanner, user, userList);
                            displayUserList(userList);
                            break;
                        }
                        case 3: { // Thay doi password
                            changePassword(scanner, user, userList);
                            displayUserList(userList);
                            break;
                        }
                        case 4: { // Dang xuat
                            showHomeMenu(userList);
                            break;
                        }
                        case 5: { // Exit
                            isQuit = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("Sai mat khau!");
                    System.out.println("[1] Dang nhap lai");
                    System.out.println("[2] Quen mat khau");
                    System.out.print("Vui long chon: ");
                    int selectedMenu = scanner.nextInt();
                    scanner.nextLine();
                    switch (selectedMenu) {
                        case 1: { // Dang nhap lai
                            isContinue = true;
                            break;
                        }
                        case 2: { // Quen mat khau
                            forgetPassword(scanner, user, userList);
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Username khong ton tai. Vui long kiem tra lai.");
            }
            if (isQuit) {
                break;
            }
        }
    }

    static void signUp(Scanner scanner, List<User> userList) {
        String newUsername = createNewUsername(scanner, userList);
        String newEmail = createNewEmail(scanner, userList);
        String newPassword = createNewPassword(scanner);

        // Add new user to userList
        User newUser = new User(newUsername, newEmail, newPassword);
        userModel.insert(newUser, userList);

        System.out.println("DANG KY THANH CONG");
        displayUserList(userList);
    }

    static void quit() {
        System.out.println("HEN GAP LAI !!!");
        scanner.close();
    }
}