package Day03_If_Switch_Loop;

import java.util.Scanner;

public class BTVN_1 {
// BÀI 1:
// Nhập một số từ bàn phím ( giả sử là số n)
// Kiểm tra số đó có phải số nguyên dương hay không.
// Nếu là số nguyên dương thì tính tổng : 1 + 2 + 3 + … + n
// Ví dụ:
//      Nhập số nguyên dương: 
//      4
//      Tổng từ 1 -> 4: 10
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        int intNum = input.nextInt();
        input.close();

        if (intNum > 0) {
            int sum = (intNum + 1) * intNum / 2;
            System.out.printf("Tổng từ 1 đến %d là: %d", intNum, sum);
        } else {
            System.out.println("Không phải số nguyên dương");
        }
    }
}