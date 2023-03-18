import java.util.Scanner;

public class Random_Number {
// Viết chương trình:
// - Nhập một số kiểu int từ bàn phím
// - Tạo một số ngẫu nhiên kiểu int từ 1 đến 100
// - So sánh 2 số trên với nhau
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên: ");
        int intNumber = scanner.nextInt();
        System.out.println("Bạn đã nhập: " + intNumber);

        double random = Math.random();  // Sinh ra số double ngẫu nhiên từ 0 đến 1
        System.out.println(random);
        int randomNum = (int)(random * 100);
        System.out.println("Số random từ 1 đến 100: " + randomNum);
        String compare = intNumber > randomNum ? "Số nhập từ bàn phím lớn hơn số random" : "Số nhập từ bàn phím nhỏ hơn số random";
        System.out.println(compare);
        
        scanner.close();
    }
}