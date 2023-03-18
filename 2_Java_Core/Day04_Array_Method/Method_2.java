package Day04_Array_Method;

import java.util.Scanner;

public class Method_2 {
    // BÀI 1
    static void Day03_BTVN_1(Scanner input) {
        System.out.println("\n==========BÀI 1==========");
        System.out.print("Nhập một số nguyên: ");
        int intNum = input.nextInt();

        if (intNum > 0) {
            int sum = (intNum + 1) * intNum / 2;
            System.out.printf("Tổng từ 1 đến %d là: %d \n", intNum, sum);
        } else {
            System.out.println("Không phải số nguyên dương");
        }
    }

    // BÀI 2
    static void Day03_BTVN_2() {
        System.out.println("\n==========BÀI 2==========");
        int sum = 0;
        int intNum = 2;
        int count = 1;
        boolean isPrime;
        
        System.out.println("100 số nguyên tố đầu tiên:");
        do {
            // Kiểm tra xem intNum có phải số nguyên tố hay không
            isPrime = true;
            for (int i = 2; i <= intNum/2; i++) {
                if (intNum % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            // Nếu intNum là số nguyên tố thì cộng vào biến sum và tăng biến count thêm 1
            if (isPrime == true) {
                System.out.print(intNum + "\t");
                sum += intNum; // sum = sum + intNum;
                ++count;
            }
            // Tăng biến intNum để kiểm tra số nguyên tiếp theo
            ++intNum;
        } while (count <= 100);

        System.out.println("\nTổng 100 số nguyên tố đầu tiên: " + sum);
    }

    // BÀI 3
    static void Day03_BTVN_3(Scanner input) {
        System.out.println("\n==========BÀI 3==========");
        System.out.print("Nhập một số nguyên dương: ");
        long Num = input.nextLong();

        int lastDigit;
        int digitSum = 0;
        while (Num > 0) {
            lastDigit = (int)(Num % 10);
            digitSum = digitSum + lastDigit;
            Num = Num / 10;
        }

        System.out.println("Tổng các chữ số: " + digitSum);
    }

    public static void main(String[] args) {
        // Tạo biến "input" có scope ở mức method, để sử dụng được ở tất cả các method bên trong method "main"
        Scanner input = new Scanner(System.in);

        // Truyền biến "input" vừa tạo vào method Day03_BTVN_1 và Day03_BTVN_3
        Day03_BTVN_1(input);
        Day03_BTVN_2();
        Day03_BTVN_3(input);

        input.close();
    }
}