public class TestPasswordPolicy {
    public static void main(String[] args) {
        String password = "aaZZc44@";
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        // Tham khao: https://helpex.vn/question/regexp-java-de-xac-thuc-mat-khau-609efc1ba941cd7a68b8a9e7
        System.out.println("Password matches the pattern?\n\t" + password.matches(pattern));
    }
}