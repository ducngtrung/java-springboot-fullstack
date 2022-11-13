package Day03_If_Switch_Loop;

import java.util.Scanner;

public class BTVN_3 {
// BÀI 3:
// Nhập từ bàn phím một số nguyên dương.
// Sử dụng vòng lặp while để tính tổng các chữ số của số đó.
// Ví dụ:
//     Nhập số nguyên dương:
//     6789123
//     Tổng các chữ số: 36
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        long Num = input.nextLong();
        input.close();

        int lastDigit;
        int digitSum = 0;
        while (Num > 0) {
            lastDigit = (int)(Num % 10);
            digitSum = digitSum + lastDigit;
            Num = Num / 10;
        }

        System.out.println("Tổng các chữ số: " + digitSum);
    }
}