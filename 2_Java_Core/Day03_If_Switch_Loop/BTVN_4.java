package Day03_If_Switch_Loop;

import java.util.Scanner;

public class BTVN_4 {
// BÀI 4:
// Viết chương trình lấy một số làm đầu vào và in ra bảng cửu chương của số đó.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        int Num = input.nextInt();
        input.close();

        System.out.println("Bảng cửu chương:");
        for (int i = 1; i <= 10; ++i) {
            System.out.println(Num + " x " + i + " = " + Num*i);
        }
    }
}