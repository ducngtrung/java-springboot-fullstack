package Day03_If_Switch_Loop;

import java.util.Scanner;

public class So_nguyen_to {
// Kiểm tra một số có phải số nguyên tố hay không.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số nguyên >= 2: ");
        int intNum = input.nextInt();
        input.close();
        
        boolean isPrime = true;
        for (int i = 2; i <= intNum/2; i++) {
            if (intNum % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime == true) {
            System.out.println("Là số nguyên tố");
        } else {
            System.out.println("Không phải số nguyên tố");
        }
    }
}